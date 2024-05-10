package br.com.digab.messageresume.repositories;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.Optional;

import br.com.digab.messageresume.models.entities.User;

@Transactional
@ApplicationScoped
@SuppressWarnings("unchecked")
public class UserRepository {
    @PersistenceContext
    private EntityManager em;

    public User save(User user) {
        em.persist(user);
        return user;
    }

    public Optional<User> getAuthenticateUser(User user) {
        return (Optional<User>) em.createNativeQuery("SELECT * FROM users WHERE name = :name AND password = :password" , User.class)
                .setParameter("name" , user.getName())
                .setParameter("password" , user.getPassword())
                .getResultStream()
        .findFirst();
    }
}

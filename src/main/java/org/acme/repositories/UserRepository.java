package org.acme.repositories;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.acme.models.entities.User;

import java.util.Optional;

@Transactional
@ApplicationScoped
@SuppressWarnings("unchecked")
public class UserRepository {
    @Inject
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

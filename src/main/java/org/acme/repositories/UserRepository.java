package org.acme.repositories;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.acme.models.entities.User;

@Transactional
@ApplicationScoped
public class UserRepository {
    @PersistenceContext
    private EntityManager em;

    public User save(User user) {
        em.persist(user);
        return user;
    }
}

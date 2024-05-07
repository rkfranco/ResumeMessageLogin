package org.acme.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.models.dtos.UserDto;
import org.acme.models.entities.User;
import org.acme.models.forms.UserForm;
import org.acme.repositories.UserRepository;

@ApplicationScoped
public class UserService {
    @Inject
    private UserRepository userRepository;

    public UserDto save(UserForm form) {
        return new UserDto(userRepository.save(new User(form)));
    }
}

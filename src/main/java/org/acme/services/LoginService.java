package org.acme.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.models.dtos.LoginDto;
import org.acme.models.entities.User;
import org.acme.models.exceptions.UserAuthenticationException;
import org.acme.models.forms.LoginForm;
import org.acme.repositories.UserRepository;

@ApplicationScoped
public class LoginService {

    @Inject
    private UserRepository userRepository;

    public LoginDto login(LoginForm loginForm) throws Exception {
        return new LoginDto(userRepository.getAuthenticateUser(new User(loginForm)).orElseThrow(UserAuthenticationException::new));
    }
}

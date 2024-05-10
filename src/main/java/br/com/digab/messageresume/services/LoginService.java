package br.com.digab.messageresume.services;

import br.com.digab.messageresume.models.dtos.LoginDto;
import br.com.digab.messageresume.models.entities.User;
import br.com.digab.messageresume.models.exceptions.UserAuthenticationException;
import br.com.digab.messageresume.models.forms.LoginForm;
import br.com.digab.messageresume.repositories.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class LoginService {

    @Inject
    private UserRepository userRepository;

    public LoginDto login(LoginForm loginForm) throws Exception {
        return new LoginDto(userRepository.getAuthenticateUser(new User(loginForm)).orElseThrow(UserAuthenticationException::new));
    }
}

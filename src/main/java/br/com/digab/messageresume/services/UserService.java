package br.com.digab.messageresume.services;

import br.com.digab.messageresume.models.dtos.UserDto;
import br.com.digab.messageresume.models.entities.User;
import br.com.digab.messageresume.models.exceptions.UserAllreadyExistsException;
import br.com.digab.messageresume.models.forms.UserForm;
import br.com.digab.messageresume.repositories.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class UserService {
    @Inject
    private UserRepository userRepository;

    public UserDto save(UserForm form) throws Exception {
        User user = new User(form);

        if (userRepository.isUserAllreadyExists(user)) {
            throw new UserAllreadyExistsException();
        }
        
        return new UserDto(userRepository.save(user));
    }
}

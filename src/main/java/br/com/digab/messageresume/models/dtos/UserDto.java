package br.com.digab.messageresume.models.dtos;

import br.com.digab.messageresume.models.entities.User;

public record UserDto(String name, Long id) {
    public UserDto(User user) {
        this(user.getName(), user.getId());
    }
}

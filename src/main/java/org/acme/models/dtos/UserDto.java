package org.acme.models.dtos;

import org.acme.models.entities.User;

public record UserDto(String name, Long id) {
    public UserDto(User user) {
        this(user.getName(), user.getId());
    }
}

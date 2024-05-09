package org.acme.models.dtos;

import org.acme.models.entities.User;

public record LoginDto(String name, Long id) {
    public LoginDto(User user) {
        this(user.getName(), user.getId());
    }
}
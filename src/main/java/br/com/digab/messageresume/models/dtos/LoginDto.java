package br.com.digab.messageresume.models.dtos;

import br.com.digab.messageresume.models.entities.User;

public record LoginDto(String name, Long id) {
    public LoginDto(User user) {
        this(user.getName(), user.getId());
    }
}
package br.com.digab.messageresume.models.forms;

import jakarta.validation.constraints.NotBlank;

public record UserForm(@NotBlank String name, @NotBlank String password) {}


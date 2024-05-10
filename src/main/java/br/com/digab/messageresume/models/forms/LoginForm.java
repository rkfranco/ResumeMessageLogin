package br.com.digab.messageresume.models.forms;

import jakarta.validation.constraints.NotBlank;

public record LoginForm(@NotBlank String name, @NotBlank String password) {}

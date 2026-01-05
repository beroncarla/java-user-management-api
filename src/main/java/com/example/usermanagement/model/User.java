package com.example.usermanagement.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * Modelo de dominio
 * Representa un usuario del sistema externo.
 * <p>
 * En integraciones, este objeto será serializado a JSON.
 * Validaciones con Jakarta Validation API.
 * NotNull: el campo no puede ser null
 * NotBlank: el campo no puede ser null ni vacio
 * Email: el campo debe tener formato de email valido
 */
public record User(
        @NotNull Long id,
        @NotBlank String name,
        @Email String email
) {
}

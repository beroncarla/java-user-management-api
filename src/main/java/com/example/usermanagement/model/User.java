package com.example.usermanagement.model;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "User object returned by the API")
public record User(
        @Schema(example = "1")
        @NotNull Long id,
        @Schema(example = "Juan Perez")
        @NotBlank String name,
        @Schema(example = "juan.perez@gmail.com")
        @Email String email
) {
}

package com.example.usermanagement.model;

/**
 * Modelo de dominio
 * Representa un usuario del sistema externo.
 * <p>
 * En integraciones, este objeto será serializado a JSON.
 */
public record User(
        Long id,
        String name,
        String email
) {
}

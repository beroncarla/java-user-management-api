package com.example.usermanagement.repository;

import com.example.usermanagement.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Simula una fuente de datos externa.
 * En el mundo real podria ser:
 * - una base de datos
 * - otro sistema
 * - un servicio remoto
 */
@Repository
public class UserRepository {

    private List<User> users = new ArrayList<>();

    public UserRepository() {
        this.users.add(new User(1L, "Alice", "alice@gmail.com"));
        this.users.add(new User(2L, "Bob", "bob@gmail.com"));
    }

    /**
     * Obtiene todos los usuarios.
     * usado por integraciones tipo GET /users
     */
    public List<User> findAll() {
        return this.users;
    }

    /**
     * Obtiene un usuario por su id.
     * Devuelve un Optional que puede estar vacio si no se encuentra el usuario.
     */
    public Optional<User> findById(Long id) {
        return this.users.stream()
                .filter(user -> user.id().equals(id))
                .findFirst();
    }
}

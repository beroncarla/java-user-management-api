package com.example.usermanagement.controller;

import com.example.usermanagement.model.User;
import com.example.usermanagement.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * User controller
 * <p>
 * Expone endpoints REST consumibles por sistemas externos (CPI)
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    /**
     * Constructor con inyeccion de dependencias
     * Spring automaticamente inyecta el UserService
     */
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * GET /api/users{id}
     * Devuelve un usuario por su id
     * - 200 OK con el usuario si se encuentra
     * - 404 Not Found si no se encuentra
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return this.userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * POST /api/users
     * Crea un nuevo usuario
     * - 201 Created con el usuario creado
     * - 400 Bad Request si los datos son invalidos (@valid)
     */
    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User createdUser = this.userService.createUser(user);
        return ResponseEntity.status(201).body(createdUser); //201 created
    }

    /**
     * DELETE /api/users/{id}
     * Elimina un usuario por su id
     * - 204 No Content si se elimina correctamente
     * - 404 Not Found si no se encuentra el usuario
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        boolean deleted = userService.deleteUser(id);
        if (deleted) {
            return ResponseEntity.noContent().build(); //204 No Content
        } else {
            return ResponseEntity.notFound().build(); //404 Not Found
        }
    }

    /**
     * PUT /api/users/{id}
     * Actualiza un usuario por su id
     * - 200 OK con el usuario actualizado
     * - 404 Not Found si no se encuentra el usuario
     */
    @PutMapping("/api/users/{id}")
    public ResponseEntity<User> updateUser(
            @PathVariable Long id,
            @RequestBody User user) {

        return userService.updateUser(id, user)
                .map(updated -> ResponseEntity.ok(updated))
                .orElse(ResponseEntity.notFound().build());
    }

}

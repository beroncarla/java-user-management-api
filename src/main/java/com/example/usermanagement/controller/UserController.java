package com.example.usermanagement.controller;

import com.example.usermanagement.model.User;
import com.example.usermanagement.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
}

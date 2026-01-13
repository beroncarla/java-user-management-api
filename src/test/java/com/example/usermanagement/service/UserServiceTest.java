package com.example.usermanagement.service;

import com.example.usermanagement.dto.User;
import com.example.usermanagement.repository.UserRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserServiceTest {

    @Test
    void createUser_shouldAddUser() {
        UserRepository repo = new UserRepository();
        UserService service = new UserService(repo);

        var user = new User(3L, "Carla", "carla@gmail.com");
        service.createUser(user);

        assertEquals(3, repo.findAll().size());
        assertTrue(service.getUserById(3L).isPresent());

    }
}

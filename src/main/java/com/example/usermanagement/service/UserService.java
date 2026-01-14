package com.example.usermanagement.service;

import com.example.usermanagement.dto.User;
import com.example.usermanagement.model.UserEntity;
import com.example.usermanagement.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    // Inyección por constructor (recomendada)
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<UserEntity> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public UserEntity createUser(User user) {
        UserEntity entity = new UserEntity(
                user.name(),
                user.email()
        );
        return userRepository.save(entity);
    }
}


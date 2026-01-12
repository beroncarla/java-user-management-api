package com.example.usermanagement.service;

import com.example.usermanagement.model.User;
import com.example.usermanagement.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Capa de servicio que contiene la lógica de negocio
 * Se define como un Bean de Spring para ser inyectado en otros componentes.
 */
@Service
public class UserService {

    //Dependencia interna
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Devuelve todos los usuarios
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Devuelve un usuario por id
     * Retorna Optional.empty() si no se encuentra
     */
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    /**
     * Logica de negocio para crear un nuevo usuario
     */
    public User createUser(User user) {
        //validaciones
        if (user.name() == null || user.email() == null) {
            throw new IllegalArgumentException("Name and email cannot be null");
        }
        userRepository.save(user);
        return user;
    }

    public Optional<User> updateUser(Long id, User updateUser) {
        return userRepository.findById(id)
                .map(existingUser -> {
                            User newUser = new User(
                                    existingUser.id(),
                                    updateUser.name(),
                                    updateUser.email()
                            );
                            userRepository.save(newUser);
                            return newUser;
                        }
                );
    }
}

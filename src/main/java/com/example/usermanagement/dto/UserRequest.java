package com.example.usermanagement.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRequest(

        @NotBlank(message = "Name is mandatory")
        String name,

        @Email(message = "Invalid email format")
        @NotBlank(message = "Email is mandatory")
        String email
) {
}

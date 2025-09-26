package com.example.clinicapp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DoctorDTO(

        @NotBlank
        String name,

        @NotBlank
        String specialization,

        @Email
        String email

) {
}

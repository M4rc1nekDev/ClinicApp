package com.example.clinicapp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record PatientDTO(
        @NotBlank
        String name,

        @Email
        String email,

        @NotBlank
        @Pattern(regexp = "\\+?[0-9]{9,15}", message = "Numer telefonu musi zawierac tylko cyfry")
        String phoneNumber

){
}

package com.example.clinicapp.dto;

import com.example.clinicapp.AppointmentStatus;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record AppointmentDTO(

        //   private LocalDateTime dataTime;
        //    private AppointmentStatus status

        @Future
        @NotNull
        LocalDateTime dateTime,

        @NotNull
        AppointmentStatus status,

        @NotNull Long doctorId,

        @NotNull Long patientId

) {
}

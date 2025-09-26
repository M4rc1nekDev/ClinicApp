package com.example.clinicapp.entity;

import com.example.clinicapp.AppointmentStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder


public class Appointment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //dla status zmienic na enum


    private LocalDateTime dateTime;
    @Enumerated(jakarta.persistence.EnumType.STRING)
    private AppointmentStatus status; // scheduled, cancelled, done

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor assignedDoctor;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient assignedPatient;

}

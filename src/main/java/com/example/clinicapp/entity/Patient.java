package com.example.clinicapp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "patients")
public class Patient {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String phoneNumber;
    private String email;
    private String name;


    @OneToMany(mappedBy = "assignedPatient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Appointment> appointments;


}

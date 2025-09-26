package com.example.clinicapp.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "doctors")
@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;
    private String specialization;
    private String email;

    @OneToMany(mappedBy = "assignedDoctor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Appointment> appointments;


}

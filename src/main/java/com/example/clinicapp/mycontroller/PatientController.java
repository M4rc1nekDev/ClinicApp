package com.example.clinicapp.mycontroller;

import com.example.clinicapp.dto.PatientDTO;
import com.example.clinicapp.entity.Patient;
import com.example.clinicapp.myservice.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class PatientController {
    private final PatientService patientService;

    @PostMapping("/patient")
    public Patient addPatient(@RequestBody @Valid PatientDTO patientDTO) {
        return patientService.addPatient(patientDTO);
    }


    @GetMapping("/patient/{id}")
        public Optional<Patient> getPatientById(@PathVariable Long id){
        return patientService.getPatientById(id);
    }


    @GetMapping("/patientDetail/{id}")
    public PatientDTO getPatientDetailById(@PathVariable Long id){
        return patientService.getPatientDetailById(id);
    }


}

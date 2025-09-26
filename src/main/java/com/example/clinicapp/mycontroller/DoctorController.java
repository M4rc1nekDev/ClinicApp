package com.example.clinicapp.mycontroller;

import com.example.clinicapp.dto.DoctorDTO;
import com.example.clinicapp.entity.Doctor;
import com.example.clinicapp.myservice.DoctorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class DoctorController {
    private final DoctorService doctorService;


    @PostMapping("/doctor")
    public Doctor addDoctor(@RequestBody @Valid DoctorDTO doctorDTO) {
        return doctorService.addDoctor(doctorDTO);
    }

    @GetMapping("/doctor/{id}")
    public Optional<Doctor> getDoctorById(@PathVariable Long id) {
        return doctorService.getDoctorById(id);
    }

    @GetMapping("/doctorDetail/{id}")
    public DoctorDTO getDoctorDetailByID(@PathVariable Long id) {
        return doctorService.getDoctorDetailById(id);
    }

}

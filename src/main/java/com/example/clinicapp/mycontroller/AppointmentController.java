package com.example.clinicapp.mycontroller;

import com.example.clinicapp.AppointmentStatus;
import com.example.clinicapp.dto.AppointmentDTO;
import com.example.clinicapp.entity.Appointment;
import com.example.clinicapp.entity.Doctor;
import com.example.clinicapp.entity.Patient;
import com.example.clinicapp.myrepository.DoctorRepository;
import com.example.clinicapp.myrepository.PatientRepository;
import com.example.clinicapp.myservice.AppointmentService;
import com.example.clinicapp.myservice.DoctorService;
import com.example.clinicapp.myservice.PatientService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class AppointmentController {
    private final AppointmentService appointmentService;
    private final DoctorService doctorService;
    private final PatientService patientService;



    @PostMapping("/Appointment")
    public AppointmentDTO addAppointment(@RequestBody @Valid AppointmentDTO appointmentDTO) {
        return appointmentService.createAppointment(appointmentDTO);
    }


    @GetMapping("/Appointment")
    public List<Appointment> getAllAppointment(){
        return appointmentService.getAllAppointment();
    }

    @GetMapping("/AppointmentPatient/{id}")
    public List<Appointment> getAppointmentPatient(@PathVariable Long id){
        return appointmentService.getAppointmentPatient(id);
    }

    @GetMapping("/AppointmentDoctor/{id}")
    public List<Appointment> getAppointmentDoctor(@PathVariable Long id){
        return appointmentService.getAppointmentDoctor(id);
    }

    @PutMapping("/changeAppointmentStatus/{id}/{appointmentStatus}")
    public Appointment changeAppointmentStatus(@PathVariable Long id, @PathVariable AppointmentStatus appointmentStatus){
        return appointmentService.changeAppointmentStatus(id,appointmentStatus);
    }



}

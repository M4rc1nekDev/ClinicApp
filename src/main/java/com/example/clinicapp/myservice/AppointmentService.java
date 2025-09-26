package com.example.clinicapp.myservice;

import com.example.clinicapp.AppointmentStatus;
import com.example.clinicapp.dto.AppointmentDTO;
import com.example.clinicapp.entity.Appointment;
import com.example.clinicapp.entity.Doctor;
import com.example.clinicapp.entity.Patient;
import com.example.clinicapp.myrepository.AppointmentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final DoctorService doctorService;
    private final PatientService patientService;

    public AppointmentDTO createAppointment(AppointmentDTO appointmentDTO){

        Doctor doctor = doctorService.getDoctorById(appointmentDTO.doctorId())
                .orElseThrow(() -> new EntityNotFoundException("Nie znaleziono doctora z id: " + appointmentDTO.doctorId()));
        Patient patient = patientService.getPatientById(appointmentDTO.patientId())
                .orElseThrow(() -> new EntityNotFoundException("Nie znaleziono pacjenta z id: " + appointmentDTO.patientId()));


        Appointment appointment = Appointment.builder()
                .status(AppointmentStatus.SCHEDULED)
                .dateTime(appointmentDTO.dateTime())
                .assignedDoctor(doctor)
                .assignedPatient(patient)
                .build();
        Appointment savedAppointment = appointmentRepository.save(appointment);

        return new AppointmentDTO(
                savedAppointment.getDateTime(),
                savedAppointment.getStatus(),
                savedAppointment.getAssignedDoctor().getId(),
                savedAppointment.getAssignedPatient().getId()
        );


        //technicznie dziala, ale nie dziala jak prawdziwe rest api (pobieranie encji po id, pelne dto, poprawa lazy loading)
    }


    public List<Appointment> getAllAppointment(){
        return appointmentRepository.findAll();
    }

    public List<Appointment> getAppointmentPatient(Long id){
       return patientService.getPatientById(id)
               .orElseThrow(() -> new EntityNotFoundException("Nie znaleziono pacjenta z id: " + id))
               .getAppointments();
    }


    public List<Appointment> getAppointmentDoctor(Long id){
        return doctorService.getDoctorById(id)
                .orElseThrow(() -> new EntityNotFoundException("Nie znaleziono doctora z id: " + id))
                .getAppointments();
    }

    public Appointment changeAppointmentStatus(Long id, AppointmentStatus appointmentStatus){
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Nie znaleziono wizyty z id: " + id));
        appointment.setStatus(appointmentStatus);
        return appointmentRepository.save(appointment);
    }


}

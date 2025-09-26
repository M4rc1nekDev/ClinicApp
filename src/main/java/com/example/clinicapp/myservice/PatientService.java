package com.example.clinicapp.myservice;

import com.example.clinicapp.dto.PatientDTO;
import com.example.clinicapp.entity.Patient;
import com.example.clinicapp.myrepository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PatientService {
    private final PatientRepository patientRepository;


    public Patient addPatient(PatientDTO patientDTO) {
        Patient patient = Patient.builder()
                .name(patientDTO.name())
                .email(patientDTO.email())
                .phoneNumber(patientDTO.phoneNumber()).build();
        return patientRepository.save(patient);
    }

    public Optional<Patient> getPatientById(Long id) {
        return patientRepository.findById(id);
    }


    public PatientDTO getPatientDetailById(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Nie znaleziono Pacjenta o id:  " + id));
        return new PatientDTO(patient.getName(), patient.getEmail(), patient.getPhoneNumber());
    }


}

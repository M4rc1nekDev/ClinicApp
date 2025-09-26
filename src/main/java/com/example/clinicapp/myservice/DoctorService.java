package com.example.clinicapp.myservice;

import com.example.clinicapp.dto.DoctorDTO;
import com.example.clinicapp.entity.Doctor;
import com.example.clinicapp.myrepository.DoctorRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;


    public Doctor addDoctor(DoctorDTO doctorDTO) {
        Doctor doctor = Doctor.builder()
                .name(doctorDTO.name())
                .specialization( doctorDTO.specialization())
                .email(doctorDTO.email()).build();
        return doctorRepository.save(doctor);
    }

    public Optional<Doctor> getDoctorById(Long id){
        return doctorRepository.findById(id);
    }

    public DoctorDTO getDoctorDetailById(Long id){
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Nie znaleziono doctora o id: " + id));
        return new DoctorDTO(doctor.getName(), doctor.getSpecialization(), doctor.getEmail());
    }

}

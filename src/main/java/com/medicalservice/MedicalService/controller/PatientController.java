package com.medicalservice.MedicalService.controller;

import com.medicalservice.MedicalService.model.Patient;
import com.medicalservice.MedicalService.repository.PatientRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;


@RestController
public class PatientController {
    private PatientRepository patientRepository;

    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @GetMapping("/medical-service")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<Patient> patientCollection() {
        return patientRepository.findAll().stream().collect(Collectors.toList());
    }
}

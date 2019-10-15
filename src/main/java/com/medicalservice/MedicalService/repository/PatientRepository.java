package com.medicalservice.MedicalService.repository;

import com.medicalservice.MedicalService.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PatientRepository extends JpaRepository<Patient, Long> {}

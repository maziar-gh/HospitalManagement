package com.restfulproject.dhrubo.repository;

import com.restfulproject.dhrubo.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.annotation.Resource;

@Resource
public interface PatientRepository extends JpaRepository<Patient, String> {

}

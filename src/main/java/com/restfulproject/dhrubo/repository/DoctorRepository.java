package com.restfulproject.dhrubo.repository;

import com.restfulproject.dhrubo.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.annotation.Resource;

@Resource
public interface DoctorRepository extends JpaRepository<Doctor, String> {

    Doctor findById(Long id);
}

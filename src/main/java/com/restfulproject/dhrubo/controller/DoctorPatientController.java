package com.restfulproject.dhrubo.controller;

import com.restfulproject.dhrubo.model.Doctor;
import com.restfulproject.dhrubo.model.Patient;
import com.restfulproject.dhrubo.payload.ApiResponseDoctorInsert;
import com.restfulproject.dhrubo.payload.ApiResponsePatientInsert;
import com.restfulproject.dhrubo.payload.ApiResponseSignup;
import com.restfulproject.dhrubo.repository.DoctorRepository;
import com.restfulproject.dhrubo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(path = "/api")
public class DoctorPatientController {

    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    PatientRepository patientRepository;

    @PostMapping(value = "/insert/doctor/new",consumes = "application/json")
    public ApiResponseDoctorInsert create(@RequestBody Doctor doctor) {
        Doctor result = doctorRepository.save(doctor);
        return new ApiResponseDoctorInsert("success");
    }

    @PostMapping(value = "/insert/patient/new",consumes = "application/json")
    public ApiResponsePatientInsert create(@RequestBody Patient patient) {
        Patient result = patientRepository.save(patient);
        return new ApiResponsePatientInsert("success");
    }
}

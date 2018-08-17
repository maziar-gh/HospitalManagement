package com.restfulproject.dhrubo.controller;

import com.restfulproject.dhrubo.model.Doctor;
import com.restfulproject.dhrubo.model.Patient;
import com.restfulproject.dhrubo.payload.ApiResponseDoctorInsert;
import com.restfulproject.dhrubo.payload.ApiResponsePatientInsert;
import com.restfulproject.dhrubo.payload.ApiResponseSignup;
import com.restfulproject.dhrubo.repository.DoctorRepository;
import com.restfulproject.dhrubo.repository.PatientRepository;
import org.hibernate.annotations.ColumnTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import javax.transaction.Transactional;


@RestController
@RequestMapping(path = "/api")
public class DoctorPatientController {

    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    PatientRepository patientRepository;

    @PostMapping(value = "/insert/doctor/new", consumes = "application/json")
    public ApiResponseDoctorInsert create(@RequestBody Doctor doctor) {
        Doctor result = doctorRepository.save(doctor);
        return new ApiResponseDoctorInsert("success");
    }

    @PostMapping(value = "/insert/patient/new", consumes = "application/json")
    public ApiResponsePatientInsert create(@RequestBody Patient patient) {
        Patient result = patientRepository.save(patient);
        return new ApiResponsePatientInsert("success");
    }

    @GetMapping(value = "/doctors")
    public Iterable<Doctor> findAllDoctor() {
        return doctorRepository.findAll();
    }

    @GetMapping(value = "/patients")
    public Iterable<Patient> findAllPatient() {
        return patientRepository.findAll();
    }

    @GetMapping(value = "/doctors/{doctor_id}")
    public Doctor findDoctorByID(@PathVariable("doctor_id") Long id) {
        return doctorRepository.findById(id);
    }

    @GetMapping(value = "/patients/{patient_id}")
    public Patient findPatientByID(@PathVariable("patient_id") Long id) {
        return patientRepository.findById(id);


    }

    @PutMapping(value = "/update/doctor/{doctor_id}", consumes = "application/json")
    public ApiResponseDoctorInsert updateDoctor(@PathVariable("doctor_id") Long id, @RequestBody Doctor doctor) {

        if (doctorRepository.findById(id) == null) {
            return new ApiResponseDoctorInsert("failed: Id do not exist");
        }
        doctor.setId(id);
        doctorRepository.save(doctor);
        return new ApiResponseDoctorInsert("updated");
    }

    @PutMapping(value = "/update/patient/{patient_id}", consumes = "application/json")
    public ApiResponsePatientInsert updatePatient(@PathVariable("patient_id") Long id, @RequestBody Patient patient) {

        if (patientRepository.findById(id) == null) {
            return new ApiResponsePatientInsert("failed: Id do not exist");
        }
        patient.setId(id);
        patientRepository.save(patient);
        return new ApiResponsePatientInsert("updated");
    }

    @Transactional
    @DeleteMapping (value = "/delete/doctor/{doctor_id}")
    public ApiResponseDoctorInsert deleteDoctor(@PathVariable("doctor_id") Long id) {
        if (doctorRepository.findById(id) == null) {
            return new ApiResponseDoctorInsert("failed: Id do not exist");
        }

        doctorRepository.removeById(id);
        return new ApiResponseDoctorInsert("deleted");
    }

    @Transactional
    @DeleteMapping (value = "/delete/patient/{patient_id}")
    public ApiResponsePatientInsert deletePatient(@PathVariable("patient_id") Long id) {
        if (patientRepository.findById(id) == null) {
            return new ApiResponsePatientInsert("failed: Id do not exist");
        }

        patientRepository.removeById(id);
        return new ApiResponsePatientInsert("deleted");
    }

}

package com.example.patient_management_1.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.patient_management_1.entity.Doctor;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor,Long> {

}

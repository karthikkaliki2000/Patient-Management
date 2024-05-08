package com.example.patient_management_1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.patient_management_1.entity.Patient;
import com.example.patient_management_1.repository.PatientRepository;

@Service
public class PatientService {

	@Autowired
	PatientRepository patientRepository;
	
	public Patient getById(long id) {
		// TODO Auto-generated method stub
		return patientRepository.findById(id).get();
	}

	public Patient add(Patient patient) {
		// TODO Auto-generated method stub
		return patientRepository.save(patient);
	}

	public Patient update(Patient patient) {
		// TODO Auto-generated method stub
		return patientRepository.save(patient);
	}

	public void delete(long id) {
		// TODO Auto-generated method stub
		patientRepository.deleteById(id);
	}
	
	

}

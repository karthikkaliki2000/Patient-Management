package com.example.patient_management_1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.patient_management_1.entity.Doctor;
import com.example.patient_management_1.entity.Patient;
import com.example.patient_management_1.repository.DoctorRepository;
import com.example.patient_management_1.repository.PatientRepository;

@Service
public class DoctorService {

	@Autowired
	DoctorRepository doctorRepository;
	
	@Autowired
	PatientRepository patientRepository;
	
	public Doctor getById(long id) {
		// TODO Auto-generated method stub
		return doctorRepository.findById(id).get();
	}

	public Doctor add(Doctor doctor, long patientId) {
		Doctor doctor2= doctorRepository.save(doctor);
		Patient patient=patientRepository.findById(patientId).get();
		patient.setDoctor(doctor);
		patientRepository.save(patient);
		return doctor2;
	}

	public Doctor update(Doctor doctor) {
		// TODO Auto-generated method stub
		return doctorRepository.save(doctor);
	}

	public void delete(long id) {
		 
		for(Patient patient:patientRepository.findAll()) {
		            if (patient.getDoctor()!=null && patient.getDoctor().getId().equals(id)) {
		                patient.setDoctor(null);
		                patientRepository.save(patient);
		                doctorRepository.deleteById(id);
		            }
		        }
	}

}

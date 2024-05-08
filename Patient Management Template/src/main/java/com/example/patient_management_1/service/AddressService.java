package com.example.patient_management_1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.patient_management_1.entity.Address;
import com.example.patient_management_1.entity.Patient;
import com.example.patient_management_1.repository.AddressRepository;
import com.example.patient_management_1.repository.PatientRepository;


@Service
public class AddressService {

	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	PatientRepository patientRepository;
	
	public Address getById(Long id) {
		Address address= addressRepository.findById(id).get();
		return address;
	}

	public Address add(Address address, Long id) {
		// TODO Auto-generated method stub
		Address address2=addressRepository.save(address);
		Patient patient=patientRepository.findById(id).get();
		patient.setAddress(address);
		patientRepository.save(patient);
		return address2;
	}

	public Address update(Address address) {
		// TODO Auto-generated method stub
		return addressRepository.save(address);
	}

	public void delete(Long id) {
		for(Patient patient : patientRepository.findAll()) {
			if (patient.getAddress()!=null && patient.getAddress().getId().equals(id)) {
				patient.setAddress(null);
				patientRepository.save(patient);
				addressRepository.deleteById(id);
			}
		}
	}

	

}

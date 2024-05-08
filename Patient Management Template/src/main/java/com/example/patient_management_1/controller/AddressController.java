package com.example.patient_management_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.patient_management_1.entity.Address;
import com.example.patient_management_1.entity.Patient;
import com.example.patient_management_1.service.AddressService;
import com.example.patient_management_1.service.PatientService;

@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	AddressService addressService;
	
	@GetMapping("/{id}")
	public Address getById(@PathVariable Long id) {
		Address address=addressService.getById(id);
		return address;
	}
	
	
	@PostMapping("/add/{patientId}")
	public Address add(@PathVariable Long patientId,@RequestBody Address address) {
		return addressService.add(address,patientId);
	}
	
	
	@PutMapping("/update")
	public Address update(@RequestBody Address address) {
		return addressService.update(address);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		addressService.delete(id);
	}
}

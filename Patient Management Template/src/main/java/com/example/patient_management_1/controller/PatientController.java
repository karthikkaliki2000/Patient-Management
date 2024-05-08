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


import com.example.patient_management_1.entity.Patient;
import com.example.patient_management_1.service.PatientService;

@RestController
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	PatientService patientService;
	
	@GetMapping("/{id}")
	public Patient getById(@PathVariable long id) {
		return patientService.getById(id);
	}
	
	
	@PostMapping("/add")
	public Patient add(@RequestBody Patient patient) {
		return patientService.add(patient);
	}
	
	
	@PutMapping("/update")
	public Patient update(@RequestBody Patient patient) {
		return patientService.update(patient);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable long id) {
		patientService.delete(id);
	}
}

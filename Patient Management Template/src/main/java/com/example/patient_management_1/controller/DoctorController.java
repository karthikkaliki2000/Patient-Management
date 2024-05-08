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

import com.example.patient_management_1.entity.Doctor;
import com.example.patient_management_1.entity.Patient;
import com.example.patient_management_1.service.DoctorService;
import com.example.patient_management_1.service.PatientService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	DoctorService doctorService;
	
	@GetMapping("/{id}")
	public Doctor getById(@PathVariable long id) {
		return doctorService.getById(id);
	}
	
	
	@PostMapping("/add/{patientId}")
	public Doctor add(@PathVariable long patientId,@RequestBody Doctor doctor) {
		return doctorService.add(doctor,patientId);
	}
	
	
	@PutMapping("/update")
	public Doctor update(@RequestBody Doctor doctor) {
		return doctorService.update(doctor);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable long id) {
		doctorService.delete(id);
	}
}

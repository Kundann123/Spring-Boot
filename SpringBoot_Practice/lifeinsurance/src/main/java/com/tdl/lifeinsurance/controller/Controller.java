package com.tdl.lifeinsurance.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tdl.lifeinsurance.entity.Address;
import com.tdl.lifeinsurance.entity.Student;
import com.tdl.lifeinsurance.repository.AddressRepository;
import com.tdl.lifeinsurance.repository.StudentRepository;

@RestController
public class Controller {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	ObjectMapper objectMapper;

	@GetMapping("/saving")
	public void saving() {
		List<Address> address = new ArrayList<Address>();
		
		Student student = new Student();
		student.setName("Raghu");
		student.setCollege("Vignan");
		student.setBranch("CIVIL");
		
		Address ad = new Address();
		ad.setCity("Hyderabad");
		ad.setLocality("Koheda");
		ad.setPinCode(501511);
		ad.setStudent(student);

		Address ad1 = new Address();

		ad1.setCity("Hyderabad");
		ad1.setLocality("Sanghi");
		ad1.setPinCode(501511);
		ad1.setStudent(student);
		address.add(ad1);
		address.add(ad);
		
		student.setAddress(address);

		try {
			String writeValueAsString = objectMapper.writeValueAsString(student);
			System.out.println("Student--->" + writeValueAsString);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		studentRepository.save(student);

	}

	@PostMapping("/saving")
	public void saving1(@RequestBody Student student) {

		try {
			String writeValueAsString = objectMapper.writeValueAsString(student);
			System.out.println("Student--->" + writeValueAsString);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		studentRepository.save(student);
	}
	
	@GetMapping("/fetch/{id}")
	public Optional<Student> fetchData(@PathVariable("id") int id){
		return studentRepository.findById(id);
	}
}

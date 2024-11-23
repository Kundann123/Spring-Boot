package com.dbmodule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbmodule.model.Employee;
import com.dbmodule.repository.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;
	
	public void saveEmployee(Employee emp) {
		employeeRepo.save(emp);
	}
}

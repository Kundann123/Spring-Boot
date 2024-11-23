package com.dbmodule.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dbmodule.exception.UserDetailsNotFoundException;
import com.dbmodule.model.Company;
import com.dbmodule.model.Employee;
import com.dbmodule.service.CompanyService;
import com.dbmodule.service.EmployeeService;

@RestController
@RequestMapping("/jpa/emp")
public class EmployeeController {

	@Autowired
	private CompanyService companyService;
	@Autowired
	private EmployeeService employeeService;

	// method used for retrieving all the employees related to target company.
	//id -> company id
	@GetMapping("/get/{id}/com")
	public List<Employee> findEmpDataById(@PathVariable int id) {
		Optional<Company> data = companyService.findEmpDetailsById(id);
		if (data.isEmpty()) {
			throw new UserDetailsNotFoundException("Data not found of ID: " + id);
		}
		return data.get().getEmployee();
	}

	// adding new employee for the company
	@PostMapping("/add/{id}")
	public ResponseEntity<String> addEmpforCom(@PathVariable int id, @RequestBody Employee emp) {
		Optional<Company> comOptional = companyService.findEmpDetailsById(id);
		if (comOptional.isEmpty()) {
			throw new UserDetailsNotFoundException("Deta not found of ID: " + id);
		}
		Company company = comOptional.get();
		emp.setCompany(company); // map the company to the employee
		employeeService.saveEmployee(emp); // save employee to the database
		return ResponseEntity.status(HttpStatus.CREATED).body("Sucess");
	}
}

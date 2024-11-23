package com.dbmodule.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dbmodule.model.Company;
import com.dbmodule.service.CompanyService;

@RestController
@RequestMapping("/jpa/com")
public class CompanyController {
	@Autowired
	private CompanyService companyService;

	// method for adding company data
	@PostMapping("/add")
	public ResponseEntity<String> addCompany(@RequestBody Company com) {
		companyService.saveComData(com);
		return ResponseEntity.status(HttpStatus.CREATED).body("Success"); // proper response
	}

	//get-method for getting all companies
	@GetMapping("/get_all")
	public List<Company> getAllCompnies() {
		return companyService.getAllComData();
	}

	// post-method for getting one or all companies
	@PostMapping("/get")
	public List<Company> postMethodName(@RequestBody Company com) {
		List<Company> comList = new ArrayList<Company>();
		Optional<Company> singleCom = companyService.findEmpDetailsById(com.getComId());

		if (singleCom.isEmpty()) {
			companyService.getAllComData().forEach(comList::add); 
		} else {
			singleCom.stream().forEach(comList::add); //adding result into list
		}
		return comList;
	}

}

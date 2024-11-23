package com.dbmodule.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dbmodule.model.Company;
import com.dbmodule.repository.CompanyRepo;

@Service
public class CompanyService{
	
	@Autowired
	private CompanyRepo jpaRepo;
	
	public void saveComData(Company com) {
		jpaRepo.save(com);
	}

	public List<Company> getAllComData() {
		return jpaRepo.findAll();
	}
	
	public Optional<Company> findEmpDetailsById(int id) {
		return jpaRepo.findById(id);
	}
}

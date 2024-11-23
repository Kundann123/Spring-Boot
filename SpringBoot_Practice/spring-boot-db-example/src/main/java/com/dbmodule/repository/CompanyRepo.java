package com.dbmodule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.dbmodule.model.Company;

@Repository
public interface CompanyRepo extends JpaRepository<Company, Integer>{

}

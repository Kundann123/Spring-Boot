package com.dbmodule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.dbmodule.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}

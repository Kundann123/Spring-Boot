package com.tdl.lifeinsurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tdl.lifeinsurance.entity.Student;


public interface StudentRepository extends JpaRepository<Student, Integer>{

	
}

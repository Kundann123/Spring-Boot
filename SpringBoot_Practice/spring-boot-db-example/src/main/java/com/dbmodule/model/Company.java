package com.dbmodule.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int comId;
	private String comName;
	private String location;
	@OneToMany(mappedBy = "company")
	@JsonIgnore
	private List<Employee> employee;
	
	protected Company() {
		
	}
	public Company(int comId, String comName, String location) {
		super();
		this.comId = comId;
		this.comName = comName;
		this.location = location;
	}
	
	public int getComId() {
		return comId;
	}
	public void setComId(int comId) {
		this.comId = comId;
	}
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public List<Employee> getEmployee() {
		return employee;
	}
	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}
	
	@Override
	public String toString() {
		return "Company [comId=" + comId + ", comName=" + comName + ", location=" + location + ", employee=" + employee
				+ "]";
	}
}

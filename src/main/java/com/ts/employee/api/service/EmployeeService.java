package com.ts.employee.api.service;

import java.util.List;
import java.util.Optional;

import com.ts.employee.api.entities.Employee;


public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public Optional<Employee> getEmployee(Long empId);
	
	List<Employee> findByEmail(String email);
	
	public void createEmployee(Employee emp);
	
	public void deleteEmployee(Long empId);
	
	public void updateEmployee(Employee emp);
	
	

}

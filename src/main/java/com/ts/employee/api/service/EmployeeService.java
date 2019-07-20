package com.ts.employee.api.service;

import java.util.List;

import com.ts.employee.api.modal.Employee;


public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public Employee getEmployee(Long empId);
	
	List<Employee> findByEmail(String email);
	
	public void createEmployee(Employee emp);
	
	public void deleteEmployee(Long empId);
	
	public void updateEmployee(Employee emp);
	
	

}

package com.ts.employee.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ts.employee.api.entities.Employee;
import com.ts.employee.api.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	

	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> findAll() {	
		List<Employee> emps= (List<Employee>)employeeRepository.findAll();
		return emps;
	}

	
	public Optional<Employee> getEmployee(Long empId) {		
		return employeeRepository.findById(empId);
	}

	@Override
	public void createEmployee(Employee emp) {
		employeeRepository.save(emp);
	}

	@Override
	public void deleteEmployee(Long empId) {
		employeeRepository.deleteById(empId);
		
	}

	@Override
	public void updateEmployee(Employee emp) {		
		employeeRepository.save(emp);
		
	}

	@Override
	public List<Employee> findByEmail(String email) {
		return employeeRepository.findByEmail(email);
	}
	
	

}

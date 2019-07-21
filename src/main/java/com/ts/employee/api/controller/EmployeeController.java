package com.ts.employee.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ts.employee.api.entities.Employee;
import com.ts.employee.api.exception.EmployeeNotFoundException;
import com.ts.employee.api.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {		
		this.employeeService = employeeService;
	}

	@GetMapping("/api/employees")
	public List<Employee> getEmployees(){		
		return employeeService.findAll();
		
	}	

	@GetMapping("/api/employee/email/{emailId}")
	public List<Employee> findByEmail(@PathVariable(name="emailId") String emailId){		
		return employeeService.findByEmail(emailId);
		
	}
	
	@GetMapping("/api/employee/{empId}")
	public ResponseEntity<Employee> getEmployee(@PathVariable(name="empId")Long empId){			
		log.info("Start Method getEmployee()");		
		log.info("Employee ID::::::{}",empId);		
		return employeeService.getEmployee(empId)
                .map(emp -> new ResponseEntity<>(emp, HttpStatus.OK))
                .orElseThrow(() -> new EmployeeNotFoundException(empId));
		}	
	
	@PostMapping("/api/employee/create")
	public ResponseEntity<?> createEmployee(@RequestBody Employee emp,UriComponentsBuilder ucBuilder){		
		
		employeeService.createEmployee(emp);
		  HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/api/books/{isbn}").buildAndExpand(emp.getId()).toUri());
	        return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}	
	@DeleteMapping("/api/employee/delete/{empId}")
	public ResponseEntity<?> deleteEmployee(@PathVariable(name="empId") Long empId){		
		
		 return employeeService.getEmployee(empId)
	                .map(emp -> {
	                	employeeService.deleteEmployee(empId);
	                    return new ResponseEntity(HttpStatus.NO_CONTENT);
	                })
	                .orElseThrow(() -> new EmployeeNotFoundException(empId));		
		
		
	}
	
	
	
	@PutMapping("/api/employee/update")
	public ResponseEntity<Employee> updateEmployee(@Valid @RequestBody Employee emp){			
		 return employeeService.getEmployee(emp.getId())
	                .map(empToUpdate -> {	                	
	                	empToUpdate.setId(emp.getId());
	                	empToUpdate.setName(emp.getName());
	                	empToUpdate.setEmail(emp.getEmail());
	                	empToUpdate.setSalary(emp.getSalary());
	                	empToUpdate.setDepartment(emp.getDepartment());
	                	
	                	employeeService.updateEmployee(empToUpdate);

	                    return new ResponseEntity<>(empToUpdate, HttpStatus.OK);
	                })
	                .orElseThrow(() -> new EmployeeNotFoundException(emp.getId()));	
		
	}
	

}

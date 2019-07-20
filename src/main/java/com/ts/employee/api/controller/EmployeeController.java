package com.ts.employee.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ts.employee.api.modal.Employee;
import com.ts.employee.api.service.EmployeeService;

@RestController
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
	public Employee getEmployee(@PathVariable(name="empId")Long empId){		
		return employeeService.getEmployee(empId);
		
	}	
	
	@PostMapping("/api/employee/create")
	public void createEmployee(@RequestBody Employee emp){		
		employeeService.createEmployee(emp);
		
	}
	
	
	@DeleteMapping("/api/employee/delete/{empId}")
	public void deleteEmployee(@PathVariable(name="empId") Long empId){		
		employeeService.deleteEmployee(empId);
		
	}
	
	@PutMapping("/api/employee/update")
	public void updateEmployee(@RequestBody Employee emp){	
		Employee employee=null;
		if(null !=emp) {
			employee=employeeService.getEmployee(emp.getId());			
		}
		if(null !=employee) {
			employeeService.updateEmployee(emp);
		}		
		else {
			System.out.println("Employee Object null;");
		}
		
		
	}
	

}

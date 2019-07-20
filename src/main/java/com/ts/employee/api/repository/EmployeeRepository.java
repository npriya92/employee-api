package com.ts.employee.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ts.employee.api.modal.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Long>{
	
	List<Employee> findByEmail(String email);
	
	
	
	

}

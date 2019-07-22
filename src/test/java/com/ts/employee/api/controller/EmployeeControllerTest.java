package com.ts.employee.api.controller;

import static org.junit.Assert.fail;
import static org.mockito.BDDMockito.given;
import static  org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static  org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static  org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.ts.employee.api.entities.Employee;
import com.ts.employee.api.service.EmployeeService;

@RunWith(SpringRunner.class)
@WebMvcTest
public class EmployeeControllerTest {
	
	@MockBean
	private EmployeeService employeeService;
	
	@Autowired
	private MockMvc mockMvc;
	

	@Test
	public void testGetEmployees() throws Exception{
		//given
		Employee emp1 = new Employee();
		emp1.setId(1L);
		emp1.setEmail("test@gmail.com");
		emp1.setName("Test");
		emp1.setDepartment("123");
		emp1.setSalary(6000);		
		
		List<Employee> employees = new ArrayList<Employee>();	
		employees.add(emp1);
		given(employeeService.findAll()).willReturn(employees);		
		// when + then
		this.mockMvc.perform(get("/api/employees")).andExpect(status().isOk())
		.andExpect(content().json("[{'id':1,'email':'test@gmail.com','name':'Test','department':'123','salary':6000}]"));
		
		
		
	}

	@Test
	public void testFindByEmail() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetEmployee() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateEmployee() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteEmployee() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateEmployee() {
		fail("Not yet implemented");
	}

}

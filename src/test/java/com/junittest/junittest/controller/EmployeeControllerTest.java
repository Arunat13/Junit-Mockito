package com.junittest.junittest.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.junittest.junittest.model.Employee;
import com.junittest.junittest.service.EmployeeService;

import ch.qos.logback.core.net.ObjectWriter;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private EmployeeService employeeService;
	
	Employee employeeOne;
	Employee employeeTwo;
	List<Employee> employeesList = new ArrayList();
	int count = 0;
	int count2 = 0;

	@BeforeEach
	public void setUp() {
		employeeOne = new Employee(1, "AAAA", "aaa@gmail.com", "9944556677", "psw1");
		employeeTwo = new Employee(2, "BBBB", "bbb@gmail.com", "8877667788", "psw2");

		employeesList.add(employeeOne);
		employeesList.add(employeeTwo);
		
		System.out.println("Hello :" + count++);
	}

	@AfterEach
	void tearDown() {
		System.out.println("Hello tearDown :" + count2++);
	}

	@Test
	public void testGetEmployeeById() throws Exception {
		Mockito.when(employeeService.getEmployeeByEmployeeName("AAAA")).thenReturn(employeeOne);
		mockMvc.perform(MockMvcRequestBuilders.get("/employee/getName" + "/AAAA"))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
//	@Disabled -> which used to skip this test case only
	public void testGetAllEmployee() throws Exception {
		Mockito.when(employeeService.getAllEmployee()).thenReturn(employeesList);
		mockMvc.perform(MockMvcRequestBuilders.get("/employee/get")).andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void testCreateEmployee() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        com.fasterxml.jackson.databind.ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(employeeOne);
        
		Employee employee = new Employee(1, "AAAA", "aaa@gmail.com", "9944556677", "psw1");
		Mockito.when(employeeService.createEmployee(employee)).thenReturn("success");
		mockMvc.perform(MockMvcRequestBuilders.post("/employee/createEmp" ).contentType(MediaType.APPLICATION_JSON)
				.content(requestJson)).andExpect(MockMvcResultMatchers.status().isOk());
		
		

	}

	
	

}

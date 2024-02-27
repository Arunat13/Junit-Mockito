package com.junittest.junittest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.junittest.junittest.model.Employee;
import com.junittest.junittest.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/createEmp")
	public String createEmployee(@RequestBody Employee employee) {

		employeeService.createEmployee(employee);

		return "success";
	}
	
	@GetMapping("/get/{id}")
	public Employee getEmployeeById(@PathVariable("id") int id) {
		
		Employee employee = employeeService.getEmployeeById(id);
		
		return employee;
	}
	
	@GetMapping("/get")
	public List<Employee> getAllEmployees(){
		
		List<Employee> employees = employeeService.getAllEmployee();
		
		return employees;
	}
	
	@GetMapping("/getName/{employeeName}")
	public Employee getEmployeeByEmployeeName(@PathVariable("employeeName") String employeeName) {
		
		Employee employee = employeeService.getEmployeeByEmployeeName(employeeName);
		
		return employee;
	}
}
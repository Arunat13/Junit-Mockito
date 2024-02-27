package com.junittest.junittest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.junittest.junittest.model.Employee;


public interface EmployeeService {

	String createEmployee(Employee employee);

	Employee getEmployeeById(int id);

	List<Employee> getAllEmployee();

	Employee getEmployeeByEmployeeName(String employeeName);


}

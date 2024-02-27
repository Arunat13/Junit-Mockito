package com.junittest.junittest.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.junittest.junittest.model.Employee;
import com.junittest.junittest.repo.EmployeeRepository;
import com.junittest.junittest.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public String createEmployee(Employee employee) {

		employeeRepository.save(employee);
		
		return "success";
	}

	@Override
	public Employee getEmployeeById(int id){

		Employee employee = employeeRepository.findById(id).orElseThrow(RuntimeException::new);
		return employee;
	}

	public List<Employee> getAllEmployee() {

		List<Employee> employees = employeeRepository.findAll();

		return employees;
	}

	@Override
	public Employee getEmployeeByEmployeeName(String employeeName) {

		Employee employee = employeeRepository.findByEmployeeName(employeeName).orElseThrow(RuntimeException::new);
		return employee;
	}
	
	

}

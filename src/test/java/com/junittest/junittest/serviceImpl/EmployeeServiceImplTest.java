package com.junittest.junittest.serviceImpl;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.junittest.junittest.model.Employee;
import com.junittest.junittest.repo.EmployeeRepository;
import com.junittest.junittest.service.EmployeeService;



public class EmployeeServiceImplTest {

	@Mock
	private EmployeeRepository employeeRepository;
	private EmployeeService employeeService;
	AutoCloseable autoCloseable;
	Employee employee;

	@BeforeEach
	public void setUp() {
		autoCloseable = MockitoAnnotations.openMocks(this);
		employeeService = new EmployeeServiceImpl(employeeRepository);
		employee = new Employee(1, "AAAA", "aaa@gmail.com", "9944556677", "psw");
	}

	@AfterEach
	public void tearDown() throws Exception {
		autoCloseable.close();
	}
	
	@Test
	void testCreateEmployee() {
	
		
		mock(Employee.class);
		mock(EmployeeRepository.class);

		when(employeeRepository.save(employee)).thenReturn(employee);
		assertThat(employeeService.createEmployee(employee)).isEqualTo("success");
		
		
	}

	
	
}

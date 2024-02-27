package com.junittest.junittest.repo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.junittest.junittest.model.Employee;

@DataJpaTest
public class EmployeeRepositoryTest {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	Employee employee;
	
	@BeforeEach
	public void setUp() {
		employee =  new Employee(1,"AAAA","aaa@gmail.com","9944556677","psw");
		employeeRepository.save(employee);
	}
	
	@AfterEach
	public void tearDown() {
		employee = null;
		employeeRepository.deleteAll();
	}
	
	@Test
	public void testFindByEmployee() {
		Optional<Employee> employeeByName = employeeRepository.findByEmployeeName("AAAA");
		
		assertThat(employeeByName.get().getEmployeePhone()).isEqualTo(employee.getEmployeePhone());
	}
	
	
}

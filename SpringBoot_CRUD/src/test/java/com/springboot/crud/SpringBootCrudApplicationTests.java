package com.springboot.crud;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.springboot.crud.model.Employee;
import com.springboot.crud.repository.EmployeeRepository;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class SpringBootCrudApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;

	// Test Case 1: To check if the Employee data is saved to DB
	@Test
	@Order(1)
	@Rollback(value=false)
	public void saveEmployeeTest() {
		Employee employee = new Employee();
		employee.setId(100);
		employee.setFirstName("Rakesh");
		employee.setLastname("Upadhay");
		employee.setEmailId("raku.upad@gmail.com");
		employeeRepository.save(employee);
		assertThat(employee.getId()).isEqualTo(100);
	}
	
	//Test Case 2: To check 
	@Test
	@Order(2)
	@Rollback(value = false)
	public void getEmployeeTest() {
		Employee employee = new Employee();
		employee.setId(101);
		employee.setFirstName("sss");
		employee.setLastname("Upadhay");
		employee.setEmailId("raku.upad@gmail.com");
		employeeRepository.save(employee);
		Employee emmployee=employeeRepository.findById(101).get();
		assertThat(emmployee.getId()).isEqualTo(101);
		
		
	}
}

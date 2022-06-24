package com.springboot.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.crud.exception.ResourceNotFoundException;
import com.springboot.crud.model.Employee;
import com.springboot.crud.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	// Fetch All employees
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

	// Save Single Employee
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	// Save Multiple Employee
	public List<Employee> saveEmployees(List<Employee> employee) {
		return employeeRepository.saveAll(employee);
	}

	// Fetch Employee by Id
	public Employee getEmployeeById(int id) {
		return employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee does not Exist with Id" + id));
	}

	// Update Employee based on Id
	public Employee updateEmployee(int id, Employee employee) {
		Employee updatedEmployee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee does not Exist with Id:" + id));
		updatedEmployee.setFirstName(employee.getFirstName());
		updatedEmployee.setLastname(employee.getLastname());
		updatedEmployee.setEmailId(employee.getEmailId());
		return employeeRepository.save(updatedEmployee);

	}

	// Delete Employee based on Id
	public void deleteEmployee(int id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee does not Exist with Id:" + id));

	 employeeRepository.delete(employee);

	}

}

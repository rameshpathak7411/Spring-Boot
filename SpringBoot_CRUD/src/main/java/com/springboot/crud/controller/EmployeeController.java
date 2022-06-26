package com.springboot.crud.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.crud.model.Employee;
import com.springboot.crud.service.EmployeeService;

@RestController
@RequestMapping("/api/c1")
public class EmployeeController {
	Logger logger= LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/allEmployees")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		/* return employeeService.getEmployees(); */
		logger.info("Inside the getAllEmployee()" );
		return  ResponseEntity.ok(employeeService.getEmployees());
	}
	
	@PostMapping("/createEmployee")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}
	
	@PostMapping("/createMultipleEmployee")
	public List<Employee> createEmployees(@RequestBody List<Employee> employee) {
		return employeeService.saveEmployees(employee);
	}
	
	@GetMapping("/getEmployeeById/{id}")
	public Employee getEmployeeById(@PathVariable int id) {
		return employeeService.getEmployeeById(id);
	}
	
	@PutMapping("/updateEmployee/{id}")
	public Employee updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
		return employeeService.updateEmployee(id, employee);
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public void deleteEmployee(@PathVariable int id) {
		 employeeService.deleteEmployee(id);
		
	}

}

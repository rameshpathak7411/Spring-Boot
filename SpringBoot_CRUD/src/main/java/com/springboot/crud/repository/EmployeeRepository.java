package com.springboot.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.crud.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	//Employee deleteById(Employee employee);
	
	

}

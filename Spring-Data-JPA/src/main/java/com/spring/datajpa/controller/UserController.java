package com.spring.datajpa.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.datajpa.model.User;
import com.spring.datajpa.service.UserService;

@RestController
@RequestMapping("/spring-data-jpa")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to SpringBoot Data JPA App";
		
	}
	
	//Fetch All the Users from DB
	@GetMapping("/users")
	public List<User> getUsers() {
		return userService.getUsers();
		
	}
	
	//Save Single User to DB
	@GetMapping("/saveUsers")
	public List<User> saveUser() {
		return userService.getUsers();

	}
	
	//Fetch User by Profession
	@GetMapping("/getUserByProfession/{profession}")
	public List<User> getUsersByProfession(@PathVariable String profession){
		return userService.getUsersByProfession(profession);
	}
	
	//Count User by Age
	@GetMapping("/countUserByAge/{age}")
	public int countUsersByAge(@PathVariable int age) {
		return userService.countUserByAge(age);
	}
	
	//Delete User by Name
	@DeleteMapping("/deleteByName/{name}")
	public List<User> deleteByName(@PathVariable String name) {
		return userService.deleteByName(name);
	}
	
	//Find By Profession and Age
	@GetMapping("/findByProfessionAge/{profession}/{age}")
	public List<User> countUsersByAge(@PathVariable String profession, @PathVariable int age) {
		return userService.findByProfessionAndAge(profession, age);
	}
	
	//Sort data by field
	@GetMapping("/sort/{field}")
	public List<User> getSortedUser(@PathVariable String field) {
		return userService.getUsersBySort(field);
	}
	
	@GetMapping("/findByProfessionIgnoreCase")
	public List<User> getUserByProfession(@RequestParam("profession") String profession){
		return userService.getUsersByProfessionIgnorecase(profession);
	}
	
	@GetMapping("/customerQueryFetchUsers")
	public List<User> getUsersCustomQuery(){
		return userService.getUserCustomQuery();
	}
	
	@GetMapping("/getPaginatedData")
	public Page<User> getPaginatedRecords(){
		return userService.getPaginatedUser();
		
	}
	
	

}

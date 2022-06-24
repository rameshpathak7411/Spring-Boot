package com.spring.datajpa.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.spring.datajpa.dao.UserRepository;
import com.spring.datajpa.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;

	@PostConstruct
	public void loadUsers() {
		List<User> users=new ArrayList<>();
	    users.add(new User(110,"Ramesh","IT",23));
	    users.add(new User(111,"Vaibhav","IT",25));
	    users.add(new User(112,"shailesh","Medical",20));
	    users.add(new User(113,"Khan","CA",30));
	    users.add(new User(114,"Subodh","Business",30));
	    repository.saveAll(users);
	}
	
	public List<User> getUsers(){
		return repository.findAll();
	}

	public List<User> saveUser(){
		return repository.save(null);
	}

	
	public List<User> getUsersByProfession(String profession){
		return repository.findByProfession(profession);
	}
	
	public int countUserByAge(int age) {
		return repository.countByAge(age);
	}
	
	public List<User> deleteByName(String name) {
		return repository.deleteByName(name);
	}
	
	public List<User> findByProfessionAndAge(String profession, int age){
		return repository.findByProfessionAndAge(profession, age);
	}
	
	//Sorting
	public List<User> getUsersBySort(String field){
	    return repository.findAll(org.springframework.data.domain.Sort.by(field));
	}
	
	public List<User> getUsersByProfessionIgnorecase(String  profession){
		return repository.findByProfessionIgnoreCase(profession);
	}
	
	//Custom Query
	public List<User> getUserCustomQuery(){
		return repository.getUserCustomQuery();
	}
	
	//Pagination and sorting
	public Page<User> getPaginatedUser(){
		return repository.findAll(PageRequest.of(0, 2, Sort.by("name")));
	}
	
	 
}

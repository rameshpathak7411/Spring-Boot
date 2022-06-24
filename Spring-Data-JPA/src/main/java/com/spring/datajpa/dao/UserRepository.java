package com.spring.datajpa.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.datajpa.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	public List<User> findByProfession(String profession);
	public int countByAge(int age);
	public User findByAge(int age);
	public List<User> deleteByName(String name);
	//MultiCondition
	public List<User> findByProfessionAndAge(String profession,int age);
	//Custom Query
	@Query(value="select u from User u where u.profession=IT")
	public List<User> getUserCustomQuery();
	public List<User> findByProfessionIgnoreCase(String profession);
	
	

}

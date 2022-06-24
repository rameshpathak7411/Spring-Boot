package com.spring.datajpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString*/
@Entity
@Table

public class User {
   
	@Id
	@Column(columnDefinition = "JSON")
	private int id;
	@Column(columnDefinition = "JSON")
	private String name;
	@Column(columnDefinition = "JSON")
	private String profession;
	@Column(columnDefinition = "JSON")
	private int age;
	
	public User() {
		
	}
	public User(int id, String name, String profession, int age) {
		super();
		this.id = id;
		this.name = name;
		this.profession = profession;
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", profession=" + profession + ", age=" + age + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}

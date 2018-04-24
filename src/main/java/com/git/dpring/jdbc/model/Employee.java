package com.git.dpring.jdbc.model;

public class Employee {
	public Employee() {
	}
	
	public Employee( String name, Byte age, Integer dept) {
		this.name = name;
		this.age = age;
		this.dept = dept;
	}
	
	Integer id;
	String name;
	Byte age;
	Integer dept;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Byte getAge() {
		return age;
	}
	public void setAge(Byte age) {
		this.age = age;
	}
	public Integer getDept() {
		return dept;
	}
	public void setDept(Integer dept) {
		this.dept = dept;
	}
	

}

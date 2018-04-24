package com.git.dpring.jdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.git.dpring.jdbc.dao.EmployeeDao;
import com.git.dpring.jdbc.model.Employee;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao employeeDao ;
	
	public int getEmpCount() {
		return employeeDao.getCountEmployee();
	}
	
	public void addEmployee(Employee emp) {
		employeeDao.addEmployee(emp);
	}
	
	public List<Employee> getAllEmployees()  {
		return employeeDao.getAllEmployees();
	}

}

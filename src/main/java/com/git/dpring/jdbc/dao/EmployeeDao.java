package com.git.dpring.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.git.dpring.jdbc.model.Employee;
import com.git.dpring.jdbc.rowmapper.EmployeeRowMapper;

@Repository
public class EmployeeDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	private static final String GET_ALL_EMPLOYEE_COUNT = "SELECT count(*) FROM employee";
	 private static final String INSERT_EMPLOYEE= "insert into employee (name,age,dept) "
	 		+ "values (:name,:age,:dept)";
	 
	 private static final String EMPLOYEE = "SELECT * FROM employee";
	
	public int getCountEmployee() {
		return jdbcTemplate.queryForObject(GET_ALL_EMPLOYEE_COUNT,Integer.class);
	}
	
	public void addEmployee(Employee emp) {
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("name", emp.getName())
				.addValue("age", emp.getAge())
				.addValue("dept", emp.getDept());
		KeyHolder keyHolder = new GeneratedKeyHolder();
		namedParameterJdbcTemplate.update(INSERT_EMPLOYEE, param,keyHolder);
		
	}
	
	public List<Employee> getAllEmployees() {
		List<Employee> emps = jdbcTemplate.query(EMPLOYEE, new EmployeeRowMapper());
		return emps;
		
	}

}

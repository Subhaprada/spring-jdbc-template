package com.git.dpring.jdbc.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("classpath:application.properties")
public class BeanConfiguration {
	@Autowired
	Environment env;
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource  = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("mysql.driverClass"));
		dataSource.setUrl(env.getProperty("mysql.url"));
		dataSource.setUsername(env.getProperty("mysql.user"));
		dataSource.setPassword(env.getProperty("mysql.password"));
		return dataSource;
	}
	
	@Bean
	public JdbcTemplate getJdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
	}
	

	@Bean
	public NamedParameterJdbcTemplate getNamedParamJdbcTemplate() {
		NamedParameterJdbcTemplate namedTemplate = new NamedParameterJdbcTemplate(getDataSource());
		return namedTemplate;
	}
	
}

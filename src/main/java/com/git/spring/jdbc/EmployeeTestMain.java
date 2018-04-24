package com.git.spring.jdbc;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.git.dpring.jdbc.model.Employee;
import com.git.dpring.jdbc.service.EmployeeService;

public class EmployeeTestMain {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext();
		ctx.scan("com.git");
		ctx.refresh();
		EmployeeService service = ctx.getBean("employeeService",EmployeeService.class);
		System.out.println(service.getEmpCount());
		
		System.out.println(service.getEmpCount());
		
		Employee emp = getEmployee();
		//service.addEmployee(emp);
		System.out.println(service.getEmpCount());
		listAllEmployee(service);

	}

	private static Employee getEmployee() {
		Employee emp = new Employee("Hari",new Byte("12"),45);
		return emp;
	}
	
	
	private static void listAllEmployee(EmployeeService empService) {
		List<Employee> employees = empService.getAllEmployees();
		
		employees.forEach(emp -> {
			System.out.print("id:" + emp.getId());
			System.out.print(",name: "+emp.getName());
			System.out.print(",age:"+emp.getAge());
			System.out.print(",dept:"+emp.getDept());
			System.out.println();
			
		});
		
		
	}

}

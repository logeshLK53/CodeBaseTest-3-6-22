package com.zensar.hrservice.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.hrservice.models.Employee;


@RestController
@RequestMapping("/hr")
public class HrResource {
	
	List<Employee> employees = Arrays.asList(
		new Employee("e1", "LK", "Dean"),
		new Employee("e2", "Buvaneshwari", "Ortho"),
		new Employee("e3", "Kathir", "Surgery")
	);
	
	@RequestMapping("/employees")
	public Employee getEmployees() {
		
		Employee employeesList = new Employee();
		employeesList.setEmployees(employees);		
		return employeesList;
	}
	
	@RequestMapping("/employees/{Id}")
	public Employee getEmployeeById(@PathVariable("Id") String Id) {
		Employee emp = employees.stream()
				.filter(employee ->Id.equals(employee.getId()))
				.findAny()
				.orElse(null);
		return emp;
	}		

}

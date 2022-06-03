package com.zensar.Admissions.model;

import java.util.List;

public class Employee {
		private String id;
		private String name;
		private String role;
		
		public List<Employee> employees;
		
		public Employee() {
			
		}

		public Employee(String id, String name, String role) {
		
			this.id = id;
			this.name = name;
			this.role = role;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		public List<Employee> getEmployees() {
			return employees;
		}

		public void setEmployees(List<Employee> employees) {
			this.employees = employees;
		}
		

}

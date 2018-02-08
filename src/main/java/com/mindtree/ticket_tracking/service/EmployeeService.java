package com.mindtree.ticket_tracking.service;

import java.util.List;

import com.mindtree.ticket_tracking.entity.Employee;

public interface EmployeeService {
	public List<Employee> getAllEmployees();
	public Employee getEmployeeById(String mid);
	public void removeEmployee(String mid);
	public void addEmployee(Employee employee);
	
	
}

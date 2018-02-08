package com.mindtree.ticket_tracking.dao;

import java.util.List;

import com.mindtree.ticket_tracking.entity.Employee;
import com.mindtree.ticket_tracking.exceptions.EmployeeDaoException;

public interface EmployeeDao {

	public List<Employee> getAllEmployee() throws EmployeeDaoException;

	public Employee getEmployeeByMid(String mid);

	public void deleteEmployee(String mid);
	
	public void addEmployee(Employee employee);

}

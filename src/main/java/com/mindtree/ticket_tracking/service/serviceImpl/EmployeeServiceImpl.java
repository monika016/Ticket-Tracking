package com.mindtree.ticket_tracking.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.ticket_tracking.dao.EmployeeDao;
import com.mindtree.ticket_tracking.entity.Employee;
import com.mindtree.ticket_tracking.exceptions.EmployeeDaoException;
import com.mindtree.ticket_tracking.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	public List<Employee> getAllEmployees() {
		System.out.println("in service");
		try {
			return this.employeeDao.getAllEmployee();
		} catch (EmployeeDaoException e) {
			// TODO Auto-generated catch block
			return null;
			
 		}
	}

	public Employee getEmployeeById(String mid) {
		return this.employeeDao.getEmployeeByMid(mid);
	}

	public void removeEmployee(String mid) {
		this.employeeDao.deleteEmployee(mid);
	}

	public void addEmployee(Employee employee) {
		this.employeeDao.addEmployee(employee);
	}

}

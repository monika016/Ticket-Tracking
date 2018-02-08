package com.mindtree.ticket_tracking.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EmployeeDto {
	private String mid;

	private String employee_name;

	private String date;

	private String dept;

	public EmployeeDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeDto(String mid, String employee_name, String date, String dept) {
		super();
		this.mid = mid;
		this.employee_name = employee_name;
		this.date = date;
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "EmployeeDto [mid=" + mid + ", employee_name=" + employee_name + ", date=" + date + ", dept=" + dept
				+ "]";
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

}

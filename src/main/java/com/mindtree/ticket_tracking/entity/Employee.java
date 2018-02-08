package com.mindtree.ticket_tracking.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Employee")
public class Employee {

	@Id
	private String mid;

	@Column
	private String employee_name;

	@Column
	private String date;

	@Column
	private String dept;

	@OneToMany(mappedBy = "resolvedByEmployee", fetch = FetchType.EAGER)
	@JsonManagedReference
	private Set<Ticket> resolvedTickets = new HashSet<Ticket>();

	@OneToMany(mappedBy = "raisedByEmployee", fetch = FetchType.EAGER)
	@JsonManagedReference
	private Set<Ticket> raisedTickets = new HashSet<Ticket>();

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String mid, String employee_name, String date, String dept, Set<Ticket> resolvedTickets,
			Set<Ticket> raisedTickets) {
		super();
		this.mid = mid;
		this.employee_name = employee_name;
		this.date = date;
		this.dept = dept;
		this.resolvedTickets = resolvedTickets;
		this.raisedTickets = raisedTickets;
	}

	@Override
	public String toString() {
		return "Employee [mid=" + mid + ", employee_name=" + employee_name + ", date=" + date + ", dept=" + dept
				+ ", resolvedTickets=" + resolvedTickets + ", raisedTickets=" + raisedTickets + "]";
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

	public Set<Ticket> getResolvedTickets() {
		return resolvedTickets;
	}

	public void setResolvedTickets(Set<Ticket> resolvedTickets) {
		this.resolvedTickets = resolvedTickets;
	}

	public Set<Ticket> getRaisedTickets() {
		return raisedTickets;
	}

	public void setRaisedTickets(Set<Ticket> raisedTickets) {
		this.raisedTickets = raisedTickets;
	}

}

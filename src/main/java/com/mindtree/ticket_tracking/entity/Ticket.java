package com.mindtree.ticket_tracking.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "ticket")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ticked_Id;

	@ManyToOne( fetch = FetchType.EAGER)
	@JoinColumn(name = "mid")
	@JsonBackReference
	private Employee raisedByEmployee;

	@Column
	private String raisedDate;

	@Column
	private String severity;

	@Column
	private String ticketDesciption;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "mid_r")
	@JsonBackReference
	private Employee resolvedByEmployee;

	@Column
	private String resolution;

	@Column
	private String resolvedDate;

	@Column
	private String status;

	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ticket(int ticked_Id, Employee raisedByEmployee, String raisedDate, String severity, String ticketDesciption,
			Employee resolvedByEmployee, String resolution, String resolvedDate, String status) {
		super();
		this.ticked_Id = ticked_Id;
		this.raisedByEmployee = raisedByEmployee;
		this.raisedDate = raisedDate;
		this.severity = severity;
		this.ticketDesciption = ticketDesciption;
		this.resolvedByEmployee = resolvedByEmployee;
		this.resolution = resolution;
		this.resolvedDate = resolvedDate;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Ticket [ticked_Id=" + ticked_Id + ", raisedDate=" + raisedDate + ", severity=" + severity
				+ ", ticketDesciption=" + ticketDesciption + ", resolution=" + resolution + ", resolvedDate="
				+ resolvedDate + ", status=" + status + "]";
	}

	public int getTicked_Id() {
		return ticked_Id;
	}

	public void setTicked_Id(int ticked_Id) {
		this.ticked_Id = ticked_Id;
	}

	public Employee getRaisedByEmployee() {
		return raisedByEmployee;
	}

	public void setRaisedByEmployee(Employee raisedByEmployee) {
		this.raisedByEmployee = raisedByEmployee;
	}

	public String getRaisedDate() {
		return raisedDate;
	}

	public void setRaisedDate(String raisedDate) {
		this.raisedDate = raisedDate;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public String getTicketDesciption() {
		return ticketDesciption;
	}

	public void setTicketDesciption(String ticketDesciption) {
		this.ticketDesciption = ticketDesciption;
	}

	public Employee getResolvedByEmployee() {
		return resolvedByEmployee;
	}

	public void setResolvedByEmployee(Employee resolvedByEmployee) {
		this.resolvedByEmployee = resolvedByEmployee;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public String getResolvedDate() {
		return resolvedDate;
	}

	public void setResolvedDate(String resolvedDate) {
		this.resolvedDate = resolvedDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}

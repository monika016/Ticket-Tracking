package com.mindtree.ticket_tracking.entity;

import java.util.Date;
import javax.xml.bind.annotation.*;;

@XmlRootElement(name = "ticketDto")
public class TicketDto {

	private int ticket_id;
	private String raisedDate;
	private String severity;
	private String ticketDesciption;
	private String status;
	private String raisedByEmployee;
	private String resolvedByEmployee;
	private String resolvedDate;
	private String resolution;

	public TicketDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TicketDto(int ticket_id, String raisedDate, String severity, String ticketDesciption, String status,
			String raisedByEmployee, String resolvedByEmployee, String resolvedDate, String resolution) {
		super();
		this.ticket_id = ticket_id;
		this.raisedDate = raisedDate;
		this.severity = severity;
		this.ticketDesciption = ticketDesciption;
		this.status = status;
		this.raisedByEmployee = raisedByEmployee;
		this.resolvedByEmployee = resolvedByEmployee;
		this.resolvedDate = resolvedDate;
		this.resolution = resolution;
	}

	@Override
	public String toString() {
		return "TicketDto [ticket_id=" + ticket_id + ", raisedDate=" + raisedDate + ", severity=" + severity
				+ ", ticketDesciption=" + ticketDesciption + ", status=" + status + ", raisedByEmployee="
				+ raisedByEmployee + ", resolvedByEmployee=" + resolvedByEmployee + ", resolvedDate=" + resolvedDate
				+ ", resolution=" + resolution + "]";
	}

	public int getTicket_id() {
		return ticket_id;
	}

	@XmlElement
	public void setTicket_id(int ticket_id) {
		this.ticket_id = ticket_id;
	}

	public String getRaisedDate() {
		return raisedDate;
	}

	@XmlElement
	public void setRaisedDate(String raisedDate) {
		this.raisedDate = raisedDate;
	}

	public String getSeverity() {
		return severity;
	}

	@XmlElement
	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public String getTicketDesciption() {
		return ticketDesciption;
	}

	@XmlElement
	public void setTicketDesciption(String ticketDesciption) {
		this.ticketDesciption = ticketDesciption;
	}

	public String getStatus() {
		return status;
	}

	@XmlElement
	public void setStatus(String status) {
		this.status = status;
	}

	public String getRaisedByEmployee() {
		return raisedByEmployee;
	}

	@XmlElement
	public void setRaisedByEmployee(String raisedByEmployee) {
		this.raisedByEmployee = raisedByEmployee;
	}

	public String getResolvedByEmployee() {
		return resolvedByEmployee;
	}

	@XmlElement
	public void setResolvedByEmployee(String resolvedByEmployee) {
		this.resolvedByEmployee = resolvedByEmployee;
	}

	public String getResolvedDate() {
		return resolvedDate;
	}

	@XmlElement
	public void setResolvedDate(String resolvedDate) {
		this.resolvedDate = resolvedDate;
	}

	public String getResolution() {
		return resolution;
	}

	@XmlElement
	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

}

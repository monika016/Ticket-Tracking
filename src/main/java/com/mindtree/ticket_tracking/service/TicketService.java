package com.mindtree.ticket_tracking.service;

import java.util.List;

import com.mindtree.ticket_tracking.dao.TicketDao;
import com.mindtree.ticket_tracking.entity.Ticket;

public interface TicketService {
 	public void addTicket(Ticket ticket);
	public void deleteTicket(int ticket_id);
	public List<Ticket> getAllTickets();
	public Ticket getTicketById(int ticket_id);
	public void updateTicket(Ticket ticket);
}

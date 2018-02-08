package com.mindtree.ticket_tracking.dao;

import java.util.List;

import com.mindtree.ticket_tracking.entity.Ticket;

public interface TicketDao {
	public void addTicket(Ticket ticket);

	public Ticket getTicketById(int ticket_id);

	public List<Ticket> getAllTickets();

	public void deleteTicket(int ticket_id);
}

package com.mindtree.ticket_tracking.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.ticket_tracking.dao.TicketDao;
import com.mindtree.ticket_tracking.entity.Ticket;
import com.mindtree.ticket_tracking.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketDao ticketDao;

	public TicketDao getTicketDao() {
		return ticketDao;
	}

	public void setTicketDao(TicketDao ticketDao) {
		this.ticketDao = ticketDao;
	}

	public void addTicket(Ticket ticket) {
		this.ticketDao.addTicket(ticket);
	}

	public void deleteTicket(int ticket_id) {
		this.ticketDao.deleteTicket(ticket_id);
	}

	public List<Ticket> getAllTickets() {
		return this.ticketDao.getAllTickets();
	}

	public Ticket getTicketById(int ticket_id) {
		return this.ticketDao.getTicketById(ticket_id);
	}

	public void updateTicket(Ticket ticket) {
		this.deleteTicket(ticket.getTicked_Id());

		this.ticketDao.addTicket(ticket);

	}

}

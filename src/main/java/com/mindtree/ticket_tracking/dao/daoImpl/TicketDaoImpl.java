package com.mindtree.ticket_tracking.dao.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.ticket_tracking.dao.TicketDao;
import com.mindtree.ticket_tracking.entity.Ticket;

@Repository
@Transactional
public class TicketDaoImpl implements TicketDao{

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// add ticket method
	public void addTicket(Ticket ticket) {
		this.sessionFactory.getCurrentSession().save(ticket);
	}

	// get ticket by ticket id
	public Ticket getTicketById(int ticket_id) {
		return this.sessionFactory.getCurrentSession().get(Ticket.class, new Integer(ticket_id));
	}

	// get all tickets
	public List<Ticket> getAllTickets() {
		return this.sessionFactory.getCurrentSession().createQuery("from Ticket").list();
	}

	//delete ticket
	public void deleteTicket(int ticket_id)	{
		System.out.println(ticket_id);
		this.sessionFactory.getCurrentSession().remove(this.getTicketById(ticket_id));
	}
	
	
}

package com.mindtree.ticket_tracking.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.ticket_tracking.entity.Employee;
import com.mindtree.ticket_tracking.entity.Ticket;
import com.mindtree.ticket_tracking.entity.TicketDto;
import com.mindtree.ticket_tracking.service.EmployeeService;
import com.mindtree.ticket_tracking.service.TicketService;

@RestController
@CrossOrigin
public class TicketController {

	@Autowired
	private EmployeeService employeeService;
	
	
	@Autowired
	private TicketService ticketService;

	public TicketService getTicketService() {
		return ticketService;
	}

	public void setTicketService(TicketService ticketService) {
		this.ticketService = ticketService;
	}

	@RequestMapping(value = "/addTickets")
	@ResponseBody
	public void addTicket(@RequestBody Ticket ticket) {

		this.ticketService.addTicket(ticket);
		System.out.println("ticket added");

	}
	
	
	@RequestMapping(value = "/deleteTicket")
	@ResponseBody
	public void deleteTicket(@RequestBody int ticketId) {

 		System.out.println("ticket added");

	}
	
	@RequestMapping(value="/getAllOpenTicketIds")
	@ResponseBody
	public List<Integer> getAllTicketIds()
	{
		List<Ticket> list=this.ticketService.getAllTickets();
		List<Integer> listOfIds=new ArrayList<Integer>();
		
		for(Ticket t:list)
		{
			if(t.getStatus().equalsIgnoreCase("open"))
			listOfIds.add(t.getTicked_Id());
		}
		
		return listOfIds;
	}
	
	@RequestMapping(value = "/closeTicket")
	@ResponseBody
	public void closeTicket(@RequestBody TicketDto ticketDto) {

		Ticket ticket=new Ticket();
		
		ticket.setTicketDesciption(ticketDto.getTicketDesciption());
		ticket.setRaisedDate(ticketDto.getRaisedDate());
		ticket.setSeverity(ticketDto.getSeverity());
		ticket.setStatus(ticketDto.getStatus());
		ticket.setResolution(ticketDto.getResolution());
		ticket.setTicked_Id(ticketDto.getTicket_id());
		
		Employee raisedByEmployee=this.employeeService.getEmployeeById(ticketDto.getRaisedByEmployee());
		Employee resolvedByEmployee=this.employeeService.getEmployeeById(ticketDto.getResolvedByEmployee());
		
		ticket.setRaisedByEmployee(raisedByEmployee);
		ticket.setResolvedByEmployee(resolvedByEmployee);
		ticket.setResolvedDate(ticketDto.getResolvedDate());
		
		this.ticketService.updateTicket(ticket);

	}
	
	
	
	
	@RequestMapping(value="/demo")
	@ResponseBody
	public TicketDto myfun()
	{
		return new TicketDto(2,"2018-09-11","Major","AntiVirus Showing Error","CLOSED","M1043100","M1043178","201-01-11","Please Restart your System");		
		
		
	}
	

}

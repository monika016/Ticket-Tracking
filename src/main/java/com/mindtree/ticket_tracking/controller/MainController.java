package com.mindtree.ticket_tracking.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.ticket_tracking.entity.Employee;
import com.mindtree.ticket_tracking.entity.EmployeeDto;
import com.mindtree.ticket_tracking.entity.Ticket;
import com.mindtree.ticket_tracking.entity.TicketDto;
import com.mindtree.ticket_tracking.service.EmployeeService;
import com.mindtree.ticket_tracking.service.TicketService;

@RestController
@CrossOrigin
public class MainController {

	@Autowired
	private EmployeeService employeeService;

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@Autowired
	private TicketService ticketService;

	public TicketService getTicketService() {
		return ticketService;
	}

	public void setTicketService(TicketService ticketService) {
		this.ticketService = ticketService;
	}

	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	@ResponseBody
	public void funt(@RequestBody EmployeeDto employeeDto) {
		// System.out.println(employeeDto.toString());
		
		Employee employee = new Employee();
		employee.setMid(employeeDto.getMid());
		employee.setDept(employeeDto.getDept());
		employee.setEmployee_name(employeeDto.getEmployee_name());
		employee.setDate(employeeDto.getDate());
		employee.setRaisedTickets(null);
		employee.setResolvedTickets(null);
		this.employeeService.addEmployee(employee);

	}

	@RequestMapping(value = "/getAllEmployees", method = RequestMethod.GET)
	@ResponseBody
	public List<Employee> getAllEmployee() {
		List<Employee> list = new ArrayList<Employee>();
		list = this.employeeService.getAllEmployees();

		System.out.println(list);
		return list;
	}

	@RequestMapping(value = "/addTicket", method = RequestMethod.POST)
	@ResponseBody
	public void addTicket(@RequestBody TicketDto ticketDto) {

		System.out.println("Dfd");

		Ticket ticket = new Ticket();
		ticket.setTicketDesciption(ticketDto.getTicketDesciption());
		ticket.setSeverity(ticketDto.getSeverity());
		ticket.setStatus(ticketDto.getStatus());
		ticket.setRaisedDate(ticketDto.getRaisedDate());

		String mid = ticketDto.getRaisedByEmployee();
		Employee raisedByEmployee = this.employeeService.getEmployeeById(mid);

		ticket.setRaisedByEmployee(raisedByEmployee);
		ticket.setResolution(new String());
		// System.out.println(ticket.toString());
		this.ticketService.addTicket(ticket);

	}

	@RequestMapping(value = "/getAllTickets")
	@ResponseBody
	public List<TicketDto> getAllTicket() {
		List<Ticket> list = this.ticketService.getAllTickets();
		
		System.out.println("here");
		for(Ticket t:list)
		System.out.println(t.getRaisedByEmployee());
		
		
		
		List<TicketDto> listSend = new ArrayList<TicketDto>();

		TicketDto ticketDto;

		for (Ticket t : list) {
			System.out.println(t.getRaisedByEmployee().getEmployee_name());
			ticketDto = new TicketDto();
			ticketDto.setTicket_id(t.getTicked_Id());
			ticketDto.setRaisedByEmployee(t.getRaisedByEmployee().getMid());
			ticketDto.setRaisedDate(t.getRaisedDate());
			ticketDto.setResolution(t.getResolution());
			
			if (t.getResolvedByEmployee() == null)
				ticketDto.setResolvedByEmployee("");
			else
				ticketDto.setResolvedByEmployee(t.getResolvedByEmployee().getMid());
			
			ticketDto.setResolvedDate(t.getResolvedDate());
			ticketDto.setSeverity(t.getSeverity());
			ticketDto.setStatus(t.getStatus());
			ticketDto.setTicketDesciption(t.getTicketDesciption());
			listSend.add(ticketDto);
		}

		return listSend;
	}

}

package spring.movieTicketBookingApplication2.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import spring.movieTicketBookingApplication2.entities.Ticket;

@Component
public interface TicketService {
	
	public Ticket addTicket(Ticket ticket);
	
	@Transactional
	public Ticket updateTicket(Ticket ticket);
	public Ticket cancelTicket(Ticket ticket);
	public Ticket viewTicket(int ticektId);
	public List<Ticket> viewTicketList();

}

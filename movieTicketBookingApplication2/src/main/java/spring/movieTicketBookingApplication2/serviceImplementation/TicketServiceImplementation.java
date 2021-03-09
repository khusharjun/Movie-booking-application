package spring.movieTicketBookingApplication2.serviceImplementation;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.movieTicketBookingApplication2.entities.Ticket;
import spring.movieTicketBookingApplication2.repository.ITicketRepository;
import spring.movieTicketBookingApplication2.services.TicketService;

@Service
public class TicketServiceImplementation implements TicketService{
	
	@Autowired
	ITicketRepository ticketRepository;
	
	public Ticket addTicket(Ticket ticket) {
		ticketRepository.save(ticket);
		return ticket;
	}
	
	@Transactional
	public Ticket updateTicket(Ticket ticket) {
		Optional<Ticket> getUpdateTicket = ticketRepository.findById(ticket.getTicketId());
		Ticket updateTicket = null;
		if(getUpdateTicket.isPresent()) {
			updateTicket = getUpdateTicket.get();
			if(ticket.getBookingRef()!=null) {
				updateTicket.setBookingRef(ticket.getBookingRef());
			}
			if(ticket.getSeats()!=null) {
				updateTicket.setSeats(ticket.getSeats());
			}
		}
		return ticket;
	}
	
	public Optional<Ticket> cancelTicket(int id) {
		Optional<Ticket> findTicket = ticketRepository.findById(id);
		if(findTicket != null) {
			ticketRepository.deleteById(id);
		}
		return findTicket;
		
	}
	
	public Ticket viewTicket(int ticketId) {
		Optional<Ticket> findTicket = ticketRepository.findById(ticketId);
		return findTicket.get();
		
	}
	
	public List<Ticket> viewTicketList(){
		List<Ticket> tickets = ticketRepository.findAll();
		return tickets;
	}

	@Override
	public Ticket cancelTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		return null;
	}

}

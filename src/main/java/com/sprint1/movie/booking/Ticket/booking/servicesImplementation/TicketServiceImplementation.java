package com.sprint1.movie.booking.Ticket.booking.servicesImplementation;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint1.movie.booking.Ticket.booking.entities.Seat;
import com.sprint1.movie.booking.Ticket.booking.entities.Ticket;
import com.sprint1.movie.booking.Ticket.booking.entities.TicketBooking;
import com.sprint1.movie.booking.Ticket.booking.exceptions.TicketNotExistsException;
import com.sprint1.movie.booking.Ticket.booking.repository.TicketRepository;
import com.sprint1.movie.booking.Ticket.booking.service.TicketService;

@Service
public class TicketServiceImplementation implements TicketService {

	@Autowired
	TicketRepository ticketRepository;

	/** Addition of a new Ticket... */
	public Ticket addTicket(Ticket ticket) {
		ticket.setNoOfSeats(ticket.getSeats().size());
		for (Seat s : ticket.getSeats()) {
			s.setType("Standard");
			s.setPrice(150);
		}
		return ticketRepository.save(ticket);
	}

	/** Method to update a ticket */
	@Transactional
	public Ticket updateTicket(Ticket ticket) {
		Optional<Ticket> getUpdateTicket = ticketRepository.findById(ticket.getTicketId());
		Ticket updateTicket = null;
		if (getUpdateTicket.isPresent()) {
			updateTicket = getUpdateTicket.get();
			if (ticket.getBookingRef() != null) {
				updateTicket.setBookingRef(ticket.getBookingRef());
			}
			if (ticket.getSeats() != null) {
				updateTicket.setSeats(ticket.getSeats());
			}
			if (ticket.getNoOfSeats() != 0) {
				updateTicket.setNoOfSeats(ticket.getNoOfSeats());
			}
			updateTicket.setTicketStatus(ticket.isTicketStatus());
			ticketRepository.save(updateTicket);
		} else {
			throw new TicketNotExistsException("Ticket Not Exists with ID : " + ticket.getTicketId());
		}
		return ticket;
	}


	/** View ticket by id... */
	public Ticket viewTicket(int ticketId) {
		Optional<Ticket> findTicket = ticketRepository.findById(ticketId);
		if (findTicket.isPresent()) {
			findTicket.get().setBookingRef(null);
			return findTicket.get();
		} else {
			throw new TicketNotExistsException("Ticket Not Exist with ID : " + ticketId);
		}

	}

	/** View List of tickets... */
	public List<Ticket> viewTicketList() {
		List<Ticket> tickets = ticketRepository.findAll();
		for (Ticket t : tickets) {
			t.setBookingRef(null);
		}
		return tickets;
	}

	/** Cancel a ticket... */
	@Override
	public Ticket cancelTicket(Ticket ticket) {

		Optional<Ticket> findTicket = ticketRepository.findById(ticket.getTicketId());
		Ticket cancelTicket = null;
		if (findTicket.isPresent()) {
			
			ticketRepository.delete(findTicket.get());
		} else {
			throw new TicketNotExistsException("Ticket Not Exist with ID : " + ticket.getTicketId());
		}
		return cancelTicket;
	}

	/** Cancel a ticket by id... */
	public Ticket cancelTicketById(int id) {
		Optional<Ticket> findTicket = ticketRepository.findById(id);
		if (findTicket.isPresent()) {
			ticketRepository.deleteById(id);
		} else {
			throw new TicketNotExistsException("Ticket Not Exist with ID : " + id);
		}
		return findTicket.get();

	}

}
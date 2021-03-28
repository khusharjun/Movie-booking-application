package com.sprint1.movie.booking.Ticket.booking;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sprint1.movie.booking.Ticket.booking.entities.Seat;
import com.sprint1.movie.booking.Ticket.booking.entities.Ticket;
import com.sprint1.movie.booking.Ticket.booking.servicesImplementation.TicketServiceImplementation;

@SpringBootTest
class TicketServiceTest {

	@Autowired
	TicketServiceImplementation ticketServiceImplementaion;

	/** Test to add ticket... */
//	@Test
	void testAddTicket() {
		Seat seat = new Seat("L30", "Standard", 150.00);
		List<Seat> seats = new ArrayList<>();
		seats.add(seat);

		Ticket ticket = new Ticket(1, seats, null, true);
		ticketServiceImplementaion.addTicket(ticket);
	}

	/** Test to update ticket... */
//		@Test
	void testUpdateTicket() {
		Ticket ticket = new Ticket(12, 1, null, null, false);
		ticketServiceImplementaion.updateTicket(ticket);

	}

	/** Test to view ticket by id... */
//		@Test
	void testViewTicket() {
		int id = 12;
		Ticket ticket = ticketServiceImplementaion.viewTicket(id);
		System.out.println(ticket);
	}

	/** Test to cancel a ticket by id... */
//		@Test 
	void testCancelTicketById() {
		int id = 6;
		ticketServiceImplementaion.cancelTicketById(id);

	}

	/** Test to Cancel a ticket... */
//	@Test 
	void testCancelTicket() {
		Ticket ticket = new Ticket(17, 2, null, null, true);
		ticketServiceImplementaion.cancelTicket(ticket);

	}

	/** Test to View list of tickets... */
//	@Test
	void testViewAllTickets() {
		List<Ticket> tickets = ticketServiceImplementaion.viewTicketList();
		System.out.println(tickets);
	}

}
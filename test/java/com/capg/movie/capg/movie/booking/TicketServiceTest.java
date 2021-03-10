package com.capg.movie.capg.movie.booking;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.movie.capg.movie.booking.entities.Seat;
import com.capg.movie.capg.movie.booking.entities.Ticket;
import com.capg.movie.capg.movie.booking.servicesImplementation.TicketServiceImplementation;


@SpringBootTest
class TicketServiceTest {

	@Autowired
	TicketServiceImplementation ticketServiceImplementaion;

//		@Test
	void testAddTicket() {
		Seat seat  = new Seat("L30", "Luxary", 330.00);
		List<Seat> seats = new ArrayList<>();
		seats.add(seat);
		
		Ticket ticket = new Ticket(1, seats, null, true);
		ticketServiceImplementaion.addTicket(ticket);
		
	}

//		@Test
	void testUpdateTicket() {
		Ticket ticket = new Ticket(1,1,null,null,false);
		ticketServiceImplementaion.updateTicket(ticket);
		
	}

//		@Test
	void testViewTicket() {
		int id = 1;
		Ticket ticket = ticketServiceImplementaion.viewTicket(id);
		System.out.println(ticket);
	}

//		@Test 
	void testCancelTicketById(){
		int id = 1;
		ticketServiceImplementaion.cancelTicket(id);
		
	}
	
//	@Test 
	void testCancelTicket(){
		Ticket ticket = new Ticket(2,1,null,null,true);
		ticketServiceImplementaion.cancelTicket(ticket);
		
	}
	
//	@Test
	void testViewAllTickets() {
		List<Ticket> tickets = ticketServiceImplementaion.viewTicketList();
		System.out.println(tickets);
	}

}

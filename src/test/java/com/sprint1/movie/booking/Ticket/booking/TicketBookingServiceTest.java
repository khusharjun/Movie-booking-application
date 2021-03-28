package com.sprint1.movie.booking.Ticket.booking;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sprint1.movie.booking.Ticket.booking.entities.Seat;
import com.sprint1.movie.booking.Ticket.booking.entities.Ticket;
import com.sprint1.movie.booking.Ticket.booking.entities.TicketBooking;
import com.sprint1.movie.booking.Ticket.booking.servicesImplementation.TicketBookingServiceImplementation;

@SpringBootTest
class TicketBookingServiceTest {

	@Autowired
	TicketBookingServiceImplementation bookingServiceImplementation;
	org.slf4j.Logger log = LoggerFactory.getLogger(TicketBookingServiceTest.class);
	LocalDate bookingDate;
	
	/** Test to add a booking... */
//	@Test
	void testAddBooking() {
		try {
		Seat seat = new Seat("S45");
		Seat seat2 = new Seat("S46");
		List<Seat> seats = new ArrayList<>();
		seats.add(seat);
		seats.add(seat2);
		Ticket ticket = new Ticket(2, seats, null, true);
		TicketBooking booking = new TicketBooking(3, ticket);
		bookingServiceImplementation.addBooking(booking);
		}
		catch(NoResultException e) {
			log.info(e.getMessage());
		}
	}

	/** Test to show all bookings by date... */
//	@Test
	void testShowAllBooking() {
		LocalDate date = LocalDate.parse("2021-03-15");
		List<TicketBooking> ticketBooking = bookingServiceImplementation.showAllBookingByDate(date);
		System.out.println(ticketBooking);
	}
	
	/** Test to update booking... */
//	@Test
	void testUpdateBooking() {
//		Seat seat = new Seat("S52", "Standard", 150.00);
//		List<Seat> seats = new ArrayList<>();
//		seats.add(seat);
//		Ticket ticket = new Ticket(12, 1, seats, null, true);
		TicketBooking booking = new TicketBooking(6, 2, bookingDate, 2021001, "UPI", "Success", 440.04, null);
		bookingServiceImplementation.updateBooking(booking);
		System.out.println("Check Postgre");
	}
	
	/** Test to cancel booking... */
//	@Test 
	void testCancelBooking() {
		TicketBooking ticketBooking = new TicketBooking(5, 7, LocalDate.now(), 321002, "UPI", "Completed", 440.04, null);
		bookingServiceImplementation.cancelBooking(ticketBooking);
		System.out.println("Check Postgre");
	}

	/** Test to show all booking... */
//	@Test
	void testShowAllBookingByMovieId() {
		int movieId=1;
		List<TicketBooking> ticketBooking = bookingServiceImplementation.showAllBooking(movieId);
		System.out.println(ticketBooking);
	}
	
	/** Test show all booking by id... */
//	@Test
	void testShowAllBookingByShowId() {
		int showId=3;
		List<TicketBooking> ticketBooking = bookingServiceImplementation.showAllBooking(showId);
		System.out.println(ticketBooking);
	}
	
	/** Test to calulate total cost... */
//	@Test
	void testCalculateTotalCost() {
		int bookingId=7;
		double cost = bookingServiceImplementation.calculateTotalCost(bookingId);
		System.out.println("Total Cost is : " + cost);
	}
}
package com.capg.movie.capg.movie.booking;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.movie.capg.movie.booking.entities.Seat;
import com.capg.movie.capg.movie.booking.entities.Ticket;
import com.capg.movie.capg.movie.booking.entities.TicketBooking;
import com.capg.movie.capg.movie.booking.servicesImplementation.TicketBookingServiceImplementation;

@SpringBootTest
class TicketBookingServiceTest {

	@Autowired
	TicketBookingServiceImplementation bookingServiceImplementation;
	
	LocalDate bookingDate;
	
//	@Test
	void testAddBooking() {
		Seat seat = new Seat("L13, L14, L15", "Luxary", 900.00);
		List<Seat> seats = new ArrayList<>();
		seats.add(seat);
		Ticket ticket = new Ticket(3, seats, null, true);
		TicketBooking booking = new TicketBooking(3, LocalDate.now(), 202103, "Online", 
				"Success", 900.00, ticket);
		bookingServiceImplementation.addBooking(booking);
	}

//	@Test
	void testShowAllBooking() {
		LocalDate date = LocalDate.parse("2021-03-10");
		List<TicketBooking> ticketBooking = bookingServiceImplementation.showAllBookingByDate(date);
		System.out.println(ticketBooking);
	}
	
//	@Test
	void testUpdateBooking() {
//		Seat seat = new Seat(4,"L52", "Luxary", 320.00);
//		List<Seat> seats = new ArrayList<>();
//		seats.add(seat);
		LocalDate date = LocalDate.parse("2021-03-10");
//		Ticket ticket = new Ticket(3, 1, seats, null, true);
		TicketBooking booking = new TicketBooking(2, 2, date, 2021001, "UPI", "Success", 440.04, null);
		bookingServiceImplementation.updateBooking(booking);
		System.out.println("Check Postgre");
	}
	
//	@Test 
	void testCancelBooking() {
		TicketBooking booking = new TicketBooking(1, 7, LocalDate.now(), 321002, "UPI", "Completed", 440.04, null);
		TicketBooking ticketBooking = bookingServiceImplementation.cancelBooking(booking);
		System.out.println("Check Postgre");
	}

//	@Test
	void testShowAllBookingByMovieId() {
		int movieId=3;
		List<TicketBooking> ticketBooking = bookingServiceImplementation.showAllBooking(movieId);
		System.out.println(ticketBooking);
	}
	
//	@Test
	void testShowAllBookingByShowId() {
		int showId=3;
		List<TicketBooking> ticketBooking = bookingServiceImplementation.showAllBooking(showId);
		System.out.println(ticketBooking);
	}
	
//	@Test
	void testCalculateTotalCost() {
		int bookingId=3;
		double cost = bookingServiceImplementation.calculateTotalCost(bookingId);
		System.out.println("Total Cost is : " + cost);
	}
}

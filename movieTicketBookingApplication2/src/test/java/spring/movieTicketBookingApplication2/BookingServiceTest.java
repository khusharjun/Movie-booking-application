package spring.movieTicketBookingApplication2;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import spring.movieTicketBookingApplication2.entities.Seat;
import spring.movieTicketBookingApplication2.entities.Ticket;
import spring.movieTicketBookingApplication2.entities.TicketBooking;
import spring.movieTicketBookingApplication2.serviceImplementation.BookingServiceImplementation;

@SpringBootTest
class BookingServiceTest {

	@Autowired
	BookingServiceImplementation bookingServiceImplementation;
	
	LocalDate bookingDate;
	
//	@Test
	void testAddBooking() {
//		Seat seat = new Seat("L10, L11, L12", "Luxary", 900.00);
		Ticket ticket = new Ticket(3, null, null, false);
		TicketBooking booking = new TicketBooking(2, LocalDate.now(), 202101, "Yono Pay", 
				"Success", 900.0, ticket);
		bookingServiceImplementation.addBooking(booking);
		System.out.println("Check PostgreSQL");
	}
	
////	@Test
//	void testShowAllBooking() {
//		int id = 5 ;
//		List<TicketBooking> ticketBooking = bookingServiceImplementation.showAllBooking(id);
//		System.out.println(ticketBooking);
//	}

	@Test
	void testShowAllBooking() {
		LocalDate date = LocalDate.parse("2021-01-01");
		List<TicketBooking> ticketBooking = bookingServiceImplementation.showAllBooking(date);
		System.out.println(ticketBooking);
	}
	
//	@Test
	void testUpdateBooking() {
		TicketBooking booking = new TicketBooking(7, 7, LocalDate.now(), 321002, "UPI", "Completed", 440.04, null);
		bookingServiceImplementation.updateBooking(booking);
		System.out.println("Check Postgre");
	}
	
//	@Test 
	void testCancelBooking() {
		int id = 8;
		TicketBooking ticketBooking = bookingServiceImplementation.cancelBooking(id);
		System.out.println("Check Postgre");
	}
}

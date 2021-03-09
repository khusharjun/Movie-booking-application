package spring.movieTicketBookingApplication2;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import spring.movieTicketBookingApplication2.entities.Seat;
import spring.movieTicketBookingApplication2.entities.TicketBooking;
import spring.movieTicketBookingApplication2.serviceImplementation.BookingServiceImplementation;

@SpringBootTest
class BookingServiceTest {

	@Autowired
	BookingServiceImplementation bookingServiceImplementation;
	
	LocalDate bookingDate;
	
	@Test
	void testAddBooking() {
		TicketBooking booking = new TicketBooking(2, bookingDate, 202101, "Yono Pay", 
				"Success", 0, null);
		bookingServiceImplementation.addBooking(booking);
		System.out.println("Check PostgreSQL");
	}
	
	@Test
	void testShowAllBooking() {
		int id = 5;
		TicketBooking ticketBooking = bookingServiceImplementation.showAllBooking(id);
		System.out.println(ticketBooking);
	}

}

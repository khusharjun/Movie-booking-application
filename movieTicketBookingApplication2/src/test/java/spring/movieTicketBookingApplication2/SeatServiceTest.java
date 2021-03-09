package spring.movieTicketBookingApplication2;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import spring.movieTicketBookingApplication2.entities.Seat;
import spring.movieTicketBookingApplication2.serviceImplementation.SeatServiceImplementation;

@SpringBootTest
class SeatServiceTest {
	@Autowired
	SeatServiceImplementation seatServiceImplementaion;
	
//	@Test
	void testAddSeat() {
		Seat seat = new Seat("J50", "Standard", 220.03);
		seatServiceImplementaion.addSeat(seat);
		System.out.println("Done");
	}
	
	@Test
	void testUpdateSeat() {
		Seat seat = new Seat(2,"S50",null , 0);
		seatServiceImplementaion.updateSeat(seat);
		System.out.println("mission accomplished");
	}

//	@Test
	void testRemoveSeat() {
		int id = 1;
		Seat seat = seatServiceImplementaion.removeSeat(id);
		System.out.println("done");
	}
	
//	@Test
	void testViewSeat() {
		int id = 1;
		Seat seat = seatServiceImplementaion.viewSeat(id);
		System.out.println(seat);
	}
}

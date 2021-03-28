package com.sprint1.movie.booking.Ticket.booking;

import java.util.List;
import javax.persistence.NoResultException;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.sprint1.movie.booking.Ticket.booking.entities.Seat;
import com.sprint1.movie.booking.Ticket.booking.exceptions.SeatNotExistsException;
import com.sprint1.movie.booking.Ticket.booking.servicesImplementation.SeatServiceImplementation;

@SpringBootTest
class SeatServiceTest {
	org.slf4j.Logger log = LoggerFactory.getLogger(SeatServiceTest.class);
	@Autowired
	SeatServiceImplementation seatServiceImplementaion;

	/** Test case to add a Seat in the Database... */

//	 	@Test
	void testAddSeat() {
		try {
			Seat seat = new Seat("L50", "Standard", 220.03);
			seatServiceImplementaion.addSeat(seat);
			System.out.println("Done");
		} catch (NoResultException e) {
			log.info(e.getMessage());
		}
	}

	/** Test Case to update the Seat... */

//	 	@Test
	void testUpdateSeat() {
		try {
			Seat seat = new Seat(0, "S50", "Standard", 150);
			seatServiceImplementaion.updateSeat(seat);
		} catch (SeatNotExistsException s) {
			log.info(s.getMessage());
		}
	}

	/** Test Case to delete a particular Seat... */

//		@Test
	void testRemoveSeatById() {
		try {
			int seatId = 12;
			seatServiceImplementaion.deleteSeat(seatId);
		} catch (SeatNotExistsException s) {
			log.info(s.getMessage());
		}
	}

	/** Test Case to View a particular Seat... */

//		@Test
	void testViewSeat() {
		try {
			int id = 22;
			Seat seat = seatServiceImplementaion.viewSeat(id);
			System.out.println(seat);
		} catch (SeatNotExistsException s) {
			log.info(s.getMessage());
		}
	}

	/** Test Case to View List of Seats... */

//		@Test
	void testViewSeatList() {
		try {
			List<Seat> seats = seatServiceImplementaion.viewSeatList();
			System.out.println(seats);
		} catch (NoResultException e) {
			log.info(e.getMessage());
		}
	}

	/** Test Case to View Seat by Type... */

//		@Test
	void testViewSeatByType() {
		try {
			String type = "Standard";
			List<Seat> seats = seatServiceImplementaion.viewSeatByType(type);
			System.out.println(seats);
		} catch (SeatNotExistsException s) {
			log.info(s.getMessage());
		}
	}
}
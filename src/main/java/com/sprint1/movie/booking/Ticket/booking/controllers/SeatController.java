package com.sprint1.movie.booking.Ticket.booking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprint1.movie.booking.Ticket.booking.entities.Seat;
import com.sprint1.movie.booking.Ticket.booking.repository.SeatRepository;
import com.sprint1.movie.booking.Ticket.booking.servicesImplementation.SeatServiceImplementation;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/seat")
public class SeatController {

	@Autowired
	SeatRepository seatRepository;

	@Autowired
	SeatServiceImplementation seatServiceImplementation;

	/** Addition of a Seat using Post url... */
	@PostMapping("/")
	public ResponseEntity<Seat> addSeat(@RequestBody Seat seat) {
		ResponseEntity<Seat> responseEntity;
		seat.setType("Standard");
		Seat getSeat = seatServiceImplementation.addSeat(seat);
		responseEntity = new ResponseEntity<>(getSeat, HttpStatus.CREATED);

		return responseEntity;
	}

	/** Updation of a Seat using Put mapping... */
	@PutMapping(value = "/")
	public ResponseEntity<Void> updateSeat(@RequestBody Seat seat) {
		ResponseEntity<Void> responseEntity;

		seatServiceImplementation.updateSeat(seat);
		responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);

		return responseEntity;
	}

	/** Find by Seat id using Get mapping... */
	@GetMapping("/{seatId}")
	public ResponseEntity<Seat> findBySeatId(@PathVariable int seatId) {
		ResponseEntity<Seat> responseEntity;

		Seat seat = seatServiceImplementation.viewSeat(seatId);
		responseEntity = new ResponseEntity<>(seat, HttpStatus.OK);

		return responseEntity;
	}

	/** List of Seats using Get mapping... */
	@GetMapping("/")
	public ResponseEntity<List<Seat>> viewAllSeats() {
		ResponseEntity<List<Seat>> responseEntity;
		List<Seat> seats = seatServiceImplementation.viewSeatList();

		responseEntity = new ResponseEntity<>(seats, HttpStatus.OK);

		return responseEntity;
	}

	/** Deletion of Seat by id using Delete mapping... */
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteSeat(@PathVariable("id") int seatId) {
		ResponseEntity<Void> responseEntity;
		seatServiceImplementation.deleteSeat(seatId);
		responseEntity = new ResponseEntity<>(HttpStatus.OK);

		return responseEntity;
	}

	/** Deletion of seat by delete mapping... */
	@DeleteMapping("/s/")
	public ResponseEntity<Void> deleteSeat(@RequestBody Seat seat) {
		ResponseEntity<Void> responseEntity;

		seatServiceImplementation.deleteSeat(seat.getSeatId());
		responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);

		return responseEntity;
	}

	/** Getting seat by type... */
	@GetMapping("/{type}")
	public ResponseEntity<List<Seat>> viewAllSeatsByType(@PathVariable("type") String type) {
		ResponseEntity<List<Seat>> responseEntity;
		List<Seat> seats = seatServiceImplementation.viewSeatByType(type);
		responseEntity = new ResponseEntity<>(seats, HttpStatus.OK);

		return responseEntity;
	}
}
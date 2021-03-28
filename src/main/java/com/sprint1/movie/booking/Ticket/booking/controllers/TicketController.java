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

import com.sprint1.movie.booking.Ticket.booking.entities.Ticket;
import com.sprint1.movie.booking.Ticket.booking.repository.TicketRepository;
import com.sprint1.movie.booking.Ticket.booking.servicesImplementation.TicketServiceImplementation;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/ticket")
public class TicketController {

	@Autowired
	TicketRepository ticketRepository;

	@Autowired
	TicketServiceImplementation ticketServiceImplementation;

	/* Addition of a Ticket using Post mapping... */
	@PostMapping("/")
	public ResponseEntity<Ticket> addTicket(@RequestBody Ticket ticket) {
		ResponseEntity<Ticket> responseEntity;
		try {
			ticketServiceImplementation.addTicket(ticket);
			responseEntity = new ResponseEntity<>(ticket, HttpStatus.CREATED);
			return responseEntity;
		} catch (Exception e) {
			responseEntity = new ResponseEntity<>(ticket, HttpStatus.CONFLICT);
			return responseEntity;
		}

	}

	/** Updation of a Ticket using request mapping... */
	@PutMapping(value = "/tickets")
	public ResponseEntity<Void> updateTicket(@RequestBody Ticket ticket) {
		ResponseEntity<Void> responseEntity;
		ticketServiceImplementation.updateTicket(ticket);
		responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return responseEntity;
	}

	/** Deletion of a Ticket using delete mapping... */
	@DeleteMapping(value = "/")
	public ResponseEntity<Void> cancelTicket(@RequestBody Ticket ticket) {
		ResponseEntity<Void> responseEntity;
		ticketServiceImplementation.cancelTicket(ticket);
		responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return responseEntity;
	}

	/** Finding ticket by id Get mapping... */
	@GetMapping("/{ticketId}")
	public ResponseEntity<Ticket> findByticketId(@PathVariable("ticketId") int ticketId) {
		ResponseEntity<Ticket> responseEntity;
		Ticket ticket = ticketServiceImplementation.viewTicket(ticketId);
		responseEntity = new ResponseEntity<>(ticket, HttpStatus.OK);
		return responseEntity;
	}
	
	/** Finding all the tickets by Get mapping... */
	@GetMapping("/")
	public ResponseEntity<List<Ticket>> findAllTickets() {
		ResponseEntity<List<Ticket>> responseEntity;
		List<Ticket> tickets = ticketServiceImplementation.viewTicketList();
		responseEntity = new ResponseEntity<>(tickets, HttpStatus.OK);
		return responseEntity;
	}

}
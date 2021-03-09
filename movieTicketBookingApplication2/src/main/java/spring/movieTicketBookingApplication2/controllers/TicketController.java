package spring.movieTicketBookingApplication2.controllers;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import spring.movieTicketBookingApplication2.entities.Ticket;
import spring.movieTicketBookingApplication2.repository.ITicketRepository;

@RestController
public class TicketController {
	
	@Autowired
	ITicketRepository ticketRepository;
	
	@PostMapping("/tickets")
	public ResponseEntity<Void> addSeat(@RequestBody Ticket ticket){
		ResponseEntity<Void> re;
				
		Ticket tkt1 = ticketRepository.findByTicketId(ticket.getTicketId());
		if(tkt1 == null) {
		ticketRepository.save(ticket);
		re = new ResponseEntity<>(HttpStatus.CREATED);
		}
		else {
		re = new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return re;
	}
	
	@GetMapping("/tickets")
	public List<Ticket> findByticketId(){
		System.out.println("Method mapped to Http....");
		return ticketRepository.findAll();
	}

	@GetMapping("/tickets/{ticketId}")
	public Ticket findByticketId(@PathVariable int ticketId){
		return ticketRepository.findById(ticketId).get();
	}
	
	@RequestMapping(value = "/tickets", method = RequestMethod.PUT)
	@Transactional
	public ResponseEntity<Void> updateTicket(@RequestBody Ticket ticket){
		ResponseEntity<Void> re;
		Ticket tkt = ticketRepository.findByTicketId(ticket.getTicketId());
		tkt.setTicketStatus(ticket.isTicketStatus());
		re =  new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return re;
	}
}

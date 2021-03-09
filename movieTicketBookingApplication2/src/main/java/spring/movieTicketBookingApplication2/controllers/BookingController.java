package spring.movieTicketBookingApplication2.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import spring.movieTicketBookingApplication2.entities.TicketBooking;
import spring.movieTicketBookingApplication2.repository.IBookingRepository;

@RestController
public class BookingController {

	@Autowired
	IBookingRepository bookingRepository;
	
	@PostMapping("/bookings")
	public ResponseEntity<Void> addBooking(@RequestBody TicketBooking booking){
		ResponseEntity<Void> re;
				
		TicketBooking tkt1 = bookingRepository.findByTicketId(booking.getTicketId());
		if(tkt1 == null) {
		bookingRepository.save(booking);
		re = new ResponseEntity<>(HttpStatus.CREATED);
		}
		else {
		re = new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return re;
	}
	
	
	
	@GetMapping("/bookings")
	public List<TicketBooking> findAllByTicketId(){
		System.out.println("Method mapped to Http....");
		return bookingRepository.findAll();
	}
	
	@GetMapping("/bookings/{date}")
	public TicketBooking findByLocalDate(@PathVariable LocalDate date) {
		return bookingRepository.findByBookingDate(date);
	}
	
	@GetMapping("/bookings/{ticketId}")
	public TicketBooking findByticketId(@PathVariable int ticketId) {
		return bookingRepository.findByTicketId(ticketId);
	}
	
	@GetMapping("/bookings/{transactionId};{ticketId}")
	public List<TicketBooking> findBytransactionIdAndticketId(@PathVariable int transactionId, @PathVariable int ticketId) {
		
		return bookingRepository.findByTransactionIdAndTicketId(transactionId, ticketId);
	}
	
	@RequestMapping(value = "/bookings", method = RequestMethod.PUT)
	@Transactional
	public ResponseEntity<Void> updateTicketBooking(@RequestBody TicketBooking booking){
		ResponseEntity<Void> re;
		TicketBooking bkng = bookingRepository.findByTicketId(booking.getShowId());
		bkng.setTransactionStatus(booking.getTransactionStatus());
		re = new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return re;
	}
	
	@DeleteMapping("/bookings/{id}")
	public ResponseEntity<Void> cancelBooking(@PathVariable("id")int id) {
		ResponseEntity<Void> re;
		Optional<TicketBooking> Booking = bookingRepository.findById(id);
		TicketBooking tktbkng = null;
		if(Booking.isPresent()) {
			tktbkng = Booking.get();
			bookingRepository.delete(tktbkng);
			re = new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		else {
			re = new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		return re;
		
	
//	@GetMapping("/bookings/")
//	public List<>
	}
//	public static void main(String[] args) {
//		Ticket tkt =  new Ticket(0, null, null, false);
//		
//		TicketBooking bkng = new TicketBooking(0, null, 0, null, null, 0, tkt);
//		
//		bookingRepository.save(bkng);
//		
//	}
	}


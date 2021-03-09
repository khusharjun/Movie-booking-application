package spring.movieTicketBookingApplication2.controllers;

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

import spring.movieTicketBookingApplication2.entities.Seat;
import spring.movieTicketBookingApplication2.repository.ISeatRepository;

@RestController
public class SeatController {
	
	@Autowired
	ISeatRepository seatRepository;
	
	@PostMapping("/seats")
	public ResponseEntity<Void> addSeat(@RequestBody Seat seatId){
		ResponseEntity<Void> re;
				
		Seat s = seatRepository.findBySeatId(seatId.getSeatId());
		if(s == null) {
		seatRepository.save(seatId);
		re = new ResponseEntity<>(HttpStatus.CREATED);
		}
		else {
		re = new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return re;
	}
	
	@GetMapping("/seats")
	public List<Seat> findByseatNumber(){
		System.out.println("Method mapped to Http....");
		return seatRepository.findAll();
	}
	
	@GetMapping("/seats/{seatId}")
	public Seat findByticketId(@PathVariable int seatId){
		return seatRepository.findBySeatId(seatId);
	}
	
	@RequestMapping(value = "/seats", method = RequestMethod.PUT)
	@Transactional
	public ResponseEntity<Void> updateSeat(@RequestBody Seat seat){
		ResponseEntity<Void> re;
		Seat s = seatRepository.findBySeatId(seat.getSeatId());
		s.setType(seat.getType());
		re = new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return re;
	}
	
	@DeleteMapping("/seats/{id}")
	public void deleteSeat(@PathVariable("id") int id) {
		Optional<Seat> seat = seatRepository.findById(id);
		Seat s = null;
		if(seat.isPresent()) {
			s = seat.get();
			seatRepository.delete(s);
		}
	}
}

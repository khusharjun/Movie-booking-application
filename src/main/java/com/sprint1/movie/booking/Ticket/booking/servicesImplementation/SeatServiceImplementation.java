package com.sprint1.movie.booking.Ticket.booking.servicesImplementation;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint1.movie.booking.Ticket.booking.entities.Seat;
import com.sprint1.movie.booking.Ticket.booking.exceptions.SeatNotExistsException;
import com.sprint1.movie.booking.Ticket.booking.repository.SeatRepository;
import com.sprint1.movie.booking.Ticket.booking.service.SeatService;

@Service

public class SeatServiceImplementation implements SeatService {

	/** Enabling of object dependency Implicitly */
	@Autowired
	SeatRepository seatRepository;

	/** Addition of a new Seat... */
	public Seat addSeat(Seat seat) {
		seat.setPrice(150);
		return seatRepository.save(seat);
	}

	@Transactional

	/** Method to update the Seat... */
	public Seat updateSeat(Seat seat) {
		Optional<Seat> getUpdateSeat = seatRepository.findById(seat.getSeatId());
		Seat updateSeat = null;
		if (getUpdateSeat.isPresent()) {
			updateSeat = getUpdateSeat.get();
			if (seat.getSeatNumber() != null) {
				updateSeat.setSeatNumber(seat.getSeatNumber());
			}
			if (seat.getType() != null) {
				updateSeat.setType(seat.getType());
			}
			if (seat.getPrice() != 0) {
				updateSeat.setPrice(seat.getPrice());
			}
		} else {
			throw new SeatNotExistsException("Seat Doesn't Exists with ID : " + seat.getSeatId());
		}
		return updateSeat;
	}

	/** Deletion of a seat method... */
	public Seat deleteSeat(int seatId) {
		Optional<Seat> findSeat = seatRepository.findById(seatId);
		if (findSeat.isPresent()) {
			seatRepository.deleteById(seatId);
		} else {
			throw new SeatNotExistsException("Seat Doesn't Exists with ID : " + seatId);
		}
		return findSeat.get();
	}

	/** Viewing of a particular seat... */
	public Seat viewSeat(int seatId) {
		Optional<Seat> findSeat = seatRepository.findById(seatId);
		if (findSeat.isPresent()) {
			return findSeat.get();
		} else {
			throw new SeatNotExistsException("Seat Doesn't Exists with ID : " + seatId);
		}
	}

	/** List of Seats in the Database... */
	public List<Seat> viewSeatList() {
		return seatRepository.findAll();
	}

	/** Viewing of seat by Type... */
	public List<Seat> viewSeatByType(String type) {
		List<Seat> seats = seatRepository.findByType(type);
		if (seats.isEmpty()) {
			throw new SeatNotExistsException("Seats Don't Exist with type: " + type);
		}
		return seats;
	}
}
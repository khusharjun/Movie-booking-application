package com.sprint1.movie.booking.Ticket.booking.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.sprint1.movie.booking.Ticket.booking.entities.Seat;

@Component
public interface SeatService {

	public Seat addSeat(Seat seat);
	
	@Transactional
	public Seat updateSeat(Seat seat);
	public Seat viewSeat(int SeatId);
	public List<Seat> viewSeatList();
	public Seat deleteSeat(int seatId);
	public List<Seat> viewSeatByType(String type);
}
package spring.movieTicketBookingApplication2.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import spring.movieTicketBookingApplication2.entities.Seat;

@Component
public interface SeatService {

	public Seat addSeat(Seat seat);
	@Transactional
	public Seat updateSeat(Seat seat);
	public Seat removeSeat(Seat seat);
	public Seat viewSeat(int SeatId);
	public List<Seat> viewSeatList();
//	public List<Seat> viewSeatTypeList();
	
	
}

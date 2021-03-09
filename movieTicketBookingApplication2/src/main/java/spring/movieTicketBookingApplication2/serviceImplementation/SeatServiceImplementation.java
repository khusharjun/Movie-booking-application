package spring.movieTicketBookingApplication2.serviceImplementation;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.movieTicketBookingApplication2.entities.Seat;
import spring.movieTicketBookingApplication2.repository.ISeatRepository;
import spring.movieTicketBookingApplication2.services.SeatService;

@Service
public class SeatServiceImplementation implements SeatService{
	
//	@Autowired
//	IBookingRepository bookingRepository;
	
	@Autowired
	ISeatRepository seatRepository;
	
//	@Autowired
//	ITicketRepository ticketRepository;
	
	public Seat addSeat(Seat seat) {
		seatRepository.save(seat);
		return seat;
	}
	
	@Transactional
	public Seat updateSeat(Seat seat) {
		Optional<Seat> getUpdateSeat = seatRepository.findById(seat.getSeatId());
		Seat updateSeat = null;
		if(getUpdateSeat.isPresent()) {
			updateSeat = getUpdateSeat.get();
			if(seat.getSeatNumber()!=null) {
				updateSeat.setSeatNumber(seat.getSeatNumber());
			}
			if(seat.getType()!=null) {
				updateSeat.setType(seat.getType());
			}
			if(seat.getPrice()!=0) {
				updateSeat.setPrice(seat.getPrice());
			}
		}
		return updateSeat;
	}
	
	public Seat removeSeat(Seat seat) {
		Optional<Seat> findSeat = seatRepository.findById(seat.getSeatId());
		Seat removeSeat = null;
		if(findSeat.isPresent()) {
			removeSeat = findSeat.get();
			seatRepository.delete(removeSeat);
		}
		return removeSeat;
		
	}
	
	public Seat viewSeat(int seatId) {
		Optional<Seat> findSeat = seatRepository.findById(seatId);
		return findSeat.get();
	}
	
	public List<Seat> viewSeatList(){
		List<Seat> seats = seatRepository.findAll();
		return seats;
	}

	public Seat removeSeat(int id) {
		Optional<Seat> findSeat = seatRepository.findById(id);
		if(findSeat != null) {
			seatRepository.deleteById(id);
		}
		return findSeat.get();
	}

//	@Override
//	public Seat removeSeat(Seat seat) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	
	
//	public List<Seat> viewSeatTypeList(){
//		List<Seat> seats = seatRepository.
//	}
}

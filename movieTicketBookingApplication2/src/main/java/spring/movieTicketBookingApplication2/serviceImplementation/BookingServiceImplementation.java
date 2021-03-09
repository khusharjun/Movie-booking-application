package spring.movieTicketBookingApplication2.serviceImplementation;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import spring.movieTicketBookingApplication2.entities.TicketBooking;
import spring.movieTicketBookingApplication2.repository.IBookingRepository;
import spring.movieTicketBookingApplication2.repository.ISeatRepository;
import spring.movieTicketBookingApplication2.repository.ITicketRepository;

@Service
public class BookingServiceImplementation {

	@Autowired
	IBookingRepository bookingRepository;
	
	@Autowired
	ISeatRepository seatRepository;
	
	@Autowired
	ITicketRepository ticketRepository;
	
	public TicketBooking addBooking(TicketBooking booking) {
		bookingRepository.save(booking);
		return booking;
	}
	
	@Transactional
	public TicketBooking updateBooking(TicketBooking booking) {
		Optional<TicketBooking> getUpdateBooking = bookingRepository.findById(booking.getTicketId());
		TicketBooking updateBooking = null;
		if(getUpdateBooking.isPresent()) {
			updateBooking = getUpdateBooking.get();
			if(booking.getTicket()!=null) {
				updateBooking.setTicket(booking.getTicket());
			}
			if(booking.getBookingDate()!=null) {
				updateBooking.setBookingDate(booking.getBookingDate());
			}
			if(booking.getShowId()!= 0) {
				updateBooking.setShowId(booking.getShowId());
			}
			if(booking.getTotalCost()!=0) {
				updateBooking.setTotalCost(booking.getTotalCost());
			}
			if(booking.getTransactionId()!=0) {
				updateBooking.setTransactionId(booking.getTransactionId());
			}
			if(booking.getTransactionMode()!=null) {
				updateBooking.setTransactionMode(booking.getTransactionMode());
			}
			if(booking.getTransactionStatus()!=null) {
				updateBooking.setTransactionStatus(booking.getTransactionStatus());
			}
			}
		return updateBooking;
		}
		
	public TicketBooking cancelBooking(int id) {
		Optional<TicketBooking> findCancelBooking = bookingRepository.findById(id);
		TicketBooking cancelBooking = null;
		if(findCancelBooking.isPresent()) {
			cancelBooking = findCancelBooking.get();
			bookingRepository.delete(cancelBooking);
		}
		return cancelBooking;
	}
	
	LocalDate date = LocalDate.parse("2021-03-09");
	public List<TicketBooking> showAllBooking(LocalDate date) {
		List<TicketBooking> allBookings = bookingRepository.findAll();
		return allBookings;
	}
	
		
	public TicketBooking showAllBookingList(int showId) {
		List<TicketBooking> findBookings = bookingRepository.findAll();
		return findBookings.get(showId);
	}
	
//	public List<TicketBooking> showAllBooking(int movieId) {
//		List<TicketBooking> findBooking = bookingRepository.findByMovieId(movieId);
//		return findBooking;
//	}
	
//			To find the total cost of the tickets................
//	public TicketBooking calculateTotalCost(double 
	
	
	
}

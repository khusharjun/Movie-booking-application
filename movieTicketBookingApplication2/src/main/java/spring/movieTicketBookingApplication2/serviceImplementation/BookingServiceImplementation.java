package spring.movieTicketBookingApplication2.serviceImplementation;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
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
			}
		return updateBooking;
		}
		
	public TicketBooking cancelBooking(TicketBooking booking) {
		Optional<TicketBooking> findCancelBooking = bookingRepository.findById(booking.getTicketId());
		TicketBooking cancelBooking = null;
		if(findCancelBooking.isPresent()) {
			cancelBooking = findCancelBooking.get();
			bookingRepository.delete(cancelBooking);
		}
		return cancelBooking;
	}
	
//	public List<TicketBooking> showAllBooking(LocalDate date) {
//		Optional<TicketBooking> findCancelBooking = bookingRepository.findById(date);
//	}
	
	public TicketBooking showAllBookingList(int showId) {
		Optional<TicketBooking> findCancelBooking = bookingRepository.findById(showId);
		return findCancelBooking.get();
	}
	
	public TicketBooking showAllBooking(int movieId) {
		Optional <TicketBooking> findCancelBooking = bookingRepository.findById(movieId);
		return findCancelBooking.get();
	}
	
//	public TicketBooking
}

package spring.movieTicketBookingApplication2.services;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import spring.movieTicketBookingApplication2.entities.TicketBooking;

@Component
public interface BookingService {
	public TicketBooking addBooking (TicketBooking booking);
	
	@Transactional
	public TicketBooking updateBooking(TicketBooking booking);
	public TicketBooking cancelBooking(TicketBooking booking);
	public List<TicketBooking> showAllBooking(int movieId);
	public List<TicketBooking> showAllBooking(LocalDate date);
	public List<TicketBooking> showBookingList(TicketBooking booking);
	public TicketBooking calculateTotalCost(int bookingid);
	}
	
	
	
//	@Autowired
//	IBookingRepository brepo;
//	
//	Optional<TicketBooking> bkng = null;
//	
//	public void addBooking(TicketBooking booking) {
//		bkng = brepo.findById(booking.getShowId());
//		if(bkng.isEmpty()) {
//			brepo.save(booking);
//		}
//	}
//	
//	public TicketBooking updateBooking(TicketBooking booking) {
//		
//		Optional<TicketBooking> getUpdate
//	}



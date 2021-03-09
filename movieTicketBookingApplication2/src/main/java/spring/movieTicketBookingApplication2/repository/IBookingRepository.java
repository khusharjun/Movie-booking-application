package spring.movieTicketBookingApplication2.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.movieTicketBookingApplication2.entities.TicketBooking;

@Repository
public interface IBookingRepository extends JpaRepository<TicketBooking, Integer>{
	
	public TicketBooking findByTicketId(int ticketId);
	
	public List<TicketBooking> findByTransactionIdAndTicketId(int transactionId,int ticketId);

	public TicketBooking findByTransactionIdAndTransactionStatus(int transactionId, String transactionStatus);
	
//	public List<TicketBooking> findByMovieId(int movieId);
	
	public TicketBooking findByBookingDate(LocalDate bookingDate);


//	public List<TicketBooking> findAllByMovieId(int id);
	
}

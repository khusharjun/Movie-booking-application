package spring.movieTicketBookingApplication2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.movieTicketBookingApplication2.entities.Seat;

@Repository
public interface ISeatRepository extends JpaRepository<Seat, Integer>{
	
	public Seat findBySeatNumber(String seatNumber);
	
	public Seat findBySeatId(int seatId);

}

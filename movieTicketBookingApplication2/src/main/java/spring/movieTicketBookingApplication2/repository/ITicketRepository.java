package spring.movieTicketBookingApplication2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.movieTicketBookingApplication2.entities.Ticket;



public interface ITicketRepository extends JpaRepository<Ticket, Integer>{

	public Ticket findByTicketId(int ticketId);
}

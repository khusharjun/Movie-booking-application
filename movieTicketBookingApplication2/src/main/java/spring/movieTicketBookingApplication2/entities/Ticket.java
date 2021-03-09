package spring.movieTicketBookingApplication2.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int ticketId;
	int noOfSeats;
	
	@OneToMany(cascade = CascadeType.ALL)
	List<Seat> Seats;
	
	@OneToOne
	TicketBooking bookingRef;
	boolean ticketStatus;
	
	public Ticket(int noOfSeats, TicketBooking bookingRef, List<Seat> Seats,
			boolean tickeStatus) {
		
		this.noOfSeats = noOfSeats;
		this.Seats = Seats;
		this.bookingRef = bookingRef;		
	}

	public int getTicketId() {
		return ticketId;
	}

	public Ticket() {
		
	}
	
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public List<Seat> getSeats() {
		return Seats;
	}

	public void setSeats(List<Seat> seats) {
		Seats = seats;
	}

	public TicketBooking getBookingRef() {
		return bookingRef;
	}

	public void setBookingRef(TicketBooking bookingRef) {
		this.bookingRef = bookingRef;
	}

	public boolean isTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(boolean ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", noOfSeats=" + noOfSeats 
				+ ", bookingRef=" + bookingRef + ", ticketStatus=" + ticketStatus + "]";
	}

	
}

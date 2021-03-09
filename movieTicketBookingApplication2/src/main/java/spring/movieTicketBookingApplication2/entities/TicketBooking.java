package spring.movieTicketBookingApplication2.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class TicketBooking {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	int ticketId;
	int showId;
	LocalDate bookingDate;
	int transactionId;
	String transactionMode;
	String transactionStatus;
	double totalCost;
	@OneToOne(cascade = CascadeType.ALL,targetEntity = Ticket.class)
	Ticket ticket;
	
	
	
	public TicketBooking(int showId, LocalDate bookingDate, int transactionId, String transactionMode,
			String transactionStatus, double totalCost, Ticket ticket) {
		this.bookingDate = bookingDate;
		this.showId = showId;
		this.ticket = ticket;
		this.totalCost = totalCost;
		this.transactionId = transactionId;
		this.transactionMode = transactionMode;
		this.transactionStatus = transactionStatus;
		this.totalCost = totalCost;
		this.ticket = ticket;
	}
	
	
	public TicketBooking(int ticketId, int showId, LocalDate bookingDate, int transactionId, String transactionMode,
			String transactionStatus, double totalCost, Ticket ticket) {
		super();
		this.ticketId = ticketId;
		this.showId = showId;
		this.bookingDate = bookingDate;
		this.transactionId = transactionId;
		this.transactionMode = transactionMode;
		this.transactionStatus = transactionStatus;
		this.totalCost = totalCost;
		this.ticket = ticket;
	}


	public TicketBooking() {
		
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public int getShowId() {
		return showId;
	}

	public void setShowId(int showId) {
		this.showId = showId;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionMode() {
		return transactionMode;
	}

	public void setTransactionMode(String transactionMode) {
		this.transactionMode = transactionMode;
	}

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	@Override
	public String toString() {
		return "TicketBooking [ticketId=" + ticketId + ", showId=" + showId + ", bookingDate=" + bookingDate
				+ ", transactionId=" + transactionId + ", transactionMode=" + transactionMode + ", transactionStatus="
				+ transactionStatus + ", totalCost=" + totalCost + ", ticket=" + ticket + "]";
	}

	
}

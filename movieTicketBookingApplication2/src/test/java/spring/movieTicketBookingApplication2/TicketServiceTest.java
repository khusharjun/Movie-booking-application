package spring.movieTicketBookingApplication2;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import spring.movieTicketBookingApplication2.entities.Ticket;
import spring.movieTicketBookingApplication2.serviceImplementation.TicketServiceImplementation;

@SpringBootTest
class TicketServiceTest {
	
	@Autowired
	TicketServiceImplementation ticketServiceImplementaion;

//	@Test
	void testAddTicket() {
		Ticket ticket = new Ticket(3, null, null, false);
		ticketServiceImplementaion.addTicket(ticket);
		System.out.println("Check postgre");
	}
	
//	@Test
	void testUpdateTicket() {
		Ticket ticket = new Ticket(10,null,null,false);
		ticketServiceImplementaion.updateTicket(ticket);
		System.out.println("done");
	}
	
//	@Test
	void testViewTicket() {
		int id = 3;
		Ticket ticket = ticketServiceImplementaion.viewTicket(id);
		System.out.println(ticket);
	}
	
	@Test 
	void testCancelTicket(){
		int id = 4;
		ticketServiceImplementaion.cancelTicket(id);
		System.out.println("Check PostgreSQL");
	}

}

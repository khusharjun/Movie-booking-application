package com.sprint1.movie.booking.Ticket.booking.servicesImplementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprint1.movie.booking.Ticket.booking.entities.Customer;
import com.sprint1.movie.booking.Ticket.booking.entities.TicketBooking;
import com.sprint1.movie.booking.Ticket.booking.entities.User;
import com.sprint1.movie.booking.Ticket.booking.exceptions.CustomerNotExistsException;
import com.sprint1.movie.booking.Ticket.booking.repository.CustomerRepostitory;
import com.sprint1.movie.booking.Ticket.booking.service.CustomerService;

@Service
public class CustomerServiceImplementation implements CustomerService{
	@Autowired
	CustomerRepostitory customerRepostitory;

	@Autowired
	TicketBookingServiceImplementation ticketBookingServiceImplementation;

	Optional<Customer> customers = null;

	//Adding a customer
	@Transactional
	public Customer addCustomer(Customer customer) {
		
			User user = new User(customer.getPassword(),"Customer");
			customer.setUser(user);
			return customerRepostitory.save(customer); 
		

	}
	
		//Update
		@Transactional
		public Customer updateCustomer(Customer customer) {
			Optional<Customer> getCustomer = customerRepostitory.findById(customer.getCustomerId());
			Customer updatecust = null;
			if(getCustomer.isPresent()) {
				updatecust = getCustomer.get();
				if(customer.getCustomerName()!=null) {
					updatecust.setCustomerName(customer.getCustomerName());
				}
				if(customer.getAddress()!=null) {
					updatecust.setAddress(customer.getAddress());
				}
				if(customer.getEmail()!=null) {
					updatecust.setEmail(customer.getEmail());
				}
				if(customer.getMobileNo()!=null) {
					updatecust.setMobileNo(customer.getMobileNo());
				}
				if(customer.getPassword()!=null) {
					updatecust.setPassword(customer.getPassword());
				}
			}
			else {
				throw new CustomerNotExistsException("Customer with id:"+customer.getCustomerId()+" does not exists");
			}
			return updatecust;
		}
		
		//Deleting a customer
		public Customer deleteCustomer(int id){
			Optional<Customer> customer = customerRepostitory.findById(id);
			Customer c = null;
			if(customer.isPresent()) {
				c = customer.get();
				customerRepostitory.delete(c);
				return c;
			}
			else {
				throw new CustomerNotExistsException("Customer with id:"+id+" does not exists");
			}
			
		}	
		
		//Viewing customer by id
		public Customer viewCustomerById(int id) {
		
			Optional<Customer> customer = customerRepostitory.findById(id);
			Customer c = null;
			if(customer.isPresent()) {
				c = customer.get();
				return c;
			}
			else {
				throw new CustomerNotExistsException("Customer with id:"+id+" does not exists");
			}
		
		}
		
		//Viewing all customers
		public List<Customer> viewAllCustomer() {
			List<Customer> customers = customerRepostitory.findAll();
			return customers;
		}

		
	public Customer addCustomerAndTicket(int id,List<TicketBooking> ticket) {
		Optional<Customer> customer = customerRepostitory.findById(id);
		Customer cust = customer.get(); 
		if(customer.isPresent()) {
			for(TicketBooking t:ticket) {
				cust.getTicketBooking().add(t);

			}
			customerRepostitory.save(cust);
		}
		else {
			throw new CustomerNotExistsException("Customer with id:"+id+" does not exists");
		}
		return cust;
	}


//	public void deleteCustomerandTicket(int id,int ticketId) {
//		Optional<Customer> customer = customerRepostitory.findById(id);
//		if(customer.isPresent()) {
//			Customer cust = customer.get();
//			if(ticketBookingServiceImplementation.showAllBookingList(ticketId)!=null && cust.getTicketBooking().get(cust.getTicketBooking().indexOf(ticketBookingServiceImplementation.showAllBookingList(ticketId)))!=null) {
//				cust.getTicketBooking().remove(ticketBookingServiceImplementation.showAllBookingList(ticketId));
//				customerRepostitory.save(cust);
//			}
//		}
//		else {
//			throw new CustomerNotExistsException("Customer with id:"+id+" does not exists");
//		}

	

	
	public List<Customer> viewAllCustomerInAMovie(int id) {
		List<Customer> customers = customerRepostitory.findAll();
		List<Customer> customerInAMovie = new ArrayList<Customer>();
		List<TicketBooking> tickets = ticketBookingServiceImplementation.showAllBooking(id);
		for(TicketBooking t:tickets) {
			for(Customer c:customers) {
				for(TicketBooking ticket:c.getTicketBooking()) {
					if(ticket.getTicketId()==t.getTicketId()) {
						customerInAMovie.add(c);
					}
				}
			}
		}
		return customerInAMovie;
	}

@Override
public void deleteCustomerandTicket(int id, int ticketId) {
	// TODO Auto-generated method stub
	
}

	
	

	

	







}
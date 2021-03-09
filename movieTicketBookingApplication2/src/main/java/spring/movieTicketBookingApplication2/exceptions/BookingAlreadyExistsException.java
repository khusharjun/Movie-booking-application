package spring.movieTicketBookingApplication2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class BookingAlreadyExistsException extends RuntimeException {
	
	public BookingAlreadyExistsException() {
		
	}
	
	public BookingAlreadyExistsException(String message) {
		super(message);
	}

}
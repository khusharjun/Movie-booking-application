package com.sprint1.movie.booking.Ticket.booking.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sprint1.movie.booking.Ticket.booking.entities.Movie;
import com.sprint1.movie.booking.Ticket.booking.entities.Screen;
import com.sprint1.movie.booking.Ticket.booking.entities.Theatre;
@Component
public interface TheatreService {

	public Theatre addTheatre(Theatre theatre);
	@Transactional
	public void updateTheatre(Theatre theatre);
	public void removeTheatre(int theatreId);
	public Theatre viewTheatreById(int theatreId);
	public List<Theatre>viewTheatreList();
	public Theatre theatreAddMovie(int theatreId,Movie movie);
	public Theatre theatreRemoveMovie(int theatreId,int movieid);
	public List<Theatre>viewTheatreListByCity(String City);
	public Theatre theatreAddScreen(int theatreId,Screen screen);
	public Theatre theatreRemoveScreen(int theatreId,int screenId);
}

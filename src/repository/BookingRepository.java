package repository;

import models.Movie;

public interface BookingRepository {

    public void addMovie(String input);

    public void displayMovies();

    public void bookTicket(Integer movieId, Integer showtimeId);

    public void cancelTicket(Integer ticketId);

    public void displayBookings();

    public void displayShowtimeForSelectedMovie(Integer id);
}

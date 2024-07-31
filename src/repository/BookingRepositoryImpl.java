package repository;

import models.Movie;
import models.Ticket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookingRepositoryImpl implements BookingRepository {

    private final List<Movie> movieList;
    private final List<Ticket> ticketList;

    public BookingRepositoryImpl() {
        this.movieList = new ArrayList<>();
        this.ticketList = new ArrayList<>();
    }

    public void addMovie(String input) {
        // input: Deadpool&Wolverine 10:00,1:30,4:00,7:00,10:00
        try {
            String[] inputs = input.split(" ");
            Movie newMovie = new Movie(this.movieList.size()+1, inputs[0], "ENG", Arrays.asList(inputs[1].split(",")));

            movieList.add(newMovie);

            System.out.println("Movie added successfully!!");
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void displayMovies() {
        // input: 5

        if(movieList.isEmpty()) {
            System.out.println("There are no movies available as of now!");
            return;
        }

        System.out.println("Movies:");
        int i = 1;
        for (Movie movie : movieList) {
            System.out.println(i + ". " +movie.toString());
        }
    }

    public void bookTicket(Integer movieId, Integer showTimeId) {
        // input: 3 <movie_id> timings Ex: 1 10:00
        try {
            Movie movie = this.movieList.get(movieId-1);

            if(movie == null) {
                System.out.println("Movie not found!");
                System.out.println("Please enter movie from the list and try again!!");
                return;
            }

            if(movie.getShowTimes().get(showTimeId-1) == null) {
                System.out.println("Not a valid showtime selected for the movie!");
                System.out.println("Please select a valid showtime and try again!!");
                return;
            }

            Ticket newTicket = new Ticket(this.ticketList.size()+1, movieId, showTimeId);
            ticketList.add(newTicket);

            System.out.println("Ticket booked successfully!!");
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void cancelTicket(Integer ticketId) {
        // input: 4 <ticket_id> Ex: 4 1
        try {
            Ticket ticket = this.ticketList.get(ticketId);
            if(ticket == null) {
                System.out.println("Ticket not found!");
                System.out.println("Please enter ticket id from the list and try again!!");
                return;
            }

            this.ticketList.remove(ticket);
            System.out.println("Ticket cancelled successfully!!");
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void displayBookings() {
        // input: 6
        if(ticketList.isEmpty()) {
            System.out.println("There are no bookings available as of now!");
        }
        System.out.println("Bookings:");
        int i = 1;
        for (Ticket ticket : ticketList) {
            Movie movie = this.movieList.get(ticket.getMovieId()-1);
            System.out.println(ticket.getId() + ". " + movie.toString() + " timing " + movie.getShowTimes().get(ticket.getShowtimeId()-1));
        }
    }

    public void displayShowtimeForSelectedMovie(Integer id) {
        try {
            Movie movie = this.movieList.get(id-1);
            if(movie == null) {
                System.out.println("Movie not found! Please select a valid movie from the list!");
            }

            assert movie != null;
            int i = 1;
            for(String showtime: movie.getShowTimes()) {
                System.out.println(i + ": " + showtime);
                i++;
            }
        }catch (Exception e) {
            System.out.println("Movie not found! Please select a valid movie from the list!");
        }
    }
}

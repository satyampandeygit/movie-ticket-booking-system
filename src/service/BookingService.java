package service;

import repository.BookingRepository;
import repository.BookingRepositoryImpl;

import java.util.Scanner;

public class BookingService {
    private BookingRepository bookingRepository;
    private Scanner scanner;

    public BookingService() {
        this.bookingRepository = new BookingRepositoryImpl();
        this.scanner = new Scanner(System.in);
    }

    public void addMovie() {
        try {
            System.out.println("Enter movie details in below format");
            System.out.println("<movie_name> <show_timings>");
            System.out.println("Show timings should be separated by space like 10:00 1:30:");
            String input = scanner.nextLine();
            bookingRepository.addMovie(input);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void displayMovies() {
        bookingRepository.displayMovies();
    }

    public void bookTicket() {
        try {
            System.out.println("Select movie from below list of movies:");
            bookingRepository.displayMovies();
            System.out.println("Enter id of the movies from above list like 1,2:");
            Integer movieId = scanner.nextInt();

            bookingRepository.displayShowtimeForSelectedMovie(movieId);
            System.out.println("From the available showtimes select which is suitable for you and enter id of the showtime from above list like 1,2:");
            Integer showtimeId = scanner.nextInt();
            
            bookingRepository.bookTicket(movieId, showtimeId);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }



    public void displayBooking() {
        try {
            bookingRepository.displayBookings();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void cancelBooking() {
        try {
            bookingRepository.displayBookings();
            System.out.println("From the above list select ticket to cancel Ex- 1,2:");
            Integer ticketId = scanner.nextInt();

            bookingRepository.cancelTicket(ticketId);
        }catch (Exception e) {
            System.out.println("Error while canceling ticket");
            System.out.println(e.getMessage());
        }
    }
}

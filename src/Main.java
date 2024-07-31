import repository.BookingRepository;
import service.BookingService;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static BookingService bookingService = new BookingService();

    public static void main(String[] args) {
        displayMenu();
    }

    public static void displayMenu() {
        try {
            System.out.println("Select from menu options below:");
            System.out.println("1. Add Movie");
            System.out.println("2. List all available movies");
            System.out.println("3. Book Ticket");
            System.out.println("4. Cancel Ticket");
            System.out.println("5. Manage Booking");
            System.out.println("Select from options above Example: 1,2:");

            int selectedOption = scanner.nextInt();

            switch (selectedOption) {
                case 1:
                    bookingService.addMovie();
                    break;
                case 2:
                    bookingService.displayMovies();
                    break;
                case 3:
                    bookingService.bookTicket();
                    break;
                case 4:
                    bookingService.cancelBooking();
                    break;
                case 5:
                    bookingService.displayBooking();
                    break;
                default:
                    System.out.println("Invalid option selected!!");
                    System.out.println("Please try again");
                    break;
            }

            displayMenu();
        }
        catch (Exception e) {
            scanner.close();
            System.out.println(e.getMessage());
        }
    }
}
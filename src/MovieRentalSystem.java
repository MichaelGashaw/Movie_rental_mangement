import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MovieRentalSystem {
    private static ArrayList<Media> mediaList = new ArrayList<>(); // ArrayList to store media items

    // Main method to start the program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object to read user input

        // Add some movies to the media list
        mediaList.add(new Movie("The Shawshank Redemption", "Drama", 1994));
        mediaList.add(new Movie("The Godfather", "Crime", 1972));
        mediaList.add(new Movie("The Dark Knight", "Action", 2008));

        // Display a welcome message
        System.out.println("*********************************************");
        System.out.println("*      Welcome to the Movie Rental System    *");
        System.out.println("*********************************************");

        // Main loop to display the menu and handle user input
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Rent a Movie");
            System.out.println("2. Return a Movie");
            System.out.println("3. List all available movies");
            System.out.println("4. Exit");

            try {
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt(); // Read user's choice

                // Perform actions based on user's choice
                switch (choice) {
                    case 1:
                        rentMedia(scanner); // Call method to rent a movie
                        break;
                    case 2:
                        returnMedia(scanner);
                        break;
                    case 3:
                        listAvailableMovies();
                        break;
                    case 4:
                        // Display exit message and terminate the program
                        System.out.println("*********************************************");
                        System.out.println("*  Thank you for using the Movie Rental System!  *");
                        System.out.println("*********************************************");
                        System.exit(0);
                    default:
                        // Display error message for invalid choice
                        System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                }
            } catch (InputMismatchException e) {
                // Handle input mismatch exception
                System.out.println("Invalid input. Please enter a valid integer choice.");
                scanner.next(); // Clear the buffer
            }
        }
    }

    // Method to handle returning a movie
    private static void returnMedia(Scanner scanner) {
        // Display movies that are currently rented by the user
        System.out.println("\nMovies you have rented:");
        int count = 1;
        for (Media media : mediaList) {
            if (media instanceof Movie) {
                Movie movie = (Movie) media;
                if (!movie.isAvailable()) {
                    System.out.println(count + ". " + movie.getTitle());
                    count++;
                }
            }
        }

        // Prompt the user to choose a movie to return
        System.out.print("Enter the number of the movie you want to return: ");
        int returnChoice = scanner.nextInt();

        // Check if the return choice is valid
        if (returnChoice >= 1 && returnChoice < count) {
            Media media = mediaList.get(returnChoice - 1);
            if (media instanceof Movie) {
                Movie movie = (Movie) media;
                if (!movie.isAvailable()) {
                    movie.returnMedia();
                    System.out.println("Thank you for returning " + movie.getTitle());
                } else {
                    System.out.println("This movie is already returned.");
                }
            }
        } else {
            System.out.println("Invalid choice.");
        }
    }

    // Method to handle renting a movie
    private static void rentMedia(Scanner scanner) {
        // Display available movies for rent
        System.out.println("\nAvailable Movies:");
        int count = 1;
        for (Media media : mediaList) {
            if (media instanceof Movie) {
                Movie movie = (Movie) media;
                if (movie.isAvailable()) {
                    System.out.println(count + ". " + movie.getTitle() + " (" + movie.getGenre() + ", " + movie.getYear() + ")");
                    count++;
                }
            }
        }

        // Prompt the user to choose a movie to rent
        System.out.print("Enter the number of the movie you want to rent: ");
        int rentChoice = scanner.nextInt();

        // Check if the rent choice is valid
        if (rentChoice >= 1 && rentChoice < count) {
            Media media = mediaList.get(rentChoice - 1);
            if (media instanceof Movie) {
                Movie movie = (Movie) media;
                if (movie.isAvailable()) {
                    movie.rentMedia();
                    System.out.println("You have successfully rented " + movie.getTitle());
                } else {
                    System.out.println("This movie is already rented.");
                }
            }
        } else {
            System.out.println("Invalid choice.");
        }
    }

    // Method to list all available movies
    private static void listAvailableMovies() {
        System.out.println("\nAvailable Movies:");
        int count = 1;
        for (Media media : mediaList) {
            if (media instanceof Movie) {
                Movie movie = (Movie) media;
                if (movie.isAvailable()) {
                    System.out.println(count + ". " + movie.getTitle() + " (" + movie.getGenre() + ", " + movie.getYear() + ")");
                    count++;
                }
            }
        }
    }
}
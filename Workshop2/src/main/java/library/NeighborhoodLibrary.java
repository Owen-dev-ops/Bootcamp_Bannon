package library;

import java.util.Scanner;

public class NeighborhoodLibrary {

    // Used to apply bold font in print statements
    public static final String BOLD = "\u001B[1m";
    public static final String RESET = " \u001B[0m";

    public static void main(String[] args) {
        // Program will run as long as this is false
        boolean quitProgram = false;
        // Scanner for getting user input
        Scanner scanner = new Scanner(System.in);
        // Books in the library
        Book[] books = LibraryData.books;

        // Output message when user loads app
        System.out.println("Welcome to Book Finder, please select an option from the following menu:");

        while(!quitProgram) {
            System.out.println("1) Available Books\n" +
                    "2) Checked Out Books\n" +
                    "3) Exit Book Finder");
            // User will be asked for user input as long as validAnswer is false
            boolean validAnswer = false;
            // Holds user input
            String userInput = "";

            while(!validAnswer) {
                userInput = scanner.nextLine().toLowerCase();
                switch(userInput) {
                    // Show available books
                    case "1", "available", "available books", "show available" -> {
                        System.out.println("Available Books:\n" +
                                "------------------------------------------------------");
                        for( Book book : books){
                            if(!book.getIsCheckedOut()){
                                System.out.printf("%sId:%s%d %s Title:%s%s %sISBN:%s%s\n\n",BOLD, RESET, book.getId(), BOLD, RESET, book.getTitle(), BOLD, RESET, book.getIsbn());
                            }
                        }
                        System.out.println("------------------------------------------------------");

                        // Ask user if they'd like to check out or return to main menu
                        System.out.println("Check out a book? Please enter the book title or id. Or enter x to go back to the main menu\n" +
                                "C) Check out\n" +
                                "X) Back to main menu");
                        while(!validAnswer){
                            userInput = scanner.nextLine().toLowerCase();
                            switch(userInput){
                                // If user answers the question literally ask them for a book name
                                case "c", "yes", "check out", "check out a book" -> {
                                    System.out.println("Please enter the book's title or id:");
                                    break;
                                }
                                // Send user back to menu if they don't wish to check out a book
                                case "x", "no", "back", "main menu", "back to main menu" -> {
                                    validAnswer = true;
                                    break;
                                }
                                /* If the user doesn't decide to go back to the main menu the text inputted is assumed to be
                                 the book title they wish to check out. If the book is currently in the library and the title
                                 is valid ask for the users name and checkout the book, then return user to main menu. Other-wise don't
                                 and inform user with the reason why. */
                                default -> {
                                    boolean bookInLibrary = false;
                                    for( Book book : books ){
                                        if(book.getTitle().toLowerCase().equals(userInput) || String.valueOf(book.getId()).equals(userInput)) {
                                            bookInLibrary = true;
                                            if(book.getIsCheckedOut()){
                                                System.out.println("Sorry but this book is currently checked out, please try again:");
                                                break;
                                            } else {
                                                System.out.println("Please enter your name:");
                                                String bookTitle = userInput;
                                                userInput = scanner.nextLine();
                                                book.checkOut(userInput);
                                                System.out.println(userInput + " checked out book " + bookTitle + " successfully, returning you to main menu...");
                                                validAnswer = true;
                                                break;
                                            }
                                        }
                                    }
                                    if(!bookInLibrary) {
                                        System.out.println("No book with that title or id detected, please try again:");
                                    }
                                }
                            }
                        }
                        break;
                    }
                    // Show checked out books
                    case "2", "checked out", "checked out books", "show checked out"  -> {
                        System.out.println("Checked Out Books:\n" +
                                "------------------------------------------------------");
                        for( Book book : books){
                            if(book.getIsCheckedOut()){
                                System.out.printf("%sId:%s%d %s Title:%s%s %sISBN:%s%s %sChecked Out To:%s %s\n\n",BOLD, RESET, book.getId(), BOLD, RESET, book.getTitle(), BOLD, RESET, book.getIsbn(), BOLD, RESET, book.getCheckedOutTo());
                            }
                        }
                        System.out.println("------------------------------------------------------");
                        System.out.println("Check in a book? Please enter the book title or id. Or enter x to go back to the main menu.\n" +
                                "C) Check in\n" +
                                "X) Main menu");
                        while(!validAnswer){
                            userInput = scanner.nextLine().toLowerCase();
                            switch(userInput){
                                // If user answers the question literally ask them for a book name
                                case "c", "yes", "check in", "check in a book" -> {
                                    System.out.println("Please enter the book's title or id:");
                                    break;
                                }
                                // Send user back to menu if they don't wish to check out a book
                                case "x", "no", "back", "main menu", "back to main menu" -> {
                                    validAnswer = true;
                                    break;
                                }
                                // Answers other than the ones laid out in the above two cases are assumed to be the book title
                                default -> {
                                    boolean bookInLibrary = false;
                                    for( Book book : books ){
                                        if(book.getTitle().toLowerCase().equals(userInput) || String.valueOf(book.getId()).equals(userInput)){
                                            bookInLibrary = true;
                                            if(!book.getIsCheckedOut()){
                                                System.out.println("This book is already checked in, is there a different book you'd like to check in?:");
                                                break;
                                            } else {
                                                book.checkIn();
                                                System.out.println("Checked in book " + userInput + " successfully, returning you to main menu...");
                                                validAnswer = true;
                                                break;
                                            }
                                        }
                                    }
                                    if(!bookInLibrary) {
                                        System.out.println("No book with that title or id detected, please try again:");
                                    }
                                }
                            }
                        }
                        break;
                    }
                    case "3", "exit", "exit book finder", "quit" -> {
                        System.out.println("Goodbye");
                        validAnswer = true;
                        quitProgram = true;
                    }
                    default -> {
                        System.out.println("Help Menu:\n" +
                                "Please select an option by entering 1, 2, 3, 4, or show available, show checked out, etc...");
                    }
                }
            }
        }
        scanner.close();
    }
}

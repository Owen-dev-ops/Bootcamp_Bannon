package swifttally;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Search {
    // Search for a transaction
    public static void Search(List<Transaction> transactions, Scanner s) {
        String userInput = "";
        boolean validAnswer = false;

        while(!validAnswer){
            // Display search options usage menu
            Display.displaySearchMenu();
            // Get user input
            userInput = s.nextLine().toLowerCase();
            // Process correlating function to complete users search request. If user enters an invalid search menu command print usage menu and ask for input again.
            validAnswer = DirectUser.directUserSearchMenu(userInput, transactions, s, validAnswer);
        }
        // Search Successful
        System.out.println("What would you like to do next? (Enter h or help for options menu)");
    }

    // Search functions

    // Return list of all transactions made this month
    public static void monthToDate(List<Transaction> transactions) {
        // Get the current local date
        LocalDateTime currentLocalDate = LocalDateTime.now();
        // Get the current month from currentLocalDate and hold this valud in a String, currentMonth
        String currentMonth = Constants.LDTFM.format(currentLocalDate);
        String currentYear = Constants.LDTFY.format(currentLocalDate);

        // For each transaction within transactions if the year matches the current year and the month matches the current month, print it to the user
        for(Transaction transaction : transactions){
            if(Constants.LDTFM.format(transaction.getTransactionDate()).equals(currentMonth) && Constants.LDTFY.format(transaction.getTransactionDate()).equals(currentYear)){
                transaction.printTransaction();
            }
        }
    }

    // Return list of all transactions made during last month
    public static void previousMonth(List<Transaction> transactions){
        // Get the current local date
        LocalDateTime currentLocalDate = LocalDateTime.now();
        // Make a new date starting on the first day of last month
        LocalDateTime previousMonthLocalDate = LocalDateTime.of(Integer.parseInt(Constants.LDTFY.format(currentLocalDate)), Integer.parseInt(Constants.LDTFM.format(currentLocalDate)) - 1, 1, 1, 1);
        // Get the previous month from the previousMonthLocalDate
        String previousMonth = Constants.LDTFM.format(previousMonthLocalDate);
        String currentYear = Constants.LDTFY.format(previousMonthLocalDate);

        // For each transaction within transactions if year matches the current year and the month matches the previous month, print it to the user
        for(Transaction transaction : transactions){
            if(Constants.LDTFM.format(transaction.getTransactionDate()).equals(previousMonth) && Constants.LDTFY.format(transaction.getTransactionDate()).equals(currentYear)){
                transaction.printTransaction();
            }
        }

    }

    // Return list of all transactions made this year
    public static void yearToDate(List<Transaction> transactions){

    }

    // Return list of all transactions made last year
    public static void previousYear(List<Transaction> transactions){

    }

    // Return list of all transactions made by the vendor the user inputs
    public static void searchByVendor(List<Transaction> transactions, Scanner s){

    }

    // Return list of all transactions made based off of various search parameters entered by the user
    public static void customSearch(List<Transaction> transactions, Scanner s){

    }
}

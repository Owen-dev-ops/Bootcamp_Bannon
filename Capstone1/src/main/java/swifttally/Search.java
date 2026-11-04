package swifttally;

import java.util.List;
import java.util.Scanner;

public class Search {
    // Search for a transaction
    public static void Search(List<Transaction> transactions, Scanner s) {
        // Display search options usage menu
        Display.displaySearchMenu();
        // Get user input
        String userInput = "";
        userInput = s.nextLine().toLowerCase();
        // Process correlating function to complete users search request
        DirectUser.directUserSearchMenu(userInput, transactions, s);

        System.out.println("What would you like to do next? (Enter h or help for options menu)");
    }

    // Search functions

    // Return list of all transactions made this month
    public static void monthToDate(List<Transaction> transactions) {

    }

    // Return list of all transactions made during last month
    public static void previousMonth(List<Transaction> transactions){

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

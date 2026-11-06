package swifttally;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
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
        // Get the current month and year from currentLocalDate and hold this value in a String, currentMonth
        String currentMonth = Constants.LDTFM.format(currentLocalDate);
        String currentYear = Constants.LDTFY.format(currentLocalDate);
        boolean isEmpty = true;

        // For each transaction within transactions if the year matches the current year and the month matches the current month, print it to the user
        for(Transaction transaction : transactions){
            if(Constants.LDTFM.format(transaction.getTransactionDate()).equals(currentMonth) && Constants.LDTFY.format(transaction.getTransactionDate()).equals(currentYear)){
                isEmpty = false;
                transaction.printTransaction();
            }
        }
        if(isEmpty){
            System.out.println("No search results...");
        }
    }

    // Return list of all transactions made during last month
    public static void previousMonth(List<Transaction> transactions){
        // Get the current local date
        LocalDateTime currentLocalDate = LocalDateTime.now();
        // Make a new date starting on the first day of last month
        LocalDateTime previousMonthLocalDate = LocalDateTime.of(Integer.parseInt(Constants.LDTFY.format(currentLocalDate)), Integer.parseInt(Constants.LDTFM.format(currentLocalDate)) - 1, 1, 1, 1);
        // Get the previous month and current year from the previousMonthLocalDate
        String previousMonth = Constants.LDTFM.format(previousMonthLocalDate);
        String currentYear = Constants.LDTFY.format(previousMonthLocalDate);
        boolean isEmpty = true;

        // For each transaction within transactions if year matches the current year and the month matches the previous month, print it to the user
        for(Transaction transaction : transactions){
            if(Constants.LDTFM.format(transaction.getTransactionDate()).equals(previousMonth) && Constants.LDTFY.format(transaction.getTransactionDate()).equals(currentYear)){
                isEmpty = false;
                transaction.printTransaction();
            }
        }
        if(isEmpty){
            System.out.println("No search results...");
        }
    }

    // Return list of all transactions made this year
    public static void yearToDate(List<Transaction> transactions){
        // Get the current local date
        LocalDateTime currentLocalDate = LocalDateTime.now();
        // Get the current year from currentLocalDate
        String currentYear = Constants.LDTFY.format(currentLocalDate);
        boolean isEmpty = true;

        // For each transaction within transactions if the year matches the current year print the transaction
        for(Transaction transaction : transactions){
            if(Constants.LDTFY.format(transaction.getTransactionDate()).equals(currentYear)){
                isEmpty = false;
                transaction.printTransaction();
            }
        }
        if(isEmpty){
            System.out.println("No search results...");
        }
    }

    // Return list of all transactions made last year
    public static void previousYear(List<Transaction> transactions){
        // Get the current local date
        LocalDateTime currentLocalDate = LocalDateTime.now();
        // Get the year from currentLocalDate and subtract 1 to get the previous year
        String priorYear = String.valueOf(Integer.parseInt(Constants.LDTFY.format(currentLocalDate)) - 1);
        boolean isEmpty = true;

        // For each transaction within transactions if the year matches the prior year print the transaction
        for(Transaction transaction : transactions){
            if(Constants.LDTFY.format(transaction.getTransactionDate()).equals(priorYear)){
                isEmpty = false;
                transaction.printTransaction();
            }
        }
        if(isEmpty){
            System.out.println("No search results...");
        }
    }

    // Return list of all transactions made by the vendor the user inputs
    public static void searchByVendor(List<Transaction> transactions, Scanner s){
        boolean resultsEmpty = true;
        String userInput = "";

        while(true){
            resultsEmpty = true;
            userInput = "";
            System.out.println("Please enter the vendors name you'd like to search for or 'b' to return: ");
            userInput = s.nextLine().toLowerCase();
            if(userInput.equals("b") || userInput.equals("back")){
                break;
            }
            System.out.println("Search Results:\n------------------------------------------------------------------------------------------------------------------------------------------------------");
            for(Transaction transaction : transactions){
                if(transaction.getTransactionVendor().toLowerCase().contains(userInput)){
                    resultsEmpty = false;
                    transaction.printTransaction();
                }
            }
            if(resultsEmpty) {
                System.out.println("No transaction with that vendor name found.");
                System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
            }
        }
    }

    // Return list of all transactions made based off of various search parameters entered by the user
    public static void customSearch(List<Transaction> transactions, Scanner s){
        while(true){
            // Print proper usage
            System.out.println("Please enter the values you'd like to filter by or 'c' to return to search menu: ");

            // Get search parameters and verify user input. Within userInput[], index 0 = start date, 1 = end date, 2 = description, 3 = vendor, and 4 = amount
            Object[] userInput = new Object[5];
            for(int i = 0; i <= userInput.length; i++) {
                boolean validAnswer = false;
                switch (i) {
                    case 0:
                        while (!validAnswer) {
                            System.out.printf("%sStarting Date:%s \n", Constants.BOLD, Constants.RESET);
                            try {
                                userInput[i] = s.nextLine().toLowerCase();
                                if(userInput[i].equals("c")){
                                    System.out.printf("%ssearch canceled, returning you to menu...%s\n", Constants.GREEN, Constants.RESET);
                                    return;
                                }
                                if(userInput[i].equals("")){
                                    break;
                                }
                                userInput[i] = LocalDate.parse((String)userInput[i], Constants.LDTF);
                                validAnswer = true;
                            } catch (Exception ex) {
                                System.out.printf("%sInvalid date, please enter using this format: yyyy-mm-dd. Ex: 2004-07-15%s\n", Constants.RED, Constants.RESET);
                            }
                        }
                        break;
                    case 1:
                        while (!validAnswer) {
                            System.out.printf("%sEnd Date:%s \n", Constants.BOLD, Constants.RESET);
                            try {
                                userInput[i] = s.nextLine().toLowerCase();
                                if(userInput[i].equals("c")){
                                    System.out.printf("%ssearch canceled, returning you to menu...%s\n", Constants.GREEN, Constants.RESET);
                                    return;
                                }
                                if(userInput[i].equals("")){
                                    break;
                                }
                                userInput[i] = LocalDate.parse((String)userInput[i], Constants.LDTF);
                                validAnswer = true;
                            } catch (Exception ex) {
                                System.out.printf("%sInvalid date, please enter using this format: yyyy-mm-dd. Ex: 2004-07-15%s\n", Constants.RED, Constants.RESET);
                            }
                        }
                        break;
                    case 2:
                        System.out.printf("%sDescription:%s \n", Constants.BOLD, Constants.RESET);
                        userInput[i] = s.nextLine().toLowerCase();
                        if(((String) userInput[i]).equalsIgnoreCase("c")){
                            System.out.printf("%ssearch canceled, returning you to menu...%s\n", Constants.GREEN, Constants.RESET);
                            return;
                        }
                        break;
                    case 3:
                        System.out.printf("%sVendor:%s \n", Constants.BOLD, Constants.RESET);
                        userInput[i] = s.nextLine().toLowerCase();
                        if(((String) userInput[i]).equalsIgnoreCase("c")){
                            System.out.printf("%ssearch canceled, returning you to menu...%s\n", Constants.GREEN, Constants.RESET);
                            return;
                        }
                        break;
                    case 4:
                        System.out.printf("%sAmount:%s \n", Constants.BOLD, Constants.RESET);
                        while (!validAnswer) {
                            try {
                                userInput[i] = s.nextLine().toLowerCase();
                                if(userInput[i].equals("c")){
                                    System.out.printf("%ssearch canceled, returning you to menu...%s\n", Constants.GREEN, Constants.RESET);
                                    return;
                                }
                                if(userInput[i].equals("")){
                                    break;
                                }
                                userInput[i] = Double.parseDouble((String)userInput[i]);
                                validAnswer = true;
                            } catch (Exception ex) {
                                System.out.printf("%sInvalid amount, please enter a valid dollar amount using this format: $$.cc. Ex: 50.32, 1032.06%s\n", Constants.RED, Constants.RESET);
                            }
                        }
                        break;
                    default:
                }
            }

            // searchResults will hold a list of the filtered search
            List<Transaction> searchResults = new ArrayList<>(transactions);
            // toRemove holds a list of the transactions to remove from searchResults
            List<Transaction> toRemove = new ArrayList<>();


            // If user entered a start date filter out all prior transactions up to that date
            if(!userInput[0].equals("")){
                // Add any dates prior to the starting date year to the toRemove list
                for(Transaction transaction : searchResults){
                    if(Integer.parseInt(Constants.LDTFY.format(transaction.getTransactionDate())) < Integer.parseInt(Constants.LDTFY.format((TemporalAccessor) userInput[0]))) {
                        toRemove.add(transaction);
                    }
                }

                // For each transaction in toRemove, remove it from searchResults
                for(Transaction transaction : toRemove){
                    searchResults.remove(transaction);
                }

                // clear toRemove
                toRemove.clear();

                // Add any dates prior the starting month to the toRemove list
                for(Transaction transaction : searchResults){
                    if(Integer.parseInt(Constants.LDTFY.format(transaction.getTransactionDate())) == Integer.parseInt(Constants.LDTFY.format((TemporalAccessor) userInput[0])) && Integer.parseInt(Constants.LDTFM.format(transaction.getTransactionDate())) < Integer.parseInt(Constants.LDTFM.format((TemporalAccessor) userInput[0]))) {
                        toRemove.add(transaction);
                    }
                }

                // For each transaction in toRemove, remove it from searchResults
                for(Transaction transaction : toRemove){
                    searchResults.remove(transaction);
                }

                // clear toRemove
                toRemove.clear();

                // Add any dates prior to the starting day to the toRemove list
                for(Transaction transaction : searchResults){
                    if(Integer.parseInt(Constants.LDTFY.format(transaction.getTransactionDate())) == Integer.parseInt(Constants.LDTFY.format((TemporalAccessor) userInput[0])) && Integer.parseInt(Constants.LDTFM.format(transaction.getTransactionDate())) == Integer.parseInt(Constants.LDTFM.format((TemporalAccessor) userInput[0])) && Integer.parseInt(Constants.LDTFD.format(transaction.getTransactionDate())) < Integer.parseInt(Constants.LDTFD.format((TemporalAccessor) userInput[0]))) {
                        toRemove.add(transaction);
                    }
                }

                // For each transaction in toRemove, remove it from searchResults
                for(Transaction transaction : toRemove){
                    searchResults.remove(transaction);
                }

                // clear toRemove
                toRemove.clear();
            }

            // If user entered an end date filter out all transactions post that date
            if(!userInput[1].equals("")){
                // Add any transactions with dates post the end date year to the toRemove list
                for(Transaction transaction : searchResults){
                    if(Integer.parseInt(Constants.LDTFY.format(transaction.getTransactionDate())) > Integer.parseInt(Constants.LDTFY.format((TemporalAccessor) userInput[1]))) {
                        toRemove.add(transaction);
                    }
                }

                // For each transaction in toRemove, remove it from searchResults
                for(Transaction transaction : toRemove){
                    searchResults.remove(transaction);
                }

                // clear toRemove
                toRemove.clear();

                // Add any transactions with dates post the end month to the toRemove list
                for(Transaction transaction : searchResults){
                    if(Integer.parseInt(Constants.LDTFY.format(transaction.getTransactionDate())) == Integer.parseInt(Constants.LDTFY.format((TemporalAccessor) userInput[1])) && Integer.parseInt(Constants.LDTFM.format(transaction.getTransactionDate())) > Integer.parseInt(Constants.LDTFM.format((TemporalAccessor) userInput[1]))) {
                        toRemove.add(transaction);
                    }
                }

                // For each transaction in toRemove, remove it from searchResults
                for(Transaction transaction : toRemove){
                    searchResults.remove(transaction);
                }

                // clear toRemove
                toRemove.clear();

                // Add any transactions with dates post to the end date day to the toRemove list
                for(Transaction transaction : searchResults){
                    if(Integer.parseInt(Constants.LDTFY.format(transaction.getTransactionDate())) == Integer.parseInt(Constants.LDTFY.format((TemporalAccessor) userInput[1])) && Integer.parseInt(Constants.LDTFM.format(transaction.getTransactionDate())) == Integer.parseInt(Constants.LDTFM.format((TemporalAccessor) userInput[1])) && Integer.parseInt(Constants.LDTFD.format(transaction.getTransactionDate())) > Integer.parseInt(Constants.LDTFD.format((TemporalAccessor) userInput[1]))) {
                        toRemove.add(transaction);
                    }
                }

                // For each transaction in toRemove, remove it from searchResults
                for(Transaction transaction : toRemove){
                    searchResults.remove(transaction);
                }

                // clear toRemove
                toRemove.clear();
            }

            // If user entered a description filter out all transactions that don't have that transaction
            if(!userInput[2].equals("")){
                for(Transaction transaction : transactions){
                    if(!transaction.getTransactionDescription().toLowerCase().contains((String)userInput[2])){
                        toRemove.add(transaction);
                    }
                }

                // For each transaction in toRemove, remove it from searchResults
                for(Transaction transaction : toRemove){
                    searchResults.remove(transaction);
                }

                // clear toRemove
                toRemove.clear();
            }

            // If user entered a vendor name filter out all transactions that don't have that vendor name
            if(!userInput[3].equals("")){
                for(Transaction transaction : transactions){
                    if(!transaction.getTransactionVendor().toLowerCase().contains((String)userInput[3])){
                        toRemove.add(transaction);
                    }
                }

                // For each transaction in toRemove, remove it from searchResults
                for(Transaction transaction : toRemove){
                    searchResults.remove(transaction);
                }

                // clear toRemove
                toRemove.clear();
            }

            // If user entered an amount filter out all transactions that don't have that amount
            if(!userInput[4].equals("")){
                for(Transaction transaction : transactions){
                    if(transaction.getTransactionAmount() != (Double)userInput[4]){
                        toRemove.add(transaction);
                    }
                }

                // For each transaction in toRemove, remove it from searchResults
                for(Transaction transaction : toRemove){
                    searchResults.remove(transaction);
                }

                // clear toRemove
                toRemove.clear();
            }

            // Print search results
            System.out.println("Search Results:\n------------------------------------------------------------------------------------------------------------------------------------------------------");
            if(searchResults.isEmpty()){
                System.out.println("No search results...");
            }else{
                for (Transaction transaction : searchResults) {
                    transaction.printTransaction();
                }
            }
            System.out.print("Continue custom search? ");
        }
    }
}

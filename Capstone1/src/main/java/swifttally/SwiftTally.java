// Simple personal finance tracker

package swifttally;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SwiftTally {
    public static void main(String[] args) {
        // scanner will get userInput
        Scanner scanner = new Scanner(System.in);
        // transactions stores all the transactions entered by the user into the app
        List<Transaction> transactions = FileManager.readFile();
        // userInput will hold users inputs as they navigate the program
        String userInput = "";


        /*
        Test to ensure FileManger is working correctly
        for(Transaction transaction: transactions){
            System.out.println(transaction.toString());
        }

        Transaction newTransaction = new Transaction(LocalDate.parse("2026-11-02"), LocalTime.parse("09:30:05"), "breakfast", "Starbucks", -12.74);

        FileManager.writeToFile(newTransaction);
        transactions = FileManager.readFile();
        for(Transaction transaction: transactions){
            System.out.println(transaction.toString());
        }
        */


        // Display Swift Tally usage menu
        System.out.printf("%sWelcome to Swift Tally%s\n", Constants.BOLD, Constants.RESET);
        displayMenu();
        // While the user hasn't chosen to exit the program, direct them to the correct method based off their input
        while (true) {
            userInput = scanner.nextLine().toLowerCase();
            directUser(userInput, transactions, scanner);
        }
    }

    /* Methods */

    // Display Swift Tally usage menu
    public static void displayMenu() {
        System.out.printf("%sStore Guide:%s\n" +
                "%sPost Credit Transaction%s           : c, post-credit\n" +
                "%sPost Debit Transaction%s            : d, post-debit\n" +
                "%sDisplay Ledger (All Transactions)%s : l, display-ledger\n" +
                "%sDisplay All Credit Transactions%s   : lc, display-credits\n" +
                "%sDisplay All Debit Transactions%s    : ld, display-debits\n" +
                "%sSearch for a Transaction%s          : s, search\n" +
                "%sExit Swift Tally%s                  : e, exit\n", Constants.BOLD, Constants.RESET, Constants.BOLD, Constants.RESET, Constants.BOLD, Constants.RESET, Constants.BOLD, Constants.RESET, Constants.BOLD, Constants.RESET, Constants.BOLD, Constants.RESET, Constants.BOLD, Constants.RESET, Constants.BOLD, Constants.RESET);
    }

    // Direct user based off input
    public static void directUser(String userInput, List<Transaction> transactions, Scanner scanner) {
        switch (userInput) {
            case "c", "post-credit":
                postCredit(transactions, scanner);
                break;
            case "d", "post-debit":
                postDebit(transactions, scanner);
                break;
            case "l", "display-ledger":
                displayLedger(transactions);
                break;
            case "lc", "display-credits":
                displayCredits(transactions);
                break;
            case "ld", "display-debits":
                displayDebits(transactions);
                break;
            case "s", "search":
                Search(transactions, scanner);
                break;
            case "e", "exit":
                System.out.println("Goodbye");
                System.exit(0);
                break;
            default:
                displayMenu();
        }
    }

    // Add a credit transaction to transactions.psv
    public static void postCredit(List<Transaction> transactions, Scanner s){

    }


    // Add a debit transaction to transactions.psv
    public static void postDebit(List<Transaction> transactions, Scanner s){

    }


    // Display all transactions
    public static void displayLedger(List<Transaction> transactions){
        System.out.printf("%sLedger:%s\n", Constants.BOLD, Constants.RESET);
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
        for(Transaction transaction : transactions){
            System.out.printf("%sDate%s: %s  " +
                    "%sTime%s: %s   " +
                    "%sDescription%s: %s   " +
                    "%sVendor%s: %s   " +
                    "%sAmount%s: %.2f\n", Constants.BOLD, Constants.RESET, transaction.getTransactionDate(), Constants.BOLD, Constants.RESET, transaction.getTransactionTime(), Constants.BOLD, Constants.RESET, transaction.getTransactionDescription(), Constants.BOLD, Constants.RESET, transaction.getTransactionVendor(), Constants.BOLD, Constants.RESET, transaction.getTransactionAmount());
            System.out.println("---------------------------------------------------------------------------------------------------------------------");
        }
    }


    // Display all credit transactions
    public static void displayCredits(List<Transaction> transactions){

    }


    // Display all debit transactions
    public static void displayDebits(List<Transaction> transactions){

    }


    // Search for a transaction
    public static void Search(List<Transaction> transactions, Scanner s) {

    }
}
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

        // Test to ensure FileManger is working correctly
        for(Transaction transaction: transactions){
            System.out.println(transaction.toString());
        }

        Transaction newTransaction = new Transaction(LocalDate.parse("2026-11-02"), LocalTime.parse("09:30:05"), "breakfast", "Starbucks", -12.74);

        FileManager.writeToFile(newTransaction);
        transactions = FileManager.readFile();
        for(Transaction transaction: transactions){
            System.out.println(transaction.toString());
        }

        // Display Swift Tally usage menu
        System.out.printf("%sWelcome to Swift Tally%s\n", Constants.BOLD, Constants.RESET);
        // displayMenu();
        // While the user hasn't chosen to exit the program, direct them to the correct method based off their input
        /* while(true){
            userInput = scanner.nextLine().toLowerCase();
            directUser(userInput, transactions, scanner);
        } */
    }

    // methods
}

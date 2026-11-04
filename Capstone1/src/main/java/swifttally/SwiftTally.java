// Simple personal finance tracker

package swifttally;

import java.util.List;
import java.util.Scanner;

public class SwiftTally {
    public static void run() {
        // scanner will get userInput
        Scanner scanner = new Scanner(System.in);
        // transactions stores all the transactions entered by the user into the app
        List<Transaction> transactions = FileManager.readFile();
        // userInput will hold users inputs as they navigate the program
        String userInput = "";

        // Display Swift Tally usage menu
        System.out.printf("%sWelcome to Swift Tally%s\n", Constants.BOLD, Constants.RESET);

        // While the user hasn't chosen to exit the program, direct them to the correct method based off their input
        while (true) {
            Display.displayMenu();
            userInput = scanner.nextLine().toLowerCase();
            DirectUser.directUserMainMenu(userInput, transactions, scanner);
        }
    }

    /* Methods */

    // Direct user based off input
    public static void directUser(String userInput, List<Transaction> transactions, Scanner scanner) {
        switch (userInput) {
            case "c", "post-credit":
                TransactionHandler.postCredit(transactions, scanner);
                break;
            case "d", "post-debit":
                TransactionHandler.postDebit(transactions, scanner);
                break;
            case "l", "display-ledger":
                Display.displayLedger(transactions);
                break;
            case "lc", "display-credits":
                Display.displayCredits(transactions);
                break;
            case "ld", "display-debits":
                Display.displayDebits(transactions);
                break;
            case "s", "search":
                Search.Search(transactions, scanner);
                break;
            case "e", "exit":
                System.out.println("Goodbye");
                System.exit(0);
                break;
            default:
                System.out.println("Please see below for valid Swift Tally commands:");
        }
    }
}
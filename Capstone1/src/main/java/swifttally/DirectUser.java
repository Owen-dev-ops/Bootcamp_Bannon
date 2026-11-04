package swifttally;

import java.util.List;
import java.util.Scanner;

public class DirectUser {

    // Direct user based off input (Main Menu)
    public static void directUserMainMenu(String userInput, List<Transaction> transactions, Scanner scanner) {
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

    // Direct user based off input (Search Menu)
    public static boolean directUserSearchMenu(String userInput, List<Transaction> transactions, Scanner s, boolean validAnswer) {
        switch (userInput) {
            case "mtd", "month-todate-search":
                System.out.println("Search Results:\n---------------------------------------------------------------------------------------------------------------------");
                Search.monthToDate(transactions);
                System.out.println("Continue searching?:");
                break;
            case "pms", "previous-month-search":
                System.out.println("Search Results:\n---------------------------------------------------------------------------------------------------------------------");
                Search.previousMonth(transactions);
                System.out.println("Continue searching?:");
                break;
            case "ytd", "year-todate-search":
                System.out.println("Search Results:\n---------------------------------------------------------------------------------------------------------------------");
                Search.yearToDate(transactions);
                System.out.println("Continue searching?:");
                break;
            case "pys", "previous-year-search":
                System.out.println("Search Results:\n---------------------------------------------------------------------------------------------------------------------");
                Search.previousYear(transactions);
                System.out.println("Continue searching?:");
                break;
            case "vs", "vendor-search":
                System.out.println("Search Results:\n---------------------------------------------------------------------------------------------------------------------");
                Search.searchByVendor(transactions, s);
                System.out.println("Continue searching?:");
                break;
            case "cs", "custom-search":
                System.out.println("Search Results:\n---------------------------------------------------------------------------------------------------------------------");
                Search.customSearch(transactions, s);
                System.out.println("Continue searching?:");
                break;
            case "b", "back":
                System.out.println("Returning to menu...");
                validAnswer = true;
                break;
            default:
                System.out.println("Please see below for valid search commands:");
        }
        return validAnswer;
    }
}

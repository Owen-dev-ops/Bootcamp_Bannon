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
    public static void directUserSearchMenu(String userInput, List<Transaction> transactions, Scanner s) {
        switch (userInput) {
            case "mtd", "month-todate-search":
                Search.monthToDate(transactions);
                break;
            case "pms", "previous-month-search":
                Search.previousMonth(transactions);
                break;
            case "ytd", "year-todate-search":
                Search.yearToDate(transactions);
                break;
            case "pys", "previous-year-search":
                Search.previousYear(transactions);
                break;
            case "vs", "vendor-serach":
                Search.searchByVendor(transactions, s);
                break;
            case "cs", "custom-search":
                Search.customSearch(transactions, s);
                break;
            case "b", "back":
                System.out.println("Goodbye");
                break;
            default:
                System.out.println("Please see below for valid search commands:");
        }
    }
}

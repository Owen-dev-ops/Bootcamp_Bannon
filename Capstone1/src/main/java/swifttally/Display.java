package swifttally;

import java.util.List;

public class Display {

    // Display Swift Tally usage menu
    public static void displayMenu() {
        System.out.println(".--------------------------------------------------------.\n" +
                "|\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//|\n" +
                "|//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\|");
        System.out.printf("\n%s%s%sSwift Tally Guide:%s\n\n" +
                "%s%sPost Credit Transaction%s           : c, post-credit\n" +
                "%s%sPost Debit Transaction%s            : d, post-debit\n" +
                "%s%sDisplay Ledger (All Transactions)%s : l, display-ledger\n" +
                "%s%sDisplay All Credit Transactions%s   : lc, display-credits\n" +
                "%s%sDisplay All Debit Transactions%s    : ld, display-debits\n" +
                "%s%sSearch for a Transaction%s          : s, search\n" +
                "%s%sExit Swift Tally%s                  : e, exit\n\n", Constants.BOLD, Constants.UNDERLINE, Constants.GREEN, Constants.RESET, Constants.BOLD, Constants.YELLOW, Constants.RESET, Constants.BOLD, Constants.YELLOW, Constants.RESET, Constants.BOLD, Constants.YELLOW, Constants.RESET, Constants.BOLD, Constants.YELLOW, Constants.RESET, Constants.BOLD, Constants.YELLOW,Constants.RESET, Constants.BOLD, Constants.YELLOW, Constants.RESET, Constants.BOLD, Constants.YELLOW, Constants.RESET);
        System.out.print("|\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//|\n" +
                "|//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\|\n" +
                "'--------------------------------------------------------'\n");

    }

    // Display search menu usage menu
    public static void displaySearchMenu() {
        System.out.println(".--------------------------------------------------------.\n" +
                "|\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//|\n" +
                "|//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\|");
        System.out.printf("\n%s%s%sPlease select a search option:%s\n\n" +
                "%s%sMonth to Date%s    : mtd, month-todate-search\n" +
                "%s%sPrevious Month%s   : pms, previous-month-search\n" +
                "%s%sYear to Date%s     : ytd, year-todate-search\n" +
                "%s%sPrevious Year%s    : pys, previous-year-search\n" +
                "%s%sSearch by Vendor%s : vs, vendor-search\n" +
                "%s%sCustom Search%s    : cs, custom-search\n" +
                "%s%sBack to Menu%s     : b, back\n\n", Constants.BOLD, Constants.UNDERLINE, Constants.GREEN, Constants.RESET, Constants.BOLD, Constants.YELLOW, Constants.RESET, Constants.BOLD, Constants.YELLOW, Constants.RESET, Constants.BOLD, Constants.YELLOW,Constants.RESET, Constants.BOLD, Constants.YELLOW, Constants.RESET, Constants.BOLD, Constants.YELLOW, Constants.RESET, Constants.BOLD, Constants.YELLOW, Constants.RESET, Constants.BOLD, Constants.YELLOW, Constants.RESET);
        System.out.print("|\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//|\n" +
                "|//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\|\n" +
                "'--------------------------------------------------------'\n");
    }


    // Display all transactions
    public static void displayLedger(List<Transaction> transactions){
        System.out.printf("%s%s%sLedger:%s\n", Constants.BOLD, Constants.UNDERLINE, Constants.BLUE, Constants.RESET);
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
        for(Transaction transaction : transactions){
            transaction.printTransaction();
        }
        System.out.printf("%sWhat would you like to do next? (Enter h or help for options menu)%s\n", Constants.YELLOW, Constants.RESET);
    }


    // Display all credit transactions
    public static void displayCredits(List<Transaction> transactions){
        System.out.printf("%s%s%sAll Credit Transactions:%s\n", Constants.BOLD, Constants.UNDERLINE, Constants.BLUE, Constants.RESET);
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
        for(Transaction transaction : transactions){
            if(transaction.getTransactionAmount() > 0){
                transaction.printTransaction();
            }
        }
        System.out.printf("%sWhat would you like to do next? (Enter h or help for options menu)%s\n", Constants.YELLOW, Constants.RESET);
    }


    // Display all debit transactions
    public static void displayDebits(List<Transaction> transactions){
        System.out.printf("%s%s%sAll Debit Transactions:%s\n", Constants.BOLD, Constants.UNDERLINE, Constants.BLUE, Constants.RESET);
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
        for(Transaction transaction : transactions){
            if(transaction.getTransactionAmount() < 0){
                transaction.printTransaction();
            }
        }
        System.out.printf("%sWhat would you like to do next? (Enter h or help for options menu)%s\n", Constants.YELLOW, Constants.RESET);
    }

}

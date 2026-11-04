package swifttally;

import java.util.List;

public class Display {

    // Display Swift Tally usage menu
    public static void displayMenu() {
        System.out.printf("%sSwift Tally Guide:%s\n" +
                "%sPost Credit Transaction%s           : c, post-credit\n" +
                "%sPost Debit Transaction%s            : d, post-debit\n" +
                "%sDisplay Ledger (All Transactions)%s : l, display-ledger\n" +
                "%sDisplay All Credit Transactions%s   : lc, display-credits\n" +
                "%sDisplay All Debit Transactions%s    : ld, display-debits\n" +
                "%sSearch for a Transaction%s          : s, search\n" +
                "%sExit Swift Tally%s                  : e, exit\n", Constants.BOLD, Constants.RESET, Constants.BOLD, Constants.RESET, Constants.BOLD, Constants.RESET, Constants.BOLD, Constants.RESET, Constants.BOLD, Constants.RESET, Constants.BOLD, Constants.RESET, Constants.BOLD, Constants.RESET, Constants.BOLD, Constants.RESET);
    }


    // Display all transactions
    public static void displayLedger(List<Transaction> transactions){
        System.out.printf("%sLedger:%s\n", Constants.BOLD, Constants.RESET);
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
        for(Transaction transaction : transactions){
            transaction.printTransaction();
        }
        System.out.println("What would you like to do next? (Enter h or help for options menu)");
    }


    // Display all credit transactions
    public static void displayCredits(List<Transaction> transactions){
        System.out.printf("%sAll Credit Transactions:%s\n", Constants.BOLD, Constants.RESET);
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
        for(Transaction transaction : transactions){
            if(transaction.getTransactionAmount() > 0){
                transaction.printTransaction();
            }
        }
        System.out.println("What would you like to do next? (Enter h or help for options menu)");
    }


    // Display all debit transactions
    public static void displayDebits(List<Transaction> transactions){
        System.out.printf("%sAll Debit Transactions:%s\n", Constants.BOLD, Constants.RESET);
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
        for(Transaction transaction : transactions){
            if(transaction.getTransactionAmount() < 0){
                transaction.printTransaction();
            }
        }
        System.out.println("What would you like to do next? (Enter h or help for options menu)");
    }

}

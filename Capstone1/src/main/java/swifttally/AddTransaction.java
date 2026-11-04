package swifttally;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

public class AddTransaction {

    // Add a credit transaction to transactions.psv
    public static void postCredit(List<Transaction> transactions, Scanner s){
        System.out.println("Please enter credit transaction info or c at anytime to cancel:");
        addTransaction(transactions, s, 0);
    }

    // Add a debit transaction to transactions.psv
    public static void postDebit(List<Transaction> transactions, Scanner s){
        System.out.println("Please enter debit transaction info or c at anytime to cancel: ");
        addTransaction(transactions, s, 1);
    }

    // Ask user for required info to add a new transaction. Call function with int 0 to add a credit transaction or 1 for debit transactions.
    public static void addTransaction(List<Transaction> transactions, Scanner s, int creditOrDebit){
        // if creditOrDebit = 0 then add a credit transaction, otherwise add a debit transaction. This is required as for credits the code below ensures the user entered a postive value as well as it ensures a negative value is entered for debits.

        Object[] userInput = new Object[5];
        for(int i = 0; i <= userInput.length; i++) {
            boolean validAnswer = false;
            switch (i) {
                case 0:
                    while (!validAnswer) {
                        System.out.print("Date: ");
                        try {
                            userInput[i] = s.nextLine().toLowerCase();
                            if(userInput[i].equals("c")){
                                System.out.println("transaction canceled, returning you to menu...");
                                return;
                            }
                            userInput[i] = LocalDate.parse((String)userInput[i], Constants.DTF);
                            validAnswer = true;
                        } catch (Exception ex) {
                            System.out.println("Invalid date, please enter using this format: yyyy-mm-dd. Ex: 2004-07-15");
                        }
                    }
                    break;
                case 1:
                    while (!validAnswer) {
                        System.out.print("Time: ");
                        try {
                            userInput[i] = s.nextLine().toLowerCase();
                            if(userInput[i].equals("c")){
                                System.out.println("transaction canceled, returning you to menu...");
                                return;
                            }
                            userInput[i] = LocalTime.parse((String)userInput[i], Constants.TF);
                            validAnswer = true;
                        } catch (Exception ex) {
                            System.out.println("Invalid time, please enter using this format: HH:mm:ss. Ex: 10:13:25");
                        }
                    }
                    break;
                case 2:
                    System.out.print("Description: ");
                    userInput[i] = s.nextLine();
                    if(((String) userInput[i]).equalsIgnoreCase("c")){
                        System.out.println("transaction canceled, returning you to menu...");
                        return;
                    }
                    break;
                case 3:
                    System.out.print("Vendor: ");
                    userInput[i] = s.nextLine();
                    if(((String) userInput[i]).equalsIgnoreCase("c")){
                        System.out.println("transaction canceled, returning you to menu...");
                        return;
                    }
                    break;
                case 4:
                    System.out.print("Amount: ");
                    while (!validAnswer) {
                        try {
                            userInput[i] = s.nextLine().toLowerCase();
                            if(userInput[i].equals("c")){
                                System.out.println("transaction canceled, returning you to menu...");
                                return;
                            }
                            userInput[i] = Double.parseDouble((String)userInput[i]);
                            if (creditOrDebit == 0) {
                                if ((double) userInput[i] < 0) {
                                    System.out.println("Amount for credit transactions must be a positive value: ");
                                    throw new RuntimeException();
                                }
                            } else if (creditOrDebit == 1) {
                                if ((double) userInput[i] > 0) {
                                    System.out.println("Amount for debit transactions must be a negative value: ");
                                    throw new RuntimeException();
                                }
                            }
                            validAnswer = true;
                        } catch (Exception ex) {
                            System.out.println("Invalid amount, please enter a valid dollar amount using this format: $$.cc. Ex: 50.32, 1032.06");
                        }
                    }
                    break;
                default:
            }
        }
        Transaction newTransaction = new Transaction((LocalDate) userInput[0], (LocalTime)userInput[1], (String)userInput[2], (String)userInput[3], (double)userInput[4]);

        transactions.add(newTransaction);

        FileManager.writeToFile(newTransaction);

        if(creditOrDebit == 0){
            System.out.println("Credit transaction added successfully, returning you to menu...");
        }else if(creditOrDebit == 1){
            System.out.println("Debit transaction added successfully, returning you to menu...");
        }
    }
}



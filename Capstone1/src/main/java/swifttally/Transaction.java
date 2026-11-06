// Represents a financial transaction

package swifttally;

import java.time.LocalDate;
import java.time.LocalTime;

public class Transaction {
    // Properties
    private LocalDate transactionDate;
    private LocalTime transactionTime;
    private String transactionDescription;
    private String transactionVendor;
    private double transactionAmount;

    // Constructor
    public Transaction(LocalDate transactionDate, LocalTime transactionTime, String transactionDescription, String vendor, double transactionAmount) {
        this.transactionDate = transactionDate;
        this.transactionTime = transactionTime;
        this.transactionDescription = transactionDescription;
        this.transactionVendor = vendor;
        this.transactionAmount = transactionAmount;
    }

    public Transaction() {

    }

    // setters/getters
    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public LocalTime getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(LocalTime transactionTime) {
        this.transactionTime = transactionTime;
    }

    public String getTransactionDescription() {
        return transactionDescription;
    }

    public void setTransactionDescription(String transactionDescription) {
        this.transactionDescription = transactionDescription;
    }

    public String getTransactionVendor() {
        return transactionVendor;
    }

    public void setTransactionVendor(String transactionVendor) {
        this.transactionVendor = transactionVendor;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    // Behaviors
    public void printTransaction(){
        System.out.printf("%s%sDate%s: %-15s" +
                "%s%sTime%s: %-15s" +
                "%s%sDescription%s: %-30s" +
                "%s%sVendor%s: %-30s" +
                "%s%sAmount%s: %-20.2f\n" +
                "------------------------------------------------------------------------------------------------------------------------------------------------------\n", Constants.BOLD, Constants.BLUE, Constants.RESET, this.transactionDate, Constants.BOLD, Constants.BLUE, Constants.RESET, this.transactionTime, Constants.BOLD, Constants.BLUE, Constants.RESET, this.transactionDescription, Constants.BOLD, Constants.BLUE, Constants.RESET, this.transactionVendor, Constants.BOLD, Constants.BLUE, Constants.RESET, this.transactionAmount);
    }
}

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
    @Override
    public String toString() {
        return "transaction{" +
                "transactionDate=" + transactionDate +
                ", transactionTime=" + transactionTime +
                ", transactionDescription='" + transactionDescription + '\'' +
                ", vendor='" + transactionVendor + '\'' +
                ", transactionAmount=" + transactionAmount +
                '}';
    }
}

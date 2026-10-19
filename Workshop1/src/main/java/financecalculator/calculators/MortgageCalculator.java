package financecalculator.calculators;

public class MortgageCalculator {
    public static double calculateTotalInterest(double p, double r, double n) {
        double monthlyInterestRate = (r / 12) / 100;
        double numMonthlyPayments = n * 12;
        double monthlyPaymentAmount = (p * (monthlyInterestRate * (Math.pow(1 + monthlyInterestRate, numMonthlyPayments)))) /
                (Math.pow(1 + monthlyInterestRate, numMonthlyPayments) - 1);
        return (monthlyPaymentAmount * numMonthlyPayments) - p;
    }

    public static double calculateMonthlyPayment(double p, double r, double n) {
        double monthlyInterestRate = (r / 12) / 100;
        double numMonthlyPayments = n * 12;
        return (p * (monthlyInterestRate * (Math.pow(1 + monthlyInterestRate, numMonthlyPayments)))) /
                (Math.pow(1 + monthlyInterestRate, numMonthlyPayments) - 1);
    }
}

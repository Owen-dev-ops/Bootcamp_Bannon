package financecalculator.calculators;

public class PresentValueCalculator {
    public static double calculatePresentValue(double pmt, double r, double t) {
        double monthlyInterestRate = (r / 12) / 100;
        double numPayments = t * 12;
        return pmt * ((1 - Math.pow(1 + monthlyInterestRate, -numPayments)) / monthlyInterestRate);
    }
}

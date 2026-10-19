package financecalculator.calculators;

public class FutureValueCalculator {
    public static double calculateFutureValue(double p, double r, double t) {
        double dailyInterest = (r / 100) / 365;
        return p * Math.pow(1 + dailyInterest, 365 * t);
    }

    public static double calculateTotalInterestEarned(double p, double r, double t) {
        return calculateFutureValue(p, r, t) - p;
    }
}

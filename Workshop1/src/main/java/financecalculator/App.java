// Financial Calculators

package financecalculator;

import java.util.Scanner;
import financecalculator.calculators.MortgageCalculator;
import financecalculator.calculators.FutureValueCalculator;
import financecalculator.calculators.PresentValueCalculator;

public class App {

    // Used to verify user inputs of type double
    public static double inputDouble (Scanner s, String msg) {
        try {
            return s.nextDouble();
        } catch (Exception _e) {
            System.out.println(msg);
            s.nextLine();
            return -1;
        }
    }

    /* No longer in use, decided to only use doubles for calculations to prevent math errors from different data types.
    public static float inputFloat(Scanner s, String msg) {
        try {
            return s.nextFloat();
        } catch (Exception _e) {
            System.out.println(msg);
            s.nextLine();
            return -1;
        }
    }

    public static int inputInt(Scanner s, String msg) {
        try {
            return s.nextInt();
        } catch (Exception _e) {
            System.out.println(msg);
            s.nextLine();
            return -1;
        }
    }
    */


    public static void main(String[] args) {

        boolean quitProgram = false;
        boolean validAnswer = false;
        String answer = "";
        Scanner scanner = new Scanner(System.in);

        // Main Program Loop
        while (quitProgram == false) {
            // Ask user which calculator they would like to use
            System.out.println("Which calculator would you like to use? \n" +
                    "1: Mortgage Calculator \n" +
                    "2: Future Value Calculator \n" +
                    "3: Present Value Calculator \n" +
                    "Or \n" +
                    "4: Close Calculator");

            // Verify user input
            while (!validAnswer) {
                answer = scanner.nextLine();
                answer = answer.toLowerCase();
                switch (answer) {
                    case "1", "mortgage", "mortgage calculator", "mort calc", "mortgage calc" -> {
                        System.out.println("Mortgage calculator was selected.");
                        answer = "1";
                        validAnswer = true;
                        break;
                    }
                    case "2", "future", "future calculator", "future value calculator", "fut calc", "future calc" -> {
                        System.out.println("Future value calculator was selected.");
                        answer = "2";
                        validAnswer = true;
                        break;
                    }
                    case "3", "present", "present calculator", "present value calculator", "pres calc", "present calc" -> {
                        System.out.println("Present value calculator was selected.");
                        answer = "3";
                        validAnswer = true;
                        break;
                    }
                    case "4", "close", "close calculator", "close calc" -> {
                        answer = "4";
                        validAnswer = true;
                        break;
                    }
                    default ->
                            System.out.println("Please enter a valid answer.\ni.e:  1, 2, 3, 4, mortgage, future, Present value calculator, close, etc...");
                }
            }

            // Ask user for financial information correlating with the calculation they would like to complete.
            // Then validate their input, calculate values, and display to user.
            double amount = 0L;
            double interest = 0f;
            double years = 0;
            validAnswer = false;

            switch (answer) {
                case "1" -> {
                    System.out.println("Please enter the following information in order to calculate monthly mortgage payment and total interest:");
                    System.out.print("- Principal Balance in Dollars: ");
                    while (!validAnswer) {
                        String message = "Please enter a valid dollar amount:";
                        amount = App.inputDouble(scanner, message);
                        if (amount != -1) {
                            validAnswer = true;
                        }
                    }
                    validAnswer = false;
                    System.out.print("- Annual Interest Rate as a percent: ");
                    while (!validAnswer) {
                        String message = "Please enter a valid interest rate listed as a percent:";
                        interest = App.inputDouble(scanner, message);
                        if (interest != -1) {
                            validAnswer = true;
                        }
                    }
                    validAnswer = false;
                    System.out.print("- Loan Term in Years: ");
                    while (!validAnswer) {
                        String message = "Please enter a valid number of years:";
                        years = App.inputDouble(scanner, message);
                        if (years != -1) {
                            validAnswer = true;
                        }
                    }
                    validAnswer = false;

                    // Calculate total interest and monthly payment amount
                    double totalInterest = MortgageCalculator.calculateTotalInterest(amount, interest, years);
                    double monthlyPayment = MortgageCalculator.calculateMonthlyPayment(amount, interest, years);
                    System.out.printf("Total Interest: $%,.2f\n", totalInterest);
                    System.out.printf("Monthly Payment Amount: $%,.2f\n", monthlyPayment);
                    break;
                }
                case "2" -> {
                    System.out.println("Please enter the following information in order to calculate the future value of a CD and total interest earned:");
                    System.out.print("- Amount of initial deposit in dollars: ");
                    while (!validAnswer) {
                        String message = "Please enter a valid dollar amount:";
                        amount = App.inputDouble(scanner, message);
                        if (amount != -1) {
                            validAnswer = true;
                        }
                    }
                    validAnswer = false;
                    System.out.print("- Annual interest rate as a percent: ");
                    while (!validAnswer) {
                        String message = "Please enter a valid interest rate listed as a percent:";
                        interest = App.inputDouble(scanner, message);
                        if (interest != -1) {
                            validAnswer = true;
                        }
                    }
                    validAnswer = false;
                    System.out.print("- Length of CD in years: ");
                    while (!validAnswer) {
                        String message = "Please enter a valid number of years:";
                        years = App.inputDouble(scanner, message);
                        if (years != -1) {
                            validAnswer = true;
                        }
                    }
                    validAnswer = false;

                    // Calculate future value and total interest earned amount
                    double futureValue = FutureValueCalculator.calculateFutureValue(amount, interest, years);
                    double totaleInterestEarned = FutureValueCalculator.calculateTotalInterestEarned(amount, interest, years);
                    System.out.printf("Future Value of CD: $%,.2f\n", futureValue);
                    System.out.printf("Total Interest Earned: $%,.2f\n", totaleInterestEarned);
                    break;
                }
                case "3" -> {
                    System.out.println("Please enter the following information in order to calculate the present value of an annuity:");
                    System.out.print("- Monthly payout in dollars: ");
                    while(!validAnswer) {
                        String message = "Please enter a valid dollar amount:";
                        amount = App.inputDouble(scanner, message);
                        if (amount != -1) {
                            validAnswer = true;
                        }
                    }
                    validAnswer = false;
                    System.out.print("- Expected annual interest rate as a percent: ");
                    while(!validAnswer) {
                        String message = "Please enter a valid interest rate listed as a percent:";
                        interest = App.inputDouble(scanner, message);
                        if (interest != -1) {
                            validAnswer = true;
                        }
                    }
                    validAnswer = false;
                    System.out.print("- Number of years the annuity pays: ");
                    while (!validAnswer) {
                        String message = "Please enter a valid number of years:";
                        years = App.inputDouble(scanner, message);
                        if (years != -1) {
                            validAnswer = true;
                        }
                    }
                    break;
                }
                case "4" -> {
                    System.out.println("Good bye");
                    quitProgram = true;
                    break;
                }
            }
            System.out.println("success!");
            quitProgram = true;
            // Using the correlating class from the calculators package, calculate the requested value.

            // Print to user

            // Ask if the user would like to select another calculator or quit program.
                // if the user selects continue just don't change the value of quitProgram and the program will repeat

                // else
                    // print goodbye
                    // quitProgram = true
        }
        scanner.close();
    }
}

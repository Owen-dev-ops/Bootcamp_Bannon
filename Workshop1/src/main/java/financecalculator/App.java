// Financial Calculators

package financecalculator;

import java.util.Scanner;


public class App {
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
                    "2: Future Calculator \n" +
                    "3: Present Value Calculator \n" +
                    "Or \n" +
                    "4: Close Calculator \n");

            // Verify user input
            while (!validAnswer) {
                answer = scanner.nextLine();
                answer = answer.toLowerCase();
                switch (answer) {
                    case "1", "mortgage", "mortgage calculator", "mort calc", "mortgage calc" -> {
                        System.out.println("Mortgage was selected.");
                        answer = "1";
                        validAnswer = true;
                    }
                    case "2", "future", "future calculator", "future value calculator", "fut calc", "future calc" -> {
                        System.out.println("Future was selected");
                        answer = "2";
                        validAnswer = true;
                    }
                    case "3", "present", "present calculator", "present value calculator", "pres calc", "present calc" -> {
                        System.out.println("Present was selected");
                        answer = "3";
                        validAnswer = true;
                    }
                    case "4", "close", "close calculator", "close calc" -> {
                        System.out.println("Close calculator");
                        answer = "4";
                        validAnswer = true;
                    }
                    default ->
                            System.out.println("Please enter a valid answer.\ni.e:  1, 2, 3, 4, mortgage, future, Present value calculator, close, etc...");
                }
            }

            // Ask user for financial information correlating with the calculation they would like to complete.
            switch (answer) {
                case "1" -> {
                    System.out.println("Please enter the following information in order to calculate monthly mortgage payment: \n" +
                            "- Principal Balance in Dollars: \n" +
                            "- Annual Interest Rate as a percent: \n" +
                            "- Loan Term in Years: \n");
                }
                case "2" -> {
                    System.out.println("Please enter the following information in order to calculate the future value of a CD: \n" +
                            "- Amount of initial deposit in dollars: \n" +
                            "- Annual interest rate as a percent: \n" +
                            "- Length of CD in years \n");
                }
                case "3" -> {
                    System.out.println("Please enter the following information in order to calculate the present value of an annuity: \n" +
                            "- Monthly payout in dollars \n" +
                            "- Expected annual interest rate as a percent \n" +
                            "- Number of years the annuity pays \n");
                }
                case "4" -> {
                    System.out.println("Good bye");
                    quitProgram = true;
                }
            }

            // Get users answers
            long amount = 0;
            float interest = 0;
            int years = 0;
            validAnswer = false;

            // Verify correct user inputs
            while (!validAnswer) {
                amount = scanner.nextLong();
                interest = scanner.nextFloat();
                years = scanner.nextInt();

            }

            // Using the correlating class from the calculators package, calculate the requested value.
            // Print to user

            // Ask if the user would like to select another calculator or quit program.
                // if the user selects continue just don't change the value of quitProgram and the program will repeat

                // else
                    // print goodbye
                    // quitProgram = true
        }
    }
}

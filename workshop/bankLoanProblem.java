package workshop;

import java.util.Scanner;
import java.lang.Math;

public class bankLoanProblem {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        float payment = bankLoan(args);
        System.out.println("Monthly payment: " + payment);
    }

    public static float bankLoan(String[] args) {
        // Loan amount must be at least $500
        System.out.println("What is the amount of the loan? (Minimum: 500)");
        float loanAmount = input.nextFloat();
        if (loanAmount < 500) {
            System.out.println("Loan amount must be at least 500. Exiting.");
            return 0;
        }

        // Interest rate must be at least 7% and at most 50%
        System.out.println("What is the interest rate? (Minimum: 7%, Maximum: 50%)");
        float interestRate = input.nextFloat();
        if (interestRate < 7 || interestRate > 50) {
            System.out.println("Interest rate must be at least 7%. Exiting.");
            return 0;
        }

        // Time frame must be at least 2 years and at most 40 years
        System.out.println("What is the time frame? (Years, Minimum: 2 years, Maximum: 40 years)");
        int timeFrame = input.nextInt();
        if (timeFrame < 2 || timeFrame > 40) {
            System.out.println("Time frame must be at least 2 years. Exiting.");
            return 0;
        }

        return monthlyPayment(loanAmount, interestRate, timeFrame);
    }

    public static float monthlyPayment(float loanAmount, float interestRate, int timeFrame) {
        float monthlyInterestRate = interestRate / 100 / 12;
        int numberOfPayments = timeFrame * 12;
        return (float)(loanAmount * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments) / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1));
    }
}

package workshop;

import java.util.Scanner;

public class paymentInterestProblem {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("This program calculates the total payment after a year based on your savings and debt.");

        float totalPayment = paymentInterest(args);
        System.out.println("Total savings after the specified period: " + totalPayment);
    }
    public static float paymentInterest(String[] args) {
        System.out.println("Enter the ammount of money allocated to the credit card: ");
        float savings = input.nextFloat();
        if (savings < 0) {
            System.out.println("Savings cannot be negative. Exiting.");
            return 0;
        }
        System.out.println("Enter the ammount you owe: ");
        float debt = input.nextFloat();
        if (debt < 0) {
            System.out.println("Debt cannot be negative. Exiting.");
            return 0;
        }

        System.out.println("What's the interest rate: (as a whole number, e.g., 20 for 20%)");
        float interestRate = input.nextFloat();
        interestRate /= 100; // Convert to decimal
        if (interestRate < 0 || interestRate > 1) {
            System.out.println("Interest rate must be between 0 and 100. Exiting.");
            return 0;
        }

        
        for(int i = 1; i < 13; i++) {
            int counter = 12; 
            savings = savings - ((debt / counter) * (1 + interestRate));

            
            float leftOverDebt = 0;
            leftOverDebt -= debt / 12; // Pay off a portion of the debt each month

            System.out.println(" month: " + i + "\n");
            System.out.println("savings: " + savings);
            System.out.println("debt: " + leftOverDebt + "\n");

            if (savings < 0) {
                System.out.println("Not enough money to pay off the debt. Exiting on the month: " + i +".");
                return 0;
            }

            counter--; 
        }

        return savings; 
    } 
}

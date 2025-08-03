package workshop;

import java.util.Scanner;

public class savingAccountProblem {

    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        float totalSavings = calculateSavings(args);
        System.out.println("Total savings after the specified period: " + totalSavings);

    }

    public static float calculateSavings(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the initial amount in your savings account:");
        float initialAmount = input.nextFloat();

        if (initialAmount < 0) {
            System.out.println("Initial amount cannot be negative. Exiting.");
            return 0;
        }

        System.out.println("Enter the ammount you will be saving every month:");
        float monthlySavings = input.nextFloat();
        
        if (monthlySavings < 1) {
            System.out.println("Monthly savings cannot be lower than 1. Exiting.");
            return 0;
        }

        System.out.println("Enter the number of years you plan to save:");
        int years = input.nextInt();

        if (years < 0) {
            System.out.println("Number of years cannot be negative. Exiting.");
            return 0;
        }


        // Probably one of the good ways to use a cicle for this exercise. 
        // for(int i = 0; i < years; i++) {
        //     if (i % 5 == 0 && i != 0) {
        //         System.out.println("You have saved for " + i + " years. Do you want to continue saving? (yes/no)");
        //         String response = input.next();
        //         if (!response.equalsIgnoreCase("yes")) {
        //             break;
        //         }
        //     }
        // }

        return initialAmount + (monthlySavings * 12 * years);
    }
}

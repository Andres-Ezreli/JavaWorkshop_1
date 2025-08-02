package workshop;

import java.util.Scanner;

public class moneyExchangeProblem {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Select your currency: 1) COP (Colombian Peso) 2) CLP (Chilean Peso) 3) ARS (Argentinian Peso)");
        int option = input.nextInt();

        float usdRate = 0, eurRate = 0;
        String currency = "";
        switch(option) {
            case 1: // Colombian Peso
                usdRate = 0.00025f;
                eurRate = 0.00023f;
                currency = "COP";
                break;
            case 2: // Chilean Peso
                usdRate = 0.0011f;
                eurRate = 0.0010f;
                currency = "CLP";
                break;
            case 3: // Argentinian Peso
                usdRate = 0.0012f;
                eurRate = 0.0011f;
                currency = "ARS";
                break;
            default:
                System.out.println("Invalid option.");
                return;
        }

        System.out.println("Enter the amount in your currency (" + currency + "):");
        float localAmount = input.nextFloat();
        if (localAmount < 0) {
            System.out.println("Amount cannot be negative. Exiting.");
            return;
        }
        System.out.println("Equivalent in USD: " + (localAmount * usdRate));
        System.out.println("Equivalent in EUR: " + (localAmount * eurRate));
    }
}

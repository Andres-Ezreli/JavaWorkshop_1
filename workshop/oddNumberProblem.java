package workshop;

import java.util.Scanner;

public class oddNumberProblem {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        boolean pass = isPrime(args);

        if (pass) {
            System.out.println("The number is prime.");
        } else {
            System.out.println("The number is not prime.");
        }
    }

    public static boolean isPrime(String[] args) {
        System.out.println("Enter a number to check if it is a prime number:");
        int number = input.nextInt();

        boolean result = true; 

        for (int i = 1; i < 10; i++) {
            if (number % i == 0 && i != 1 && i != number) {
                System.out.println("The number is divisible by " + i + ". It is not prime.");
                result = false;
            }
        }
        return result; 
    }
}

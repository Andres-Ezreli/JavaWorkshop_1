package workshop;

import java.util.Scanner;

public class factorialProblem {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("This program calculates the factorial of a given number.");
        System.out.println("Enter a non-negative integer:");
        int number = input.nextInt();
        long factorial = calculateFactorial(number);
        System.out.println("The factorial of " + number + " is: " + factorial);
    }

    // can use big integer, gotta ask. 
    public static long calculateFactorial(int n) { //64 bit size = long
        if (n < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
            return -1;
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}

package workshop;

import java.util.Scanner;

public class taxCalculatorProblem {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        float total = taxCalculator(args);
        System.out.println("Total with tax: " + total);
    }

    public static float taxCalculator(String[] args) {
        System.out.println("Enter a product (1)");
        float product_one = input.nextFloat();

        System.out.println("Enter a product (2)");
        float product_two = input.nextFloat();

        float total = product_one + product_two;
        float tax = ((total / 100) * 15);
        return total + tax;
    }
}

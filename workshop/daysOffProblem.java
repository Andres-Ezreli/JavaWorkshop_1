package workshop; 

import java.util.Scanner;

public class daysOffProblem {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        float average = daysOff(args);
        System.out.println("Allowed days off: " + average);
    }

    public static int daysOff(String[] args) {
        System.out.println("Enter the number of years worked:");
        int yearsWorked = input.nextInt();

        if (yearsWorked < 0) {
            System.out.println("Years worked cannot be negative. Exiting.");
            return 0;
        }

        return (6 + (yearsWorked - 1) * 2) <= 20 ? (6 + (yearsWorked - 1) * 2) : 20;
    }
}

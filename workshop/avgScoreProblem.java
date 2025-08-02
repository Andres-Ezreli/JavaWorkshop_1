package workshop;

import java.util.Scanner;

public class avgScoreProblem {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        float average = calculateAverage(args);
        System.out.println("The average grade is: " + average);
    }

    public static float calculateAverage(String[] args) {
        System.out.println("This program calculates the weighted average of a set of grades. Type -1 to exit.");
        System.out.println("Enter the number of grades:");
        int numberOfScores = input.nextInt();
        float weightedSum = 0;
        float totalWeight = 0;

        for (int i = 1; i <= numberOfScores; i++) {
            System.out.println("Enter score " + i + ":");
            float score = input.nextFloat();
            if (score == -1) {
                System.out.println("Exiting the program.");
                return 0;
            }
            System.out.println("Enter weight for score " + i + " (as a percentage, e.g., 20 for 20%):");
            float weight = input.nextFloat();
            weightedSum += score * weight;
            totalWeight += weight;
        }
        if (totalWeight == 0) {
            System.out.println("Total weight cannot be zero.");
            return 0;
        }
        if (totalWeight < 100) {
            System.out.println("Warning: The total weight is less than 100%. The average will be based on " + totalWeight + "% of the total.");
        } else if (totalWeight > 100) {
            System.out.println("Warning: The total weight is greater than 100%. The average will be based on " + totalWeight + "% of the total.");
        }
        return weightedSum / totalWeight;
    }
}
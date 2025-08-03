package workshop;

import java.util.Scanner;

public class passingGradeProblem {

    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        String passing = passingGrade(args);
        System.out.println("Your result is: " + passing);
    }

    public static String passingGrade(String[] args) {
        System.out.println("Enter your grade:");
        Scanner input = new Scanner(System.in);
        int numberOfScores = input.nextInt();
        String result = "";

        if (numberOfScores < 0) {
            System.out.println("Number of scores must be a positive number. Exiting.");
            return "Error: Invalid score";
        } else if (numberOfScores < 60) {
            result = "You have failed the course.";
        } else if (numberOfScores >= 60 && numberOfScores < 70) {
            result = "You have to recover the course.";
        } else if (numberOfScores >= 70 && numberOfScores <= 100) {
            result = "You have passed the course";
        } else { 
            System.out.println("Number of scores cannot be more than 100. Exiting.");
            return "Error: Invalid score"; 
        }

        return result;
    }
}

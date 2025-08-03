package workshop;

import java.util.Scanner;
import java.lang.Math;
import java.util.concurrent.*;

public class guessGameProblem {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        int numberToGuess = (int)(Math.random() * 100) + 1; // Random number between 1 and 100
        int userGuess = 0;
        int attempts = 0;

        System.out.println("Welcome to the Guessing Game!");
        System.out.println("Try to guess the number between 1 and 100.");

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Callable<String> task = () -> {
            Thread.sleep(2000); // Simulate a long-running task
            return "Task Completed";
        };

        while (userGuess != numberToGuess && attempts < 5) {
            System.out.println("Enter your guess (attempt " + (attempts + 1) + "):");
            try {
                userGuess = input.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                input.next(); // Clear the invalid input
                continue;
            }

            if (userGuess < 1 || userGuess > 100) {
                System.out.println("Please guess a number between 1 and 100.");
                continue;
            }

            attempts++;
            if (userGuess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else if (userGuess > numberToGuess) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You've guessed the number: " + numberToGuess);
            }

            System.out.println("Attempts left: " + (5 - attempts));
            if (attempts == 5 && userGuess != numberToGuess) {
                System.out.println("Sorry, you've used all your attempts. The number was: " + numberToGuess);
            }
        }
        
        Future<String> future = executor.submit(task);
        
        try {
            String result = future.get(30, TimeUnit.SECONDS); // Set a 1-second time limit
            System.out.println(result);
        } catch (TimeoutException e) {
            System.out.println("You have not guessed the number in time!");
            future.cancel(true); // Cancel the task
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}
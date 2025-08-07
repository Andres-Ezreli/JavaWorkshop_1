import java.util.Scanner;
import java.lang.Math;
import java.util.concurrent.*;


public class workshop_1 {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Please uncomment the desired problem in the main method to run it.");
        // Uncomment the following lines to run specific problems

        // System.out.println("Total with tax: " + taxCalculator(args)); // Problema 1
        // System.out.println("Monthly payment: " + bankLoan(args)); // Problema 2
        // System.out.println(storageConvertion(args)); // Problema 3
        // System.out.println("The average grade is: " + calculateAverage(args)); // Problema 4
        // System.out.println(moneyExchange(args)); // Problema 5
        // detectFraudulentTransaction(args); // Problema 6
        // authStreaming(args); // Problema 7 -> Usuario: Pepito, Contraseña: 1234
        // System.out.println("Allowed days off: " + daysOff(args)); // Problema 8
        // System.out.println("Your result is: " + passingGrade(args)); // Problema 9
        // System.out.println("Total savings after the specified period: " + calculateSavings(args)); // problem 11
        // System.out.println("Total savings after the specified period: " + paymentInterest(args)); // problem 12
        // isPrime(args); // problem 13
        // calculateFactorial(args); // problem 14
        // guessGame(args); // problem 15

    }

    // problema 1
    public static float taxCalculator(String[] args) {
        System.out.println("Enter a product (1)");
        float product_one = input.nextFloat();

        System.out.println("Enter a product (2)");
        float product_two = input.nextFloat();

        float total = product_one + product_two;
        float tax = ((total / 100) * 15);
        return total + tax;
    }

    // problema 2
    public static float bankLoan(String[] args) {
        // Loan amount must be at least $500
        System.out.println("What is the amount of the loan? (Minimum: 500)");
        float loanAmount = input.nextFloat();
        if (loanAmount < 500) {
            System.out.println("Loan amount must be at least 500. Exiting.");
            return 0;
        }

        // Interest rate must be at least 7% and at most 50%
        System.out.println("What is the interest rate? (Minimum: 7%, Maximum: 50%)");
        float interestRate = input.nextFloat();
        if (interestRate < 7 || interestRate > 50) {
            System.out.println("Interest rate must be at least 7%. Exiting.");
            return 0;
        }

        // Time frame must be at least 2 years and at most 40 years
        System.out.println("What is the time frame? (Years, Minimum: 2 years, Maximum: 40 years)");
        int timeFrame = input.nextInt();
        if (timeFrame < 2 || timeFrame > 40) {
            System.out.println("Time frame must be at least 2 years. Exiting.");
            return 0;
        }

        return monthlyPayment(loanAmount, interestRate, timeFrame);
    }

    public static float monthlyPayment(float loanAmount, float interestRate, int timeFrame) {
        float monthlyInterestRate = interestRate / 100 / 12;
        int numberOfPayments = timeFrame * 12;
        return (float)(loanAmount * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments) / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1));
    }

    // problema 3
    public static String storageConvertion(String[] args) {
        System.out.println("This program converts storage sizes from megabytes to kylobytes and gigabytes.");
        System.out.println("Enter the size in megabytes (MB): ");
        float megabytes = input.nextFloat();
    
        if (megabytes < 0) {
            return "Error: Size cannot be negative.";
        }
        
        float kilobytes = megabytes * 1024;
        float gigabytes = megabytes / 1024;

        return "Size in kilobytes: " + kilobytes + " KB\n" + "Size in gigabytes: " + gigabytes + " GB"; 
    }

    // Problema 4
    
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

    // Problema 5
    public static void moneyExchange(String[] args) {
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

    // Problema 6
    public static void detectFraudulentTransaction(String[] args) {
        boolean isFraudulent = false;

        System.out.println("Cual es el monto de la transacción? (USD)");
        float transactionAmount = input.nextFloat();

        // Una transaccion puede ser invalida pero no fraudulenta, por eso hago la distinción entre los dos. Y da error con strings. 

        if (transactionAmount < 0.1) {
            System.out.println("El monto de la transacción es invalido. Saliendo.");
            isFraudulent = false;
        } else if (transactionAmount > 2000) {
            System.out.println("Transacción sospechosa: monto mayor a 2,000 USD. Saliendo.");
            isFraudulent = true;
        }
        
        if (isFraudulent) {
            System.out.println("Transacción fraudulenta detectada.");
        } else {
            System.out.println("Transacción aprobada.");
        }
    }

    // Problema 7
    public static void authStreaming(String[] args) {

        String username = "Pepito"; 
        String password = "1234";
        int attempts = 0;
        boolean isFraud = true;

        System.out.println("Type up your username: ");
        String inputUsername = input.nextLine();
        System.out.println("Type up your password: ");
        String inputPassword = input.nextLine();

        for(int i = 0; i < 3; i++) {
            if (inputUsername.equals(username) && inputPassword.equals(password)) {
                System.out.println("Authentication successful.");
                isFraud = true;
                break; 
            } else {
                attempts++;
                if (attempts < 3) {
                    System.out.println("Incorrect username or password. Try again.");
                    System.out.println("Type up your username: ");
                    inputUsername = input.nextLine();
                    System.out.println("Type up your password: ");
                    inputPassword = input.nextLine();
                } else {
                    System.out.println("Too many failed attempts. Exiting.");
                    isFraud = false;
                }
            }
        }

        if (isFraud) {
            System.out.println("Welcome to the streaming service!");
            // Here you can add more functionality for the streaming service.
        } else {
            System.out.println("Authentication failed. Blocked.");
        }
    }

    // Problem 8 
    public static int daysOff(String[] args) {
        System.out.println("Enter the number of years worked:");
        int yearsWorked = input.nextInt();

        if (yearsWorked < 0) {
            System.out.println("Years worked cannot be negative. Exiting.");
            return 0;
        }

        return (6 + (yearsWorked - 1) * 2) <= 20 ? (6 + (yearsWorked - 1) * 2) : 20;
    }

    // problem 9
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

    // problem 11
    public static float calculateSavings(String[] args) {
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
        return initialAmount + (monthlySavings * 12 * years);
    }


    // problem 12
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

    // problem 13
    public static void isPrime(String[] args) {
        System.out.println("Enter a number to check if it is a prime number:");
        int number = input.nextInt();

        boolean result = true; 

        for (int i = 1; i < 10; i++) {
            if (number % i == 0 && i != 1 && i != number) {
                System.out.println("The number is divisible by " + i + ". It is not prime.");
                result = false;
            }
        }
        if (result) {
            System.out.println("The number is prime.");
        } else {
            System.out.println("The number is not prime.");
        }    
    }

    public static void calculateFactorial(String[] args) { //64 bit size = long
        System.out.println("This program calculates the factorial of a given number.");

        System.out.println("Enter a non-negative integer:");
        int number = input.nextInt();

        if (number < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
            return; 
        }
        long result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        System.out.println("The factorial of " + number + " is: " + result);
    }


    // problem 15
    public static void guessGame(String[] args) {
        Thread gameThread = new Thread(() -> {
            int numberToGuess = (int)(Math.random() * 100) + 1;
            int userGuess = 0;
            int attempts = 0;

            System.out.println("Welcome to the Guessing Game!");
            System.out.println("Try to guess the number between 1 and 100. You have 30 seconds!");

            while (userGuess != numberToGuess && attempts < 5) {
                System.out.println("Enter your guess (attempt " + (attempts + 1) + "):");

                try {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("Time's up! Game interrupted.");
                        return;
                    }

                    userGuess = input.nextInt();
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a number.");
                    input.next(); // Clear invalid input
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
                    return;
                }

                System.out.println("Attempts left: " + (5 - attempts));
            }

            System.out.println("Sorry, you've used all your attempts. The number was: " + numberToGuess);
        });

        gameThread.start();

        try {
            gameThread.join(30_000); // Wait up to 30 seconds
            if (gameThread.isAlive()) {
                gameThread.interrupt(); // Time's up
                System.out.println("You ran out of time!");
                System.exit(0);
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
            System.exit(1);
        }
    }
}

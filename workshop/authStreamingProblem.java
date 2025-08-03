package workshop;

import java.util.Scanner;

public class authStreamingProblem {

    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        if (authenticateUser(args)) {
            System.out.println("Welcome to the streaming service!");
            // Here you can add more functionality for the streaming service.
        } else {
            System.out.println("Authentication failed. Blocked.");
        }
    }

    public static boolean authenticateUser(String[] args) {
        String username = "Pepito"; 
        String password = "1234";
        int attempts = 0;

        System.out.println("Type up your username: ");
        String inputUsername = input.nextLine();
        System.out.println("Type up your password: ");
        String inputPassword = input.nextLine();

        for(int i = 0; i < 3; i++) {
            if (inputUsername.equals(username) && inputPassword.equals(password)) {
                System.out.println("Authentication successful.");
                return true;
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
                    return false;
                }
            }
        }


       return true;
    }
}

package workshop;

import java.util.Scanner;

public class fraudCreditCardProblem {

    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        if (detectFraudulentTransaction(args) == true) {
            System.out.println("Transacción fraudulenta detectada.");
        } else {
            System.out.println("Transacción aprobada.");
        }
    }

    public static boolean detectFraudulentTransaction(String[] args) {
        System.out.println("Cual es el monto de la transacción? (USD)");
        float transactionAmount = input.nextFloat();

        // Una transaccion puede ser invalida pero no fraudulenta, por eso hago la distinción entre los dos. Y da error con strings. 

        if (transactionAmount < 0.1) {
            System.out.println("El monto de la transacción es invalido. Saliendo.");
            return false;
        } else if (transactionAmount > 2000) {
            System.out.println("Transacción sospechosa: monto mayor a 2,000 USD. Saliendo.");
            return true;
        }

        return false; 
    }

}

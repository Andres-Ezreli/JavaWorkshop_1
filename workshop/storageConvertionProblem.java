package workshop;

import java.util.Scanner;

public class storageConvertionProblem {

    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        String result = storageConvertion(args);
        System.out.println(result);
    }

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
}

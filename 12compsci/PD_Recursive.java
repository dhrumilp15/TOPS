//RecursionProblems
//Dhrumil Patel
//ICS4U1

import java.util.Scanner;
import java.lang.Math;

public class PD_Recursive {
    static Scanner sc; // Scanner object

    /**
     * Driver method for determining prime numbers
     */
    private static void primeDriver() {
        System.out.print("Enter an integer: "); // Prompt user for input
        int n = sc.nextInt(); // Gets user input
        String message = "";
        if (!prime(n)) // If the number isn't prime, use a not message
            message = " not";
        System.out.println(n + " is" + message + " prime.");
        sc.nextLine();
        sc.nextLine();
    }

    /**
     * Finds if a number is prime
     * 
     * @param N number to test
     * @return true if prime, false otherwise
     */
    private static boolean prime(int N) {
        if (N <= 1) // numbers less than or equal to 1 are not prime
            return false;
        // Testing prime numbers only requires testing from 2 to sqrt(n)
        return prime(N, (int) Math.ceil(Math.sqrt(N))); // Pass it to the overloaded method that takes two integers
    }

    /**
     * Recursive overloaded method that tests if N is divisible by D
     * 
     * @param N The number to test, will stay the same throughout
     * @param D The divisor to test
     * @return true if the number is prime, false otherwise
     */
    private static boolean prime(int N, int D) {
        if (D == 1) // It's prime!
            return true; // Return up the chain
        if (N % D == 0) // It divided evenly, not prime
            return false; // Return up the chain
        return prime(N, D - 1); // Check the next integer down from D.
    }

    /**
     * Driver method that displays the given value in the Perrin sequence based on a
     * user given index
     */
    private static void perrinDriver() {
        System.out.println("Enter an integer: "); // Prompt user for input
        int n = sc.nextInt(); // Get user input
        // Calculate nth perrin sequence number using iteration
        System.out.printf("Without Recursion, element [%d] in the Perrin sequence is (%d).\n", n, perrinIterative(n));
        // Calculate nth perrin sequence number using slow recursion
        System.out.printf("Using Recursion, element [%d] in the Perrin sequence is (%d).\n", n, perrin(n));
        sc.nextLine();
        sc.nextLine();
    }

    /**
     * Recursive method that calculates the nth value in the Perrin sequence
     * 
     * @param n The index of the requested number
     * @return The nth value in the Perrin sequence
     */
    private static int perrin(int n) {
        // Exit conditions
        if (n == 0) // Check for 0, return 3
            return 3;
        if (n == 1) // Check for 1, return 0
            return 0;
        if (n == 2) // Check for 2, return 2
            return 2;
        return perrin(n - 2) + perrin(n - 3); // Calculate the recursive sequence
    }

    /**
     * Calculates the nth value in the Perrin sequence with memoization
     * 
     * @param n: The index of the requested number
     * @return The nth value of the Perrin sequence
     */
    private static int perrinIterative(int n) {
        int[] perrinArr = new int[n + 1]; // Create the sequence array
        // Base cases
        perrinArr[0] = 3; // Set 0 to 3
        perrinArr[1] = 0; // Set 1 to 0
        perrinArr[2] = 2; // Set 2 to 2

        for (int i = 3; i <= n; i++) { // Loop through all the numbers from 3 to n
            perrinArr[i] = perrinArr[i - 2] + perrinArr[i - 3]; // Save the number calculated into the array
        }
        return perrinArr[n]; // Finally, return the nth value in the array which is our answer
    }

    public static void main(String[] args) {
        sc = new Scanner(System.in); // Create the scanner object from the input stream
        char choice;
        do {
            // Print out the menu
            System.out.println("\n\n\nRecursion Problems");
            System.out.println("--------------");
            System.out.println("1. Prime Number Check");
            System.out.println("2. Perrin Sequence");
            System.out.println("0. Quit");
            choice = sc.nextLine().charAt(0); // Receive the user's choice

            // Case the possible choices (and ignore if impossible choice).
            switch (choice) {
                case '1':
                    primeDriver();
                    break;
                case '2':
                    perrinDriver();
                    break;
            }
        } while (choice != '0'); // exit when 0
    } // main method
} // PD_Recursive class
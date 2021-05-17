import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PD_Methods {
	static Random rand = new Random(); // Initializes the random object

	/**
	 * Calcuates the area of a circle.
	 * 
	 * @param r The radius of the circle
	 * @return area of circle as double.
	 */
	public static double circle(double r) {
		return Math.PI * Math.pow(r, 2);
	}

	/**
	 * Finds if a number is odd
	 * 
	 * @param n A number to test
	 * @return false if n is even, else odd
	 */
	public static boolean odd(int n) {
		if (n % 2 == 0)
			return false;
		return true;
	}

	/**
	 * Gets the name of the nth month
	 * 
	 * @param n Index of month to get
	 * @return month name as String
	 */
	public static String month(int n) {
		List<String> list = Arrays.asList("January", "Febuary", "March,", "April", "May", "June", "July", "August",
				"September", "Octobder", "November", "December");
		return list.get(n - 1);
	}

	/**
	 * Gets the number of days of the nth month.
	 * 
	 * @param n Index of the month for which to get the number of days.
	 * @return number of days as integer.
	 */
	public static int days(int n) {
		// Number of days in each month
		List<Integer> list = Arrays.asList(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);
		// Return the value of days of the nth month
		return list.get(n - 1);
	}

	/**
	 * Gets a random number between max and min, inclusive
	 * 
	 * @param max Largest possible value
	 * @param min Smallest possible value
	 * @return a random number as an integer.
	 */
	public static int random(int max, int min) {
		// Subtract min from max and add 1 to allow max to be included in generation of
		// the random number
		return rand.nextInt(max - min + 1) + min;
	}

	/**
	 * Flips a coin
	 * 
	 * @return an H or T as a String
	 */
	public static char flip() {
		// Let H be 1
		if (random(1, 0) == 1) { // Grabs a random number
			return 'H'; // Returns H if the number is 1
		}
		return 'T'; // Returns T if the number is 0
	}

	/**
	 * Gets a random letter from capital A to capital Z
	 * 
	 * @return a random capital letter as a char
	 */
	public static char randomLetter() {
		return (char) random(90, 65); // Casts the random number to a capital letter
	}

	static Scanner sc; // Declares a new scanner object

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int choice = -1; // Initializes choice as an impossible value
		while (choice != 0) {
			// Prints menu and take choice
			System.out.println("\n\n\n~~~Methods ~~~\n"); // Greeting
			// Program options
			System.out.println("1. Circles");
			System.out.println("2. Month Days");
			System.out.println("3. Random Flip and Letters");

			choice = sc.nextInt(); // Gets user choice

			// Calls the apropriate method
			switch (choice) {
			case 1: // If the user enters 1
				System.out.println("Enter radius of circle"); // Prompts for given radius
				int radius = sc.nextInt(); // Gets the given radius
				if (odd(radius)) { // Checks if the radius is odd and reports as such
					System.out.println("The radius is odd");
				} else {
					System.out.println("The radius is even");
				}
				System.out.printf("Area = %1.2f square units", circle(radius)); // Displays the area
				break;
			case 2: // If the user enters 2
				// Prints the month padded with 15 spots, followed by the number of days
				System.out.printf("%-15s%20s\n", "Month", "Days");
				for (int i = 1; i <= 12; i++) // Prints each month and the number of days in the month
					System.out.printf("%-15s%20d\n", month(i), days(i));
				break;
			case 3: // If the user enters 3
				// Prints a heading
				System.out.print("10 coin flips: ");
				int numTails = 0; // Initializes the number of tails as 0
				for (int i = 0; i < 10; i++) { // Flips 10 coins
					if (flip() == 'H') { // Checks if the flipped coin is H
						System.out.print("H"); // Prints H if it's an H
					} else {
						System.out.print("T"); // Prints T if it's a T
						numTails++; // Increment the number of tails if it's tails
					}
				}
				// Reports the tails and strings
				System.out.printf(" %1d", 10 * numTails);
				System.out.print("% Tails");
				System.out.printf("\n5 4 random letter strings ");
				for (int i = 0; i < 5; i++) { // Runs 5 times
					for (int j = 0; j < 4; j++) { // Runs 4 times
						System.out.print(randomLetter()); // Shows a random capital letter
					}
					System.out.print(" "); // Prints a space to separate
				}
				break;
			}

		}

	}

}

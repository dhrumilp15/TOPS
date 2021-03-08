//LoopingProblems
//Dhrumil Patel
//ICS4U1

import java.util.Scanner;

public class PD_LoopingProblems {
	static Scanner sc;

	/**
	 * Adds all the reciprocals of numbers from 1 to N
	 */
	private static void sumComplete() {
		System.out.println("Enter N");
		int N = sc.nextInt(); // Receive the N from the user
		double sum = 0;
		for (int i = 1; i <= N; i++) { // Loop through all numbers from 1 to N
			sum += 1.0d / i; // Add the reciprocal making sure to use double arithmetic
		}
		System.out.println("\nSum is: " + sum); // Print out the sum
		sc.nextLine();
		sc.nextLine();
	}

	/**
	 * Adds the squares and cubes of numbers using open and closed forms of the
	 * series
	 */
	private static void addingSquaresAndCubes() {
		System.out.println("Upper Limit:");
		int N = sc.nextInt(); // Gets the N value from the user
		int sumOfSquaresLooped = 0;
		int sumOfCubesLooped = 0;
		for (int i = 1; i <= N; i++) { // Loops through 1 to N
			sumOfSquaresLooped += i * i; // Adds all the squares
			sumOfCubesLooped += i * i * i; // Adds all the cubes
		}
		// Prints the sum of squares from loop
		System.out.println("The sum of Squares (Loop) is " + sumOfSquaresLooped);
		// Calculates the sum of squares using the closed form
		int sumOfSquaresCalc = N * (N + 1) * (2 * N + 1) / 6;
		// Prints the the sum of squares from the closed form
		System.out.println("The sum of Squares (Calc) is " + sumOfSquaresCalc);
		// Prints the value of the cube sum from loop
		System.out.println("The sum of Cubes   (Loop) is " + sumOfCubesLooped);
		// Calculates the sum of cubes using the closed form
		int sumOfCubesCalc = N * N * (N + 1) * (N + 1) / 4;
		// Prints the closed form of sum of cubes
		System.out.println("The sum of Cubes   (Calc) is " + sumOfCubesCalc);
		sc.nextLine();
		sc.nextLine();
	}

	/**
	 * Repeatedly prompts the user for limits of a range and adds the numbers in the
	 * range
	 */
	private static void inRangeAdder() {
		System.out.println("In-range Adder");
		System.out.println("Low end of range:");
		int lowEnd = sc.nextInt(); // Gets the min of range
		System.out.println("High end of range:");
		int highEnd = sc.nextInt(); // Gets the max of range

		int inclusiveSum = 0;
		int exclusiveSum = 0;

		int data;
		do { // Constantly loop
			System.out.println("Enter data:");
			data = sc.nextInt(); // Gets the user input
			if (data >= lowEnd && data <= highEnd)
				inclusiveSum += data; // Adds to the inclusiveSum if inside range
			else
				exclusiveSum += data; // Adds to the exclusiveSum if outside range
		} while (data != 0); // Breaks out of loop when user enters 0
		System.out.println("Sum of in range values: " + inclusiveSum); // Prints the sum of numbers in the range
		System.out.println("Sum of out of range values: " + exclusiveSum); // Prints the sum of numbers out of range
		sc.nextLine();
		sc.nextLine();
	}

	/**
	 * Repeatedly prompts the user for a weight and prints out a cost
	 */
	private static void shippingCost() {
		int weight;
		do { // Constantly loops
			System.out.println("Weight of Order:");
			weight = sc.nextInt(); // Gets the weight from the user
			if (weight > 0) {
				float cost = 3 + Math.max(((float) weight) - 10, 0) / 4; // Calculates the cost needed using the base
																			// cost and .25 extras
				System.out.printf("Shipping Cost: $%1.2f\n", cost); // Prints the cost
			}
			System.out.println();
		} while (weight > 0); // Break if weight is 0 or less
		System.out.println("bye");
		sc.nextLine();
		sc.nextLine();
	}

	/**
	 * Calculates the credit card bill using values acquired by prompting the user
	 */
	private static void creditCardBill() {
		System.out.println("Enter the beginning balance:");
		float balance = sc.nextFloat(); // Stores the beginning balance
		System.out.println("Enter the monthly interest:");
		float interest = sc.nextFloat() / 100; // Stores the monthly interest as a percent
		System.out.println("Enter the monthly payment:");
		float payment = sc.nextFloat(); // Stores the monthly payment
		// Useful variables
		float totalPayment = 0;
		int month = 0;
		// Repeatedly decrease balance to determine the final payment needed
		while (balance > 0) {
			float currentInterest = balance * interest; // Calculate interest on current amount
			balance += currentInterest; // Update balance
			totalPayment += payment; // Update the totalPayment
			month++; // Increment a passed month
			if (balance > payment) {
				balance -= payment; // Decrease balance to clear a single month's payment
				// Print useful metrics
				System.out.printf("Month: %d\tbalance: %1.2f\t\ttotal payments: %1.2f\n", month, balance, totalPayment);
			} else {
				// Print the final payment
				System.out.println("Final Payment Needed: " + balance);
				balance = -1; // exit out of the loop
			}
		}
		sc.nextLine();
		sc.nextLine();
	}

	/**
	 * Calculates the potency of a drug given that it decreases its potency over
	 * time
	 */
	private static void drugPotency() {
		// Sets initial effectiveness and month
		float effectiveness = 100;
		int month = 0;
		// Drug becomes unsuable after its effectiveness falls below 50
		while (effectiveness > 50) {
			// Prints the current status
			System.out.printf("month: %d\teffectiveness: %1.2f\n", month, effectiveness);
			// Decreases the drug's effectiveness by 4% each month
			effectiveness *= 0.96;
			// Updates the month
			month++;
		}
		// Prints the month it expires
		System.out.printf("month: %d\teffectiveness: %1.2f DISCARDED\n", month, effectiveness);
		sc.nextLine();
		sc.nextLine();
	}

	public static void main(String[] args) {
		sc = new Scanner(System.in); // Create the scanner object from the input stream
		char choice;
		do {
			// Print out the menu
			System.out.println("\n\n\nLooping Problems");
			System.out.println("--------------");
			System.out.println("1. Reciprocal Sum Calculator");
			System.out.println("2. Adding up Squares and Cubes");
			System.out.println("3. In-range Adder");
			System.out.println("4. Shipping Cost Calculator");
			System.out.println("5. Credit Card Bill");
			System.out.println("6. Drug Potency");
			System.out.println("0. Quit");
			choice = sc.nextLine().charAt(0); // Receive the user's choice

			// Case the possible choices (and ignore if impossible choice).
			switch (choice) {
			case '1':
				sumComplete();
				break;
			case '2':
				addingSquaresAndCubes();
				break;
			case '3':
				inRangeAdder();
				break;
			case '4':
				shippingCost();
				break;
			case '5':
				creditCardBill();
				break;
			case '6':
				drugPotency();
				break;
			}
		} while (choice != '0'); // exit when 0
	} // main method
} // LoopingProblems class

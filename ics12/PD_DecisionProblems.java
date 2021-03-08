/*
ICS4U1
Dhrumil Patel
Decision Problems
*/

//To accept input
import java.util.Scanner;

public class PD_DecisionProblems { // This program contains a menu of some simple decision functions

	static Scanner sc; // the class wide scanner object

	/*
	 * Prompts user for input. Calculates the cost per pound of lean beef for each
	 * package.
	 */
	private static void groundBeef() {
		// Here we take in both the price per pound and percent lean of package A and B
		// Camel casing as standard
		System.out.println("Price per pound for package A:");
		float pricePerPoundA = sc.nextFloat(); // We are using floats because they could be decimal numbers
		System.out.println("Percent lean for package A:");
		float percentLeanA = sc.nextFloat();
		System.out.println("Price per pound for package B:");
		float pricePerPoundB = sc.nextFloat();
		System.out.println("Percent lean for package B:");
		float percentLeanB = sc.nextFloat();

		// First the percent lean is divided by 100 to make the percent number into a
		// decimal. Then the
		// price per pound is divided by the resulting decimal to calculate the cost per
		// pound of lean meat
		float costPerPoundLeanA = pricePerPoundA / (percentLeanA / 100);
		System.out.println("Package A cost per pound of lean:" + costPerPoundLeanA); // We print this to the user
		float costPerPoundLeanB = pricePerPoundB / (percentLeanB / 100);
		// This calculation and print to user is repeated for the B package
		System.out.println("Package B cost per pound of lean:" + costPerPoundLeanB);
		// We check which package has a lower cost per pound of lean, which means it is
		// the better value
		char bestValue = costPerPoundLeanA < costPerPoundLeanB ? 'A' : 'B';
		// We can finally print the better value package
		System.out.println("Package " + bestValue + " is the best value");
		sc.nextLine();
		sc.nextLine();
	}

	/*
	 * Calculates and displays costs from item name, price, and overnight shipping
	 * choice
	 */
	private static void internetDelicatessen() {
		// Prompt the user for the item name, the price in cents, and whether they want
		// overnight delivery
		System.out.print("Enter the item: ");
		String itemName = sc.nextLine(); // The name is a word(s) so we use a string
		System.out.print("Enter the price: ");
		int itemPriceInCents = sc.nextInt(); // The price in cents is an integer
		System.out.print("Overnight delivery (0==no, 1==yes): ");
		// We can store the choice of overnight shipping as a boolean by only
		// temporarily
		// using the integer in the scanner for a decision
		boolean overnightShippingChoice = sc.nextInt() == 0 ? false : true;

		float itemDollarPrice = ((float) itemPriceInCents) / 100; // The dollar price is the cent price divided by 100
		float shippingCost = itemDollarPrice < 10 ? 2 : 3; // Calculate shipping cost based on order cost
		if (overnightShippingChoice) // If they chose overnight shipping, add 5 to the cost
			shippingCost += 5;

		// We can now print out the results
		System.out.println("Invoice:");

		// Using the length of the item name we can calculate the amount of tabs we need
		// for the other prints
		// in order to keep them aligned
		String paddingTabAmount = "";

		for (int i = 0; i < Math.max(itemName.length() / 7, 1); i++) // Loop as many times as the length divided by 7
			paddingTabAmount += "\t";

		System.out.printf("  " + itemName + paddingTabAmount + "\t%1.2f\n", itemDollarPrice); // The price of the item
		// The shipping cost was already calculated and can be printed
		System.out.printf("  shipping" + paddingTabAmount + "%1.2f\n", shippingCost);
		// The total is simply the item plus the shipping and can also be printed
		System.out.printf("  total " + paddingTabAmount + "%1.2f\n", (itemDollarPrice + shippingCost));
		sc.nextLine();
		sc.nextLine();
	}

	/*
	 * Prompts user for tire pressures Calculates if front and rear tires are within
	 * 3 psi of each other, respectively
	 */
	private static void pressureBuilding() {
		// Receive the tire pressures from the user
		System.out.println("Input right front pressure ");
		float rightFrontPressure = sc.nextFloat(); // Store the pressures as floating point just in case
		System.out.println("Input left front pressure ");
		float leftFrontPressure = sc.nextFloat();
		System.out.println("Input right rear pressure ");
		float rightBackPressure = sc.nextFloat();
		System.out.println("Input left rear pressure ");
		float leftBackPressure = sc.nextFloat();
		System.out.println(); // Just some padding

		// By calculating the absolute value of the subtraction between the relevant
		// tire pressures,
		// we can determine if the fall between the range of + or - 3 psi. If both pass
		// the check
		// then we can print to the user that inflation is in fact OK, or if it is not
		// in the other case
		if ((Math.abs(rightFrontPressure - leftFrontPressure) <= 3)
				&& (Math.abs(rightBackPressure - leftBackPressure) <= 3))
			System.out.println("Inflation is OK");
		else
			System.out.println("Inflation is NOT OK");
		sc.nextLine();
		sc.nextLine();
	}

	public static void main(String[] args) {
		sc = new Scanner(System.in); // Create the scanner object from the input stream
		char choice;
		do {
			// Print out the menu
			System.out.println("\n\n\nDecision Problems");
			System.out.println("--------------");
			System.out.println("1. Ground Beef Value Calculator");
			System.out.println("2. Internet Delicatessen");
			System.out.println("3. The Pressure is Building");
			System.out.println("0. Quit");
			choice = sc.nextLine().charAt(0); // Receive the user's choice

			// Case the possible choices (and ignore if impossible choice).
			switch (choice) {
			case '1':
				groundBeef();
				break;
			case '2':
				internetDelicatessen();
				break;
			case '3':
				pressureBuilding();
				break;
			}
		} while (choice != '0'); // exit when 0
	} // main method
} // DecisionProblems class

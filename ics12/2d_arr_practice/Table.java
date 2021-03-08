// Dhrumil Patel
// Table Class
// ICS4U1
// June 16, 2020

import java.util.*;

/**
 * Table class that sets up table manipulations
 */
public class Table {

	int[][] arr;
	int r; // rows
	int c; // columns

	/**
	 * Creates a table object from given rows + cols
	 * 
	 * @param row    Rows
	 * @param column Cols
	 */
	public Table(int row, int column) {
		r = row;
		c = column;
		arr = new int[r][c];

		// fill array with random numbers from 40-95
		for (int i = 0; i < r; i++) {// run through rows
			for (int j = 0; j < c; j++) {// run through columns
				arr[i][j] = (int) (Math.random() * (95 - 40 + 1)) + 40;
			}
		}
	}

	/**
	 * Populate table from given table
	 * 
	 * @param table Given table
	 */
	public Table(int[][] table) {
		arr = table;
		r = table[0].length;
		c = table.length;
	}

	/**
	 * Return table as String
	 * 
	 * @return String version of table
	 */
	public String toString() {
		String finalStr = "";
		for (int[] row : arr) {
			finalStr = finalStr.concat(row.toString()) + "\n";
		}
		return finalStr;
	}

	/**
	 * Calculates the average of a row/colum
	 * 
	 * @param rc row/col
	 * @param a  index of row/col
	 * @return double average
	 */
	public double average(String rc, int a) {
		// a is the desired row or column
		double total = 0.0;
		double average = 0.0;

		// average for a row
		if (rc.equals("r")) {
			for (int i = 0; i < c; i++) {// number of values in a row = number of columns
				total += arr[a - 1][i];// column changes, row stays constant
			}
			average = total / c;
		}
		// average for a column
		else if (rc.equals("c")) {
			for (int i = 0; i < r; i++) {// number of values in a column = number of rows
				total += arr[i][a - 1];// row changes, column stays constant
			}
			average = total / r;
		}

		return average;
	}

	/**
	 * Calculates the product of a row/colum
	 * 
	 * @param rc row/col
	 * @param a  index of row/col
	 * @return int product
	 */
	public int product(String rc, int a) {

		int product = 1;

		if (rc.equals("r")) {
			for (int i = 0; i < c; i++) {
				product *= arr[a - 1][i];
			}
		}

		else if (rc.equals("c")) {
			for (int i = 0; i < r; i++) {
				product *= arr[i][a - 1];
			}
		}

		return product;
	}

	/**
	 * Generates a random table with user input
	 * 
	 * @return Table object
	 */
	public static Table generate() {
		Scanner sc = new Scanner(System.in);
		System.out.println("How many rows?");
		int rows = sc.nextInt();
		System.out.println("How many columns?");
		int columns = sc.nextInt();
		Table array = new Table(rows, columns);
		return array;
	}

	/**
	 * Averages with user input
	 * 
	 * @param array Table object
	 */
	public static void averageDriver(Table array) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Select rows or columns (enter 'r' or 'c'):");
		String rc = sc.next();

		System.out.println("Which row/column would you like to average?");
		int a = sc.nextInt();
		double average = array.average(rc, a);
		System.out.print("The average is ");
		System.out.printf("%.2f", average);
		System.out.println("\nPress 'enter' to continue.");
		sc.nextLine();
		sc.nextLine();

	}

	/**
	 * Products with user input
	 * 
	 * @param array Table object
	 */
	public static void productDriver(Table array) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Select rows or columns (enter 'r' or 'c'):");
		String rc = sc.next();

		System.out.println("Which row/column would you like to get the product for?");
		int a = sc.nextInt();
		int product = array.product(rc, a);
		System.out.print("The product is " + product);
		System.out.println("\nPress 'enter' to continue.");
		sc.nextLine();
		sc.nextLine();
	}

	// main method
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice = 0;

		Table table = generate();

		do {

			System.out.print(table.toString());

			System.out.println("\nOptions:");
			System.out.println("1) New Table");
			System.out.println("2) Average of a row or column");
			System.out.println("3) Test - Product of a row or column");
			System.out.println("0) Quit");
			choice = sc.nextInt();

			if (choice == 1) {
				table = generate();
			}
			if (choice == 2) {
				averageDriver(table);
			} else if (choice == 3) {
				productDriver(table);
			}

		} while (choice != 0);

	}
}

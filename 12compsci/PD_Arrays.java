//Arrays
//Dhrumil Patel
//ICS4U1

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents a custom Array
 */
class Array {
	// To store names
	String[] names;

	/**
	 * Creates a default array
	 */
	public Array() {
		names = new String[0];
	}

	/**
	 * Creates an array using information in a file
	 */
	public Array(String filename) {
		File file = new File(filename); // open the file
		try {
			Scanner filesc = new Scanner(file); // start reading from it
			ArrayList<String> namesBuffer = new ArrayList<String>(); // buffer to hold the names
			while (filesc.hasNextLine()) { // while there are more lines to read
				String name = filesc.nextLine(); // read the name
				namesBuffer.add(name); // add it to the buffer
			}
			names = new String[namesBuffer.size()]; // allocate the space needed
			names = namesBuffer.toArray(names); // turn the list into our array
			filesc.close(); // close the file
		} catch (FileNotFoundException e) { // if it failed to read make an empty array instead
			System.err.println("Couldn't open file! Making empty array.");
			names = new String[0];
		}
	}

	/**
	 * Allow the user to enter values to add into the array
	 * 
	 * @param sc The scanner object from which to accept input.
	 */
	public void enter(Scanner sc) {
		String name = sc.nextLine(); // first name read
		ArrayList<String> input_names = new ArrayList<String>(); // make our buffer
		while (!name.equals("q")) { // while the name read isn't "q" for quit
			input_names.add(name); // add name to buffer
			name = sc.nextLine(); // read next name
		}
		names = new String[input_names.size()]; // allocate space in array
		names = input_names.toArray(names); // turn list into array
	}

	/**
	 * Prints each name with its index in the array along with a header.
	 */
	public void print() {
		// print special message if array is empty
		if (names.length == 0) {
			System.out.println("No names!");
			return;
		}
		System.out.println("===== " + names.length + " name(s) ====="); // Header
		for (int i = 0; i < names.length; i++) {
			System.out.println(i + ": " + names[i]); // loop through each name and print with index
		}
		System.out.println("=====-----------====="); // Footer
	}

	/**
	 * Searches for given names that start with `c`
	 * 
	 * @param c The character to search for
	 * @return An Array that holds names starting with `c`
	 */
	public Array search(char c) {
		Array return_names = new Array(); // new array to hold found names
		for (String name : names) // loop through names
			if (name.charAt(0) == c) // if the first character of the name is our target...
				return_names.add(name); // add it to the result array
		return return_names; // return the new array
	}

	/**
	 * Searches for a given surname
	 * 
	 * @param surname The specified surname for which to search
	 * @return An Array that holds names with surnames of the given surname
	 */
	public Array search(String surname) {
		Array return_names = new Array(); // new array to hold found names
		for (String name : names) { // loop through names
			String last_name = name.split(",")[0]; // get surname
			if (last_name.equals(surname)) { // if the surname is the same as our target...
				return_names.add(name); // add it to the result array
			}
		}
		return return_names; // return the new array
	}

	/**
	 * Adds a name to the array
	 * 
	 * @param name The name to add to the array
	 */
	public void add(String name) {
		String[] newnames = new String[names.length + 1]; // make new array that is one bigger
		for (int i = 0; i < names.length; i++) // loop through old array
			newnames[i] = names[i]; // assign to new array
		newnames[names.length] = name; // make last element the new name
		names = newnames; // make old array the new array
	}

	/**
	 * Removes a name from the array.
	 * 
	 * @param index The index at which to remove an item
	 */
	public void remove(int index) {
		String[] newnames = new String[names.length - 1]; // make new array that is one smaller
		for (int i = 0; i < index; i++) // loop through until index
			newnames[i] = names[i]; // assign to new array
		for (int i = index + 1; i < names.length; i++) // loop one after the index
			newnames[i - 1] = names[i]; // assign to new array
		names = newnames; // make old array the new array
	}

	/**
	 * Sorts the array using bubble sort
	 */
	public void sort() {
		// O(n^2)
		for (int i = names.length - 1; i >= 0; i--) { // loop from end
			for (int j = 0; j < i; j++) { // loop from start
				if (names[j].compareTo(names[j + 1]) > 0) { // compare the names
					String a = names[j]; // swap the names if out of order
					names[j] = names[j + 1];
					names[j + 1] = a;
				}
			}
		}
	}
}

public class PD_Arrays { // driver class
	static Scanner sc;
	static Array names;

	/**
	 * Loads a file into the array
	 */
	private static void loadFromFile() {
		System.out.println("Enter file name: "); // get filename from user
		String filename = sc.nextLine();
		names = new Array(filename); // make array with that file
	}

	/**
	 * Lets the user enter names into the array.
	 */
	private static void enterFromUser() {
		System.out.println("Start entering names (q to stop):"); // prompt to start entering names
		names = new Array();
		names.enter(sc); // accept names
	}

	/**
	 * Lets a user add names to the array
	 */
	private static void addName() {
		System.out.println("Enter name to be added:"); // get name from user
		String name = sc.nextLine();
		names.add(name); // add to array
	}

	/**
	 * Lets the user remove names from the array.
	 */
	private static void removeName() {
		System.out.println("Enter position to be removed:"); // get position from user
		int pos = sc.nextInt();
		names.remove(pos); // remove from that position
		sc.nextLine();
	}

	/**
	 * Lets the user search for a name using a chatacter.
	 */
	private static void letterSearch() {
		System.out.println("Enter letter to search:"); // get character from user
		char letter = sc.nextLine().charAt(0);
		Array results = names.search(letter); // search for character
		System.out.println("Search results:\n"); // display results
		results.print();
		sc.nextLine();
	}

	/**
	 * Lets the user search for a name using a surname.
	 */
	private static void surnameSearch() {
		System.out.println("Enter surname to search:"); // get surname from user
		String surname = sc.nextLine();
		Array results = names.search(surname); // search for surname
		System.out.println("Search results:\n"); // display results
		results.print();
		sc.nextLine();
	}

	public static void main(String[] args) { // main
		sc = new Scanner(System.in);
		names = new Array();
		char choice;
		do {
			// print the current array
			System.out.println("\n\n\n");
			names.print();

			// Print out the menu
			System.out.println("\n\nArray Problems");
			System.out.println("--------------");
			System.out.println("1. Load Names From File");
			System.out.println("2. Enter Names From User");
			System.out.println("3. Add Name");
			System.out.println("4. Remove Name");
			System.out.println("5. Search By Letter");
			System.out.println("6. Search By Surname");
			System.out.println("7. Sort");
			System.out.println("0. Quit");
			choice = sc.nextLine().charAt(0); // Receive the user's choice

			// Case the possible choices (and ignore if impossible choice).
			switch (choice) {
				case '1':
					loadFromFile();
					break;
				case '2':
					enterFromUser();
					break;
				case '3':
					addName();
					break;
				case '4':
					removeName();
					break;
				case '5':
					letterSearch();
					break;
				case '6':
					surnameSearch();
					break;
				case '7':
					names.sort();
					break;
			}
		} while (choice != '0'); // exit when 0
	}
}
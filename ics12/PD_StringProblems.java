//StringProblems
//Dhrumil Patel
//ICS4U1

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PD_StringProblems {
    static Scanner sc; // scanner object

    /**
     * Takes a string from the user and outputs if it's a palindrome
     */
    private static void palindromeDriver() {
        System.out.println("Enter a string: ");
        String input = sc.nextLine(); // Get user input
        if (palindrome(input)) // If the string is a palindrome, input as such
            System.out.println("Your string is a palindrome!");
        else // Otherwise, print it is not a palindrome.
            System.out.println("Your string is not a palindrome.");
        sc.nextLine();
        sc.nextLine();
    }

    /**
     * Tests if s is a palindrome
     * 
     * @param s: String to test if it's a palindrome
     * @return: If the string is a palindrone
     */
    private static boolean palindrome(String s) {
        s = s.toUpperCase(); // Make all letters upper case for easier checking
        s = s.replaceAll("[ .,'\"!?]", ""); // Remove all spaces and punctuation using a RegEx search.
        char[] chars = s.toCharArray(); // Turn the string into a character array for easy accessing.
        for (int i = 0; i < s.length() / 2; i++) { // Loop through half of the string
            if (chars[i] != chars[s.length() - i - 1]) // If the current leftmost and the rightmost are not equal, we
                                                       // know it is not a palindrome
                return false; // Return that it is not a palindrome
        }
        return true; // If the whole string was checked and it didn't already return false, then we
                     // can safely return that it is a palindrome (true)
    }

    /**
     * Prompts a user from the string and implements a Caesar cipher
     * 
     * A caesar cipher shifts each letter by a constant shift value, which wraps
     * around from Z -> A
     */
    private static void shiftcodeDriver() {
        System.out.println("Enter a string: ");
        String input = sc.nextLine(); // Get user input string
        System.out.println("Enter a shift value: ");
        int shift = sc.nextInt(); // Get user shift value
        System.out.println("Your string shifted by " + shift + " is: " + shiftcode(input, shift)); // Shift the string
                                                                                                   // and print the
                                                                                                   // result
        sc.nextLine();
        sc.nextLine();
    }

    /**
     * Shifts a given string by a constant amount by adding the shift value to the
     * ascii values of the string
     * 
     * @param plaintext: The plaintext to shift
     * @param shift:     The constant value to shift by
     * 
     * @return The shifted string
     */
    private static String shiftcode(String plaintext, int shift) {
        String output = ""; // Make an empty output string
        for (char c : plaintext.toCharArray()) {
            if (c >= 65 && c <= 90) { // If the character is an upper case letter:
                c -= 'A'; // Subtract the ASCII value of A to get the letter number
                c += shift; // Add the shift value
                c %= 26; // Modulo it by 26 to make sure we don't go over Z.
                c += 'A'; // Add back the ASCII value of A to get the new character.
            } else if (c >= 97 && c <= 122) { // If the character is a lower case letter:
                c -= 'a'; // Subtract the ASCII value of a to get the letter number
                c += shift; // Add the shift value
                c %= 26; // Modulo it by 26 to make sure we don't go over z.
                c += 'a'; // Add back the ASCII value of a to get the new character.
            }
            output += c; // Add the character to the output string
        }
        return output; // Return the output string
    }

    /**
     * Driver method that prompts the user for a string and scrambles it
     */
    private static void cryptocodeDriver() {
        System.out.println("Enter a string: ");
        String input = sc.nextLine(); // Get user input
        System.out.println("Your scrambled string is: " + cryptocode(input)); // Scramble and print string
        sc.nextLine();
        sc.nextLine();
    }

    // This method accepts a string and returns a scrambled string
    /**
     * Accepts a string and replaces each letter with a scrambled letter
     * 
     * @param plaintext: The plaintext to adjust
     * @return: The new adjusted string
     */
    private static String cryptocode(String plaintext) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYX"; // The alphabet
        ArrayList<Character> alphabetChars = new ArrayList<Character>(); // Make a list for all the characters in the
                                                                         // alphabet
        for (char c : alphabet.toCharArray()) { // Loop through the alphabet
            alphabetChars.add(c); // Add the character to the alphabet list
        }
        Collections.shuffle(alphabetChars); // We can now shuffle this list to shuffle all the characters
        alphabet = ""; // Clear the alphabet string
        for (Character c : alphabetChars) { // Loop through our shuffled characters
            alphabet += c; // Add the character to our new alphabet
        }
        System.out.println("Using alphabet: " + alphabet); // Print the alphabet we are now using
        String output = ""; // Make an empty output string
        for (char c : plaintext.toCharArray()) { // Loop through the characters in our input
            if (c >= 65 && c <= 90) { // If the character is an upper case letter
                c -= 'A'; // Subtract the ASCII value of A to get the letter number
                c = alphabet.charAt(c); // Index the alphabet string to get the new character
            } else if (c >= 97 && c <= 122) { // If the character is a lower case letter
                c -= 'a'; // Subtract the ASCII value of a to get the letter number
                c = alphabet.charAt(c); // Index the alphabet string to get the new character
                c += 32; // Subtract 32 to turn the upper case letter into a lower case letter
            }
            output += c; // Add the character to the output string
        }
        return output; // Return the output string
    }

    /**
     * Driver method that accepts a file name from the user and decodes a secret
     * message as encdoed in a file
     */
    private static void secretcodeDriver() {
        System.out.println("Enter the filename of the secret file: ");
        String filename = sc.nextLine(); // Get file name from user
        System.out.println("The secret code is: " + secretcode(filename)); // Decode message and print to the user
        sc.nextLine();
        sc.nextLine();
    }

    /**
     * Grab secret code from a file
     * 
     * @param filename: The path of the file to grab
     * @return The secret code s a string
     */
    private static String secretcode(String filename) {
        try { // We have to "try" this because reading the file can fail.
            File text = new File(filename); // Open the file
            Scanner fileScanner = new Scanner(text); // Create a scanner for the file
            String key = fileScanner.nextLine(); // Get the key phrase as the first line of the file
            String output = ""; // Create an empty output string
            while (fileScanner.hasNextInt()) { // Loop through the rest of the file (only integers)
                int index = fileScanner.nextInt(); // Get the next integer, this our index
                output += key.charAt(index); // Index the key phrase using the integer and add that to the output string
            }
            fileScanner.close(); // Close the file scanner, resources are important y'know
            return output; // Return the output string
        } catch (FileNotFoundException e) { // If the file reading failed, return an error message to the user.
            return "ERROR! Does the file exist?"; // The error message.
        }
    }

    public static void main(String[] args) {
        sc = new Scanner(System.in); // Create the scanner object from the input stream
        char choice;
        do {
            // Print out the menu
            System.out.println("\n\n\nString Problems");
            System.out.println("--------------");
            System.out.println("1. Palindrome Checker");
            System.out.println("2. Shift Code Creator");
            System.out.println("3. Crypto Code Creator");
            System.out.println("4. Secret Code Decoder");
            System.out.println("0. Quit");
            choice = sc.nextLine().charAt(0); // Receive the user's choice

            // Case the possible choices (and ignore if impossible choice).
            switch (choice) {
                case '1':
                    palindromeDriver();
                    break;
                case '2':
                    shiftcodeDriver();
                    break;
                case '3':
                    cryptocodeDriver();
                    break;
                case '4':
                    secretcodeDriver();
                    break;
            }
        } while (choice != '0'); // exit when 0
        sc.close();
    } // main method
} // PD_StringProblems class
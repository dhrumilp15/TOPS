//Dhrumil Patel
//June 17, 2020
//ICS4U1
//GUI Assignment

import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

/**
 * String Manipulations but with a GUI
 */
class StringFrame extends JFrame {
	private int shiftindex = 0;

	private JTextField ShiftCode = new JTextField(25);
	private JTextField Palindrome = new JTextField(25);
	private JTextField Encode = new JTextField(25);

	/**
	 * Creates a default String Frame obj
	 * 
	 * Implements a Caesar Cipher
	 * 
	 * Checks for whether a string is a palindrome
	 */
	public StringFrame() {
		// Button to check for palindrome
		JButton palinButton = new JButton("Palindrome?");
		palinButton.addActionListener(new palinButtonListener());

		// control how much you shift by
		JButton shiftbutton = new JButton("Shift");
		shiftbutton.addActionListener(new shiftButtonListener());

		String[] bad = new String[26];
		for (int i = 0; i < 26; i++) {
			bad[i] = (i + "");
		}

		// The shift value
		JComboBox<String[]> shiftindex = new JComboBox(bad);
		shiftindex.addActionListener(new shiftIndexListener());

		// Caesar cipher
		JButton encodebutton = new JButton("Encode");
		encodebutton.addActionListener(new encodeButtonListener());

		// panel setup
		JPanel content = new JPanel();
		content.setLayout(new FlowLayout());

		// Add text fields and buttons to JFrame
		content.add(Palindrome);
		content.add(palinButton);
		content.add(ShiftCode);
		content.add(shiftbutton);
		content.add(shiftindex);
		content.add(Encode);
		content.add(encodebutton);

		pack();
		setSize(475, 175); // sets the window size to 475 x 175 pixels wide & high
		setContentPane(content);
		setTitle("String Problems"); // creates a title for the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // closes the window
		setLocationRelativeTo(null); // places the window in the middle of the screen
	}

	/**
	 * Listener for the palindrome buttom
	 */
	class palinButtonListener implements ActionListener {
		/**
		 * Callback for actions like the button press
		 */
		public void actionPerformed(ActionEvent e) {
			String palinInput = Palindrome.getText(); // read input
			if (palindrome(palinInput) == true) // display method output for palindrome
				Palindrome.setText(palinInput + " is a palindrome");
			else // display method output for not a palindrome
				Palindrome.setText(palinInput + " is not a palindrome");
		}
	}

	/**
	 * Listener for the shift buttom
	 */
	class shiftButtonListener implements ActionListener {
		/**
		 * Callback for actions like the buttom press
		 */
		public void actionPerformed(ActionEvent e) {
			String shiftInput = ShiftCode.getText(); // read input
			ShiftCode.setText(shiftcode(shiftInput, shiftindex)); // display method output
		}
	}

	/**
	 * Listener for the shiftindex
	 */
	class shiftIndexListener implements ActionListener {
		/**
		 * Callback for actions like the buttom press
		 */
		public void actionPerformed(ActionEvent e) {
			JComboBox cb = (JComboBox) e.getSource(); // read selection
			shiftindex = Integer.parseInt((String) cb.getSelectedItem());
		}
	}

	/**
	 * Listener for the encode button
	 */
	class encodeButtonListener implements ActionListener {
		/**
		 * Callback for actions like the buttom press
		 */
		public void actionPerformed(ActionEvent e) {
			String encodeInput = Encode.getText(); // read input
			Encode.setText(cryptocode(encodeInput)); // display method output
		}
	}

	/**
	 * Determines whether a given string is a palindrome. This assumes that there
	 * are no punctuation issues!
	 * 
	 * @param word Given string
	 * @return Whether word is a palindrome
	 */
	public static boolean palindrome(String word) {
		int length;
		length = word.length(); // set length to the length of the word
		word = word.toUpperCase(); // change the string to upper case
		for (int i = 0; i < length / 2; i++) {
			if (word.charAt(i) != word.charAt(length - i - 1)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Caesar Cipher
	 * 
	 * @param phrase The given String to shift
	 * @param shift  How much to shift by
	 * @return The shidted String
	 */
	public static String shiftcode(String phrase, int shift) {
		int length = phrase.length();
		char character = 0;
		String shifted = "";

		// loop to push the letter the prompted shift value
		for (int i = 0; i < length; i++) {
			character = phrase.charAt(i);
			if (character >= 'A' && character <= 'Z') { // function applies only to upper case letters
				character -= 'A'; // Subtract the ascii 'A' value to get the letter number
				character += shift; // Add the shift
				character %= 26; // find the remainder to determine the position of the letter in the alphabet
				character += 'A'; // Add back the ascii 'A' value to get the new character.
			} else if (character >= 'a' && character <= 'z') { // function applies only to lower case letters
				character -= 'a'; // Subtract the ascii 'a' value to get the letter number
				character += shift; // Add the shift
				character %= 26; // find the remainder to determine the position of the letter in the alphabet
				character += 'a'; // Add back the ascii 'a' value to get the new character.
			}
			shifted += (char) character; // return the shifted characters to the new phrase
		}
		return shifted; // return the shifted phrase
	}

	/**
	 * Shuffles the alphabet
	 * 
	 * @param alphabet The alphabet
	 * @return A shuffled alphabet
	 */
	public static char[] shuffle(char[] alphabet) {
		Random rand = new Random(); // create a random object

		// shuffle the alphabet
		for (int i = 0; i < alphabet.length - 1; i++) {
			int n = rand.nextInt(alphabet.length - i) + i; // declare int n that generates a random number in the range
			char temp = alphabet[i]; // declare char temp that is equal to the character at index i of array
			alphabet[i] = alphabet[n]; // make array value at index i equal to the array value at index n
			alphabet[n] = temp; // make temp equal to the array value at index n
		}
		return alphabet; // return the shuffled alphabet code
	}

	/**
	 * Cryptocode
	 * 
	 * @param newWord The plaintext
	 * @return The ciphertext
	 */
	public static String cryptocode(String newWord) {
		// create alphabet array
		char[] alphabet = shuffle(new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
				'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' });

		// declare variables
		String scrambled = "";
		char letter;

		// run through each character in the new word and swap the letters
		for (int i = 0; i < newWord.length(); i++) {
			letter = newWord.charAt(i); // set letter to the character at the given position

			// swap letter according to the new alphabet code - upper cases
			if (letter >= 'A' && letter <= 'Z') // limits to only the upper case letter
				letter = alphabet[letter - 'A'];
			// swap letter according to the new alphabet code - lower cases
			else if (letter >= 'a' && letter <= 'z') // limits to only the lower case letter
				letter = (char) (alphabet[letter - 'a'] + 97 - 65);
			scrambled += letter; // add the letter to the scrambled phrase
		}
		// return the scrambled phrase
		return scrambled;
	}
}

/**
 * Graph class
 */
class GraphFrame extends JFrame {

	String title; // declare instance variables
	private String[] group;
	private double[] value;

	/**
	 * Creates a Graph Frame
	 */
	public GraphFrame(String t, String[] entry, double[] vals) {

		title = t; // set instance variable values
		group = entry;
		value = vals;

		JPanel content = new JPanel(); // create content pane
		content.setLayout(new FlowLayout()); // set layout
		DrawArea graph = new DrawArea(600, 500); // Custom panel to use as graphics output area
		content.add(graph); // add the graph to JPanel

		pack();
		setSize(600, 500); // set window size to 500 x 500 pixels
		setContentPane(content);
		setTitle("Graph"); // creates title for window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // closes the window
		setLocationRelativeTo(null); // places the window in the middle of the screen
	}

	/**
	 * Finds the largest element from the list of values
	 * 
	 * @param values The list of values
	 * @return The largest element
	 */
	public double maximum(double[] values) {
		double largest = values[0]; // assume biggest value is entry 1

		// iterate through array
		for (double value : values) {
			if (largest < value)
				largest = value;
		}
		return largest; // return biggest value
	}

	/**
	 * The DrawArea
	 */
	class DrawArea extends JPanel {
		/**
		 * Creates the draw area given the dimensions
		 * 
		 * @param width  The width of the window
		 * @param height The height of the window
		 */
		public DrawArea(int width, int height) // create a window of a given size
		{
			this.setPreferredSize(new Dimension(width, height));
		}

		/**
		 * To draw to the graphics object
		 * 
		 * @param g The graphics object
		 */
		public void paintComponent(Graphics g) {

			Graphics2D graphics = (Graphics2D) g;

			double max = Math.ceil(maximum(value) / 5) * 5; // set a ceiling value for the graph
			Font graphTitle = new Font("Calibri", Font.BOLD, 25); // create fonts
			Font header = new Font("Calibri", Font.BOLD, 15);
			Font body = new Font("Calibri", Font.PLAIN, 11);

			// Graph Title
			graphics.setColor(Color.black);
			graphics.setFont(graphTitle);
			graphics.drawString(title, (int) (600 / 2 - title.length() * 5), 50);

			// X-axis line
			graphics.setColor(Color.black);
			graphics.fillRect(100, 375, 440, 3);

			// Entry labels
			graphics.setFont(body);
			for (int i = 0; i < 6; i++)
				graphics.drawString(group[i], 125 + i * 70, 390);

			// Y-axis Line
			graphics.fillRect(100, 75, 3, 300);

			// Y-axis scale labels and tick marks
			graphics.setFont(body);
			for (int i = 0; i <= 12; i++) {
				graphics.fillRect(90, 375 - 25 * i, 10, 3);
				graphics.drawString(((int) i * (max / 10)) + "", 57, 380 - 25 * i);
			}

			// Create Bars for each entry
			for (int i = 0; i < 6; i++) {
				Color colour = Color.black;

				// set colour based on entry number
				if (i == 0)
					colour = Color.red;
				else if (i == 1)
					colour = Color.orange;
				else if (i == 2)
					colour = Color.yellow;
				else if (i == 3)
					colour = Color.green;
				else if (i == 4)
					colour = Color.cyan;
				else if (i == 5)
					colour = Color.pink;

				// Create the bar
				graphics.setColor(colour);
				graphics.fillRect(125 + i * 70, (int) Math.round(376 - 5 * value[i] / max * 50) - 1, 30,
						(int) Math.round(5 * value[i] / max * 50));
			}

			// X-axis label
			graphics.setColor(Color.black);
			graphics.setFont(header);
			String head = "Groups";
			graphics.drawString(head, (int) (600 / 2 - head.length() * 5), 425);

			// Y-axis label
			AffineTransform vertical = new AffineTransform();
			vertical.setToRotation(-Math.PI / 2.0);
			graphics.setTransform(vertical); // rotate the text
			graphics.drawString("# of People", -250, 25);

		} // public void paintComponent

	} // Class DrawArea
} // Class GraphFrame

/**
 * Drives the whole operation from cli
 */
class PD_GUI {
	static Scanner sc = new Scanner(System.in);

	/**
	 * String problems
	 */
	public static void stringproblems() {
		StringFrame string = new StringFrame(); // create new StringFrame object
		string.setVisible(true); // make the window visible
	}

	/**
	 * Graph problems
	 */
	public static void graph() {

		// Declare variables
		String title = "";
		String[] entry = new String[6]; // create arrays to store entries
		double[] value = new double[6];

		// Prompt for graph title
		System.out.print("Title of graph: ");
		sc.nextLine();
		title = sc.nextLine();

		// Loop for 6 entries
		for (int i = 0; i < 6; i++) {
			System.out.println("Entry " + (i + 1)); // prompt for name
			System.out.print("Entry name: ");
			if (i != 0) // helps nextLine work properly
				sc.nextLine();
			entry[i] = sc.nextLine(); // store input into array

			System.out.print("Entry value: "); // prompt for value
			value[i] = sc.nextDouble(); // store input into array
			System.out.println();
		}

		// Create new GraphFrame object that accepts title, entry name, and value
		GraphFrame graph = new GraphFrame(title, entry, value);
		graph.setVisible(true); // make the window visible
	}

	// Main method
	public static void main(String[] args) {
		int choice; // declare choice variable

		// Title
		System.out.println("GUI Problems");
		System.out.println("------------");

		// Loop until the user enters 0
		do {
			System.out.println("1 - String Problem Set"); // prompts
			System.out.println("2 - Create Graph");
			System.out.println("0 - Exit Program");
			System.out.println();
			choice = sc.nextInt();

			// Decisions and function calling
			if (choice == 1)
				stringproblems();
			else if (choice == 2)
				graph();

		} while (choice != 0);

		System.out.println("The program has terminated"); // end prompt

	} // main
} // PD_GUI

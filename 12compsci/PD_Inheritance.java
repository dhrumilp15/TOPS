//Inheritance
//Dhrumil Patel
//ICS4U1

import java.util.Scanner;

/**
 * This is an interface that represents a basic Animal.
 */
interface Animal {
	/**
	 * Gets the size of the animal
	 * 
	 * @return: An integer representing the size.
	 */
	public int getSize();

	/**
	 * Gets the average age of the animal
	 * 
	 * @return: An integer representing the average age.
	 */
	public int getAverageAge();

	/**
	 * Gets the colour of the animal
	 * 
	 * @return: A String representing the colour.
	 */
	public String getColour();

	/**
	 * Gets the name of the animal
	 * 
	 * @return: A String representing the name.
	 */
	public String getName();
}

/**
 * Represents a frog and Implements the animal interface
 */
class Frog implements Animal {
	protected int size, age; // Fields that hold the size and age.
	protected String name, colour; // Fields that hold the name and colour.

	/**
	 * Default constructor that creates a Frog with default params
	 */
	public Frog() {
		this("Default"); // Call the one with a parameter.
	}

	/**
	 * A constructor that creates a Frog with a given name
	 */
	public Frog(String name) {
		// Set all fields.
		this.name = name;
		this.size = 4;
		this.age = 5;
		this.colour = "Green";
	}

	/**
	 * Gets the size of the frog
	 * 
	 * @return An integer representing the size of the frog.
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Gets the average age of the frog
	 * 
	 * @return An integer representing the average age of the frog.
	 */
	public int getAverageAge() {
		return age;
	}

	/**
	 * Gets the colour of the frog
	 * 
	 * @return A String representing the colour of the frog.
	 */
	public String getColour() {
		return colour;
	}

	/**
	 * Gets the name of the frog
	 * 
	 * @return A String representing the name of the frog.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Creates the proper string to display information of this frog.
	 * 
	 * @return A String representing the information of this frog.
	 */
	public String toString() {
		return "Adult Frog: " + name + " has a size of " + size + " and average age of " + age + ". Its colour is "
				+ colour;
	}
}

/**
 * Represents a BabyFrog and extens a Frog.
 */
class BabyFrog extends Frog {
	// New private field containing parent frog.
	private String parent;

	/**
	 * Default constructor that creates a BabyFrog with default params
	 */
	public BabyFrog() {
		this("Default", "Default");
	}

	/**
	 * A constructor that creates a Frog with a given name
	 * 
	 * @param name:   A string representing the name of the baby frog.
	 * @param parent: A string representing the parent of the baby frog.
	 */
	public BabyFrog(String name, String parent) {
		super(name); // Call the frog constructor with the name
		// Set the other fields
		this.parent = parent;
		this.size = 2;
		this.age = 1;
	}

	/**
	 * Creates the proper string to display information of this baby frog.
	 * 
	 * @return A String representing the information of this baby frog.
	 */
	public String toString() {
		return "Baby Frog: " + name + " with parent: " + parent + " has a size of " + size + " and average age of "
				+ age + ". Its colour is " + colour;
	}
}

/**
 * Represents a famous dairy product known as cheese.
 */
abstract class Cheese {
	/**
	 * Produces the sounds of someone eating some cheese.
	 */
	public abstract void makeEatingSounds();
}

/**
 * Represents some SwissCheese
 */
class SwissCheese extends Cheese {
	/**
	 * Produces the sounds associated with eating cheese.
	 */
	public void makeEatingSounds() {
		System.out.println("I am eating swiss cheese.");
	}
}

/**
 * Driver class to interact with the Frog, BabyFrog, and Cheese classes
 */
public class PD_Inheritance {
	static Scanner sc;

	/**
	 * A helper function that prints which Animal is bigger
	 * 
	 * @param a The first animal to compare
	 * @param b The second animal to compare
	 */
	private static void compareAnimalSize(Animal a, Animal b) {
		if (a.getSize() > b.getSize()) { // If (a) is bigger than (b)
			System.out.println(a.getName() + " is bigger than " + b.getName() + "!"); // print that
		} else { // else (b) is bigger than (a)
			System.out.println(b.getName() + " is bigger than " + b.getName() + "!"); // print that
		}
	}

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		// Get adult frog name and construct the frog
		System.out.println("Enter the adult frog's name!");
		String name = sc.nextLine();
		Frog frog = new Frog(name);
		System.out.println(frog + "."); // Print frog data
		// Get baby frog name and parent and construct the baby frog
		System.out.println("Enter the baby frog's name!");
		String baby_name = sc.nextLine();
		System.out.println("Enter the baby frog's parent!");
		String parent = sc.nextLine();
		BabyFrog baby = new BabyFrog(baby_name, parent); // Print baby frog data
		System.out.println(baby + ".");
		compareAnimalSize(frog, baby); // Compare the two frogs (adult one should be bigger)
		// Make some swiss cheese and make the eating sounds play
		SwissCheese cheese = new SwissCheese();
		cheese.makeEatingSounds();
	}
}
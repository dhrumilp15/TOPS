//Box
//Dhrumil Patel
//ICS4U1

import java.util.Scanner;

/**
 * Represents a box with a width, height, and length.
 */
class Box {
    double width, height, length; // private fields containing width, height, and length.

    /**
     * Gets a box's width
     * 
     * @return A double representing the box's width
     */
    public double width() {
        return width;
    }

    /**
     * Gets a box's height
     * 
     * @return A double representing the box's height
     */
    public double height() {
        return height;
    }

    /**
     * Gets the box's length
     * 
     * @return A double representing the box's length
     */
    public double length() {
        return length;
    }

    /**
     * Creates a box with specified width, length, and height
     * 
     * @param width:  The width of the box
     * @param height: The height of the box
     * @param length: The length of the box
     */
    public Box(double width, double height, double length) {
        this.width = width; // Set width.
        this.height = height; // Set height.
        this.length = length; // Set length.
    }

    /**
     * Constructs a cube of specified length
     * 
     * @param side: The length of each side
     */
    public Box(double side) {
        this.width = side; // Set width to side length.
        this.height = side; // Set height to side length.
        this.length = side; // Set length to side length.
    }

    /**
     * Creates a copy of an existing box object by storing its fields as a box
     * object
     * 
     * @param oldBox: Existing box object
     */
    public Box(Box oldBox) {
        this.width = oldBox.width(); // Set width to other width.
        this.height = oldBox.height(); // Set height to other height.
        this.length = oldBox.length(); // Set length to other height.
    }

    /**
     * Dilates an existing box object by a factor of 1.25
     * 
     * @param oldBox: An existing box to be dilated
     */
    public void biggerBox(Box oldBox) {
        this.width = 1.25 * oldBox.width(); // Set width to 1.25 times the other width.
        this.height = 1.25 * oldBox.height(); // Set height to 1.25 times the other height.
        this.length = 1.25 * oldBox.length(); // Set length to 1.25 times the other length.
    }

    /**
     * Dilates an existing box object by a factor of 0.75
     * 
     * @param oldBox: An existing box to be dilated
     */
    public void smallerBox(Box oldBox) {
        this.width = 0.75 * oldBox.width(); // Set width to 0.75 times the other width.
        this.height = 0.75 * oldBox.height(); // Set height to 0.75 times the other height.
        this.length = 0.75 * oldBox.length(); // Set length to 0.75 times the other length.
    }

    // This method returns if the current box can "fit" inside another box.
    /**
     * Tests if a specified box can fit within the current box
     * 
     * @param outsideBox: The box to test its ability to be placed within the
     *                    current box
     * @return true if the specified box can fit within the current box, false
     *         otherwise
     */
    public boolean nests(Box outsideBox) {
        // A box fits within another box if and only if the dimensions of the other box
        // are less than or equal to the dimensions of the current box
        return this.width <= outsideBox.width()
                && this.height <= outsideBox.height() & this.length <= outsideBox.length();
    }

    /**
     * Calculates the volume of the box
     * 
     * @return A double representing the volume of a box
     */
    public double volume() {
        return width * height * length; // V = W*H*L.
    }

    /**
     * Calculates the surface area of the box
     * 
     * @return A double representing the surface area of the box
     */
    public double area() {
        return 2 * faceArea() + 2 * topArea() + 2 * sideArea(); // SA = 2*FA+2*TA+2*SiA.
    }

    /**
     * Calculates the area of the front-facing face
     * 
     * @return A double representing the area
     */
    private double faceArea() {
        return width * height; // FA = W*H.
    }

    /**
     * Calculates the area of the top face
     * 
     * @return A double representing the area
     */
    private double topArea() {
        return length * height; // TA = L*H.
    }

    /**
     * Calculates the area of the side face
     * 
     * @return A double representing the area
     */
    private double sideArea() {
        return width * length; // SiA = W*L.
    }
}

/**
 * Driver class that tests functionality of the Box class
 */
public class PD_Box {
    static Scanner sc; // static Scanner object.

    public static void main(String[] args) {
        sc = new Scanner(System.in); // Instantiate the scanner for System.in.

        double width, height, length; // Variables for user input.

        System.out.print("Enter box width: "); // Get width from user.
        width = sc.nextDouble();
        System.out.print("Enter box height: "); // Get height from user.
        height = sc.nextDouble();
        System.out.print("Enter box length: "); // Get length from user.
        length = sc.nextDouble();

        Box box = new Box(width, height, length); // Create the new box object.

        System.out.printf("The volume of the box is %.2f.\n", box.volume()); // Print the volume of the box.
        System.out.printf("The surface area of the box is %.2f.\n", box.area()); // Print the surface area of the box.

        Box bigger = new Box(0); // Create a new bigger box.
        bigger.biggerBox(box); // Set the dimensions to be 1.25 times bigger than the original box.

        System.out.printf("New box with 25%% larger dimensions: width: %.2f, height: %.2f, length %.2f", bigger.width(),
                bigger.height(), bigger.length()); // Print dimensions of new bigger box.
        System.out.println(".");

        if (box.nests(bigger)) // If the original box fits in the bigger box (which it should)
            System.out.println("Your box fits in the bigger box."); // Print that result.
        else // Otherwise...
            System.out.println("Your box does not fit in the bigger box."); // Print it does not (should not happen).

        Box smaller = new Box(0); // Create a new smaller box.
        smaller.smallerBox(box); // Set the dimensions to be 0.75 times smaller than the original box.

        System.out.printf("New box with 25%% smaller dimensions: width: %.2f, height: %.2f, length %.2f.\n",
                smaller.width(), smaller.height(), smaller.length()); // Print dimensions of the new smaller box.

        if (box.nests(smaller)) // If the original box fits in the smaller box (which it should not)
            System.out.println("Your box fits in the smaller box."); // Print that result.
        else // Otherwise...
            System.out.println("Your box does not fit in the smaller box."); // Print it does not (should happen).
    }
}
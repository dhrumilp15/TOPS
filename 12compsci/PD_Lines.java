
//Line Class
//Dhrumil Patel
//ICS4U1
import java.util.Scanner;

/**
 * Represents a point.
 */
class Point {
    private double x, y; // X and Y fields

    /**
     * Creates a point with the specified x and y coordinates
     * 
     * @param x The x coordinate
     * @param y The y coordinate
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Gets the point's x coordinate
     * 
     * @return The x coordinate
     */
    public double getX() {
        return x;
    }

    /**
     * Gets the point's y coordinate
     * 
     * @return The y coordinate
     */
    public double getY() {
        return y;
    }

    /**
     * Overrides default toString method
     * 
     * @return A nicely formmated ordered pair
     */
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

/**
 * Represents a line in standard form (Ax + By + C = 0)
 */
class Line {
    private int A = 0, B = 0, C = 0; // A, B, and C fields

    /**
     * Creates a line with the given coefficients and constant.
     * 
     * @param a The coefficient of the x term.
     * @param b The coefficient of the y term.
     * @param c The constant.
     */
    public Line(int a, int b, int c) {
        A = a;
        B = b;
        C = c;
    }

    /**
     * Gets the line's x coefficient
     * 
     * @return The line's x coefficient
     */
    public int getA() {
        return A;
    }

    /**
     * Gets the line's y coefficient
     * 
     * @return The line's y coefficient
     */
    public int getB() {
        return B;
    }

    /**
     * Gets the line's constant.
     * 
     * @return The line's constant.
     */
    public int getC() {
        return C;
    }

    /**
     * A helper method for getting the proper sign (+/-) for the coefficient in a
     * string representation.
     * 
     * @param co The given coefficient
     * @return A string with the appropriate sign
     */
    private String getCoef(int co) {
        String o = ""; // Initialize empty output string
        if (co > 0) { // If the number is greater than zero add a plus to output
            o += " + ";
        } else { // Otherwise since it cannot be zero add a minus to output
            o += " - ";
        }
        if (Math.abs(co) != 1) { // If it's also not 1 or -1 we add the actual number to the string
            o += Math.abs(co);
        }
        return o; // Return the output string
    }

    /**
     * Overrides the default toString method and returns a properly formatted string
     * 
     * @return A properly formatted string representation of the line.
     */
    public String toString() {
        String out = ""; // Initialize empty output string
        // First we check if the coef is not zero
        if (A != 0) {
            if (out == "") { // We check if there already has been strings pushed to the output string
                if (Math.abs(A) != 1) { // We add the coef
                    out += A;
                } else if (A == -1) { // Making sure to check if it's minus
                    out += "-";
                }
            } else { // Otherwise we use the helper method to generate a proper coef
                out += getCoef(A);
            }
            out += "x"; // Add the "x"
        }
        // Repeat all checks for B
        if (B != 0) {
            if (out == "") {
                if (Math.abs(B) != 1) {
                    out += B;
                } else if (B == -1) {
                    out += "-";
                }
            } else {
                out += getCoef(B);
            }
            out += "y";
        }
        // And again all checks for C
        if (C != 0) {
            if (out == "") {
                out += C;
            } else {
                out += getCoef(C); // The generation is a little different with C because it is a single number and
                                   // not a coef
                if (Math.abs(C) == 1)
                    out += "1";
            }
        }
        out += " = 0"; // Add the final "=0"
        return out; // return the output
    }

    /**
     * Finds the x-intercept of the line
     * 
     * @return The x-intercept of the line
     */
    public double xint() {
        return (double) -C / A;
    }

    /**
     * Finds the slope of the line
     * 
     * @return The slope of the line
     */
    public double slope() {
        return (double) -A / B;
    }

    /**
     * Finds the y-intercept of the line
     * 
     * @return The y-intercept of the line
     */
    public double yint() {
        return (double) -C / B;
    }

    /**
     * Checks if the line is vertical
     * 
     * @return True if the line is vertical
     */
    public boolean isVertical() {
        return B == 0;
    }

    /**
     * Checks if the line is vertical
     * 
     * @return True if the line is horizontal
     */
    public boolean isHorizontal() {
        return A == 0;
    }

    /**
     * Finds the intersection of two lines (assuming they are not parallel)
     * 
     * @param other The other line to which this line object may intersect
     * @return The point at which the lines intersect
     */
    public Point intersect(Line other) {
        double ix, iy; // Values holding X and Y
        if (isVertical()) { // If one line is vertical
            ix = xint(); // Find X value of that line and plug it into the other to find Y
            iy = other.slope() * ix + other.yint();
        } else if (other.isVertical()) { // if the other is vertical
            ix = other.xint(); // Find X value and plug into local line to find Y
            iy = slope() * ix + yint();
        } else { // Otherwise use the intersection formula to find their intersections
            ix = (other.yint() - yint()) / (slope() - other.slope());
            iy = other.slope() * ix + other.yint();
        }
        return new Point(ix, iy); // Return new point object holding the X and Y
    }

    /**
     * Custom readLine method that reads input from the user until they input a
     * valid line equation.
     * 
     * @param sc A scanner object
     */
    public void readLine(Scanner sc) {
        boolean found = false; // Found flag
        while (!found) { // Keep looping until we found a valid line
            try { // Try catch block as cheap way to test if line is valid
                String testline = sc.nextLine(); // Get input from user
                testline = testline.replaceAll("\\s+", ""); // Remove all whitespace
                String[] xs = testline.split("x"); // Split the string by the x component
                String x = "0"; // Default value of 0
                if (xs.length > 1) { // If the string actually has an X
                    if (xs[0].equals("")) { // Check if it's empty
                        x = "1"; // Set it to 1 if so
                    } else { // Otherwise set it to the value in the string
                        x = xs[0];
                    }
                    // Update input line
                    testline = xs[1];
                }
                // Do the same process for the Y component
                String[] ys = testline.split("y");
                String y = "0";
                if (ys.length > 1) {
                    if (ys[0].equals("")) {
                        y = "1";
                    } else {
                        y = ys[0];
                    }
                    testline = ys[1];
                }
                // And then again the same for the individual component
                String[] zs = testline.split("=");
                String z = "0";
                if (zs.length > 1) {
                    if (!(zs[0].equals(""))) {
                        z = zs[0]; // A little different here because we cannot assume it's 1, we assume its 0
                    }
                    testline = zs[1];
                }
                if (!testline.equals("0")) { // If the equals to is not 0 then we say this is not valid
                    throw new Exception();
                }
                // We parse the A, B, and C into ints. If an exception occurs we fail and try
                // again
                if (x.equals("+"))
                    x = "+1";
                if (x.equals("-"))
                    x = "-1";
                A = Integer.parseInt(x);
                if (y.equals("+"))
                    y = "+1";
                if (y.equals("-"))
                    y = "-1";
                B = Integer.parseInt(y);
                C = Integer.parseInt(z);
                found = true; // Everything passed so we say it's valid
            } catch (Exception e) { // If it hit an exception there was not a valid line so we prompt the user
                System.out.print("Please enter a valid line: ");
            }
        }
    }
}

/**
 * Driver class that tests the line and point classes
 */
public class PD_Lines {
    static Scanner sc; // Scanner object

    public static void main(String[] args) {
        sc = new Scanner(System.in); // Init scanner
        boolean redo = true; // Redo flag
        while (redo) { // While we still want to redo
            // Read in a line from the user
            System.out.println("(line 1) | Enter a line equation (Ax + By + C = 0): ");
            Line l = new Line(0, 0, 0);
            l.readLine(sc);
            // Print the line back formatted
            System.out.println("(line 1) | The line is: " + l);
            if (l.isVertical()) { // Check if its vertical
                System.out.println("(line 1) | The line is vertical and has infinite slope.");
            } else { // Otherwise print slope and Y intercept
                System.out.println(
                        "(line 1) | The slope of the line is " + l.slope() + " and has a Y intercept at " + l.yint());
            }
            if (l.isHorizontal()) { // Check if its horizontal
                System.out.println("(line 1) | The line is horizontal and has no X intercept.");
            } else { // Otherwise print the x intercept
                System.out.println("(line 1) | The X intercept of the line is " + l.xint());
            }
            System.out.println("------------------------------------------------");
            // Take in a second line from the user
            System.out.println("(line 2) | Enter another line equation (Ax + By + C = 0): ");
            Line l2 = new Line(0, 0, 0);
            l2.readLine(sc);
            // Print the line back formatted
            System.out.println("(line 2) | The line is: " + l2);
            if (l2.isVertical()) { // Check if its vertical
                System.out.println("(line 2) | The line is vertical and has infinite slope.");
            } else { // Otherwise print the slope and y intercept
                System.out.println(
                        "(line 2) | The slope of the line is " + l2.slope() + " and has a Y intercept at " + l2.yint());
            }
            if (l2.isHorizontal()) { // Check if its horizontal
                System.out.println("(line 2) | The line is horizontal and has no X intercept.");
            } else { // Otherwise print the x intercept
                System.out.println("(line 2) | The X intercept of the line is " + l2.xint());
            }
            if (l.slope() == l2.slope()) { // Check if the slopes are equal meaning no intersect
                System.out.println("There is no intersection between line 1 and line 2.");
            } else { // Otherwise print the intersection between the two lines
                System.out.println("The intersection between the lines is: " + l.intersect(l2));
            }
            // Check if the user wants to quit the loop
            System.out.println("\nWould you like to stop the loop? 0 == exit");
            int n = sc.nextInt();
            if (n == 0)
                redo = false; // If they do, set the flag
            System.out.println("\n");
        }
    }
}
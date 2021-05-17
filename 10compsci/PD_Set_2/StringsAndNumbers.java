// The "StringsAndNumbers" class.
import java.awt.*;
import hsa.Console;

public class StringsAndNumbers
{
    static Console c;           // The output console
    
    public static void main (String[] args)
    {
	c = new Console ();
	
	c.println("An example of an integer is " + 4);
	c.println("An example of a real number is " + 7.25);
	c.print("Adding an integer to a real number, such as 4 + 7.25");
	c.print(" gives a real result: ");
	c.print(4+7.25);
	c.println();
	c.print("The result is ");
	c.println(765.5678,0,2);
	
	//Exercise 2F
	c.println (17 - 7 + 33 * 2);
	c.println (20 * 4 - 9 * 7);
	c.println ("123456789012345");
	c.println (34567, 3);
	c.println (123.456, 2);
	c.println (54.375, 8, 0);
	c.println (54.375, 0, 8);
    } // main method
} // StringsAndNumbers class

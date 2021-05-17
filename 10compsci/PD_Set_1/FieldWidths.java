// The "FieldWidths" class.
import java.awt.*;
/*
Dhrumil Patel
September 11, 2018
ICS2O3
FieldWidths
Demonstrates the use of fieldwidths in print and println statements.*/
import hsa.Console;

public class FieldWidths
{
    static Console c;           // The output console
    
    public static void main (String[] args)
    {
	c = new Console ();
	
	c.print("1234561890");
	c.println("123456789012345");
	c.print("Hello", 6);
	c.print("Hello", 6);
	c.print("Hello", 6);
	c.print("Hello");
	c.println();
	c.println();
	c. println ("1234567890123456789012345678901234567890");
	c.print("Hello", 12);
	c.print("Hello", 12);
	c.print("Hello");
	c.println ();
	c.println ();
	c.println ("12345678901234567890");
	c.print ("", 5);

	c.println ("COMPUTER STUDIES");
	c.println ();
	c.print ("",5);
	    c.print ("Theory", 15);
	c.println ("Practical");
    } // main method
} // FieldWidths class

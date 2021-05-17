/*Dhrumil Patel
September 13, 2018
ICS2O3
/*
Dhrumil Patel  
September 13, 2018
ICS2O3
IntegersInFields
Outputs integers
*/
Displays numbers in fieldwidths*/
import java.awt.*;
import hsa.Console;

public class IntegersInFields
{
    static Console c;           // The output console
    
    public static void main (String[] args)
    {
	c = new Console ();
	
	c.println("12345678901234567890");
	c.println("35", 7);
	c.println("999", 5);
	c.println();
	c.println("12345678901234567890");
	c.println(35, 7);
	c.println(999, 7);
	c.println("Strings are left-justified, but numbers are right-justified in a field.");
    } // main method
} // IntegersInFields class

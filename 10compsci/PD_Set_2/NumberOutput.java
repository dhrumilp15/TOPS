/*
Dhrumil Patel  
September 13, 2018
ICS2O3
NumberOutput
Outputs integers and integers in strings
*/
import java.awt.*;
import hsa.Console;

public class NumberOutput
{
    static Console c;           // The output console

    public static void main (String[] args)
    {
	c = new Console ();

	c.println (7);
	c.println ("7");

	c.println (489);
	c.println ("0");
	c.println (-44);
	c.println ("4+3");
	c.println ("38-9+25");
	c.println (38 - 9 + 25);
	
	c.println (18 - 7);
	c.println (12*12);
	c.println ((4 + 5) * (13 - 9));
	c.println (7 - 4 * 3 + 1);
	c.println (24 / 6);
	c.println ((32 - 6 * 2)/5);
    } // main method
} // NumberOutput class

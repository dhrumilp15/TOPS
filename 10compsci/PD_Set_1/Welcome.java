/*
Dhrumil Patel
September 11, 2018
ICS2O3
Welcome
Prints a nice welcome message for java programming
*/
import java.awt.*;
import hsa.Console;

public class Welcome
{
    static Console c;           // The output console
    
    public static void main (String[] args)
    {
	c = new Console ();
	
	c.println("Welcone to Java.");
	c.println("Programming is easy");
    } // main method
} // Welcome class

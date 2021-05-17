/*
Dhrumil Patel
September 11, 2018
ICS2O3
Shopping
Print/println statements to space out sentence fragments about shopping
*/
import java.awt.*;
import hsa.Console;

public class Shopping
{
    static Console c;           // The output console

    public static void main (String[] args)
    {
	c = new Console ();
	c.print("I am going ");
	c.println("to the") ;
	c.println("shopping mall.");
	c.println();
	c.println("There is no bus");
	c.println("may I have a lift");
    } // main method
} // Shopping class

/*
Dhrumil Patel
September 11, 2018
ICS2O3
PrintOutput
Demonstrates the use of print/println statements, particularly with spacing
*/
//Patel, Dhrumil
//2018-09-11
import java.awt.*;
import hsa.Console;

public class PrintOutput
{
    static Console c;           // The output console
    
    public static void main (String[] args)
    {
	c = new Console ();
	
	c.print ("12345678901234567890");
	c.print ("Hello");
	c.print ("How are you");
	c.println("XXXXXXXXXXXXXXX");
    } // main method
} // PrintOutput class

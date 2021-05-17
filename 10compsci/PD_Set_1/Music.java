/*
Dhrumil Patel
September 11, 2018
ICS2O3
Music
Demonstrates the effect of spaces and adding newlines in print/println statements*/
import java.awt.*;
import hsa.Console;

public class Music
{
    static Console c;           // The output console
    
    public static void main (String[] args)
    {
	c = new Console ();
	
	c.println("123456789012345");
	c.println("  Rock and Roll");
	c.println("      Metal");
	c.println();
	c.print("    The Blues");
    } // main method
} // Music class

/*
Dhrumil Patel
September 11, 2018
ICS2O3
NameAndAddress
Displays author's name and address centered in the output window*/
import java.awt.*;
import hsa.Console;

public class NameAndAddress
{
    static Console c;           // The output console
    
    public static void main (String[] args)
    {
	c = new Console ();
	
	c.println("\t\t\t\t\tNAME AND ADDRESS");
	c.println();
	c.println("\t\t\t\t\tDhrumil Patel");
	c.println("\t\t\t\t\t1050 Markham Rd");
	c.println("\t\t\t\t\tScarborough");
	c.println("\t\t\t\t\tOntario");
    } // main method
} // NameAndAddress class

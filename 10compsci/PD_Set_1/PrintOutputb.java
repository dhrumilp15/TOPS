/*
Dhrumil Patel
September 11, 2018
ICS2O3
PrintOutputb
Demonstrates the use of string concatenation
*/
// The "PrintOutputb" class.
import java.awt.*;
import hsa.Console;

public class PrintOutputb
{
    static Console c;           // The output console
    
    public static void main (String[] args)
    {
	c = new Console ();
	
	c.print ("Hello. " + "How are you");
    } // main method
} // PrintOutputb class

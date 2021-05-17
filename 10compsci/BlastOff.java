/*
Dhrumil Patel
Nov 2018
ICS203
BlastOff
blastoff loops
*/

import java.awt.*;
import hsa.Console;

public class BlastOff
{
    static Console c;

    //*******************************dowhile*********************************


    public static void dowhile ()
    {
	Font f1 = new Font ("Arial", Font.PLAIN, 50);
	c.setFont (f1);
	int iter = 11;
	do
	{
	    iter--;
	    c.drawString (Integer.toString (iter), 120, 120);
	    try
	    {
		Thread.sleep (25);
	    }
	    catch (InterruptedException ie)
	    {
		ie.printStackTrace ();
	    }
	    c.clear ();
	}
	while (iter != 0);
	c.drawString ("BLAST OFF", 120, 120);
    }


    //***********************************Menu Program Here*************************
    public static void main (String[] args)
    {

	c = new Console ();

	//variable delclaration for user's choice
	int choice;

	do
	{
	    //Promting for choice

	    c.println ();
	    c.println ("Choose from the following menu\n");
	    c.println ("Enter 1, 2, 3, 4");
	    c.println ("1 - Wassup program");
	    c.println ("2 - ");
	    c.println ("3 - ");
	    c.println ("4 - ");


	    c.println ();
	    c.println ("Enter 0 to exit");
	    choice = c.readInt ();

	    if (choice == 1)
	    {
		dowhile ();
	    }
	    else
		if (choice == 2)
		{
		    c.clear ();
		    c.println ("Program 2");
		}
		else
		    if (choice == 3)
		    {

			c.println ("Program 3");
		    }
		    else
			if (choice == 4)
			{
			    c.println ("Program 4");
			}
	    c.print ("Press enter to continue");
	    c.getChar ();

	    c.clear ();
	    //This will loop until user enters 0
	}

	while (choice != 0);
	c.println ("The program has terminated");

    } // main method
} // Menu Demo class



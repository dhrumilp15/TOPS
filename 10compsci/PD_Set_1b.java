/*
Dhrumil Patel
Sep 2018
ICS203
Set1b
Set 1 Programs*/

import java.awt.*;
import hsa.Console;

public class PD_Set_1b
{
    static Console c;

//*******************************PrintName*********************************


    public static void PrintName ()  
    {
	c.clear();
	c.println("My name is Dhrumil Patel");
	c.println("I'm in grade 10");
	c.println("I go to Marc Garneau C.I");
	c.println("I live in Ajax, Ontario");
    }

//*******************************PrintOutput*********************************


    public static void PrintOutput ()  
    {
	c.clear ();
	c.print ("12345678901234567890");
	c.print ("Hello");
	c.println ("How are you");
    }

//*******************************Music*********************************


    public static void Music ()  
    {
	c.clear ();
	c.println("123456789012345");
	c.println("  Rock and Roll");
	c.println("      Metal");
	c.println();
	c.println("    The Blues");
    }

//*******************************Shopping*********************************


    public static void Shopping ()  
    {
	c.clear ();
	c.print("I am going ");
	c.println("to the") ;
	c.println("shopping mall.");
	c.println();
	c.println("There is no bus");
	c.println("may I have a lift");
    }

//*******************************PrintOutputb*********************************


    public static void PrintOutputb ()  
    {
	c.clear ();
	c.println ("Hello. " + "How are you");
    }

//*******************************NameAndAddress*********************************

    public static void NameAndAddress ()  
    {
	c.clear ();
	c.println("\t\t\t\t\tNAME AND ADDRESS");
	c.println();
	c.println("\t\t\t\t\tDhrumil Patel");
	c.println("\t\t\t\t\t1050 Markham Rd");
	c.println("\t\t\t\t\tScarborough");
	c.println("\t\t\t\t\tOntario");
    }

//*******************************VirusWarning*********************************

    public static void VirusWarning ()  
    {
	c.clear ();
	c.println("\t" + "WARNING" + "\n");
	c.println("\tPossible virus detected \n\tReboot and run antivirus software");
    }

//*******************************FieldWidths*********************************

    public static void FieldWidths ()  
    {
	c.clear ();    
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
	    c.println ("1 - PrintName");
	    c.println ("2 - PrintOutput");
	    c.println ("3 - Music");
	    c.println ("4 - Shopping");
	    c.println ("5 - PrintOutputb");
	    c.println ("6 - NameAndAddress");
	    c.println ("7 - VirusWarning");
	    c.println ("8 - FieldWidths");


	    c.println ();
	    c.println ("Enter 0 to exit");
	    choice = c.readInt ();

	    if (choice == 1)
	    {
		PrintName();
	    }
	    else
		if (choice == 2)
		{
		    c.clear ();
		    PrintOutput();
		}
		else
		    if (choice == 3)
		    {
			Music();
		    }
		    else
			if (choice == 4)
			{
			    Shopping();
			}
			else
			    if (choice == 5)
			    {
				PrintOutputb();
			    }
			    else
				if (choice == 6)
				{
				    NameAndAddress();
				}
				else
				    if (choice == 7)
				    {
					VirusWarning();
				    }
				    else
					if (choice == 8)
					{
					    FieldWidths();
					}


	c.print ("Press enter to continue");
	c.getChar ();
	
	c.clear ();
	    //This will loop until user enters 0
	}

	while (choice != 0);
	c.println ("The program has terminated");
	
    } // main method
} // Menu Demo 

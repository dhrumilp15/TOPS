/*
Dhrumil Patel
Sep 2018
ICS203
PD_Set_4
Set 4 Programs in an easily accessible format
*/

import java.awt.*;
import hsa.Console;

public class PD_Set_4
{
    static Console c;

    //*******************************MakeLabels*********************************

    public static void MakeLabels ()
    {
    	c.clear (); // clear the screen
    	c.println ("Type in your name and subject, hitting the return key after each");

    	String name = c.readLine ();
    	String subject = c.readLine ();

    	c.println ();
    	c.println ("****************");
    	c.println ("Name: " + name);
    	c.println ("Subject: " + subject);
    	c.println ("****************");
    }

    //*******************************InOutWord*********************************

    public static void InOutWord ()
    {
    	c.clear (); // clear the screen
    	c.println ("Type in any word and then the return key");

    	String word = c.readString ();

    	c.println ();
    	c.println ("Inputted word is: " + word);
    }

    //*******************************InputRect*********************************

    public static void InputRect ()
    {
    	c.clear (); // clear the screen
    	int length, breadth;
    	c.println ("RECTANGLE PROGRAM");
    	c.println ("Type in the length of the rectangle and press <Enter>: ");
    	length = c.readInt ();
    	c.println ("Type in the breadth of the rectangle and press <Enter>: ");
    	breadth = c.readInt ();
    	c.setColor (Color.green);
    	c.fillRect (100, 100, length, breadth);
    }


    //*******************************VaryField*********************************

    public static void VaryField ()
    {
    	c.clear (); // clear the screen
    	c.println ("Type in a real number here: ");
    	int fw = c.readInt ();
    	c.println (999, fw);
    }


    //*******************************InputReals*********************************

    public static void InputReals ()
    {
	c.clear (); // clear the screen
	double num1, num2;
	num1 = c.readDouble ();
	num2 = c.readDouble ();
	c.println ();
	c.print ("The first real number entered was ");
	c.println (num1, 0, 3);
	c.println ("The second real number entered was " + num2);
	c.print ("The cost is $");
	c.println (123.7567, 0, 2);
    }


    //*******************************PersonalDetails*********************************

    public static void PersonalDetails ()
    {
    	c.clear (); // clear the screen

    	c.print ("What's your name: ");
    	String name = c.readLine ();

      c.print ("What's the initial of your class? ");
      char classLetter = c.readChar();

    	c.print ("What's your phone number(without dashes): ");
    	int number = c.readInt ();

    	c.print ("Which year were you born in: ");
    	int year = c.readInt ();

    	c.print ("How tall are you (in meters): ");
    	double height = c.readDouble ();

    	c.clear ();
    	c.println ("PERSONAL DETAILS");
    	c.println ();

    	c.println ("NAME: " + name);
      c.println ("Grade 10" + classLetter);
    	c.println ("YEAR OF BIRTH: " + year);
    	c.println ("HEIGHT(m): " + height);
    	c.println ("TEL. NUMBER: " + number);
    }


    //*******************************ColoredCircles*********************************

    public static void ColoredCircles ()
    {
    	c.clear (); // clear the screen
    	int di1, di2;
    	c.println ("This program will draw a red and blue circle");
    	c.println ("Diameter of red circle(int between 300 and 500): ");
    	di1 = c.readInt ();
    	c.println ("Diameter of blue circle(int between 50 and 150): ");
    	di2 = c.readInt ();
    	int red, green, blue;
    	c.println ("Red: ");
    	red = c.readInt ();
    	c.println ("Green: ");
    	green = c.readInt ();
    	c.println ("Blue: ");
    	blue = c.readInt ();
    	Color col = new Color (red, green, blue);
    	c.setColor (col);
    	c.fillOval (0, 400, di1, di1);
    	c.setColor (col);
    	c.fillOval (300, 400, di2, di2);
    }


    //*******************************Prices*********************************

    public static void Prices ()
    {
    	c.clear (); // clear the screen
    	c.println ("Displays your shopping list");

    	c.print ("Item 1: ");
    	String item1 = c.readLine ();
    	c.print ("How much do/does " + item1 + " cost? $");
    	int price1 = c.readInt ();

    	c.print ("Item 2: ");
    	String item2 = c.readLine ();
    	c.print ("How much do/does " + item2 + " cost? $");
    	int price2 = c.readInt ();

    	c.print ("Item 3: ");
    	String item3 = c.readLine ();
    	c.print ("How much do/does " + item3 + " cost? $");
    	int price3 = c.readInt ();
    	c.println ();

    	c.println ("SHOPPING LIST");
    	c.println ();
    	c.println (item1 + "   $" + price1);
    	c.println (item2 + "   $" + price2);
    	c.println (item3 + "   $" + price3);
    }

//*******************************InputChars*********************************

    public static void InputChars()
    {
      c.clear (); // clear the screen
      char ch1, ch2, ch3;
    	c.println("Type in any three characters on the keyboard");
    	//c.println ("Press <Enter> after each.");
    	ch1 = c.getChar();
    	ch2 = c.getChar();
    	ch3 = c.getChar();
    	c.println();
    	c.println("Together these 3 letters spell: " + ch1 + ch2 + ch3);
    }

//*******************************InputChars2*********************************

      public static void InputChars2()
      {
        c.clear (); // clear the screen
        String ch1, ch2, ch3;
      	c.println("Type in any three characters on the keyboard");
      	c.println ("Press <Enter> after each.");
      	ch1 = c.readString();
      	ch2 = c.readString();
      	ch3 = c.readString();
      	c.println();
      	c.println("Together these 3 letters spell: " + ch1 + ch2 + ch3);
      }

//*******************************CharLiterals*********************************

    public static void CharLiterals()
    {
      c.clear (); // clear the screen
      char c1, c2, tab;
      c.println("Type in any three characters on the keyboard");
      c1 = c.getChar();
      c2 = c.getChar();
      tab = '\t';
      c.println("The two characters are " + c1 + c2 + tab);
    }

//*******************************Overwrite*********************************

    public static void Overwrite()
    {
      c.clear();
      c.println("Type in a name and <Enter>");
      String name = c.readString();
      c.println("The name is " + name);

      c.println("Type in another name and <Enter>");
      name = c.readString();

      c.println("The name is " + name);
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
	    c.println ("Enter 1, 2, 3, 4, 5, 6, 7, 8");
	    c.println ("1 - MakeLabels");
	    c.println ("2 - InOutWord");
	    c.println ("3 - InputRect");
	    c.println ("4 - VaryField");
	    c.println ("5 - InputReals");
	    c.println ("6 - PersonalDetails");
	    c.println ("7 - ColoredCircles");
	    c.println ("8 - Prices");
	    c.println ("9 - InputChars");
      c.println ("10 - InputChars2");
      c.println ("11 - CharLiterals");
      c.println ("12 - Overwrite");
	    c.println ();
	    c.println ("Enter 0 to exit");
	    choice = c.readInt ();

	    if (choice == 1)
	    {
        MakeLabels ();
	    }
      else if (choice == 2)
      {
        InOutWord ();
      }
      else if (choice == 3)
      {
        InputRect ();
      }
      else if (choice == 4)
      {
        VaryField ();
      }
      else if (choice == 5)
      {
        InputReals ();
      }
      else if (choice == 6)
      {
        PersonalDetails ();
      }
      else if (choice == 7)
      {
        ColoredCircles ();
      }
      else if (choice == 8)
      {
        Prices ();
      }
      else if (choice == 9)
      {
        InputChars();
      }
      else if (choice == 10)
      {
        InputChars2();
      }
      else if (choice == 11)
      {
        CharLiterals();
      }
      else if (choice == 12)
      {
        Overwrite();
      }

	    c.print ("Press enter to continue");
	    c.getChar ();

	    c.clear ();
	    //This will loop until user enters 0
	} while (choice != 0);
	c.println ("The program has terminated");

    } // main method
} // Menu Demo class

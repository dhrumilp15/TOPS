/*Dhrumil Patel
October 16, 2018
ICS203
PD_Set5
Set 5 in an easily accessible format*/
import java.awt.*;
import hsa.Console;

public class PD_Set_5
{
    static Console c;           // The output console

    //*******************************InputReals*********************************
    public static void InputReals ()
    {
	c.print ("Enter one real number: ");
	double num1 = c.readDouble ();
	c.print ("Enter another real number and <Enter>: ");
	double num2 = c.readDouble ();
	c.println ();
	c.println ("The first real number entered was " + num1);
	c.println ("The second real number entered was " + num2);
	c.print ("The sum of the 2 numbers is ");
	c.println (num1 + num2, 0, 1);
	c.println ("The difference of the 2 numbers is " + (num1 - num2));
	c.println ("The product of the 2 numbers is " + (num1 * num2));
    }

    //*******************************Division*********************************
    public static void Division ()
    {
	c.println ("INTEGER DIVISION");
	c.println ();
	c.print ("Input one integer and <Enter>: ");
	int num1 = c.readInt ();
	c.print ("Input another integer and <Enter>: ");
	int num2 = c.readInt ();
	c.println ("The answer to " + num1 + " divided by " + num2 + " is " + (num1 / num2));
    }

    //*******************************Remainder*********************************
    public static void Remainder ()
    {
	c.println ("FINDING THE REMAINDER");
	c.println ();
	c.print ("Input one integer and <Enter>: ");
	int num1 = c.readInt ();
	c.print ("Input another integer and <Enter>: ");
	int num2 = c.readInt ();
	c.println ("The remainder when " + num1 + " is divided by " + num2 + " is " + (num1 % num2));
    }

    //*******************************Division1*********************************
    public static void Division1()
    {
	c.clear ();
	c.println ("REAL NUMBER DIVISION");
	c.println ();
	c.print ("Input one integer: ");
	int num1 = c.readInt ();
	c.print ("Input another real number: ");
	double num2 = c.readDouble ();
	c.print ("The answer to " + num1 + " divided by " + num2 + " is ");
	c.println ((num1 / num2), 0, 3);
    }

    //*******************************Incrementing*********************************
    public static void Incrementing ()
    {
	int num1 = 7;
	int num2 = 10;
	c.println ("The first integer is " + num1);
	c.println ("The second integer is " + num2);
	num1++;
      num2++;
	c.println ("After incrementing:");
	c.println ("The first integer is now " + num1);
	c.println ("The second integer iss now " + num2);
    }
    //*******************************Exercise5D*********************************
    public static void Exercise5D ()
    {
	// Display message

	//ThreeWords Class
	//Prompting and Inputting Values
	c.println ("ThreeWords Class");
	c.print ("Input a word and <Enter>: ");
	String a = c.readString ();
	c.print ("Input another word and <Enter>: ");
	String b = c.readString ();
	c.print ("Input another word and <Enter>: ");
	String d = c.readString ();
	//Outputting the lengths of the strings
	c.println ("The total number of characters in the 3 words is " + (a.length () + b.length () + d.length ()));
	c.println ("The number of characters of " + a + " is " + a.length ());
	c.println ("The number of characters of " + b + " is " + b.length ());
	c.println ("The number of characters of " + d + " is " + d.length ());

	//NumberOfDigits Class
	c.println ();
	c.println ("NumberOfDigits Class");
	//Prompting and Inputting value
	c.print ("Input an integer and <Enter>: ");
	String e = c.readLine ();
	//Outputting the number of digits
	c.println ("The number " + e + " contains " + e.length () + " digits");

	//WholeNum Class
	c.println ();
	c.println ("WholeNum Class");
	//Declaring Variable
	int wholeNum;
	//Prompting and Inputting Value
	c.print ("Input an integer and <Enter>: ");
	wholeNum = c.readInt ();
    }


    //*******************************Marks*********************************
    public static void Marks ()
    {
	// Display message
	//Displaying Columns
	c.println ("12345678901234567890");
	//Displaying student names and their marks
	c.print ("Refiloe Smith");
	c.println (82, 25 - "Refiloe Smith".length ());
	c.print ("Anna Lin");
	c.println (67, 25 - "Anna Lin".length ());
	c.print ("Timothy Nyugen");
	c.println (75, 25 - "Timothy Nyugen".length ());
    }

    //*******************************ShoppingList*********************************
    public static void ShoppingList ()
    {
	// Display message
	//Displaying Columns
	c.println ("123456789012345678901234567890");
	//Header
	c.print ("", 4);
	c.println ("SHOPPING LIST");
	//Shopping List
	c.println ();
	c.print ("Box of disks");
	c.println (43.95, 13);
	c.print ("Computer");
	c.println (4999.99, 17);
	c.print ("Printer");
	c.println (899.50, 18);
	c.print ("MS Works");
	c.println (450.00, 17);
	c.print ("", 17);
	c.println ("--------");
	c.println ("TOTAL");
    }

    //*******************************CentreDisplay********************************
    public static void CentreDisplay ()
    {
	// Display message
	//Prompting and Inputting Values
	c.print ("Input a sentence and <Enter>: ");
	String sent = c.readLine ();
	//Ouputting Columns and the variable in the centre of the column numbers
	c.println ();
	c.println ("12345678901234567890123456789012345678901234567890123456789012345678901234567890");
	c.print (" ", 40 - sent.length () / 2);
	c.println (sent);
    }

    //*******************************Flyer*********************************
    public static void Flyer ()
    {
	c.clear (); // clear the screen
	// Display message
	//Outputting the flyer and the patterns
	c.println ("/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\");
	c.print (" ", 22 - "ETHNIK".length () / 2);
	c.println ("ETHNIK");
	c.print (" ", 22 - "AFRIKA".length () / 2);
	c.println ("AFRIKA");
	c.print (" ", 22 - "Ethnic gear at low prices".length () / 2);
	c.println ("Ethnic gear at low prices");
	c.println ("/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\");
	c.print ("WEDNESDAY", 41 - "WEDNEDAY".length ());
	c.println ("Fleamarket");
	c.print ("SATURDAY", 41 - "SATURDAY".length ());
	c.println ("Bruma Lake");
	c.print ("SUNDAY", 41 - "SUNDAY".length ());
	c.println ("Stand 43");
	c.println ("/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\");
    }

    //*******************************ComputerMenu*********************************
    public static void ComputerMenu ()
    {
	// Display message
	//Menu Header
	c.print (" ", c.getMaxColumns () / 2 - "MEGABYTE MENU".length () / 2);
	c.println ("MEGABYTE MENU");
	//Starters
	c.println ();
	c.print (" ", c.getMaxColumns () / 2 - "STARTERS".length () / 2);
	c.println ("STARTERS");
	c.print (" ", c.getMaxColumns () / 2 - "Hot keys - hot Mexican chilli chips".length () / 2);
	c.println ("Hot keys - hot Mexican chilli chips");
	c.print (" ", c.getMaxColumns () / 2 - "Data - be surprised and try this starter".length () / 2);
	c.println ("Data - be surprised and try this starter");
	//Main Course
	c.println ();
	c.print (" ", c.getMaxColumns () / 2 - "MAIN COURSE".length () / 2);
	c.println ("MAIN COURSE");
	c.print (" ", c.getMaxColumns () / 2 - "Root directory - vegetarian platter".length () / 2);
	c.println ("Root directory - vegetarian platter");
	c.print (" ", c.getMaxColumns () / 2 - "RAM - grilled to perfection in BBQ sauce".length () / 2);
	c.println ("RAM - grilled to perfection in BBQ sauce");
	//Drinks
	c.println ();
	c.print (" ", c.getMaxColumns () / 2 - "DRINKS".length () / 2);
	c.println ("DRINKS");
	c.print (" ", c.getMaxColumns () / 2 - "Tabs - Caffeine-free, sugar-free cola".length () / 2);
	c.println ("Tabs - Caffeine-free, sugar-free cola");
	c.print (" ", c.getMaxColumns () / 2 - "Copy - imitation fruit juice".length () / 2);
	c.println ("Copy - imitation fruit juice");
    }

    //*******************************VarValues*********************************
    public static void VarValues ()
    {
	c.clear (); // clear the screen
	// Display message
	//Declaring Variables
	int num1;
	int num2;
	int num3;
	//Assigning values to variables
	num1 = 7;
	num2 = 15;
	//Getting a value into a variable from the keyboard
	c.print ("Type in any integer and <Enter>: ");
	num3 = c.readInt ();
	//Displaying output
	c.println ();
	c.println ("The first integer is " + num1);
	c.println ("The second integer is " + num2);
	c.println ("The third integer is " + num3);
	//Declaring and assigning in one statement
	int sum = num1 + num2 + num3;
	int product = num1 * num2 * num3;
	//More output
	c.println ("The sum of the 3 integers is " + sum);
	c.println ("The product of the 3 integers is " + product);
    }

    //*******************************Exercise5G*********************************
    public static void Exercise5G ()
    {
	// Display message
	//Eggs Class
	//Prompting and inputting value
	c.print ("Input the total number of eggs in the box and <Enter>: ");
	int eggs = c.readInt ();
	//Outputting the number of dozens in the value
	c.println ("There are " + eggs / 12 + " dozen eggs");

	//Date100 Class
	//Prompting and Inputting the value
	c.print ("Input the year and <Enter>: ");
	int year = c.readInt ();
	//Separating the first 2 digits from the second 2 digits
	int a = year / 100;
	int b = year % 100;
	//Incrementing the first 2 digits
	a++;
	//Outputting the new year
	c.println ("The date in 100 years is " + a + b);
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
	    c.println ("Enter 1, 2, 3, 4, 5, 6, 7, 8, 9 , 10, 11, 12, 13");
	    c.println ("1 - InputReals");
	    c.println ("2 - Division");
	    c.println ("3 - Remainder");
	    c.println ("4 - Division");
	    c.println ("5 - Incrementing");
	    c.println ("6 - Exercise5D");
	    c.println ("7 - Marks");
	    c.println ("8 - ShoppingList");
	    c.println ("9 - CentreDisplay");
	    c.println ("10 - Flyer");
	    c.println ("11 - ComputerMenu");
	    c.println ("12 - VarValues");
	    c.println ("13 - Exercise5G");


	    c.println ();
	    c.println ("Enter 0 to exit");
	    choice = c.readInt ();
	c.clear ();
	switch (choice)
	{
	  case 1:
	  InputReals();
	  break;

	  case 2:
	  Division();
	  break;

	  case 3:
	  Remainder();
	  break;

	  case 4:
	  Division1();
	  break;

	  case 5:
	  Incrementing();
	  break;

	  case 6:
	  Exercise5D();
	  break;

	  case 7:
	  Marks();
	  break;

	  case 8:
	  ShoppingList();
	  break;

	  case 9:
	  CentreDisplay();
	  break;

	  case 10:
	  Flyer();
	  break;

	  case 11:
	  ComputerMenu();
	  break;

	  case 12:
	  VarValues();
	  break;

	  case 13:
	  Exercise5G();
	  break;

	  default:
	  break;
      }
	    c.print ("Press enter to continue");
	    c.getChar ();

	    c.clear ();
	    //This will loop until user enters 0
	}       while (choice != 0);
	c.println ("The program has terminated");

    } // main method
} // PD_Set_5 class

/*Andrew Pun
Nov 2018
ICS203
PD_Set_7
Set 7 programs in an easily accessible interface
*/

import hsa.Console;
import java.awt.Color;

public class PD_Set_7
{
    static Console c;

    //*******************************CheckDivision*********************************
    public static void CheckDivision ()
    {
        double a, b, result;

        c.println("Enter a value for a");
        a = c.readDouble();
        c.println("Enter a value for b");
        b = c.readDouble();

        if (b != 0) {
            result = a /b;
            c.print("The result is ");
            c.println(result, 0, 2);
        }
        else
        {
          c.println("This calculation can't be performed!");
        }
    }

    //*******************************NumChars*********************************
    public static void NumChars ()
    {
      	String wrd;
        int num, posn;
        c.println("Type any word <Enter>");
        wrd = c.readString();
        num = wrd.length();

        if (num % 2 != 0) {
            c.println(wrd + " has an odd number of letters.");
            posn = num / 2 + 1;
            c.println("The middle letter is at position " + posn);
        } else {
            c.println(wrd + " has an even number of letters.");
        }
    }

    //*******************************MaxMinNum*********************************
    public static void MaxMinNum ()
    {
	     int max = 60, min = 21, num;
        c.println("Enter any whole number: ");
        num = c.readInt();

        if (num > 0) {
            c.println("Your number " + num + " is larger than zero");
        } else {
            c.println("Your number is negative or zero");
        }
        if (num > max) {
            c.println("Your number " + num + " is larger than " + max);
        }
        if (num < min) {
            c.println("Your number " + num + " is smaller than " + min);
        }
    }

    //*******************************CheckDivision*********************************
    public static void CheckDivision2 ()
    {
        double a, b, result;

        c.println("Enter a value for a");
        a = c.readDouble();
        c.println("Enter a value for b");
        b = c.readDouble();

        if (b = 0) {
            c.printl("This calculation can't be performed!");
        }
        else
        {
          result = b /a;
          c.print("The result is ");
          c.println(result, 0, 2);
        }
    }

    //*******************************EvenOddNum*********************************
    public static void EvenOddNum ()
    {
        int number, multiple;

        c.println("Enter a whole number");
        number = c.readInt();
        c.println("Enter another whole number");
        multiple = c.readInt();
        if (number % multiple == 0) {
            c.print("The number " + number + "is a multiple of " + multiple);
        }
        else {
            c.print("The number " + number + "is not a multiple of " + multiple);
        }
    }

     //*******************************Discount*********************************
    public static void Discount ()
    {
      double purchase;
      c.println("Enter the amount of money required for the purchase");
      purchase = c.readDouble();
      c.print("Your final cost is $");

      if (purchase > 100) {
          c.println(purchase*0.9, 0, 2);
      } else {
          c.println(purchase, 0, 2);
      }
    }

     //*******************************TestNumber*********************************
    public static void TestNumber ()
    {
      int number;

      c.println("Enter a whole number");
      number = c.readInt();
      if (number == 0) {
          c.println("Your number is 0");
      }
      if (number < 0) {
        c.println("Your number is negative");
      }
      else {
        c.println("Your number is positive");
      }

      if (number % 2 ==0) {
          c.println("Your number is even");
      } else {
          c.println("Your number is odd");
      }

      if (number % 7 ==0) {
          c.println("Your number is a multiple of 7");
      } else {
          c.println("Your number is not a multiple of 7");
      }
    }

     //*******************************Driving*********************************
    public static void Driving ()
    {
      int age;
      c.println("How old are you?");
      age = c.readInt();

      if (age < 18)
      {
        c.println("Too young to drive");
      }
      else if (age > 75)
      {
        c.println("Sorry, you're over the legal age for driving.")
      }
      else if (age >= 18 && age <= 75)
      {
        c.println("Age OK. have you got a driver's license?");
      }
    }

    //*******************************MarkSymbol*********************************
    public static void MarkSymbol ()
    {
      int mark;
      char sym = 'y';
      c.println("Type in your mark:");
      mark = c.readInt();

      if (mark < 50) {
          sym = 'E';
      }
      else if (mark >= 50 & mark < 60) {
          sym = 'D';
      }
      else if (mark >= 60 & mark < 70) {
          sym = 'C';
      }
      else if (mark >= 70 & mark < 80) {
          sym = 'B';
      }
      else if (mark >= 80) {
          sym = 'A';
      }

      c.println(sym);
    }

    //*******************************CompareNumChars*********************************
    public static void CompareNumChars ()
    {
	     String wrd1, wrd2;
        c.println("Type in the first word:");
        wrd1 = c.readString();
        c.println("Type in the second word:");
        wrd2 = c.readString();

        if (wrd2.length() >= wrd1.length()){
            c.println(wrd1 + " then " + wrd2);
        } else {
            c.println(wrd2 + " then " + wrd1);
        }
    }

    //*******************************SportingEvents*********************************
    public static void SportingEvents ()
    {
      int year;
      c.println("Type in a year:");
      year = c.readInt();
      c.print("During this year, ");
      if (year % 4 == 0) {
          c.println("the Olympics will be held.");
      }
      else if (year % 4 == 2) {
        c.println("the cricket world cup will be held.");
      }
      else if(year % 4 == 3) {
        c.println("the rugby world cup will be held.");
      }
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
    	    c.println ("Enter 1 - 11");
    	    c.println ("1 - CheckDivision");
    	    c.println ("2 - NumChars");
    	    c.println ("3 - MaxMinNum");
          c.println ("4 - CheckDivision2");
    	    c.println ("5 - EvenOddNum");
    	    c.println ("6 - Discount");
          c.println ("7 - TestNumber");
          c.println ("8 - Driving");
          c.println ("9 - MarkSymbol");
          c.println ("10 - CompareNumChars");
          c.println ("11 - SportingEvents");
    	    c.println ();
    	    c.println ("Enter 0 to exit");
    	    choice = c.readInt ();

          c.clear();
    	    if (choice == 1)
    	    {
    		      CheckDivision ();
    	    }
    	    else if (choice == 2)
        	{
        	    NumChars ();
        	}
          else if (choice == 3)
          {
            MaxMinNum ();
          }
    	    else if (choice == 4)
    	    {
            MaxMinNum ();
    	    }
    	    else if (choice == 5)
    			{
            EvenOddNum ();
    			}
    			else if (choice == 6)
    	    {
            Discount ();
    	    }
          else if (choice == 7)
          {
            TestNumber ();
          }
          else if (choice == 8)
          {
            Driving ();
          }
          else if (choice == 9)
          {
            MarkSymbol ();
          }
          else if (choice == 10)
          {
            CompareNumChars ();
          }
          else if (choice == 11)
          {
            SportingEvents ();
          }
    	    c.print ("Press enter to continue");
    	    c.getChar ();

    	    c.clear ();
    	    //This will loop until user enters 0
    	}
      while (choice != 0);
    	c.println ("The program has terminated.");

    } // main method
}

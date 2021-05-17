/*
Dhrumil Patel
October 2018
ICS203
PD_Set_6
Easily accessible set 6 programs
*/

import java.awt.*;
import hsa.Console;

public class PD_Set_6
{
    static Console c;

    //*******************************NameAge*********************************
    public static void NameAge()
    {
    	c.print("Name: ");
    	String name = c.readLine();
    	c.print("Year of Birth: ");
    	int yob = c.readInt();
    	c.println(name + ", you will be " + (2018-yob) + " years old this year.");
    }

    //*******************************Chocs*********************************
    public static void Chocs()
    {
    	c.println("CHOC BAR \t QUANTITY \t COST");
    	c.print("KitKat","CHOC BAR".length());
    	c.print("\t ");
    	c.print("3","QUANTITY".length());
    	c.print(" \t ");
    	c.println("$0.99");
    }

    //*******************************Supermarket*********************************
    public static void Supermarket()
    {
      c.print("Type in the name of any food and <Enter>:");
      String name1 = c.readString();
      c.print("Type in the price and <Enter>:");
      double num1 = c.readDouble();
      c.print("Type in the name of any other food and <Enter>:");
      String name2 = c.readString();
      c.print("Type in the price and <Enter>:");
      double num2 = c.readDouble();
      c.println();
      c.println("Sally's Supermarket");
      c.println("");
      c.println(name1 + " " + num1);
      c.println(name2 + " " + num2);
      double sum = num1 + num2;
      c.println(" ------");
      c.print("TOTAL ");
      c.println(sum,0,2);
    }

    //*******************************RoundedMarks*********************************
    public static void RoundedMarks ()
    {
      c.print("Type in your name and <Enter>:");
      String name = c.readString();
      c.print("Type in your mark and <Enter>:");
      double num1 = c.readDouble();
      double dividend = (double) Math.round((num1/43.0)*100.0) / 100;
      double rounded = (num1/43.0)*100.0;
      c.print("NAME",10); // Takes 6 extra spaces
      c.print("MARK OUT OF 43",20); // Takes 6 extra spaces
      c.println("ROUNDED %");
      c.print(name, 10);
      c.print(dividend, 14);
      c.print("",6);
      c.println(rounded,"ROUNDED %".length(),2);
    }
    //*******************************PlayCosts*********************************
    public static void PlayCosts ()
    {
      c.print("Type in the number of students on Night 1 and <Enter>:");
      double num1 = c.readDouble();
      c.print("Type in the number of parents on Night 1 and <Enter>:");
      double num2 = c.readDouble();
      c.print("Type in the number of students on Night 2 and <Enter>:");
      double num3 = c.readDouble();
      c.print("Type in the number of parents on Night 2 and <Enter>:");
      double num4 = c.readDouble();
      c.println();
      double product = num1*10;
      double product2 = num2*15;
      double product3 = num1*10;
      double product4 = num1*15;

      double sum = product + product2 + product3 + product4;

      c.println("The cost for students on day 1 was $" + product);
      c.println("The cost for parents on day 1 was $" + product2);
      c.println("The cost for students on day 2 was $" + product3);
      c.println("The cost for students on day 2 was $" + product4);
      c.println("The cost in total was $" + sum);
    }
    //*******************************Swimmers*********************************
    public static void Swimmers ()
    {
      c.print("Type in the name of a female olympic swimmer and <Enter>:");
      String name1 = c.readString();
      c.print("Type in the time in seconds for 100m breast stroke final and <Enter>:");
      double num1 = c.readDouble();
      c.print("Type in the name of any other female olympic swimmer and <Enter>:");
      String name2 = c.readString();
      c.print("Type in the time in seconds for 100m breast stroke final <Enter>:");
      double num2 = c.readDouble();
      double difference = num2-num1;
      c.println();
      c.println("100 BREASTSTROKE FINAL");
      c.println("");
      c.print("NAME",14);
      c.println("TIME");
      c.print(name1,14);
      c.println(num1);
      c.print(name2,14);
      c.println(num2);
      c.println();

      c.print("Difference in times ");
      c.println(Math.abs(difference),0,2);
    }
    //*******************************Rings*********************************
    public static void Rings ()
    {
      c.setColor (Color.blue);
      c.drawOval (90, 100, 100, 100);
      c.setColor (Color.black);
      c.drawOval (200, 100, 100, 100);
      c.setColor (Color.red);
      c.drawOval (310, 100, 100, 100);
      c.setColor (Color.yellow);
      c.drawOval (145, 170, 100, 100);
      c.setColor (Color.green);
      c.drawOval (255, 170, 100, 100);
    }

    //*******************************MarkAverage*********************************
    public static void MarkAverage ()
    {
      c.print("Type in your name and <Enter>:");
      String name = c.readString();
      c.print("Type in your mark and <Enter>:");
      double num1 = c.readDouble();
      c.print("Type in your other mark and <Enter>:");
      double num2 = c.readDouble();
      double total = num1+num2;
      double perc = total*100/(25+55);

      c.println(name + " got " + num1+ " out of 25 and " + num2 + " out of 55,so her final percentage is " + perc);
    }

    //*******************************FoodStall*********************************
    public static void FoodStall ()
    {
    c.print("Type in the number of cokes bought and <Enter>:");
    double num1 = c.readDouble();
    c.print("Type in the number of packets of chips <Enter>:");
    double num2 = c.readDouble();
    c.print("Type in the amount you pay with <Enter>:");
    double num3 = c.readDouble();

    c.println();
    double product = 3 * num1;
    double product2 = 2.5 * num2;

    double sum = product + product2;
    double change = num3-sum;

    c.println("The cost for coke is $" + product);
    c.println("The cost for chips is $" + product2);
    c.println("The cost in total was $" + sum);
    c.println("The change due is $" + change);
    }
    //*******************************StarInBox*********************************
    public static void StarInBox ()
    {
      c.setColor (Color.red);
      c.fillStar (70, 10, 490, 490);
      c.setColor (Color.blue);
      c.drawStar (65, 5, 500, 500);
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
	    c.println ("Enter 1, 2, 3, 4, 5, 6, 7, 8, 9, 10");
      c.println ("1 - NameAge");
      c.println ("2 - Chocs");
      c.println ("3 - Supermarket");
      c.println ("4 - Rounded Marks");
      c.println ("5 - PlayCosts");
      c.println ("6 - Swimmers");
      c.println ("7 - Rings");
      c.println ("8 - MarkAverage");
      c.println ("9 - Foodstall");
      c.println ("10 - StarInBox");

	    c.println ();
	    c.println ("Enter 0 to exit");
	    choice = c.readInt ();
	    c.clear();
      if (choice == 1)
	    {
	       NameAge();
	    }
	    else if (choice == 2)
  		{
  		    Chocs();
  		}
      else if (choice == 3)
      {
        Supermarket();
      }
      else if (choice == 4)
			{
			    RoundedMarks();
			}
      else if (choice == 5)
			{
			    PlayCosts();
			}
      else if (choice == 6)
			{
			    Swimmers();
			}
      else if (choice == 7)
			{
			    Rings();
			}
      else if (choice == 8)
			{
			    MarkAverage();
			}
      else if (choice == 9)
			{
			    FoodStall();
			}
      else if (choice == 10)
			{
			    StarInBox();
			}
      c.print ("Press enter to continue");
      c.getChar ();
      c.clear ();
	}	while (choice != 0);

  c.println ("The program has terminated");

    } // main method
}

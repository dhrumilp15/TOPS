/*
Dhrumil Patel
Nov 2018
ICS203
PD_Set_8
Set 8 Programs in an easily accessible format
*/

import java.awt.*;
import hsa.Console;

public class PD_Set_8
{
    static Console c;

//*******************************PrintCharsA****************************************
public static void PrintCharsA ()
{
	for (int i = 65; i <= 90; i++)
	{
    char a = (char) i;
  	c.print(a + " ");
	}

	c.println();

	for (int i = 90; i >= 65; i--)
	{
    char b = (char) i;
    c.print(b + "   ");
	}
}

//*******************************PrintCharsB*****************************************
public static void PrintCharsB()
{
	for (int i = 32; i <= 126; i++)
	{
  	char a = (char) i;
  	c.print(a + " ");
	}
}

//*******************************PrintCharsC*****************************************


public static void PrintCharsC ()
{
	for (int i = 32; i <= 127; i++)
	{
  	char a = (char) i;

  	if (i <= 55)
  	{
  	    c.println("(" + a + ", " + i + ")" );
  	}
  	else if (i > 55 && i <= 79)
    {
  		c.setCursor((i-55), 11);
  		c.println("(" + a + ", " + i + ")" );
    }
    else if (i > 79 && i <= 103)
    {
      c.setCursor((i-79), 22);
      c.println("(" + a + ", " + i + ")" );
    }
    else
    {
      c.setCursor((i-103), 33);
      c.println("(" + a + ", " + i + ")" );
    }
  }
}

//*******************************PrintLbl****************************************
public static void PrintLbl ()
{
	c.setCursor(1,30);

	for (int i = 0; i <= 20; i++)
	{
	    c.print("=");
	}

	c.setCursor(3,32);
	c.print("realcoolclothing");

	c.setCursor(4,38);
	c.print("from");

	c.setCursor(5,33);
	c.print("ETHNIK  AFRIKA");

	c.setCursor(7,30);

	for (int i = 0; i <= 20; i++)
	{
	    c.print("=");
	}
}

//*******************************PrintDiag***********************************
public static void PrintDiag ()
{
	for (int i = 1; i <= 6; i++)
	{
	   c.println(7-i, 7-i);
	}

	for (int i = 1; i <= 6; i++)
	{
	   c.println(i, 7-i);
	}

	for (int i = 1; i <= 6; i++)
	{
	   c.println(7-i, i);
	}

  for (int i = 65; i <= 70; i++)
  {
    if ((char) i != 'E')
    {
      for(int j = 0; j < i-65; j++)
      {
        c.print(" ");
      }
      char ltr = (char) i;
      c.println(ltr);
    }
    else
    {
      for(int k = 0; k < 5; k++)
      {
        c.print('E');
      }
      c.println();
    }
  }
}

//*******************************ConvertTemp************************************
public static void ConvertTemp ()
{

	for (int i = 100; i <= 123; i++)
	{
	   c.println(i + "-" + (9/5*i +32));
	}

	for (int i = 124; i <= 147; i++)
	{
    c.setCursor(i-123, 10);
    c.println(i + "-" + (9/5*i +32));
	}

	for (int i = 148; i <= 171; i++)
	{
    c.setCursor(i-147, 20);
  	c.println(i + "-" + (9/5*i +32));
	}

	for (int i = 172; i <= 195; i++)
	{
    c.setCursor(i-171, 30);
    c.println(i + "-" + (9/5*i +32));
	}

	for (int i = 196; i <= 219; i++)
	{
  	c.setCursor(i-195, 40);
  	c.println(i + "-" + (9/5*i +32));
	}

	for (int i = 220; i <= 243; i++)
	{
  	c.setCursor(i-219, 50);
  	c.println(i + "-" + (9/5*i +32));
	}

	for (int i = 244; i <= 267; i++)
	{
  	c.setCursor(i-243, 60);
  	c.println(i + "-" + (9/5*i +32));
	}

	for (int i = 268; i <= 281; i++)
	{
  	c.setCursor(i-267, 70);
  	c.println(i + "-" + (9/5*i +32));
	}
}

//*******************************MaxNumsA********************************************
public static void MaxNumsA ()
{

	int num, max;
	c.println("Enter the first number: ");
	num = c.readInt();
	max  = num;

	for (int i = 2; i <= 10; i++)
	{
  	c.println("Enter the next number: ");
  	num = c.readInt ();
  	if (num > max)
  	{
  	    max = num;
  	}
	}

	c.println("The largest number in the list is " + max);
}

//*******************************MaxNumsB****************************************
public static void MaxNumsB ()
{

	int num, max, amount;
	c.println("Enter the number of numbers: ");
	amount = c.readInt();

	c.println("Enter the first number: ");
	num = c.readInt();
	max  = num;

	for (int i = 2; i <= amount; i++)
	{
  	c.println("Enter the next number: ");
  	num = c.readInt ();
  	if (num > max)
  	{
  	    max = num;
  	}
	}

	c.println("The largest number in the list is " + max);
}

//*******************************MinNum*****************************************
public static void MinNum ()
{
	int num, min, j;
	c.println("Enter the number of numbers: ");
	j = c.readInt();

	c.println("Enter the first number: ");
	num = c.readInt();
	min = num;

	for (int i = 2; i <= j; i++)
	{
  	c.println("Enter the next number: ");
  	num = c.readInt ();
  	if (num < min)
  	{
  	    min = num;
  	}
	}

	c.println("The smallest number in the list is " + min);
}

//*******************************Cheapest***************************************
public static void Cheapest ()
{
	double price, chprice;
	String name, chname;
	c.println("Enter the number of products: ");
	int y = c.readInt();

	c.println("Enter the first product's name and it's price: ");
	name = c.readLine();
	price = c.readDouble();
	chname = name;
	chprice = price;
	c.setCursor(15, 55);
	c.println("Beans | Price");
	c.setCursor(16, 55);
	c.println(name + "   $" + price);

	for (int i = 2; i <= y; i++)
	{
  	c.setCursor(3*i, 1);
  	c.println("Enter the next product's name and it's price: ");
  	name = c.readLine();
  	price = c.readDouble();
  	c.setCursor(i+15, 55);
  	c.println(name + "   $" + price);
  	if (price < chprice)
  	{
  	    chprice = price;
  	    chname = name;
  	}
	}

	c.println("The cheapest product is " + chname + ", $" + chprice + ".");
}

//*******************************FivePatterns*****************************************
public static void FivePatterns ()
{
	for (int i = 1; i <= 4; i++)
	{
	    for (int y = 1; y <= i; y++)
	    {
		      c.print(y);
	    }
	    c.println();
	}

	c.println();

	for (int i = 1; i <= 4; i++)
	{
	    for (int y = 1; y <= i; y++)
	    {
		      c.print(i);
	    }
      c.println();
	}

	c.println();

	for (int i = 1; i <= 4; i++)
	{
	    for (int y = i; y >= 1; y--)
	    {
		      c.print(y);
	    }
	    c.println();
	}

	c.println();

	for (int i = 1; i <= 4; i++)
	{
	    for (int y = (i*i-i+2)/2; y <= (i*i+i)/2; y++)
	    {
		      c.print(y);
	    }
	    c.println();
	}

	c.println();

	for (int i = 1; i <= 5; i++)
	{
	    for (int y = i; y <= i+4; y++)
	    {
		      c.print(y);
	    }
	    if (i <=4)
	    {
	       c.println();
	    }
	}
}

//*******************************AdjacentT*****************************************
public static void AdjacentT ()
{
	for (int i = 1; i <= 5; i++)
	{
	    for (int y = 1; y <= 2*i-1; y++)
	    {
		      c.print("%");
	    }
	    c.println();
	}
}

//*******************************TriangleShape*****************************************
public static void TriangleShape ()
{
	for (int i = 1; i <= 5; i++)
	{
	    c.print(" ", 6-i);
	    for (int y = 1; y <= 2*i-1; y++)
	    {
		      c.print("%");
	    }
	    c.println();
	}
}

//***********************************Menu Program Here*****************************
public static void main (String[] args)
{

	c = new Console ();

	//variable delclaration for user's choice
	int choice;

	do
	{
	    //Promting for choice

	    c.println ();
	    c.println ("Choose from the following menu.\n");
	    c.println ("Enter a number from 1-11.");
	    c.println ("1 - PrintCharsA");
	    c.println ("2 - PrintCharsB");
	    c.println ("3 - PrintCharsC");
	    c.println ("4 - PrintLbl");
	    c.println ("5 - PrintDiag");
	    c.println ("6 - ConvertTemp");
	    c.println ("7 - MaxNumsA");
	    c.println ("8 - MaxNumsB");
	    c.println ("9 - MinNum");
	    c.println ("10 - Cheapest");
	    c.println ("11 - FivePatterns");
	    c.println ("12 - AdjacentT");
	    c.println ("13 - TriangleShape");

	    c.println ();
	    c.println ("Enter 0 to exit.");
	    choice = c.readInt ();

      c.clear();
	    if (choice == 1)
	    {
        PrintCharsA();
	    }
      else if (choice == 2)
      {
        PrintCharsB();
      }
      else if (choice == 3)
      {
        PrintCharsC();
      }
      else if (choice == 4)
			{
        PrintLbl();
			}
			else if (choice == 5)
      {
        PrintDiag();
      }
      else if (choice == 6)
      {
        ConvertTemp();
      }
      else if (choice == 7)
      {
        MaxNumsA();
      }
      else if (choice == 8)
      {
        MaxNumsB();
      }
      else if (choice == 9)
      {
        MinNum();
      }
      else if (choice == 10)
      {
        Cheapest();
      }
      else if (choice == 11)
      {
        FivePatterns();
      }
      else if (choice == 12)
      {
        AdjacentT();
      }
      else if (choice == 13)
      {
        TriangleShape();
      }
	c.print("\nPress enter to continue");
	c.getChar ();

	c.clear ();
	    //This will loop until user enters 0
	}

	while (choice != 0);
	c.close();

    } // main method
} // Menu Demo class

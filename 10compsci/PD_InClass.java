/*
Dhrumil Patel
Dec 2018
ICS2O3
PD_InClass
String and character fun
*/
import java.awt.*;
import hsa.Console;

public class PD_InClass
{
    static Console c;           // The output console
    
    public static void main (String [] args)
    {
	c = new Console ();

	c.print ("Enter an integer from 0 to 999: ");
	int number = getInt (999); // forces user to enter value from 0 to 999

	c.print ("\nWhich digit do you want?(1-3): ");
	int digit = getInt (1, 3); // forces user to enter value from 1 to 3

	c.println ("\nThe digit you requested is " + getDigit (number, digit));

	c.print ("\n\nEnter a secret message: ");
	String message = c.readLine ();

	c.println ("\nThe no vowel version is  " + noVowels (message));
	
	c.println( "\nThe excluded letters version is " + exclude(message,"AEIOUaeiou"));
    }
    
    public static int getInt(int stop)
    {
	int num;
	int attempts = 0;
	do
	{
	    if(attempts > 0) c.print("Enter an integer from 0 to 999: ");
	    num = c.readInt();
	    attempts++;
	} while(num <= 0 || num >= stop);
	
	return num;
    }
    
    public static int getInt(int start, int stop)
    {
	int num;
	int attempts = 0;
	do
	{
	    if(attempts > 0) c.print("Enter an integer from 0 to 999: ");    
	    num = c.readInt();
	    attempts++;
	} while(num < start && num > stop);
	
	return num;
    }
    
    public static int getDigit(int number, int i)
    { 
	char[] list = Integer.toString(number).toCharArray();
	if(i <= 0 || i > list.length)return -1;
	return Integer.parseInt(list[i-1] + "");
    }
    
    public static String noVowels(String msg)
    {
	return msg.replaceAll("[aeiou]", "");
	
    }
    
    public static String exclude(String msg, String excludedbois)
    {
	return msg.replaceAll("[" + excludedbois + "]", "");
    }
    
    //public static 
    
} // PD_InClass class

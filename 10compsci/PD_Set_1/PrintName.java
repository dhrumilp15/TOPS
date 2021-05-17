/*
Dhrumil Patel
September 11, 2018
ICS2O3
PrintName
Prints author's name and more information to the console
*/
import java.awt.*;
import hsa.Console;

public class PrintName
{
    static Console c;           // The output console
    
    public static void main (String[] args)
    {
	c = new Console ();
	
	c.println("My name is Dhrumil Patel");
	c.println("I'm in grade 10");
	c.println("I go to Marc Garneau C.I");
	c.println("I live in Ajax, Ontario");
    } // main method
} // PrintName class


// The "RealNumberOutput" class.
import java.awt.*;
import hsa.Console;

public class RealNumberOutput
{
    static Console c;           // The output console
    
    public static void main (String[] args)
    {
	c = new Console ();
	
	c.println(45.23);
	c.println(45.23 + 8765.37);
	c.println(17.5*123.45);
	c.println(875.99/54.49);
	c.println(17.25 - 7.89 * 145.11 + 0.375/23.986);
	c.println(45.23 + 7.876);
	
	c.clear();
	c.println("12345678901234567890");
	c.println(75.375, 4);
	c.println(75.375, 2);
	c.println(75.375,10);
	c.println(75.375,0,4);
	c.println(75.375,0,2);
	c.println(75.375,0,1);
	c.println();
	c.println("12345679801234567980");
	c.println(63.97567,10,2);
	c.println(63.97567,10,3);
	c.println(63.97567,10,4);
    } // main method
} // RealNumberOutput class

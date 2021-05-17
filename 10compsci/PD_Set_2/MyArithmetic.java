// The "MyArithmetic" class.
import java.awt.*;
import hsa.Console;

public class MyArithmetic
{
    static Console c;           // The output console
    
    public static void main (String[] args)
    {
	c = new Console ();

	c.print("12345678901234567890123456789012345678901234567890");
	c.setCursor(2,7);
	c.print (57.654, 4, 1);
	c.setCursor(2,20);
	c.println(-17);
	c.println ();
	c.setCursor(4,10);
	c.println ("Integers are a subset of Real numbers " + 3);
	c.println ();
	c.setCursor(6,23);
	c.println (8754.77 - 652.876 + 423.754 * 0.5,7,3);
    } // main method
} // MyArithmetic class

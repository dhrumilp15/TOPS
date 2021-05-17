// The "Circles" class.
import java.awt.*;
import hsa.Console;

public class Circles
{
    static Console c;           // The output console

    public static void main (String[] args)
    {
	c = new Console ();

	c.setColor (Color.magenta);
	c.fillOval (215, 100, 250, 250);
    } // main method
} // Circles class

// The "MyColours" class.
import java.awt.*;
import hsa.Console;

public class MyColours
{
    static Console c;           // The output console
    
    public static void main (String[] args)
    {
	c = new Console ();
	
	Color col = new Color(221,180,67);
	c.setColor(col);
	c.fillRect(100,100,100,100);
	
    } // main method
} // MyColours class

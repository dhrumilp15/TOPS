// The "PD_quiz" class.
import java.awt.*;
import hsa.Console;

public class PD_quiz
{
    static Console c;           // The output console
    
    public static void main (String[] args)
    {
	c = new Console ();
	
	int list[] = {3, 23, 234, 173, 245, 34, 45};
	c.print("Here is the original list: ");
	print(list);
	c.print("\nHere is the reversed original list: ");
	printReverse(list);
    } // main method
    
    public static void print(int[] list)
    {
	if(list.length != 0)
	{
	    c.print(list[0]);    
	    for(int i = 1; i < list.length;i++)
	    {
		c.print(", ");
		c.print(list[i]);
	    }
	}
    }
    
    public static void printReverse(int[] list)
    {
	if(list.length != 0)
	{
	    c.print(list[list.length-1]);    
	    for(int i = list.length-2; i > -1;i--)
	    {
		c.print(", ");
		c.print(list[i]);
	    }
	}
    }
} // PD_quiz class

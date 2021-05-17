import java.awt.*;
import hsa.Console;

public class PD_Cards
{
    static Console c;

    public static void main (String[] args)
    {
	c = new Console ();
	char again;

	do
	{
	    c.print ("\n\nHere is your 3-card hand: ");
	    int card1 = getCard (1, 13), card2 = getCard (1, 13), card3 = getCard (1, 13);

	    show (card1);
	    show (card2);
	    show (card3);

	    c.println ("\nYou have " + quality (card1, card2, card3));

	    c.print ("Do you want to play again?");
	    again = c.getChar ();
	}
	while (again == 'y');
    } // main method
    
    public static int getCard (int low, int high)
    {
	return (int)(Math.random() * (high-low) + low);
    }
    
    public static void show(int card)
    {
	if(card <= 10 && card >= 1)c.print(card + " ");
	else if (card == 1)c.print("A ");
	else if (card == 11)c.print("J ");
	else if (card == 12)c.print("Q ");
	else if (card == 13)c.print("K ");
    }
    
    public static String quality(int first, int second, int third)
    {
	if(first == second && second == third)return "a three of a kind";
	else if (first == second || first == third || second == third) return "a pair";
	else return " nothing of value.";
    }
    
    public static boolean straight(int first, int second, int third)
    {
	if(second - 1 == first && second + 1 == third)return true;
	if(first == 12 && second == 13 && third == 1)return true;
	if(first == 13 && second == 1 && third == 2)return true;
	else return false;
    }
}

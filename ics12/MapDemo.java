import java.awt.*;
import javax.swing.*;
import java.awt.event.*;  // Needed for ActionListener
import java.util.*;  // Needed for Scanner
import java.io.*; // file IO
public class MapDemo extends JFrame implements MouseListener, ActionListener{
	 Map map = new Map (40,30,20,20);
	 JComboBox itemBox;
	 JLabel label1 = new JLabel("Search Results:");
	 JLabel results = new JLabel("0");
	    //======================================================== constructor
	    public MapDemo ()
	    {
	        // 1... Create/initialize components
	        JButton searchBtn = new JButton ("Search");
	        searchBtn.addActionListener (this);
	        JButton saveBtn = new JButton ("Save");
	        saveBtn.addActionListener (this);
	        JButton loadBtn = new JButton ("Load");
	        loadBtn.addActionListener (this);
	        String list[] = {"Space","Wall","Treasure","Door","Key","Monster"};
	        itemBox = new JComboBox(list);

	        // 2... Create content pane, set layout
	        JPanel content = new JPanel ();        // Create a content pane
	        content.setLayout (new BorderLayout ()); // Use BorderLayout for panel
	        JPanel north = new JPanel (); // where the buttons, etc. will be
	        north.setLayout (new FlowLayout ()); // Use FlowLayout for input area

	        DrawArea board = new DrawArea (800, 600); // Area for cards to be displayed

	        // 3... Add the components to the input area.
	        north.add (searchBtn);
	        north.add(label1);
	        north.add(results);
	        north.add (saveBtn);
	        north.add (loadBtn);
	        north.add (itemBox);
	        content.add (north, "North"); // Input area
	        content.add (board, "Center"); // Deck display area

	        content.addMouseListener(this);

	        // 4... Set this window's attributes.
	        setContentPane (content);
	        pack ();
	        setTitle ("Map Demo");
	        setSize (850, 700);
	        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	        setLocationRelativeTo (null);           // Center window.
	    }

	    public void actionPerformed (ActionEvent e)
	    {
	    	
	        if (e.getActionCommand ().equals ("Search")) {
	        	String searchstr = "" + itemBox.getSelectedItem();
	        	char search = searchstr.charAt(0);
	        	int total = map.search (search); // search for and count items
	        	results.setText(""+total);
	        }
	        else if (e.getActionCommand ().equals ("Save"))
	        {
	        	JFileChooser chooser = new JFileChooser();
	        	chooser.setVisible(true);
	        	chooser.showSaveDialog(null);
	            // get file from JFileChooser
	        	try {
	        		map.save (chooser.getSelectedFile()); // save map
	        	}
	        	catch(Exception error) {
	        		System.out.print("dAB");
	        	}
	            
	        }
	        else if (e.getActionCommand ().equals ("Load"))
	        {
	        	JFileChooser chooser = new JFileChooser();
	        	
	        	chooser.setDialogTitle("Load");
	        	chooser.showDialog(null, "Load");
	        	chooser.setVisible(true);
	            // get file from JFileChooser
	        	try {
	        		 map.load (chooser.getSelectedFile()); // load map
	        	}
	            catch (Exception error) {
	            	System.out.print("bad");
	            }
	        }

	        repaint (); // do after each action taken to update deck
	    }

	    class DrawArea extends JPanel
	    {
	        public DrawArea (int width, int height)
	        {
	            this.setPreferredSize (new Dimension (width, height)); // size
	        }

	        public void paintComponent (Graphics g)
	        {
	            map.print (g);
	        }
	    }

	    // Must implement all methods from listener
	    public void mousePressed(MouseEvent e) {}

	    public void mouseReleased(MouseEvent e) {}

	    public void mouseEntered(MouseEvent e) {}

	    public void mouseExited(MouseEvent e) {}

	    public void mouseClicked(MouseEvent e) {
	    	
	    	String str = "" + itemBox.getSelectedItem();
	    	char add = str.charAt(0);
	    	int colindex = (e.getY()-35)/map.blockheight();
	    	int rowindex = e.getX()/map.blockwidth();
	    	map.add(colindex, rowindex, add);
	        repaint();
	    }    

	    //======================================================== method main
	    public static void main (String[] args)
	    {
	        MapDemo window = new MapDemo ();
	        window.setVisible (true);
	    }
}

class Map
{
    private char map [] [];
    private int width, height;

    public Map (int cols, int rows, int blockwidth, int blockheight) // set up default map
    {
        width = blockwidth;  height = blockheight;
        map = new char [rows] [cols]; // define 2-d array size

        for (int row = 0 ; row < rows ; row++)
            for (int col = 0 ; col <cols ; col++)
            {
                if (row == 0 || row == rows-1 || col == 0 || col == cols-1) 
                    map [row] [col] = 'W'; // put up a wall
                else
                    map [row] [col] = 'S'; // blank space
        }
        map[rows-1][cols/2] = 'D'; // make a door
        map[rows-1][cols/2+1] = 'D';
    }
    
    public int blockwidth() {
    	return width;
    }
    public int blockheight() {
    	return height;
    }
    

    public void print (Graphics g)  // displays the map on the screen
    {
        for (int row = 0 ; row < map.length; row++)// number of rows
        {
            for (int col = 0 ; col < map[0].length; col++)// length of first row
            {
                if (map [row] [col] == 'W') // wall
                    g.setColor (Color.black);
                else if (map [row] [col] == 'D') // door
                    g.setColor (Color.red);
                else if (map [row] [col] == 'M') // monster
                    g.setColor (Color.green);
                else if (map [row] [col] == 'T') // treasure
                    g.setColor (Color.yellow);
                else if (map [row] [col] == 'K') // key
                    g.setColor (Color.blue);
                else if (map [row] [col] == 'S') // space
                    g.setColor (Color.white);
                g.fillRect (col * width, row * height, width, height); // draw block
            }
        }
    }

    public void add(int x, int y, char item)
    {
    	if( x == 0 && item == 'W' ) {//if it's on the top and item selected is wall
    		for(int i = 0; i < map.length;i++) {
    			map[i][y] = 'W';//fill in entire column by toggling through every row
    		}
    	}
    	else if(y == 0 && item == 'W') {//if it's on the left and the item selected is wall
    		for(int i = 0; i<map[x].length;i++) {
    			map[x][i] = 'W';//fill entire row by toggling through each column
    		}
    	}
    	else {
    		map[x][y] = item;//other wise just fill in the square according
    	}
    	
    }

    public void save(File file) throws FileNotFoundException
    {
    	PrintWriter output = new PrintWriter(file);
    	for(int i = 0; i < map.length;i++) {
    		for(int j = 0; j < map[i].length; j++) {
    			output.print(map[i][j] + " ");//simply go through the entire array and print out the letters with space in between
    		}
    		output.println();//line spacing
    	}
    	output.close();
    }

    public void load(File file) throws FileNotFoundException
    {
    	Scanner sc = new Scanner(file);
    	String[][] infostr = new String[map.length][map[0].length];
    	for(int i = 0; i < 30;i++) {
    		infostr[i] = sc.nextLine().split(" ");//each row of characters is a string array
    	}
    	for(int i = 0; i < map.length;i++) {
    		for(int j = 0;j<map[0].length;j++) {
    			map[i][j] = infostr[i][j].charAt(0);//converting from the string array to char array
    		}
    	}
    }

    public int search(char ch)
    {
    	int counter = 0;//return value, intialize at 0
    	for (int i = 0; i < map.length;i++) {
    		for(int j = 0; j < map[i].length;j++) {
    			if(map[i][j] == ch) {//go through every index of array and if it matches increment the counter
    				counter++;
    			}
    		}
    	}
    	
    	return counter;
    }

}
	    

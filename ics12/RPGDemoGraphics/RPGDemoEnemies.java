import java.awt.*;
import javax.imageio.*; // allows image loading
import java.io.*; // allows file access
import javax.swing.*;
import java.awt.event.*;  // Needed for ActionListener

class RPGDemoEnemies extends JFrame implements KeyListener
{
    static Map map = new Map (40, 50, 20, 20); // create map, block size

    //======================================================== constructor
    public RPGDemoEnemies ()
    {
      // 1... Enable key listener for movement
      addKeyListener (this);
      setFocusable (true);
      setFocusTraversalKeysEnabled (false);

      // 2... Create graphics panel

      DrawArea board = new DrawArea (1200, 900); // Area for map to be displayed

      add (board); // map display area

      // 4... Set this window's attributes.
      pack ();
      setTitle ("RPG Demo");
      setSize (1200, 900);
      setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo (null);           // Center window.

      board.addKeyListener (this);
    }


    public void keyTyped (KeyEvent e)
    {
      // nothing
    }


    public void keyReleased (KeyEvent e)
    {
      // nothing
    }


    public void keyPressed (KeyEvent e)  // handle cursor keys and enter
    {
      int key = e.getKeyCode ();
      switch (key)
      {
        case KeyEvent.VK_UP:
          map.move (0, -1, 2);
          break;
        case KeyEvent.VK_DOWN:
          map.move (0, 1, 0);
          break;
        case KeyEvent.VK_LEFT:
          map.move (-1, 0, 3);
          break;
        case KeyEvent.VK_RIGHT:
          map.move (1, 0, 1);
          break;
        case KeyEvent.VK_ENTER:
          map.explode ();
          map.setDistance (10);
          break;
      }
      repaint ();
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

    //======================================================== method main
    public static void main (String[] args)
    {
      RPGDemoEnemies window = new RPGDemoEnemies ();
      window.setVisible (true);
    }
}


// -------------------------------------- Map Class ------------------------------------------------------

class Map
{
    private char map[] [];
    private int width, height, posx, posy, distance, dir=0;
    private Image brick;
    private Image image[] = new Image[8];

    public Map (int rows, int cols, int blockwidth, int blockheight)
    {
      width = blockwidth;
      height = blockheight;
      map = new char [rows] [cols]; // define 2-d array size

      for (int row = 0 ; row < rows ; row++)
        for (int col = 0 ; col < cols ; col++)
        {
          if (row == 0 || row == rows - 1 || col == 0 || col == cols - 1) // border
            map [row] [col] = 'W'; // put up a wall
          else
            map [row] [col] = ' '; // blank space
        }
      map [rows - 1] [cols / 2] = 'D'; // make a door
      map [rows - 1] [cols / 2 + 1] = 'D';
      
      addWall (); // add a wall
      loadImages();
      
      for(int x=1;x<=5;x++)
      {
        addTreasure();
        addMonster();
        addMonster();
      }
      
      posx = cols / 2 - 2;
      posy = rows - 2;
      distance = 5;
    }

    private void loadImages()
    {
        try
        {
          for(int x=0;x<4;x++)
            image[x] = ImageIO.read (new File ("character"+(x+1)+".png")); 
          image[4] = ImageIO.read (new File ("wall.png")); 
          image[5] = ImageIO.read (new File ("treasure.png")); 
          image[6] = ImageIO.read (new File ("door.png")); 
          image[7] = ImageIO.read (new File ("monster.png")); 
        }
        catch (IOException e)
        {
            System.out.println ("File not found");
        }
    }
      
    private int radius(int y, int x)
    {
      return (int)Math.round(Math.sqrt((posx-x)*(posx-x)+(posy-y)*(posy-y)));
    }

    public void print (Graphics g)    // displays the map on the screen
    {
      for (int row = 0 ; row < map.length ; row++) // number of rows
      {
        for (int col = 0 ; col < map [0].length ; col++) // length of first row
        {
          g.setColor (Color.black);
          g.fillRect (col * width + 10, row * height + 10, width, height); // draw block
          if(radius(row,col) <= distance)
          {
            if (map [row] [col] == 'W') // wall
              g.drawImage (image[4], col * width + 10, row * height + 10, null); // draw wall
            else if (map [row] [col] == 'T')  // door
              g.drawImage (image[5], col * width + 10, row * height + 10, null); // draw treasure
            else if (map [row] [col] == 'D') // treasure
              g.drawImage (image[6], col * width + 10, row * height + 10, null); // draw door
            else if (map [row] [col] == 'M') // monster
              g.drawImage (image[7], col * width + 10, row * height + 10, null); // draw monster
            else if (map [row] [col] == ' ') // space will erase what was there
            {
              g.setColor (Color.white);
              g.fillRect (col * width + 10, row * height + 10, width, height); // draw background block
            }
          }

        }
      }
      g.drawImage (image[dir], posx * width + 10, posy * height + 10, null); // draw character
    }

    public void addWall ()  // just a simple method for demo
    {
      for (int x = 0 ; x < map.length ; x++)
        map [x] [20] = 'W';
      map[10][20] = 'D';
      map[11][20] = 'D';
    }

    public void addTreasure ()  // adds treasure to random location
    {
      int row = (int) (Math.random () * (map.length - 2) + 1);
      int col = (int) (Math.random () * (map [0].length - 2) + 1);
      map [row] [col] = 'T';
    }
    
    public void addMonster ()  // adds treasure to random location
    {
      int row = (int) (Math.random () * (map.length - 2) + 1);
      int col = (int) (Math.random () * (map [0].length - 2) + 1);
      map [row] [col] = 'M';
    }

    public void move (int dx, int dy, int d)  // moves character if possible (no obstruction)
    {
      if (map [posy + dy] [posx + dx] == ' ') // empty space
      {
        posx += dx;
        posy += dy;
      }
      dir = d;
    }

    public void explode ()  // kills everything within one space of character
    {
      for (int x = -1 ; x <= 1 ; x++)
      {
        for (int y = -1 ; y <= 1 ; y++)
        {
          map [posy + y] [posx + x] = ' ';  // empty space
        }
      }
    }
    
    public void setDistance(int d) // illumination distance
    {
      distance = d;
    }
}


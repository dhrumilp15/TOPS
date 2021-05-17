import java.awt.*;
import java.awt.event.KeyEvent;

public class Tiefighter
{
    static int vel;
    static Graphics g;
    Color body;
    Color lines;
    static int tiex[] = {80,90,110,120,110,90};
    static int tiey[] = {70,50,50,70,90,90};
    static int startx = (tiex[3] + tiex[4])/2;
    static int starty = (tiey[3] + tiey[4])/2;
    static boolean up,left,down,right,space;
    static Improved_House house;

    public Tiefighter(Graphics g, Improved_House house)
    {
      this.g=g;
      this.house = house;
    }

    public void setVel(int v)
    {
      vel=v;
    }

    public void setColor(Color c,Color bigboi)
    {
      this.body = c;
      this.lines = bigboi;
    }

    public void render()
    {
      drawfighter();
      move();
      if(space == true)fire();
    }

    public static void keyPressed(KeyEvent e) {
      if (e.getKeyChar() == 'w' || e.getKeyCode() == KeyEvent.VK_UP)
      {
        up = true;
      }
      if (e.getKeyChar() == 's' || e.getKeyCode() == KeyEvent.VK_DOWN)
      {
        down = true;
      }
      if (e.getKeyChar() == 'a' || e.getKeyCode() == KeyEvent.VK_LEFT)
      {
        left = true;
      }
      if (e.getKeyChar() == 'd' || e.getKeyCode() == KeyEvent.VK_RIGHT)
      {
        right = true;
      }
      if (e.getKeyCode() == KeyEvent.VK_SPACE)
      {
        space = true;
      }
    }

    public static void keyReleased(KeyEvent e) {
      if (e.getKeyChar() == 'w' || e.getKeyCode() == KeyEvent.VK_UP)
      {
        up = false;
      }
      if (e.getKeyChar() == 's' || e.getKeyCode() == KeyEvent.VK_DOWN)
      {
        down = false;
      }
      if (e.getKeyChar() == 'a' || e.getKeyCode() == KeyEvent.VK_LEFT)
      {
        left = false;
      }
      if (e.getKeyChar() == 'd' || e.getKeyCode() == KeyEvent.VK_RIGHT)
      {
        right = false;
      }
      if (e.getKeyCode() == KeyEvent.VK_SPACE)
      {
        space = false;
      }
    }

    private static void move()
    {
      int deltax = 0,deltay = 0;
      if (up == true)deltay=-vel;
      if (down == true)deltay=vel;
      if (left == true)deltax=-vel;
      if (right == true)deltax=vel;

      for (int i = 0, length = tiex.length; i < length; i++)
      {
        tiex[i] += deltax;
        tiey[i] += deltay;
      }
    }

    private static void fire()
    {
      int bs = 15;
      g.setColor(Color.green);
      if(space == true)
      {
        g.drawLine(startx,starty,startx + bs,starty);
        startx+=bs;
      }
      if(space == false || startx >= house.getWidth() || startx <= 0)
      {
        startx = (tiex[3] + tiex[4])/2;
        starty = (tiey[3] + tiey[4])/2;
      }
    }

    public void drawfighter()
    {
      g.setColor(body);
      g.fillPolygon(tiex,tiey,tiex.length);

      g.setColor(lines);
      for (int i = 0; i < (tiex.length/2); i++)
      {
        g.drawLine(tiex[i],tiey[i],tiex[i+ tiex.length/2],tiey[i+ tiex.length/2]);
      }
      g.fillOval((tiex[tiex.length/2] + tiex[0])/2-5,(tiey[tiey.length/2] + tiey[0])/2-5,10,10);
    }
}

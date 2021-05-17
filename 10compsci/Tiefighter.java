/*
Dhrumil Patel
Oct 2018
ICS2O3
Compliment to Improved_House
*/
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
    static boolean p1up,p1left,p1down,p1right,p1space;
    static boolean p2up,p2left,p2down,p2right,p2space;
    
    static int tie2x[] = {180,190,210,220,210,190};
    static int tie2y[] = {70,50,50,70,90,90};
    
    static int start2x = (tie2x[0] + tie2x[5])/2;
    static int start2y = (tie2y[0] + tie2y[5])/2;
    
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
      if(p1space == true)fire();
      if(p2space == true)fire2();
      //collision();
    }

    public static void keyPressed(KeyEvent e) {
      if (e.getKeyChar() == 'w' || e.getKeyChar() == 'W')
      {
	p1up = true;
      }
      if (e.getKeyChar() == 's' || e.getKeyChar() == 'S')
      {
	p1down = true;
      }
      if (e.getKeyChar() == 'a' || e.getKeyChar() == 'A')
      {
	p1left = true;
      }
      if (e.getKeyChar() == 'd' || e.getKeyChar() == 'D')
      {
	p1right = true;
      }
      if (e.getKeyCode() == KeyEvent.VK_SPACE)
      {
	p1space = true;
      }
      
      if (e.getKeyCode() == KeyEvent.VK_UP)
      {
	p2up = true;
      }
      if (e.getKeyCode() == KeyEvent.VK_DOWN)
      {
	p2down = true;
      }
      if (e.getKeyCode() == KeyEvent.VK_LEFT)
      {
	p2left = true;
      }
      if (e.getKeyCode() == KeyEvent.VK_RIGHT)
      {
	p2right = true;
      }
      if (e.getKeyChar() == 'm')
      {
	p2space = true;
      }
    }

    public static void keyReleased(KeyEvent e) {
      if (e.getKeyChar() == 'w' || e.getKeyChar() == 'W')
      {
	p1up = false;
      }
      if (e.getKeyChar() == 's' || e.getKeyChar() == 'S')
      {
	p1down = false;
      }
      if (e.getKeyChar() == 'a' || e.getKeyChar() == 'A')
      {
	p1left = false;
      }
      if (e.getKeyChar() == 'd'|| e.getKeyChar() == 'D')
      {
	p1right = false;
      }
      if (e.getKeyCode() == KeyEvent.VK_SPACE)
      {
	p1space = false;
      }
      
      if (e.getKeyCode() == KeyEvent.VK_UP)
      {
	p2up = false;
      }
      if (e.getKeyCode() == KeyEvent.VK_DOWN)
      {
	p2down = false;
      }
      if (e.getKeyCode() == KeyEvent.VK_LEFT)
      {
	p2left = false;
      }
      if (e.getKeyCode() == KeyEvent.VK_RIGHT)
      {
	p2right = false;
      }
      if (e.getKeyChar() == 'm')
      {
	p2space = false;
      }
    }

    private static void move()
    {
      int deltax = 0,deltay = 0;
      if (p1up == true)deltay=-vel;
      if (p1down == true)deltay=vel;
      if (p1left == true)deltax=-vel;
      if (p1right == true)deltax=vel;

      for (int i = 0, length = tiex.length; i < length; i++)
      {
	tiex[i] += deltax;
	tiey[i] += deltay;
      }
      int delta2x = 0,delta2y = 0;
      if (p2up == true)delta2y=-vel;
      if (p2down == true)delta2y=vel;
      if (p2left == true)delta2x=-vel;
      if (p2right == true)delta2x=vel;

      for (int i = 0, length = tie2x.length; i < length; i++)
      {
	tie2x[i] += delta2x;
	tie2y[i] += delta2y;
      }
    }

    private static void fire()
    {
      int bs = 15;
      g.setColor(Color.green);
      if(p1space == true)
      {
	g.drawLine(startx,starty,startx + bs,starty);
	startx+=bs;
      }
      if(p1space == false || startx >= house.getWidth() || startx <= 0)
      {
	startx = (tiex[3] + tiex[4])/2;
	starty = (tiey[3] + tiey[4])/2;
      }
    }
    
    private static void fire2()
    {
      int bs = 15;
      g.setColor(Color.red);
      if(p2space == true)
      {
	g.drawLine(start2x,start2y,start2x - bs,start2y);
	start2x-=bs;
      }
      if(p2space == false || start2x >= house.getWidth() || start2x <= 0)
      {
	start2x = (tie2x[0] + tie2x[5])/2;
	start2y = (tie2y[0] + tie2y[5])/2;
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
    
      g.setColor(body);
      g.fillPolygon(tie2x,tie2y,tie2x.length);

      g.setColor(lines);
      for (int i = 0; i < (tie2x.length/2); i++)
      {
	g.drawLine(tie2x[i],tie2y[i],tie2x[i+ tiex.length/2],tie2y[i+ tiex.length/2]);
      }
      g.fillOval((tie2x[tie2x.length/2] + tie2x[0])/2-5,(tie2y[tie2y.length/2] + tie2y[0])/2-5,10,10);
    }
}

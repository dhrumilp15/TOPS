/*
Dhrumil Patel
Oct 2018
ICS2O3
PD_Improved_House
*/
import java.awt.*;
import hsa.Console;
import javax.imageio.*;
import java.io.*;
import java.awt.Panel;
import java.awt.image.BufferedImage;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PD_Improved_House extends Console
{
    static PD_Improved_House house;
    static KeyListener listener;
    static Panel panel;

    public static void main (String[] args)
    {
      house = new PD_Improved_House();
      panel = house.consoleCanvasPanelInner;
      panel.addKeyListener(listener);
      BufferedImage bi = new BufferedImage(house.getWidth (), house.getHeight (), BufferedImage.TYPE_INT_ARGB);
      Graphics g = bi.getGraphics();
      PD_Tiefighter tf = new PD_Tiefighter(g,house);
      tf.setColor(Color.black, Color.gray);
      tf.setVel(2);

      while(!tf.collision())
      {
      	house.drawImage(bi,0,0,null);
      	bkg_gradient(g);
      	backclouds(g);
      	city(g);
      	midclouds(g);
      	frontclouds(g);
      	deathstar(g);
      	tf.render();
      }
      gameOver(g);
      house.drawImage(bi,0,0,null);
    }

    public static void gameOver(Graphics g)
    {
      g.clearRect(0,0,640,640);
      g.drawString("GAME OVER",290,250);
      if(g.getColor() == Color.red)
      {
        g.drawString("p2 win!",300,270);
      }
      else if (g.getColor() == Color.green)
      {
        g.drawString("p1 win!",300,270);
      }
      else
      {
        g.setColor(Color.white);
        g.drawString("Neither of you won. What?... I mean... what do you expect if you crash into each other like that?",75,270);
      }
    }

    public void keyPressed(KeyEvent e) {
      PD_Tiefighter.keyPressed(e);
    }

    public void keyReleased(KeyEvent e) {
      PD_Tiefighter.keyReleased(e);
    }

    public static void city(Graphics g)
    {
      g.setColor(new Color(91,125,163));
      g.fillRect(325,240,10,25);

      g.setColor(new Color(204,204,204));
      g.fillRect(325,265,10,110);
      g.setColor(new Color(86,114,162));
      int[] btraph = {325,300,360,335};
      int[] btrapv = {240,200,200,240};
      g.fillPolygon(btraph,btrapv,btraph.length);

      int x1 = 295;
      int x2 = 365;
      int y1 = 200;
      int y2 = 207;
      for (int i = 0; i < 5; i++)
      {
       g.setColor(new Color(86,114,162));
       int[] h = {x1,x2,x2,x1};
       int[] v = {y1,y1,y2,y2};
       g.fillPolygon(h,v,4);
       x1 += 5;
       x2 -= 5;
       y1+= 7;
       y2+= 7;
      }

      //Bottom sector
      g.setColor(new Color(73,98,154));
      g.fillArc(165,150,335,55,0,-180);

      g.setColor(new Color(81,110,158));
      int[] bigtraph = {155,163,500,510};
      int[] bigtrapv = {167,175,175,167};
      g.fillPolygon(bigtraph,bigtrapv,4);

      //Leftmost bottom arc
      g.setColor(new Color(209,210,215));
      g.fillArc(108,152,32,24,90,90);

      //Lowest rectangle
      // 209,210,215 --> 91,120,168
      //118,90,47
      for (int i = 0, steps = 100; i < steps; i++)
      {
	Color gradcol = new Color((int)(91 + i*(118.0/steps)), (int)(120 + i*(90.0/steps)),(int)(168 + (i*(47.0/steps))));
	g.setColor(gradcol);
	g.fillRect(124,152,(int)(207.0 - i*(207.0/steps)), 12);
      }
      // 159,175,198 --> 91,120,168
      //68,55,30
      for (int i = 0, steps = 100; i < steps; i++)
      {
	Color gradcol = new Color((int)(159.0 - i*(68.0/steps)), (int)(175.0 - i*(55.0/steps)),(int)(198.0 - i*(30.0/steps)));
	g.setColor(gradcol);
	g.fillRect(331,152,(int)(207.0 - i*(207.0/steps)), 12);
      }

      //Rightmost bottom arc
      g.setColor(new Color(159,175,198));
      g.fillArc(522,152,32,24,90,-90);

      g.setColor(new Color(203,203,203));
      int[] trih = {124,143,143};
      int[] triv = {152,138,152};
      g.fillPolygon(trih,triv,trih.length);

      g.setColor(new Color(162,179,205));
      int[] tri2h = {519,519,538};
      int[] tri2v = {152,138,152};
      g.fillPolygon(tri2h,tri2v,trih.length);

      for (int i = 0, steps = 100; i < steps; i++)
      {
	Color gradcol = new Color((int)(91 + i*(112.0/steps)), (int)(120 + i*(83.0/steps)),(int)(168 + (i*(35.0/steps))));
	g.setColor(gradcol);
	g.fillRect(143,138,(int)(188.0 - i*(188.0/steps)), 14);
      }

      for (int i = 0, steps = 100; i < steps; i++)
      {
	Color gradcol = new Color((int)(162.0 - i*(71.0/steps)), (int)(179.0 - i*(59.0/steps)),(int)(205.0 - i*(37.0/steps)));
	g.setColor(gradcol);
	g.fillRect(331,138,(int)(188.0 - i*(188.0/steps)), 14);
      }

      //88,114,149 --> 78,100,150
      for (int i = 0, steps = 100; i < steps; i++)
      {
	Color gradcol = new Color((int)(78 + i*(10.0/steps)), (int)(100 + i*(14.0/steps)),(int)(150 + (i*(1.0/steps))));
	g.setColor(gradcol);
	g.fillRect(153,130,(int)(173.5 - i*(173.5/steps)), 7);//500,130
      }
      //78,100,150 --> 105, 138, 173
      for (int i = 0, steps = 100; i < steps; i++)
      {
	Color gradcol = new Color((int)(105.0 - i*(27.0/steps)), (int)(138.0 - i*(38.0/steps)),(int)(173.0 - i*(23.0/steps)));
	g.setColor(gradcol);
	g.fillRect(326,130,(int)(173.5 - i*(173.5/steps)), 7);
      }

      g.setColor(new Color(208,204,201));
      int[] triangleh = {153,260,260};
      int[] trianglev = {130,110,130};
      g.fillPolygon(triangleh,trianglev,triangleh.length);

      g.setColor(new Color(156,172,198));
      int[] triangle2h = {397,397,500};
      int[] triangle2v = {130,110,130};
      g.fillPolygon(triangle2h,triangle2v,triangle2h.length);

      //208,204,201 --> 156,172,198
      for (int i = 0, steps = 100; i < steps; i++)
      {
	Color gradcol = new Color((int)(156 + i*(52.0/steps)), (int)(172 + i*(32.0/steps)),(int)(198 + (i*(3.0/steps))));
	g.setColor(gradcol);
	g.fillRect(260,109,(int)(137.0 - i*(137.0/steps)), 21);
      }

      //skyline: range(260,397) domain(110,w] hehe did you notice the square bracket there teehee
      g.setColor(new Color(169,184,205));

      int[] skylineh = {262,267,267,269,269,274,274,277,277,283,283,288,288,291,291,293,293,317,317,320,320,321,321,324,324,326,326,329,329,331,331,332,333,333,334,334,337,337,341,341,346,346,353,353,357,357,359,359,367,367,371,371,373,376,377,379,379,387,387,389,389,393,394,394};
      int[] skylinev = {108,108,94 ,94 ,108,108,98 ,98 ,108,108,98 ,98 ,108,108,102,103,108,108,102,102,105,105,101,101,105,105,98 ,98 ,104,104,82 ,78 ,82 ,105,105,98 ,98 ,106,106,98 ,98 ,103,103,98 ,98 ,103,103,98 ,98 ,88 ,88 ,102,98 ,98 ,106,106,93 ,93 ,107,107,97 ,93 ,97 ,110};
      g.fillPolygon(skylineh,skylinev,skylineh.length);

      g.fillArc(295,103,21,10,0,180);
      g.fillOval(329,86,6,4);

      //oh my - is that the Toronto skyline?!
    }

    public static void bkg_gradient(Graphics g)
    {
      g.setColor(new Color(96,123,178));
      g.fillRect(0,0,640,500);
      for (int i = 0; i < 96; i++)
      {
	       g.setColor(new Color(136 - i, 163 - i, 218 - i));
	       g.fillRect(0,0,house.getWidth(), house.getHeight() - i*10);
      }
    }

    public static void deathstar(Graphics g)
    {
      g.setColor(new Color(75,94,125));
      g.fillOval(25,10,100,100);

      g.setColor(Color.black);
      g.fillRect(26,60,98,3);

      g.setColor(new Color(50,50,50));
      g.fillRect(26,55,98,5);
      g.fillRect(26,63,98,5);

      g.setColor(new Color(75,75,75));
      g.fillArc(25,10,100,100,80,200);

      g.setColor(new Color(80,80,80));
      g.fillOval(85,25,25,25);

      g.setColor(Color.green);
      g.fillOval(98,25,3,3);
      g.fillOval(89,44,3,3);
      g.fillOval(106,44,3,3);
      g.fillOval(97,35,6,6);

    }

    public static void backclouds(Graphics g)
    {
      g.setColor(new Color(210, 210, 230));
      int lastvarb = 640;
      int bh[] = {160,
	       160,170,175,180,196,210,216,221,230,235,257,263,267,274,278,286,303,311,321,324,330,337,345,349,357,361,365,367,379,385,400,402,409,414,427,431,437,445,457,468,480,488,495,510,525,530,540,545,560,576,580,592,640,
	 lastvarb};
      int bv[] = {house.getHeight(),
	       330,326,320,324,320,325,322,330,331,336,336,327,329,324,336,340,343,336,338,344,345,330,315,315,306,304,310,307,312,298,287,282,283,277,278,273,280,270,260,266,264,266,275,267,286,280,268,288,285,285,280,280,270,
	 house.getHeight()};
      g.fillPolygon(bh,bv,bh.length);
    }

    public static void midclouds(Graphics g)
    {
      g.setColor(new Color(227, 227, 237));
      int lastvarm = 640;
      int mh[] = {157,
	       157,190,200,222,257,240,243,251,263,270,283,287,286,284,295,300,310,315,330,355,390,440,465,485,493,510,520,534,560,580,594,604,614,627,632,640,
      lastvarm};
      int mv[] = {house.getHeight(),
	       332,330,330,340,352,363,361,355,356,350,353,351,354,363,361,367,370,360,365,375,365,360,375,368,372,374,370,382,375,378,375,372,379,373,382,370,
	house.getHeight()};
      g.fillPolygon(mh,mv,mh.length);
    }

    public static void frontclouds(Graphics g)
    {
	    g.setColor(new Color(240, 240, 240));
      int lastvarf = 638;
      int fh[] = {0,
	0,10,20,24,38,50,75,80,100,110,127,142,136,141,130,149,151,160,200,225,250,260,310,350,375,415,438,495,538,575,613,625,638,
	lastvarf};
      int fv[] = {house.getHeight(),
	246,260,254,263,260,250,257,250,260,247,244,260,270,280,295,306,312,338,388,375,380,408,413,408,435,450,436,438,440,450,475,475,475,
	house.getHeight()};
      g.fillPolygon(fh,fv,fh.length);
    }
/*
    public static void gridmarkers(Graphics g)
    {
      g.setColor(Color.red);
      for (int i = 50; i < 500; i += 50)
	{
	    g.drawLine(0,i,10,i);
	}
	for (int i = 50; i < 640; i += 50)
	{
	    g.drawLine(i,0,i,10);
	}
    }
    */
}

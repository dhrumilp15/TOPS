package blastoff;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.io.*;
import hsa.Console;
import java.lang.Math;

public class PD_Blastoff extends Console
{
    static PD_Blastoff blastoff;
    static Panel panel;
    
    public PD_Blastoff(int height, int width)
    {
    	super(height,width);
    }
    
    public static BufferedImage loadImage(String filename)
    {
      BufferedImage img = null;
		try {
			img = ImageIO.read(new File(filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
      return img;
    }
    
    public static void delay(int time)
    {
    	try
    	{
    		Thread.sleep(time);
    	} catch(InterruptedException e)
    	{
    		e.printStackTrace();
    	}
    }
    public static void main (String[] args)
    {
    	blastoff = new PD_Blastoff(24,80);
    	panel = blastoff.consoleCanvasPanelInner;
    	BufferedImage layer = new BufferedImage(blastoff.getWidth (), blastoff.getHeight (), BufferedImage.TYPE_INT_ARGB);
    	Graphics g2 = (Graphics2D)layer.createGraphics();    	

   		BufferedImage bite = loadImage("src/signs/bite.jpg");
    	g2.drawImage(bite, 0, 0, null);
    	blastoff.drawImage(layer, 0, 0, null);
    	
    	PD_Sound kuchiyose = new PD_Sound("src/audio/kuchiyosenojutsu.wav");
    	kuchiyose.play();

    	String[] signs = {"boar.jpg", "dog.png", "birdn.jpg", "monkey.jpg", "ram.jpg", "finalg.png"};
    	
    	for (int i = 0; i < signs.length; i++)
    	{
    		BufferedImage img = loadImage("src/signs/" + signs[i]);
    		g2.drawImage(img, 0, 0, null);
    		blastoff.drawImage(layer, 0, 0, null);
    		g2.clearRect(0,0,640,480);
    		delay(250);
    	}
    	delay(125);
		
		PD_Sound boom = new PD_Sound("src/audio/summonboom.wav");
		boom.play();
		PD_Sound track = new PD_Sound("src/audio/track.wav");
		track.play();
		
		for(int i = 1; i < 4; i++)
		{
			BufferedImage img = null;
			if(i == 1)
			{
				img = loadImage("src/intro/intro" + Integer.toString(i) + ".jpg");
			}
			else
			{
				img = loadImage("src/intro/intro" + Integer.toString(i) + ".png");
			}

			g2.drawImage(img,0,0,null);
			blastoff.drawImage(layer, 0, 0, null);
			g2.clearRect(0,0,640,480);
			delay(275);
		}
		
		for(int i = 1; i < 48; i++)
		{
			if(i == 12) i = 16;
			BufferedImage img = loadImage("src/narutointro/nintro" + Integer.toString(i) + ".png");
			g2.drawImage(img,0,0,null);
			blastoff.drawImage(layer, 0, 0, null);
			g2.clearRect(0, 0, 640, 480);
			if(i == 4 || i == 11)
			{
				delay(400);
			}
			else
			{
				delay(33);
			}
		}
		
		for(int i = 44; i < 49; i++)
		{
			BufferedImage img = loadImage("src/gamajumps/gamajumps" + Integer.toString(i) + ".png");
			g2.drawImage(img,0,0,null);
			blastoff.drawImage(layer, 0, 0, null);
			g2.clearRect(0, 0, 640, 480);
			delay(33);
		}
		
		BufferedImage background = loadImage("src/ground/background.jpg");
		
		BufferedImage gamabunta = loadImage("src/gamabunta.png");
		
		int zerotimes = 0;
		int bigloop = 100;
		
		for(int x = 640; x > -40; x--)
		{
			int y = (int)(Math.sin(Math.toRadians(1.5*x)) * 125 + 125);
			g2.drawImage(background, 0, 0, null);
			g2.drawImage(gamabunta, x, y, null);
			if(x == 400 || x == 200 || x == 1)
			{
				if(zerotimes == 0)
				{
					for(int i = 3; i < 42; i++)
					{
						if(i==6)i=8;
						if(i==12)i=23;
						BufferedImage img = loadImage("src/sasukerunning/sasukerunning" + Integer.toString(i) + ".png");
						g2.drawImage(img,0,0,null);
						blastoff.drawImage(layer, 0, 0, null);
						g2.clearRect(0, 0, 640, 480);
						delay(bigloop);
					}
				}

				if (zerotimes == 1)
				{					
					for(int i = 3; i < 67; i++)
					{
						if(i == 9) i = 16;
						if(i == 20) i = 56;
						BufferedImage img = loadImage("src/sasukefireballsigns/sasukefireballsigns" + Integer.toString(i) + ".png");
						g2.drawImage(img,0,0,null);
						blastoff.drawImage(layer, 0, 0, null);
						g2.clearRect(0, 0, 640, 480);
						delay(bigloop);
					}
					

					for(int i = 7; i < 18; i++)
					{
						if(i == 13)i = 14;
						BufferedImage img = loadImage("src/gamaattac/gamajump" + Integer.toString(i) + ".png");
						g2.drawImage(img,0,0,null);
						blastoff.drawImage(layer, 0, 0, null);
						g2.clearRect(0, 0, 640, 480);
						delay(bigloop);
					}
				}
				
				if(zerotimes == 2)
				{
					for(int i = 1; i < 19; i++)
					{
						BufferedImage img = loadImage("src/sasukefireball/sasukefireball" + Integer.toString(i) + ".png");
						g2.drawImage(img,0,0,null);
						blastoff.drawImage(layer, 0, 0, null);
						g2.clearRect(0, 0, 640, 480);
						delay(bigloop);
					}
					
					for(int i = 7; i < 18; i++)
					{
						if(i == 13)i = 14;
						BufferedImage img = loadImage("src/gamaattac/gamajump" + Integer.toString(i) + ".png");
						g2.drawImage(img,0,0,null);
						blastoff.drawImage(layer, 0, 0, null);
						g2.clearRect(0, 0, 640, 480);
						delay(bigloop);
					}
				}
				zerotimes++;
			}
			blastoff.drawImage(layer,0,0,null);
		}
		
		for(int i = 1; i < 32; i++)
		{
			if(i==4)i=10;
			BufferedImage img = loadImage("src/gamaland/gamaland" + Integer.toString(i) + ".png");
			g2.drawImage(img,0,0,null);
			blastoff.drawImage(layer, 0, 0, null);
			g2.clearRect(0, 0, 640, 480);
			delay(bigloop);
		}
		g2.clearRect(0,0,640,480);		
		g2.setColor(Color.WHITE);
		g2.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 72));
		int x = 0;
		int y = 0;
		int dx = 1;
		int dy = 1;

		while(true)
		{
			if (x + dx < 0)
				dx = 1;
			if (x + dx > blastoff.getWidth() - 300)
				dx = -1;
			if (y + dy < 0)
				dy = 1;
			if (y + dy > blastoff.getHeight() - 30)
				dy = -1;
			
			x = x + dx;
			y = y + dy;
			g2.drawString("THE END", x, y);
			blastoff.drawImage(layer, 0, 0, null);
			g2.clearRect(0,0,640,480);
		}
    }
}

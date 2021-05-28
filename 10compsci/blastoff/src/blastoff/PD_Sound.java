package blastoff;

import javax.sound.sampled.*;
import java.io.*;
import java.net.*;

public class PD_Sound
{
	private Clip clip;
	
	public PD_Sound()
	{
		
	}
	
	public PD_Sound(String filename)
	{		
		File file = new File(filename);
		try
		{
			if(file.exists())
			{
				AudioInputStream sound = AudioSystem.getAudioInputStream(file);
				clip = AudioSystem.getClip();
				clip.open(sound);
			}
	    }
		catch (UnsupportedAudioFileException e) {
	        e.printStackTrace();
	    }
		catch (MalformedURLException e) {
	        e.printStackTrace();
	    }
		catch (IOException e) {
	        e.printStackTrace();
	    }
		catch (LineUnavailableException e) {
	        e.printStackTrace();
	    }
  }

  public void play()
  {
    clip.setFramePosition(0);
    clip.start();
  }

  public void loop()
  {
	  clip.loop(Clip.LOOP_CONTINUOUSLY);
  }

  public void stop()
  {
    clip.stop();
  }
}

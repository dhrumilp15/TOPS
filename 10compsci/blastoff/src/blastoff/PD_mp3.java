package blastoff;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javazoom.jl.converter.Converter;
import javazoom.jl.decoder.JavaLayerException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class PD_mp3 extends PD_Sound{

	private File file = null;
	private Clip clip;
	
	public PD_mp3(String filename) throws FileNotFoundException, JavaLayerException, UnsupportedAudioFileException, LineUnavailableException, IOException {
		loadFile(filename);
		Converter converter = new Converter();
		File ret = null;
		try {
			ret = File.createTempFile("temp", ".wav");
		} catch (IOException e) {
			e.printStackTrace();
		}
		converter.convert(file.getPath(), ret.getPath());
		
		if (ret.exists()) {
			AudioInputStream sound = AudioSystem.getAudioInputStream(ret);
			clip = AudioSystem.getClip();
			clip.open(sound);
		}
	}
	
	private void loadFile(String filename) {
		file = new File(filename);
	}
	
	public void play()
	  {
	    clip.setFramePosition(0);
	    clip.start();
	  }
	
}
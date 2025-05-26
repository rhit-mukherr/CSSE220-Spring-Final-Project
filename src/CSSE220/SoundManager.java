package CSSE220;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundManager {
	
	
	
	private Clip sound;
	
	public SoundManager() {
		try {
			File soundFile = new File("src/CSSE220/sounds/mixkit-wood-hard-hit-2182.wav");
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
			sound= AudioSystem.getClip();
			sound.open(audioIn);
		} catch(IOException e) {
			System.err.println("Failed loading sound" + e.getMessage());
			
		} catch(Exception e) {
			System.err.println("Error loading sound: " + e.getMessage());
		}
	}
	
	public void playWallHit() {
		if(sound == null) return;
		if(sound.isRunning()) {
			sound.stop();
		}
		
		sound.setFramePosition(0);
		sound.start();
	}
	
	public void stopWallHit() {
		if(sound!= null&& sound.isRunning()) {
			sound.stop();
		}
	}

	public void playPowerUp() {
		// TODO Auto-generated method stub
		
	}
	
}

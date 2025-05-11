package CSSE220;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class InputHandler implements KeyListener {
	
	private Maze maze;
	public InputHandler(Maze maze){
		this.maze = maze;	
	}
	@Override
	public void keyPressed(KeyEvent e) {
		 int dx = 0;	
		 int dy = 0;	
		 
		 if ( e.getKeyCode() == KeyEvent.VK_RIGHT){
			 	try {
					URL url = new URL("");
					Clip clip = AudioSystem.getClip();
					AudioInputStream ais = AudioSystem.getAudioInputStream(url);
					clip.open(ais);
					clip.start();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			 dx = 1;
			 dy = 0;
		 } else if ( e.getKeyCode() == KeyEvent.VK_LEFT){
			 try {
					URL url = new URL("");
					Clip clip = AudioSystem.getClip();
					AudioInputStream ais = AudioSystem.getAudioInputStream(url);
					clip.open(ais);
					clip.start();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			 //System.out.println("left");
			 dx = -1;	
			 dy = 0;
		 } else if (e.getKeyCode() == KeyEvent.VK_UP) {
			 try {
					URL url = new URL("");
					Clip clip = AudioSystem.getClip();
					AudioInputStream ais = AudioSystem.getAudioInputStream(url);
					clip.open(ais);
					clip.start();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			 //System.out.println("up");
			 dx = 0;	
			 dy = -1;
		 } else if ( e.getKeyCode() == KeyEvent.VK_DOWN){
			 try {
					URL url = new URL("");
					Clip clip = AudioSystem.getClip();
					AudioInputStream ais = AudioSystem.getAudioInputStream(url);
					clip.open(ais);
					clip.start();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			 //System.out.println("down");
			 dx = 0;	
			 dy = 1;
		 } else {	
			 return;
		 }
		 if (maze.isValid(dx, dy)) {
			 maze.currentCell(dx, dy);
		 }
	}
	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
}


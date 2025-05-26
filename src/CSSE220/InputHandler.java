package CSSE220;

import java.awt.Point;
import java.awt.event.KeyEvent;


import java.awt.event.KeyListener;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


/**
 * this class handles arrow-key input to move the player
 * 
 */

public class InputHandler implements KeyListener {

	private Maze maze;
	private Player player;
	private SoundManager sound;

	public InputHandler(Maze maze, Player player, SoundManager sound) {
		this.maze = maze; 
		this.player = player;
		this.sound = sound;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
	
	/**
	 * called when the key is pressed 
	 * and move the player if the player is within the 
	 * boundary
	 */
	

	@Override
	public void keyPressed(KeyEvent e) {
		
		Point before = new Point(player.getPosition());

		switch(e.getKeyCode()){
			case KeyEvent.VK_UP: 
				player.move(0,-1,maze); 
				break;
			case KeyEvent.VK_DOWN: 
				player.move(0,+1,maze);
				break;
			case KeyEvent.VK_RIGHT: 
				player.move(+1,0,maze);
				break;
			case KeyEvent.VK_LEFT: 
				player.move(-1,0,maze);
				break;
 
		}
		
		Point after = player.getPosition();
		
		if(after.equals(before)){
			sound.playWallHit();
		} else {
			
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}
}

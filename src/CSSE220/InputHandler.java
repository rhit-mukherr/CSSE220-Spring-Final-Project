package CSSE220;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class InputHandler implements KeyListener {

	private Maze maze;
	private Player player;

	public InputHandler(Maze maze, Player player) {
		this.maze = maze; 
		this.player = player;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
			case KeyEvent.VK_UP: player.move(0,-1,maze); 
			break;
			case KeyEvent.VK_DOWN: player.move(0,+1,maze);
			break;
			case KeyEvent.VK_RIGHT: player.move(+1,0,maze);
			break;
			case KeyEvent.VK_LEFT: player.move(-1,0,maze);

 
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}
}

package CSSE220;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class InputHandler implements KeyListener {

	/*private Maze maze;
	private Player player;

	public InputHandler(Maze maze, Player player) {
		this.maze = maze;
		this.player = player;
	}123


	@Override
	public void keyPressed(KeyEvent e) {
		int dx = 0;
		int dy = 0;

		int currentRow = player.getCurrentCell().getRow();
		int currentCol = player.getCurrentCell().getCol();

		switch (e.getKeyCode()) {
		case KeyEvent.VK_RIGHT:
			dx = 1;
			break;
		case KeyEvent.VK_LEFT:
			dx = -1;
			break;
		case KeyEvent.VK_UP:
			dy = -1;
			break;
		case KeyEvent.VK_DOWN:
			dy = 1;
			break;
		default:
			return;
		}

			int newCol = currentCol + dx;
			int newRow = currentRow + dy;
			
			if(isValidMove(newRow, newCol)) {
				movePlayer(newRow, newCol);
			}
	}
	
	
    }


				// play sound 
				try {
					URL url = new URL("");
					Clip clip = AudioSystem.getClip();
					AudioInputStream ais = AudioSystem.getAudioInputStream(url);
					clip.open(ais);
					clip.start();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}*/
	
	public InputHandler(Maze maze, Player player) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}

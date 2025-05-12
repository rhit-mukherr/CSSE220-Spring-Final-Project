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
	
	private boolean isValidMove(int row, int col) {
		return row >= && row < maze.getRows() &&
				col >= 0 && col < maze.getCols() &&
	               !maze.isWall(row, col);
	    }
	
	private void movePlayer(int newRow, int newCol) {
        try {
            Cell nextCell = maze.getCell(newRow, newCol);
            player.setCurrentCell(nextCell);
            playMoveSound();
        } catch (Exception ex) {
            System.err.println("Error moving player: " + ex.getMessage());
        }
	
    private void playMoveSound() {
    	try {
    		
    	}
    }

			// ensuring in bounds
			if (newRow >= 0 && newRow < maze.getRows() 
					&& newCol >= 0 && newCol < maze.getCols()
					&& !maze.isWall(newRow, newCol)) {

				Cell nextCell = maze.getCell(newRow, newCol);
				player.setCurrentCell(nextCell);

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
		}
	
	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}
}

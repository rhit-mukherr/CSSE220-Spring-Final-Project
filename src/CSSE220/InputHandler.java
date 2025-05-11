package CSSE220;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener{
	
	private Player player;
	private Maze maze;
	
	public InputHandler(Player player, Maze maze) {
		this.player = player;
		this.maze = maze;
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		switch(e.getKeyCode()) {
		case KeyEvent.VK_UP:
			player.move(0, -1, maze);
			break;	
			
		case KeyEvent.VK_DOWN:
			player.move(0, +1, maze);
			break;
			
		case KeyEvent.VK_RIGHT:
			player.move(+1, 0, maze);
			break;
			
		case KeyEvent.VK_LEFT:
			player.move(-1,0, maze);
			break;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}

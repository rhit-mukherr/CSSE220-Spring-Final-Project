package CSSE220;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

public class MazePanel extends JPanel{
	
	public static final String JackSprite = "jack";
	public static final String WalleSprite = "wall-e";
	public static final String DavidSprite = "david";
	
	private Maze maze;
	private static final int CELL_SIZE = 32;
	private Player player;
	
	
	public MazePanel(Maze maze, Player player) {
		this.maze = maze;
		this.player = player;
		
		
		int width = maze.getCols() * CELL_SIZE;
		int height = maze.getRows() * CELL_SIZE;
		setPreferredSize(new Dimension(width, height));
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		
		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		
		for (int r = 0; r < maze.getRows(); r++) {
            for (int c = 0; c < maze.getCols(); c++) {
                if (maze.isWall(r, c)) {
                    g.setColor(Color.GRAY);
                    g.fillRect(c * CELL_SIZE, r * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                }
            }
        }
		
		int col = player.getCurrentCell().getCol();
		int row = player.getCurrentCell().getRow();
		
	}

}

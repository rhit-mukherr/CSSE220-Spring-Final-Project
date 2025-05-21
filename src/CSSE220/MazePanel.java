package CSSE220;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

public class MazePanel extends JPanel{
	private Maze maze;
	private static final int CELL_SIZE = 32;
	private Player player;
	
	
	public MazePanel(Maze maze, Player player) {
		this.maze = maze;
		this.player = player;
		setPreferredSize(new Dimension(maze.getCols()*CELL_SIZE, 
				maze.getRows()*CELL_SIZE));
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());

		
		//drawing the walls;
		for (int r = 0; r < maze.getRows(); r++) {
            for (int c = 0; c < maze.getCols(); c++) {
                if (maze.isWall(r, c)) {
                    g.fillRect(
                    		c * CELL_SIZE, 
                    		r * CELL_SIZE,
                    		CELL_SIZE,
                    		CELL_SIZE);
                }
            }
        }
		
		g.setColor(Color.blue);
		for(int r= 0; r<maze.getRows(); r++) {
			for(int c =0; c<maze.getCols(); c++) {
				if(maze.isWall(r, c)) {
					g.fillRect(c*CELL_SIZE, r*CELL_SIZE, CELL_SIZE, CELL_SIZE);
				}
			}
			
		}
		// drawing the player
		g.setColor(Color.RED);
		Point p = player.getPosition();
		g.fillOval( p.x*CELL_SIZE,
					p.y*CELL_SIZE,
					CELL_SIZE,
					CELL_SIZE);
		
	}
}

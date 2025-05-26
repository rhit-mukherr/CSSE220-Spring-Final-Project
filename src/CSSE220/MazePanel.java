package CSSE220;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JPanel;

public class MazePanel extends JPanel{
	private Maze maze;
	private static final int CELL_SIZE = 32;
	private Player player;
	private GameMain game;
	
	
	public MazePanel(Maze maze, Player player, GameMain game) {
		this.maze = maze;
		this.player = player;
		this.game = game;
		setPreferredSize(new Dimension(maze.getCols()*CELL_SIZE, 
				maze.getRows()*CELL_SIZE));
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		
		//background
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
		
		ArrayList<PowerUp> up = maze.getPowerUps();
		for(PowerUp ups : up)	{
			ups.draw(g, CELL_SIZE);
		}
	
		
		//player
		g.setColor(Color.blue);
		for(int r= 0; r<maze.getRows(); r++) {
			for(int c =0; c<maze.getCols(); c++) {
				if(maze.isWall(r, c)) {
					g.fillRect(c*CELL_SIZE, r*CELL_SIZE, CELL_SIZE, CELL_SIZE);
				}
			}
			
		}
		
	
		//Player
		g.setColor(Color.RED);
		Point p = player.getPosition();
		g.fillOval( p.x*CELL_SIZE,
					p.y*CELL_SIZE,
					CELL_SIZE,
					CELL_SIZE);
		
		
		//Timer
		
		
		int timeLeft = game.getTimeLeft();
        int level    = game.getLevel();
        g.setColor(Color.WHITE);
        g.setFont(g.getFont().deriveFont(Font.BOLD, 14f));
        g.drawString(
            String.format("Time: %02d   Level: %d", timeLeft, level),
            10, 20
        );
	}
	
	
	// when the new game starts, change the maze and the player
	public void setMazeAndPlayer(Maze newMaze, Player newPlayer) {
		this.maze  = newMaze;
		this.player = newPlayer;
		setPreferredSize(new Dimension(newMaze.getCols() * CELL_SIZE,
				newMaze.getRows() * CELL_SIZE));
	}
}

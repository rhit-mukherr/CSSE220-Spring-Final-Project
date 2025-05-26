package CSSE220;

import java.awt.Point;
import java.util.ArrayList;

/**
 * this represents the maze grid composed of cells that can
 * be a wall or a path for a player;
 */

public class Maze {
    private Cell[][] grid;
    
    private final ArrayList<PowerUp> powerUP = new ArrayList<>();
    
    
    /**
     * constructs a new maze of the given size from the 
     * programmer
     * 
     * and initialize all the cell as empty
     * @param rows number of rows
     * @param cols number of columns 
     */

    public Maze(int rows, int cols) {
    	grid = new Cell[rows][cols];
    	
    	for (int r = 0; r < rows; r++) {
    		for(int c = 0; c < cols; c++) {
    			grid[r][c] = new Cell(false);
    		}
    	}
    }
    
    /**
     * adding power up
     * @param power
     */
    
    public void addPowerup(PowerUp power) {
    	powerUP.add(power);
    }
    
    
    /**
     * if the player is at r and c, call this method to see if there's powerUp, and remove
     * otherwise return null;
     * @param r
     * @param c
     * @return
     */
    public PowerUp pickupAt(int r, int c) {
    	for(int i = 0; i< powerUP.size(); i++) {
    		PowerUp power = powerUP.get(i);
    		Point p = power.getPosition();
    		if(p.y == r && p.x == c) {
    			powerUP.remove(i);
    			return power;
    		}
    	}
		return null;
    }
    
    public ArrayList<PowerUp> getPowerUps(){
    	return new ArrayList<>(powerUP);
    }

    /**
     *
     * @return the number of rows in this maze;
     */
    public int getRows() { 
    	return grid.length;
    }
    
    /**
     * number of columns of this maze
     * @return
     */
    public int getCols() { 
    	return grid[0].length;
    }
    
    /**
     * checks if the cell at the specific position is wall
     * @param r row index
     * @param c column index
     * @return true if the cell is a wall;
     */
    public boolean isWall(int r, int c) {
    	return grid[r][c].isWall();
    }
    
    
    /**
     * sets or clears a wall at the specific cell.
     * @param r
     * @param c
     * @param wall true to make it a wall; false to make it empty
     * 
     */
    public void setWall(int r, int c, boolean wall) {
    	grid[r][c].setWall(wall);
    }
}


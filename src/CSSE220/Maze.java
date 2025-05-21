package CSSE220;

public class Maze {
    private Cell[][] grid;

    public Maze(int rows, int cols) {
    	grid = new Cell[rows][cols];
    	
    	for (int r = 0; r < rows; r++) {
    		for(int c = 0; c < cols; c++) {
    			grid[r][c] = new Cell(false);
    		}
    	}
    }

    public int getRows() { 
    	return grid.length;
    }
    
    public int getCols() { 
    	return grid[0].length;
    }
    
    public boolean isWall(int r, int c) {
    	return grid[r][c].isWall();
    }
    
    public void setWall(int r, int c, boolean wall) {
    	grid[r][c].setWall(wall);
    }
}


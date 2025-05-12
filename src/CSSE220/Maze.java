	package CSSE220;

public class Maze {

	private Cell[][] matrix;
	
	public Maze(int rows, int cols, Player player) {
		matrix = new Cell[rows][cols];
		for(int r= 0; r<rows; r++) {
			for(int c =0 ;c<cols;c++) {
				matrix[r][c] = new Cell(false);
			}
		}
	}

	public int getRows() {
		return matrix.length;
	}
	
	public int getCols()	{
		return matrix[0].length;
	}
	
	public boolean isWall(int r, int c) {
		return matrix[r][c].isWall();
		
	}
	
	public void setWall(int r, int c, boolean wall) {
		matrix[r][c].setWall(wall);
		
	}

}
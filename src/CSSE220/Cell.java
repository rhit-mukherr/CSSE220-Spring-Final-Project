package CSSE220;

public class Cell {

	
	private boolean wall;
	private int row;
	private int col;
	
	public Cell(boolean wall) {
		this.wall = wall;
		this.row = row;
		this.col = col;
		
	}
	
	public Cell(boolean b, int r, int c) {
		// TODO Auto-generated constructor stub
	}

	public boolean isWall() {
		return wall;
	}
	
	public void setWall(boolean wall)	{
		this.wall = wall;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}
}
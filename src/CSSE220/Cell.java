package CSSE220;

public class Cell {

	
	private boolean wall;

	
	public Cell(boolean wall) {
		this.wall = wall;
		
		
	}
	


	public boolean isWall() {
		return wall;
	}
	
	public void setWall(boolean wall)	{
		this.wall = wall;
	}
	

}
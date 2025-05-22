package CSSE220;

import java.awt.Point;
import java.util.ArrayList;

public class Player {
	private Point position;

	public Player(Point start){
		this.position = start;
	}

	public Point getPosition() {
		return position;
	}
	
	public void move(int dx, int dy, Maze maze) {
		int nx = position.x +dx;
		int ny = position.y + dy;
		
		if(nx < 0|| ny<0 ||nx >= maze.getCols() || ny >= maze.getRows()) {
			System.out.println("Out of Bound!");
			return;
		}
		
		if(maze.isWall(ny, nx)) {
			System.out.println("Hit wall");
			return;
		}
		
		position.setLocation(nx,ny);
		
					
		}
	
}//

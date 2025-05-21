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
		int horizontal = position.x +dx;
		int vertical = position.y + dy;
		if(horizontal >= 0 && vertical < maze.getRows() && horizontal >= 0 && vertical < maze.getCols()
				&& !maze.isWall(vertical, horizontal)) {
			position.setLocation(horizontal, vertical);
		}
		if(!maze.isWall(vertical, horizontal)) {
			position.setLocation(horizontal,vertical);
		}
		
			Point next = new Point(position.x + dx, position.y + dy);
			
			try {
				if(maze.isWall(next.y, next.x)) {
				System.out.println("hit Wall");
			}else {
				this.position = next;
			}
				
			}catch(IndexOutOfBoundsException a) {
				System.out.println("You are out of bound");
			
			}
			
		}
	
}//

package CSSE220;

import java.awt.Point;

public class Player {
	
	private Point position;
	
	public Player(Point start) {
		this.position = start;
		
		
	}

	
	public Point getPosition() {
		return position;
	}
	
	public void setPosition(Point position) {
		this.position= position;
	}
	
	public void move(int dx, int dy, Maze maze) {
		Point next = new Point(position.x + dx, position.y + dy);
		
		try {
			if(maze.isWall(next.y, next.x)) {
			javax.swing.JOptionPane.showMessageDialog(null, "hit Wall");
		}else {
			this.position = next;
		}
			
		}catch(IndexOutOfBoundsException a) {
			javax.swing.JOptionPane.showMessageDialog(null,"out of bound");
		
		}
		
	}


	

	
}

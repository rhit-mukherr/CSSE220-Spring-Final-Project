package CSSE220;

import java.util.Random;

public class MazeGenerator {
	
//	private final int branch;
	private double wallProbablity;
	
	public MazeGenerator(double d) {
		this.wallProbablity = wallProbablity;
		
	
	}
	
	public Maze generate(int rows, int cols) {
		Maze maze = new Maze(rows, cols);
		Random rand = new Random();
		
		for(int c = 0; c< cols; c++) {
			maze.setWall(0,c,false);
		}
		
		for(int r = 0; r<rows; r++) {
			maze.setWall(r, cols-1, false);
		}
		
		for(int r = 0; r<rows; r++) {
			for(int c =0; c<cols; c++) {
				if((r==0) || (c==cols-1)) continue;
				if((r==rows-1 && c == cols -1)) continue;
				
				
				boolean isWall = rand.nextDouble() < wallProbablity;
				maze.setWall(r,c,isWall)	;
				
				
			}
			
		}
		return maze;
		
	}

	public static boolean[][] generateMaze(int rows, int cols) {
		// TODO Auto-generated method stub
		return null;
	}
	
}


	

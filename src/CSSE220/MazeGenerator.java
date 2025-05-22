package CSSE220;

import java.util.Random;
/**
 * This class generate a random maze with a guarenteed L shaped 
 * from the top left corner(0,0) to the top-right cornor(0, cols-1)
 * then down to the bottom right corner( rows-1, cols-1) which is the 
 * finishing line.
 * all other cells become walls with a given probability.
 */

public class MazeGenerator {
	
//	private final int branch;
	
	
	private double wallProbablity;
	
	/**
	 * constructs a new mazegenerator.
	 * @param wallProbablity: the fraction of cells between 
	 * 0 and 1
	 */
	
	public MazeGenerator(double wallProbablity) {
		this.wallProbablity = wallProbablity;
		
	
	}
	
	public Maze generate(int rows, int cols) {
		Maze maze = new Maze(rows, cols);
		Random rand = new Random();
		
		// following two for loops represents the guarentee L shaped 
		// escaping route.
		for(int c = 0; c< cols; c++) {
			maze.setWall(0,c,false);
		}
		
		for(int r = 0; r<rows; r++) {
			maze.setWall(r, cols-1, false);
		}
		
		
		// this for loop randomly place walls in all other cells
		// except the L shaped route 
		for(int r = 0; r<rows; r++) {
			for(int c =0; c<cols; c++) {
				if((r==0) || (c==cols-1)) continue;
				if((r==rows-1 && c == cols -1)) continue;
				
				
				boolean isWall = rand.nextDouble() < wallProbablity;
				maze.setWall(r,c,isWall);
				
				
			}
			
		}
		return maze;
		
	}

	public static boolean[][] generateMaze(int rows, int cols) {
		// TODO Auto-generated method stub
		return null;
	}
	
}


	

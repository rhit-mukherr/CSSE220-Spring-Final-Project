package CSSE220;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * gives additional time as a powerup class; 
 */

public class Bonus implements PowerUp {
	
	private final Point pos;
	private final int bonusSec = 5;
	
	public Bonus(Point pos) {
		this.pos = pos;
	}

	@Override
	public void apply(GameMain game) {
		// TODO Auto-generated method stub
		
		game.addTime(bonusSec);
		System.out.println("Time Bonus!" + bonusSec);
		
		
	}

	@Override
	public void draw(Graphics g, int cellSize) {
		// TODO Auto-generated method stub
		
		g.setColor(Color.yellow);
		g.fillOval(pos.x * cellSize + cellSize/4, pos.y * cellSize + cellSize/4,
				cellSize/2, cellSize/2);
		
	}

	@Override
	public Point getPosition() {
		// TODO Auto-generated method stub
		return pos;
	}

}

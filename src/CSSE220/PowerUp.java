package CSSE220;

import java.awt.Graphics;
import java.awt.Point;

public interface PowerUp {
	
	public static final Point getPosition = new Point();
	
	void apply(GameMain game);
	
	void draw(Graphics g, int cellSize);

	Point getPosition();

	

}

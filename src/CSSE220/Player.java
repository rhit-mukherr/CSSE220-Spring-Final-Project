package CSSE220;

import java.awt.Point;
import java.util.ArrayList;

public class Player {
	private String playerName;
	private String playerAvatar;
	private Cell currentCell;
	private boolean playerEliminated;
	
	private ArrayList<Boolean> playerInventory;	
	private int treasuresCollected;
	private int enemyiesKilled;
	
	public static final int KEY = 0;
	public static final int SWORD = 1;
	public static final int ICE_POWER = 2;
	public static final int NUM_INVENTORY_ITEMS = 3; 

	public Player(String playerName, String playerAvatar){
		this.playerName = playerName;
		this.playerAvatar = playerAvatar;
		playerInventory = new ArrayList<Boolean>();
		for (int i = 0; i < NUM_INVENTORY_ITEMS; i++) {
			playerInventory.add(false);	
		}
	}
	
	public String getPlayerName() {
		return this.playerName;
	}
	
	public void setDisplayName(String newName) {
		this.playerName = newName;
	}
	
	public String getPlayerAvatar() {
		return this.playerAvatar;
	}
	
	public void setPlayerAvatar(String newAvatar) {
		this.playerAvatar = newAvatar;
	}
	
	public Cell getCurrentCell() {
		return currentCell;
	}
	
	public void setCurrentCell(Cell cell) {
		currentCell = cell;
	}
	
	public void setPlayerIsEliminated(boolean status) {
		playerEliminated = status;
	}
	
	public boolean isEliminated() {
		return playerEliminated;
	}
	
	public boolean itemIsCollected(int itemIndex) {
		return playerInventory.get(itemIndex);
	}
	
	public void updateItemStatus(int itemIndex, boolean obtained) {
		playerInventory.set(itemIndex, obtained);
	}
	
	
	
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

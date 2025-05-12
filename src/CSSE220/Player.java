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
	private int enemiesKilled;
	
	public static final int NUM_INVENTORY_ITEMS = 3; 

	public Player(Point startPoisition){
		this.playerName = "Player";
		this.playerAvatar = "";
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
	
	public int getTreasuresCollected() {
		return treasuresCollected;
	}
	
	public void incrementTreasuresFound() {
		this.treasuresCollected++;
	}
	
	public int getEnemiesKilled() {
		return enemiesKilled;
	}
	
	public void addEnemiesKilled() {
		this.enemiesKilled++;
	}
	
	public void resetPlayer() {
		currentCell = null;
		playerEliminated = false;
		resetInventory();
		treasuresCollected = 0;
		enemiesKilled = 0;
	}
	
	public void resetInventory() {
		for (int i = 0; i < NUM_INVENTORY_ITEMS; i++) {
			playerInventory.set(i, false);
		}
	}
}

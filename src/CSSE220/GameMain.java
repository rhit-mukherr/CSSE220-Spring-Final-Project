package CSSE220;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class GameMain extends JFrame implements ActionListener, KeyListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private MazePanel mazePanel;
	private javax.swing.Timer gameTimer;
	
	private Maze maze;
	private Player player;
	private InputHandler i;
		
    
    private int difficulty;	
    private int score;	
    private int level;	
    private boolean finishedLevel;	
    
    private volatile boolean inGame;	
    private volatile boolean isGameOver;	
    				
    private static final int START_LEVEL_WIDTH = 17;
    private static final int START_LEVEL_HEIGHT = 17;
    private static final int POINTS_ENEMY_KILLED = 10;
    public static final int MAX_LEVEL = 10;
    public static final int EASY = -1;
    public static final int MEDIUM = 0;
    public static final int HARD = 1;  
	
	public GameMain(){
		setTitle("Maze Escape");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		isGameOver = false;
		inGame = false;
		player = new Player("Default", "Wall-E");
		score = 0;
		level = 0; 
		difficulty = EASY;
		
		mazePanel = new MazePanel(maze, player);
		i = new InputHandler(maze, player);
		
		mazePanel.setFocusable(true);
		mazePanel.addKeyListener(i);
		
		add(mazePanel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		
		gameTimer = new javax.swing.Timer(1000/60, this);
		gameTimer.start();
	}
	
	public void createMaze() {
		this.maze = new Maze(START_LEVEL_WIDTH + (2*(level+difficulty)), START_LEVEL_HEIGHT + (2*(level+difficulty)),player);
		i = new InputHandler(maze, player);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SwingUtilities.invokeLater(GameMain::new);

	}
	
	public void setIsGameOver(boolean isGameOver) {
		this.isGameOver = isGameOver;
	}
	
	public boolean isGameOver() {
		return isGameOver;
	}
	
	public void setIsInGame() {
		this.inGame = inGame;
	}
	
	public void setInputHandler(InputHandler i) {
		this.i = i;
	}
	
	public InputHandler getinputHandler() {
		return i; 
	}
	
	public Player getPlayer() {
		return this.player;
	}
	
	public Maze getMaze() {
		return this.maze;
	}
	
	public void updateScore() {
		score = player.getTreasuresCollected() + POINTS_ENEMY_KILLED * player.getEnemiesKilled();
	}
	
	public int getScore() {
		return score;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		mazePanel.repaint();
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public int getLevel() {
		return level;
	}
	
	public boolean getFinishedLevel() {
		return finishedLevel;
	}
	
	public void setFinishedLevel(boolean c) {
		finishedLevel = c;
	}
	
	public void setDifficulty(int difficulty) {
		// TODO Auto-generated method stub
		this.difficulty = difficulty;
	}
	
	public void clearGame() {
		score =0; 
		level = 0;
	}
}
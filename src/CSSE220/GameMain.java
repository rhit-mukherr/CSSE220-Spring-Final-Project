package CSSE220;

import java.awt.Panel;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class GameMain extends JFrame implements ActionListener{

	
	private static final long serialVersionUID = 1L;
	
	private MazePanel mazePanel;
	private javax.swing.Timer gameTimer;
	
	private Maze maze;
	private Player player;
	private InputHandler input;
		
    
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
		super("Maze Game");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		isGameOver = false;
		inGame = false;
		player = new Player(new Point(0,0));
		score = 0;
		level = 0; 
		difficulty = EASY;
		
		maze = new MazeGenerator(0.3).generate(17, 17);
		mazePanel = new MazePanel(maze, player);
		input = new InputHandler(maze, player);
		
		mazePanel.setFocusable(true);
		mazePanel.addKeyListener(input);
		
		add(mazePanel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		
		gameTimer = new javax.swing.Timer(1000/60, this);
		gameTimer.start();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		mazePanel.repaint();
		
		Point point = player.getPosition();
		if(point.x == maze.getCols()-1 && point.y == maze.getRows() -1)	{
			gameTimer.stop();
			JOptionPane.showMessageDialog(this, "you win");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SwingUtilities.invokeLater(GameMain::new);

	}



	
	
	
	

}
package CSSE220;

import java.awt.Point;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;


/**
 * The main window and game loop for the game
 */

public class GameMain extends JFrame implements ActionListener{

	
	
	private MazePanel mazePanel;
	private javax.swing.Timer gameTimer;
	private final int TIME_LIMIT = 60;

	private Maze maze;
	private Player player;
	private InputHandler input;
	private StopWatch stopwatch;
		
    
	
	/**
	 * this constructor sets up the maze, player, panel, 
	 * input, and starts the game.
	 * 
	 */
  
	public GameMain(){
		super("Maze Game");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		maze = new MazeGenerator(0.4).generate(30,30);
		player = new Player(new Point(0,0));
		
		mazePanel = new MazePanel(maze, player, null);
		input = new InputHandler(maze, player);
		
		
		
		mazePanel.setFocusable(true);
		mazePanel.requestFocusInWindow();
		mazePanel.addKeyListener(input);
		
		add(mazePanel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		
//		
//		stopwatch = new StopWatch();
//		stopwatch.start();
		gameTimer = new javax.swing.Timer(1000/60, this);
		gameTimer.start();
	}	
	
	/**
	 * called every frame: re-draw and checks for win
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		mazePanel.repaint();
		
//		long elapsedMs = stopwatch.getElapsedTime();
//		int elapsedSec = (int)(elapsedMs/1000);
//		if (elapsedSec >= TIME_LIMIT) {
//			gameTimer.stop();
//			JOptionPane.showMessageDialog(this, "The timer ran out! Try again.");
//			return;
//		}
		
//		public int getTimeLeft() {
//			// TODO Auto-generated method stub
//			int elapsedSec = (int)(stopwatch.getElapsedTime() / 1000);
//	        return Math.max(0, TIME_LIMIT - elapsedSec);
//		}	
		
		Point point = player.getPosition();
		if(point.x == maze.getCols()-1 &&
			point.y == maze.getRows() -1)	{
			gameTimer.stop();
			JOptionPane.showMessageDialog(this, "We have a winnner");
		}
	}
	
	
	/**
	 * this starts the application.
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(GameMain::new);

	}
}
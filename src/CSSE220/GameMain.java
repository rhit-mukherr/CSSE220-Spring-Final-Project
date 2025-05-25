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

	private SoundManager sound;
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
		
		maze = new MazeGenerator(0.3).generate(30,30);
		player = new Player(new Point(0,0));
		sound = new SoundManager();
		
		stopwatch = new StopWatch();
		stopwatch.start();
		
		
		mazePanel = new MazePanel(maze, player, this);
		input = new InputHandler(maze, player, sound);
		
		
		
		mazePanel.setFocusable(true);
		mazePanel.addKeyListener(input);
		
		add(mazePanel);
		addKeyListener(input);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		
		SwingUtilities.invokeLater(()-> mazePanel.requestFocusInWindow());
		
		gameTimer = new Timer(1000/60, this);
		gameTimer.start();
		
		
	
	}	
	
	/**
	 * called every frame: re-draw and checks for win
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		mazePanel.repaint();
		
		long elapsedMs = stopwatch.getElapsedTime();
		int elapsedSec = (int)(elapsedMs/1000);
		int timeLeft = TIME_LIMIT - elapsedSec;
		if (timeLeft<= 0) {
			gameTimer.stop();
			stopwatch.stop();
			JOptionPane.showMessageDialog(this, "The timer ran out! Try again.");
			return;
		}
		
		Point position = player.getPosition();
		if(position.x == maze.getCols() -1 && position.y == maze.getRows()-1) {
			gameTimer.stop();
			stopwatch.stop();
			showEndMessage("YOU WON!");
		}
		
			// TODO Auto-generated method stub
			
		}	
		
	public int getTimeLeft(){
		
		int elapsed = (int)(stopwatch.getElapsedTime()/1000	);
		return Math.max(0, TIME_LIMIT-elapsed);
	}
	
	private void showEndMessage(String message) {
		String[] options = {"Again", "Close"};
		int choose = JOptionPane.showConfirmDialog(this, message, "Close", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE);
				
		
		
		if(choose == JOptionPane.YES_OPTION	) {
			restartGame();
		} else {
			System.exit(0);
		}
	
	}
	
	
	private void restartGame()	{
		Maze newMaze = new MazeGenerator(0.3).generate(30, 30);
		Player newPlayer = new Player(new Point(0,0));
		
		this.maze = newMaze;
		this.player = newPlayer;
		
		mazePanel.setMazeAndPlayer(newMaze, newPlayer);
		
		
		mazePanel.removeKeyListener(input);
		InputHandler newInput = new InputHandler(newMaze, newPlayer, sound);
		this.input = newInput;
		mazePanel.addKeyListener(newInput);
	
		
		stopwatch.reset();
		stopwatch.start();
		gameTimer.start();
		
		mazePanel.requestFocusInWindow();
		mazePanel.repaint();
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
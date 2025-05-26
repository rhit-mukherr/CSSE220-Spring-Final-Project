package CSSE220;

import java.awt.Point;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import java.awt.BorderLayout;
import java.awt.Dimension;



/**
 * The main window and game loop for the game
 */

public class GameMain extends JFrame implements ActionListener{

	private static final double[] difficulties = {0.10, 0.15, 0.20, 0.25, 0.30};
	private int difficultyIndex = 0;
	
	
	private MazePanel mazePanel;
	private javax.swing.Timer gameTimer;
	private final int TIME_LIMIT = 30;

	private SoundManager sound;
	private Maze maze;
	private Player player;
	private InputHandler input;
	private StopWatch stopwatch;
	private int level = 1;
	
	/**
	 * this constructor sets up the maze, player, panel, 
	 * input, and starts the game.
	 * 
	 */
  
	public GameMain(){
		super("Maze Game");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		maze = new MazeGenerator(difficulties[difficultyIndex]).generate(30,30);
		player = new Player(new Point(0,0));
		sound = new SoundManager();
		
		stopwatch = new StopWatch();
		stopwatch.start();
		
		
		mazePanel = new MazePanel(maze, player, this);
		input = new InputHandler(maze, player, sound);
		
		
		
		mazePanel.setFocusable(true);
		mazePanel.addKeyListener(input);
		
		JButton instructionsBtn = new JButton("Instructions");
	    instructionsBtn.setFocusable(false);
	    instructionsBtn.setPreferredSize(new Dimension(200, 30));
	    instructionsBtn.setFont(instructionsBtn.getFont().deriveFont(Font.BOLD, 16f));
	    instructionsBtn.addActionListener(ev -> {
	        InstructionPanel ip = new InstructionPanel();
	        ip.setVisible(true);
	    });
		
		add(mazePanel);
		addKeyListener(input);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		
		JButton highScoresBtn = new JButton("High Scores");
		highScoresBtn.setFocusable(false);
		highScoresBtn.setPreferredSize(new Dimension(200, 30));
		highScoresBtn.setFont(highScoresBtn.getFont().deriveFont(Font.BOLD, 16f));
		highScoresBtn.addActionListener(ev -> {
		    List<HighScoreManager.Entry> top = new HighScoreManager().load();
		    StringBuilder sb = new StringBuilder(" Top Scores \n\n");
		    int rank = 1;
		    for (HighScoreManager.Entry e : top) {
		        sb.append(String.format("%2d. %-3s : %d\n", rank++, e.initials, e.level));
		    }
		    if (top.isEmpty()) {
		        sb.append("No scores yet!");
		    }
		    JOptionPane.showMessageDialog(
		        this,
		        sb.toString(),
		        "High Scores",
		        JOptionPane.INFORMATION_MESSAGE
		    );
		});
		
		JPanel southPanel = new JPanel();
		southPanel.add(instructionsBtn);
		southPanel.add(highScoresBtn);
		add(southPanel, BorderLayout.SOUTH);

		
		SwingUtilities.invokeLater(()-> mazePanel.requestFocusInWindow());
		
		gameTimer = new Timer(1000/60, this);
		gameTimer.start();
		
		
	
	}	
	
	/**
	 * called every frame: re-draw and checks for win
	 */
	
	private Maze createMazewithDifficulty() {
		double prob = difficulties[difficultyIndex];
		return new MazeGenerator(prob).generate(30, 30);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Point pos = player.getPosition();
		PowerUp up = maze.pickupAt(pos.y, pos.x);
		if(up != null) {
			up.apply(this);
			sound.playPowerUp();
		}
		
		
		
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
			int score = timeLeft + level * 1000;
            String initials = JOptionPane.showInputDialog(
                this,
                "You cleared Level " + level + "!\nEnter your initials:",
                "New High Score",
                JOptionPane.PLAIN_MESSAGE
            );
            if (initials != null && !initials.trim().isEmpty()) {
                initials = initials.trim().toUpperCase();
                if (initials.length() > 3) initials = initials.substring(0, 3);
                new HighScoreManager().add(initials, level, score);
            }
			showEndMessage("We have a winner, Do you want to advance to the next level");
		}	
		}
	
	public int getLevel() {
	    return level;
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
		
		difficultyIndex = Math.min(difficultyIndex + 1 ,difficulties.length-1);
		maze = createMazewithDifficulty();
		Player newPlayer = new Player(new Point(0,0));
		
		this.player = newPlayer;
		
		mazePanel.setMazeAndPlayer(maze, newPlayer);
		
		
		mazePanel.removeKeyListener(input);
		InputHandler newInput = new InputHandler(maze, newPlayer, sound);
		this.input = newInput;
		mazePanel.addKeyListener(newInput);
	
		
		stopwatch.reset();
		stopwatch.start();
		gameTimer.start();
		
		mazePanel.requestFocusInWindow();
		mazePanel.repaint();
	}
	public void addTime(int bonusSec) {
		// TODO Auto-generated method stub
		stopwatch.addSeconds(bonusSec);
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
package CSSE220;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class GameMain extends JFrame implements ActionListener{

	
	
	private MazePanel mazePanel;
	private javax.swing.Timer gameTimer;

	private Maze maze;
	private Player player;
	private InputHandler input;
		
    
  
	public GameMain(){
		super("Maze Game");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
	

		
		maze = new MazeGenerator(0.3).generate(20,20);
		player = new Player(new Point(0,0));

		
		mazePanel = new MazePanel(maze, player);
		input = new InputHandler(maze, player);
		
		mazePanel.setFocusable(true);
		mazePanel.requestFocusInWindow();
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
		if(point.x == maze.getCols()-1 &&
			point.y == maze.getRows() -1)	{
			gameTimer.stop();
			JOptionPane.showMessageDialog(this, "you win");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SwingUtilities.invokeLater(GameMain::new);

	}



	
	
	
	

}
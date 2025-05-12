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
	private InputHandler inputHandler;
	
	GameMain(){
		setTitle("Maze Escape");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		
		maze = new Maze(20,20);
		player = new Player(new Point(0,0));

		mazePanel = new MazePanel(maze, player);
		inputHandler = new InputHandler(maze, player);
		
		mazePanel.setFocusable(true);
		mazePanel.addKeyListener(inputHandler);
		
		add(mazePanel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		
		gameTimer = new javax.swing.Timer(1000/60, this);
		gameTimer.start();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SwingUtilities.invokeLater(GameMain::new);

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

}
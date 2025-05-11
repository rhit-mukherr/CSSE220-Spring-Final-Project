package CSSE220;


import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class GameOptionPanel extends JPanel {
private static final long serialVersionUID = 1L;
	
	private JButton character1;	
	private JButton character2;
	private JButton character3;
	private JTextField nameField;	
	
	private JRadioButton easyDifficulty;	
	private JRadioButton mediumDifficulty;
	private JRadioButton hardDifficulty;

	public GameOptionPanel(GameMain g){
		final GameMain game = g;
		this.setLayout(new GridBagLayout());		
		GridBagConstraints gbc = new GridBagConstraints();
		
		Sprite sonyPanel = new Sprite(MazePanel.character1, 48, 48);
		Sprite williamPanel = new Sprite(MazePanel.character2, 48, 48);
		Sprite jackFrostPanel = new Sprite(MazePanel.JackFrostSprite, 48, 48);
		
		character1 = new JButton("Sony - The Legend", sonyPanel.getSprite() );
		character2 = new JButton("William - The Knight", williamPanel.getSprite());
		character3 = new JButton("JackFrost - The Dark Prince", jackFrostPanel.getSprite());
		
		character1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				game.getPlayer().setCharacter(MazeFrame.SonySprite);
				try {
					URL url = new URL("file:H:\\Shamshad\\Maze\\MazeRunner\\src\\sounds\\button.wav");
					Clip clip = AudioSystem.getClip();
					AudioInputStream ais = AudioSystem.getAudioInputStream(url);
					clip.open(ais);
					clip.start();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		character2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				game.getPlayer().setCharacter(MazeFrame.WilliamSprite);
				try {
					URL url = new URL("file:H:\\Shamshad\\Maze\\MazeRunner\\src\\sounds\\button.wav");
					Clip clip = AudioSystem.getClip();
					AudioInputStream ais = AudioSystem.getAudioInputStream(url);
					clip.open(ais);
					clip.start();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		character3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				game.getPlayer().setCharacter(MazeFrame.JackFrostSprite);
				try {
					URL url = new URL("file:H:\\Shamshad\\Maze\\MazeRunner\\src\\sounds\\button.wav");
					Clip clip = AudioSystem.getClip();
					AudioInputStream ais = AudioSystem.getAudioInputStream(url);
					clip.open(ais);
					clip.start();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});;
		
		this.add(character1);	
		this.add(character2);
		this.add(character3);
		
		nameField = new JTextField("Enter Name");
		nameField.setPreferredSize(new Dimension(200,20));
		
		gbc.gridy = 1;
		gbc.gridx = 0;
		gbc.insets = new Insets(20,20,0,0);
		
		JLabel nameText = new JLabel("Introduce yourself, Champion: ");
		this.add(nameText, gbc);
		
		gbc.gridx = 1;
		this.add(nameField, gbc);

		gbc.gridy = 2;
		gbc.gridx = 0;
		JLabel difficultyText = new JLabel("Choose difficulty:");
		this.add(difficultyText, gbc);
		
		ButtonGroup difficultyButtons = new ButtonGroup();
		easyDifficulty = new JRadioButton("Easy");
		mediumDifficulty = new JRadioButton("Medium", true);
		hardDifficulty = new JRadioButton("Hard");
		difficultyButtons.add(easyDifficulty);
		difficultyButtons.add(mediumDifficulty);
		difficultyButtons.add(hardDifficulty);
		
		gbc.gridy = 3;
		gbc.gridx = 0;
		gbc.insets = new Insets(10,10,0,0);
		this.add(easyDifficulty,gbc);
		
		gbc.gridx = 1;
		this.add(mediumDifficulty,gbc);
		
		gbc.gridx = 2;
		this.add(hardDifficulty,gbc);
		
		easyDifficulty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				game.setDifficulty(GameMain.EASY);
				try {
					URL url = new URL("file:H:\\Shamshad\\Maze\\MazeRunner\\src\\sounds\\button.wav");
					Clip clip = AudioSystem.getClip();
					AudioInputStream ais = AudioSystem.getAudioInputStream(url);
					clip.open(ais);
					clip.start();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		mediumDifficulty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				game.setDifficulty(GameMain.MEDIUM);
				try {
					URL url = new URL("file:H:\\Shamshad\\Maze\\MazeRunner\\src\\sounds\\button.wav");
					Clip clip = AudioSystem.getClip();
					AudioInputStream ais = AudioSystem.getAudioInputStream(url);
					clip.open(ais);
					clip.start();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		hardDifficulty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				game.setDifficulty(GameMain.HARD);
				try {
					URL url = new URL("file:H:\\Shamshad\\Maze\\MazeRunner\\src\\sounds\\button.wav");
					Clip clip = AudioSystem.getClip();
					AudioInputStream ais = AudioSystem.getAudioInputStream(url);
					clip.open(ais);
					clip.start();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
	}
	
	public String getName(){
		return nameField.getText();
	}
}

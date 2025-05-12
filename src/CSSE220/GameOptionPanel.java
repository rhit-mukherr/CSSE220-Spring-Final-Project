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
	
	private JButton setJack;	
	private JButton setWalle;
	private JButton setDavid;
	private JTextField nameField;	
	
	private JRadioButton easyDifficulty;	
	private JRadioButton mediumDifficulty;
	private JRadioButton hardDifficulty;

	public GameOptionPanel(GameMain g){
		final GameMain game = g;
		this.setLayout(new GridBagLayout());		
		GridBagConstraints gbc = new GridBagConstraints();
		
		Sprite knightPanel = new Sprite(MazePanel.JackSprite, 48, 48);
		Sprite wallePanel = new Sprite(MazePanel.WalleSprite, 48, 48);
		Sprite davidPanel = new Sprite(MazePanel.DavidSprite, 48, 48);
		
		setJack = new JButton("Jack - The Knight", knightPanel.getSprite() );
		setWalle = new JButton("Wall-E - The Robot", wallePanel.getSprite());
		setDavid = new JButton("David - The Robot2", davidPanel.getSprite());
		
		setJack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				game.getPlayer().setPlayerAvatar(MazePanel.JackSprite);
				try {
					URL url = new URL("/CSSE220Project/src/CSSE220/sprite/character 1 by GPT.png");
					Clip clip = AudioSystem.getClip();
					AudioInputStream ais = AudioSystem.getAudioInputStream(url);
					clip.open(ais);
					clip.start();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		setWalle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				game.getPlayer().setPlayerAvatar(MazePanel.WalleSprite);
				try {
					URL url = new URL("/CSSE220Project/src/CSSE220/sprite/character 2 by GPT.png");
					Clip clip = AudioSystem.getClip();
					AudioInputStream ais = AudioSystem.getAudioInputStream(url);
					clip.open(ais);
					clip.start();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		setDavid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				game.getPlayer().setPlayerAvatar(MazePanel.DavidSprite);
				try {
					URL url = new URL("/CSSE220Project/src/CSSE220/sprite/character 3 by GPT.png");
					Clip clip = AudioSystem.getClip();
					AudioInputStream ais = AudioSystem.getAudioInputStream(url);
					clip.open(ais);
					clip.start();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});;
		
		this.add(setJack);	
		this.add(setWalle);
		this.add(setDavid);
		
		nameField = new JTextField("Enter Name");
		nameField.setPreferredSize(new Dimension(200,20));
		
		gbc.gridy = 1;
		gbc.gridx = 0;
		gbc.insets = new Insets(20,20,0,0);
		
		JLabel nameText = new JLabel("Player Name");
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
					URL url = new URL("");
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
					URL url = new URL("");
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
					URL url = new URL("");
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

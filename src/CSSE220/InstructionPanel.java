package CSSE220;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InstructionPanel {

	private JButton backButton;
	private JPanel instructions;
	private JFrame frame;
	
	public InstructionPanel () {
		frame = new JFrame();	
		frame.setTitle("Game Instructions");		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		backButton = new JButton("Close");	
		instructions = new JPanel(new GridBagLayout());

		backButton.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				try {
					URL url = new URL("");
					Clip clip = AudioSystem.getClip();
					AudioInputStream ais = AudioSystem.getAudioInputStream(url);
					clip.open(ais);
					clip.start();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				frame.setVisible(false);	
			}
		});
		frame.getContentPane().setBackground(Color.WHITE);
		instructions.setBackground(Color.WHITE);
		frame.setResizable(true);
		frame.setLayout(new GridBagLayout());
		BufferedImage wasd = null;
	   try {
	    	wasd = ImageIO.read(this.getClass().getResource(""));
	    } catch (IOException e) {
	    	System.err.println("Failed to read sprite.");
	    }
		
	    BufferedImage htp = null;
	    try {
	    	htp = ImageIO.read(this.getClass().getResource(""));
	    } catch (IOException e){
	    	System.err.println("Failed to read sprite.");
	    }
	}
	    //JLabel sprite1 = new JLabel(new Sprite(MazePanel.Sprite,48,48).getSprite());
	
		//JLabel keyboard = new JLabel(new ImageIcon(wasd));
		//JLabel howtoplay = new JLabel(new ImageIcon(htp));
		
	    // Add game instructions here
		//sprite.setText("Pick this up to kill the enemies!");
		
	public void setVisible(boolean b) {
		frame.setVisible(b);
	}
}

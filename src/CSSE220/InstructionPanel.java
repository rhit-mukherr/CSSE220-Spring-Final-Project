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
		frame.setSize(400,300);
		frame.setLocationRelativeTo(null);
		
		instructions = new JPanel(new GridBagLayout());
		instructions.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets  = new Insets(10,10,10,10);
		gbc.gridx = 0;
		gbc.anchor = GridBagConstraints.WEST;
		
		//Title
		JLabel titleLabel = new JLabel("How to Play");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(titleLabel.getFont().deriveFont(18f));
        gbc.gridy = 0;
        instructions.add(titleLabel, gbc);
        
        //Movement instructions
        JLabel moveLabel = new JLabel("Use arrow keys to move your character.");
        moveLabel.setForeground(Color.WHITE);
        gbc.gridy = 1;
        instructions.add(moveLabel, gbc);
        
        // Objective instructions
        JLabel objectiveLabel = new JLabel("Reach the exit within the given time to win.");
        objectiveLabel.setForeground(Color.WHITE);
        gbc.gridy = 2;
        instructions.add(objectiveLabel, gbc);
        
        JLabel yellowdotins = new JLabel("Collect the yellow tokens to add 5 seconds to the timer.");
        yellowdotins.setForeground(Color.WHITE);
        gbc.gridy = 3;
        instructions.add(yellowdotins, gbc);
        
        backButton = new JButton("Back");
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        instructions.add(backButton, gbc);

        // back button
		backButton.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
	            }
	        });
				frame.add(instructions);
		}

	public void setVisible(boolean b) {
		frame.setVisible(b);
	}
}

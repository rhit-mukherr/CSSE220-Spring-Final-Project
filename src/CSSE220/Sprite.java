package CSSE220;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Sprite {
	
	private ImageIcon sprite;

    public Sprite(String imageName, int x, int y) {
    	try {	
    		sprite = new ImageIcon(this.getClass().getResource("/sprites/" + imageName + ".gif"));
    		Image image = sprite.getImage().getScaledInstance(x, y, Image.SCALE_FAST);
    		sprite.setImage(image);	
    	}
    	catch (Exception e) {}	
    }
    public ImageIcon getSprite()
    {
    	return this.sprite;
    }
}

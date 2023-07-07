package design;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class UserBackImage extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void paintComponent(Graphics backGround) {
		try {
			Graphics2D img = (Graphics2D) backGround;
			InputStream imageInputStream = getClass().getResourceAsStream("UserRegistration.jpg");
			BufferedImage bufferedImage = ImageIO.read(imageInputStream);
			Image imageSet = bufferedImage.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT);
			img.drawImage(imageSet, 0, 0, this);
		}catch(Exception e) {
			
		}
	}
}
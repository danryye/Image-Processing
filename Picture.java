import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Picture {

	private String imgpath;
	
	private BufferedImage bufferedImage;
	
	private int height, width;
	
	public Picture() {
		this.height = 200;
		this.width = 100;
	}
	
	public Picture(String imgpath) {
		load(imgpath);
	}
	
	
	
	public boolean load(String imgpath) {
		try {
			File file = new File(imgpath);
			bufferedImage = ImageIO.read(file);
			
			return true;
		} catch (Exception e) {
			System.out.println("Error trying to load " + imgpath);
			return false;
		}
		
	}
	
	public BufferedImage getImage() {
		return bufferedImage;
	}
}

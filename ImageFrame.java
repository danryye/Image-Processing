import javax.swing.*;

public class ImageFrame {
	
	//main frame
	JFrame frame = new JFrame();
	//ImageIcon to hold the picture
	ImageIcon imageIcon = new ImageIcon();
	//JLabel to fit onto the frame
	JLabel jLabel = new JLabel(imageIcon);
	//path to the image
	String imgpath;
	//Picture to display
	Picture picture;
	
	public ImageFrame(String imgpath) {
		this.imgpath = imgpath;
	}
	
	public void run() {
		init();
		
	}
	
	public void init() {
		picture = new Picture(imgpath);
		
		imageIcon.setImage(picture.getImage());
		frame.getContentPane().add(jLabel);
		frame.pack();
		
		frame.setVisible(true);
	}
	
	public void update() {
		
	}
}

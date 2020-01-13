import javax.swing.*;
import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.event.*;
import java.awt.Graphics;

public class PictureFrame implements ActionListener {
    //main frame
    JFrame frame;
    //ImageIcon to hold the image
    ImageIcon imageIcon = new ImageIcon();
    //BufferedImage to hold te original image
    BufferedImage originalImage;
    //JLabel to fit onto the frame
    JLabel jLabel = new JLabel(imageIcon);
    
    
    //JMenuBar at the top of the window
    JMenuBar mb = new JMenuBar();
    
    //JMenus
    JMenu menu1;
    JMenu menu2;
    
    
    public PictureFrame(){
        init();
    }
    
    //Handles settling up the frame and its components
    public void init(){
        initFrame();
        
        initMenuBar();
        
        
        frame.getContentPane().add(jLabel);
        frame.pack();
        frame.setVisible(true);
    }
    
    //opens an image from a provided path
    public void open(String imgPath){
        load(imgPath);
    }
    
    //Tries to load an image from a given file path
    //returns an error if failed
    public boolean load(String imgPath){
        try {
            File file = new File(imgPath);
            BufferedImage bufferedImage = ImageIO.read(file);
            //System.out.println("width: " + bufferedImage.getWidth() + ", height: " + bufferedImage.getHeight());
            imageIcon.setImage(bufferedImage);
            originalImage = bufferedImage;
            frame.setTitle("Image Processing - " + file.getName());
            frame.setSize(bufferedImage.getWidth()
                            , bufferedImage.getHeight());
            update();
            
            return true;
        } catch(Exception e) {
            System.err.println("Error trying to load " + imgPath);
            return false;
        }
    }
    
    public void initFrame(){
        frame = new JFrame();
        frame.setResizable(false);
        frame.setTitle("Image Processing");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void initMenuBar(){
        //Create Menus
        menu1 = new JMenu("File");
        menu2 = new JMenu("Filter");
        
        //groups of menu bar items
        JMenuItem menu1Open = new JMenuItem("Open");
        menu1.add(menu1Open);
        
        JMenuItem menu2Original = new JMenuItem("Original");
        JMenuItem menu2OnlyRed = new JMenuItem("Only Red");
        JMenuItem menu2OnlyBlue = new JMenuItem("Only Blue");
        JMenuItem menu2OnlyGreen = new JMenuItem("Only Green");
        JMenuItem menu2ZeroRed = new JMenuItem("Zero Red");
        JMenuItem menu2ZeroBlue = new JMenuItem("Zero Blue");
        JMenuItem menu2ZeroGreen = new JMenuItem("Zero Green");
        JMenuItem menu2FlipHorizontally = new JMenuItem("Flip Horizontally");
        JMenuItem menu2FlipVertically = new JMenuItem("Flip Vertically");
        JMenuItem menu2Grayscale = new JMenuItem("Grayscale");
        
        //adds the action listeners
        menu2Original.addActionListener(this);
        menu2OnlyRed.addActionListener(this);
        menu2OnlyBlue.addActionListener(this);
        menu2OnlyGreen.addActionListener(this);
        menu2ZeroRed.addActionListener(this);
        menu2ZeroBlue.addActionListener(this);
        menu2ZeroGreen.addActionListener(this);
        menu2FlipHorizontally.addActionListener(this);
        menu2FlipVertically.addActionListener(this);
        menu2Grayscale.addActionListener(this);
        
        //add menu items to the menus
        menu1.add(menu1Open);
        
        menu2.add(menu2Original);
        menu2.add(menu2OnlyRed);
        menu2.add(menu2OnlyBlue);
        menu2.add(menu2OnlyGreen);
        menu2.add(menu2ZeroRed);
        menu2.add(menu2ZeroBlue);
        menu2.add(menu2ZeroGreen);
        menu2.add(menu2FlipHorizontally);
        menu2.add(menu2FlipVertically);
        menu2.add(menu2Grayscale);
        
        //add menus to menu bar
        mb.add(menu1);
        mb.add(menu2);
        
        //sets the menubar to the JFrame
        frame.setJMenuBar(mb);
    }
    
    public void update(){
        frame.repaint();
    }
    
    public void repack(){
        imageIcon.setImage(originalImage);
        frame.repaint();
        
        //imageIcon.setImage(originalImage);
    }
    
    public void actionPerformed(ActionEvent a){
        if(a.getActionCommand().equals("Original")) {
            repack();
            update();
        }
        
        if(a.getActionCommand().equals("Only Red")) {
            imageIcon.setImage(originalImage);
            ImageFilter.filterOnlyRed((BufferedImage)imageIcon.getImage());
            update();
        }
        
        if(a.getActionCommand().equals("Only Blue")) {
            imageIcon.setImage(originalImage);
            ImageFilter.filterOnlyBlue((BufferedImage)imageIcon.getImage());
            update();
        }
        
        if(a.getActionCommand().equals("Only Green")) {
            imageIcon.setImage(originalImage);
            ImageFilter.filterOnlyGreen((BufferedImage)imageIcon.getImage());
            update();
        }
        
        if(a.getActionCommand().equals("Zero Red")) {
            imageIcon.setImage(originalImage);
            ImageFilter.filterZeroRed((BufferedImage)imageIcon.getImage());
            update();
        }
        
        if(a.getActionCommand().equals("Zero Blue")) {
            imageIcon.setImage(originalImage);
            ImageFilter.filterZeroBlue((BufferedImage)imageIcon.getImage());
            update();
        }
        
        if(a.getActionCommand().equals("Zero Green")) {
            imageIcon.setImage(originalImage);
            ImageFilter.filterZeroGreen((BufferedImage)imageIcon.getImage());
            update();
        }
        
        if(a.getActionCommand().equals("Flip Horizontally")) {
            imageIcon.setImage(originalImage);
            ImageFilter.filterFlipHorizontally((BufferedImage)imageIcon.getImage());
            update();
        }
        
        if(a.getActionCommand().equals("Flip Vertically")) {
            imageIcon.setImage(originalImage);
            ImageFilter.filterFlipVertically((BufferedImage)imageIcon.getImage());
            update();
        }
        
        if(a.getActionCommand().equals("Grayscale")) {
            imageIcon.setImage(originalImage);
            ImageFilter.filterGrayscale((BufferedImage)imageIcon.getImage());
            update();
        }
        
    }
}

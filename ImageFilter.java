import java.awt.image.BufferedImage;
import java.awt.Color;

import java.io.*;

public class ImageFilter {
    public static BufferedWriter bw;
    
    public static void filterOnlyRed(BufferedImage img){
        try{
            bw = new BufferedWriter(new FileWriter("./logs.txt"));
            
            int width = img.getWidth();
            int height = img.getHeight();
        
            for(int i = 0; i < width; i++){
                for(int j = 0; j < height;j++){
                    int red = new Color(img.getRGB(i, j)).getRed();
                    img.setRGB(i, j, new Color(red, 0, 0).getRGB());
                    bw.write("x: " + i + ", y: " + j);
                    bw.newLine();
                }
            }
            bw.write("width: " + width + ", height: " + height);
            bw.close();
        }catch(Exception e){
            System.err.println("something messed up");
        }
    }
    
    public static void filterOnlyBlue(BufferedImage img){
        int width = img.getWidth();
        int height = img.getHeight();
        
        for(int i = 0; i < width; i++){
            for(int j = 0; j < height;j++){
                int blue = new Color(img.getRGB(i, j)).getBlue();
                img.setRGB(i, j, new Color(0, 0, blue).getRGB());
            }
        }
    }
    
    public static void filterOnlyGreen(BufferedImage img){
        int width = img.getWidth();
        int height = img.getHeight();
        
        for(int i = 0; i < width; i++){
            for(int j = 0; j < height;j++){
                int green = new Color(img.getRGB(i, j)).getGreen();
                img.setRGB(i, j, new Color(0, green, 0).getRGB());
            }
        }
    }
    
    public static void filterZeroRed(BufferedImage img){
        int width = img.getWidth();
        int height = img.getHeight();
        
        for(int i = 0; i < width; i++){
            for(int j = 0; j < height;j++){
                int blue = new Color(img.getRGB(i, j)).getBlue();
                int green = new Color(img.getRGB(i, j)).getGreen();
                img.setRGB(i, j, new Color(0, green, blue).getRGB());
            }
        }
    }
    
    public static void filterZeroBlue(BufferedImage img){
        int width = img.getWidth();
        int height = img.getHeight();
        
        for(int i = 0; i < width; i++){
            for(int j = 0; j < height;j++){
                int red = new Color(img.getRGB(i, j)).getRed();
                int green = new Color(img.getRGB(i, j)).getGreen();
                img.setRGB(i, j, new Color(red, green, 0).getRGB());
            }
        }
    }
    
    public static void filterZeroGreen(BufferedImage img){
        int width = img.getWidth();
        int height = img.getHeight();
        
        for(int i = 0; i < width; i++){
            for(int j = 0; j < height;j++){
                int red = new Color(img.getRGB(i, j)).getRed();
                int blue = new Color(img.getRGB(i, j)).getBlue();
                img.setRGB(i, j, new Color(red, 0, blue).getRGB());
            }
        }
    }
    
    public static void filterFlipHorizontally(BufferedImage img){
        int width = img.getWidth();
        int height = img.getHeight();
        
        for(int i = 0; i < width/2; i++){
            for(int j = 0; j < height; j++){
                int rgb1 = img.getRGB(i, j);
                int rgb2 = img.getRGB(width - 1 - i, j);
                img.setRGB(i, j, rgb2);
                img.setRGB(width - 1 - i, j, rgb1);
            }
        }
    }
    
    public static void filterFlipVertically(BufferedImage img){
        int width = img.getWidth();
        int height = img.getHeight();
        
        for(int i = 0; i < width; i++){
            for(int j = 0; j < height/2; j++){
                int rgb1 = img.getRGB(i, j);
                int rgb2 = img.getRGB(i, height - 1 - j);
                img.setRGB(i, j, rgb2);
                img.setRGB(i, height - 1 - j, rgb1);
            }
        }
    }
    
    public static void filterGrayscale(BufferedImage img){
        int width = img.getWidth();
        int height = img.getHeight();
        
        for(int i = 0; i < width; i++){
            for(int j = 0; j < height; j++){
                Color color = new Color(img.getRGB(i, j));
                int avg = (color.getRed() + color.getGreen() + color.getBlue()) / 3;
                
                img.setRGB(i, j, new Color(avg, avg, avg).getRGB());
            }
        }
    }
}

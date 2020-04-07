package framework.commands;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ZoomInCommand implements Command {

    int newWidth, initX;
    int newHeight, initY;

    JLabel image = null;
    File selectedFile;
    
    public ZoomInCommand(File selectedFile, JLabel img) {
    	this.selectedFile = selectedFile;
    	this.image = img;
    	newWidth = img.getWidth();
    	newHeight = img.getHeight();
    }
    
    @Override
    public void handle() {
    	zoomIn();
    }

    // resize
    public Image resize(int width, int height, Image img) {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = bi.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(img, 0, 0, width, height, null);
        g2.dispose();
        return bi;
    }

    // zoom in
    public void zoomIn() {
        if (image != null) {
            try {

                // agrandissement de 100 en x et y
                newWidth = newWidth + 100;
                newHeight = newWidth + 100;

                // redessiner l'image selon la nouvelle grandeur
                Image temp = ImageIO.read(selectedFile);
                ImageIcon ic = new ImageIcon(resize(newWidth, newHeight, temp));
                image.setIcon(ic);
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

package framework.commands;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ZoomOutCommand implements Command {

    int newWidth, initX;
    int newHeight, initY;

    JLabel image = null;
    private File selectedFile;
    
    public ZoomOutCommand(File selectedFile, JLabel img) {
    	this.selectedFile = selectedFile;
    	this.image = img;
    	newWidth = img.getWidth();
    	newHeight = img.getHeight();
    }
    
    public void handle() {
    	zoomOut();
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
    
	 // zoom out
    public void zoomOut() {
        if (selectedFile != null) {
            try {

                // tant que l'imagine ne deviendra pas negatif
                if (newWidth > 100 && newHeight > 100) {

                    // reduit l'image de 100 en x et y
                    newWidth = newWidth - 100;
                    newHeight = newHeight - 100;

                    // redessiner l'image selon la nouvelle grandeur
                    Image temp = ImageIO.read(selectedFile);
                    ImageIcon ic = new ImageIcon(resize(newWidth, newHeight, temp));
                    image.setIcon(ic);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

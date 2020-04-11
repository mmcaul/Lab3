package framework.commands;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/******************************************************
 Cours:   LOG121
 Session: H2020
 Groupe: 04
 Projet: Laboratoire #3
 Étudiant(e)s: Mélissa McAuley, Anthony Nguyen, Dat Quang Nguyen, Yussef Shehadeh

 Professeur : Benoit Galarneau
 Nom du fichier: ZoomInCommand.java
 Date créé: 2020-03-30
 Date dern. modif. 2020-04-07
 *******************************************************/

public class ZoomInCommand implements Command {

    int newWidth;
    int newHeight;

    JLabel image;
    File selectedFile;

    /**
     * Constructeur par parametre
     * @param selectedFile : File
     * @param img : JLabel
     */
    public ZoomInCommand(File selectedFile, JLabel img) {
    	this.selectedFile = selectedFile;
    	this.image = img;
    	newWidth = img.getWidth();
    	newHeight = img.getHeight();
    }

    /**
     * Effectue l'appel pour la commande du zoom interieur
     */
    @Override
    public void handle() {
    	zoomIn();
    }

    /**
     * Redimensionne l'image
     * @param width : int
     * @param height : int
     * @param img : Image
     * @return : Image
     */
    public Image resize(int width, int height, Image img) {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = bi.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(img, 0, 0, width, height, null);
        g2.dispose();
        return bi;
    }

    /**
     * Methode du zoom interieur
     */
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

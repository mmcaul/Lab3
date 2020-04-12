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

/******************************************************
 Cours:   LOG121
 Session: H2020
 Groupe: 04
 Projet: Laboratoire #3
 Étudiant(e)s: Mélissa McAuley, Anthony Nguyen, Dat Quang Nguyen, Yussef Shehadeh

 Professeur : Benoit Galarneau
 Nom du fichier: ZoomOutCommand.java
 Date créé: 2020-03-30
 Date dern. modif. 2020-04-07
 *******************************************************/

public class ZoomOutCommand implements Command {

    int newWidth;
    int newHeight;

    JLabel image;
    private File selectedFile;

    /**
     * Constructeur par parametre
     * @param selectedFile : File
     * @param img : JLabel
     */
    public ZoomOutCommand(File selectedFile, JLabel img) {
    	this.selectedFile = selectedFile;
    	this.image = img;
    	newWidth = img.getWidth();
    	newHeight = img.getHeight();
    }

    /**
     * Effectue l'appel pour la commande du zoom exterieur
     */
    public void handle() {
    	zoomOut();
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
     * Methode du zoom exterieur
     */
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

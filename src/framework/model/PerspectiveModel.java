package framework.model;

import framework.observer.MonObservable;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class PerspectiveModel extends MonObservable implements Image {

    ArrayList<ImageIcon> arrayImage = new ArrayList<>();

    String imagePathThumbnail = "BabyYodaThumbnail.jpg";
    ImageIcon pictureThumbnail = new ImageIcon(imagePathThumbnail);
    BufferedImage imageThumbnail;

    String imagePathMagnified = "BabyYodaMagnified.jpg";
    ImageIcon pictureMagnified = new ImageIcon(imagePathMagnified);
    BufferedImage imageMagnified;

    String imagePathTurned = "BabyYodaTurned.jpg";
    ImageIcon pictureTurned = new ImageIcon(imagePathTurned);
    BufferedImage imageTurned;

    public PerspectiveModel(){

        try{
            imageThumbnail = ImageIO.read(new File(imagePathThumbnail));
            imageMagnified = ImageIO.read(new File(imagePathMagnified));
            imageTurned = ImageIO.read(new File(imagePathTurned));
        } catch(IOException ie){
            ie.printStackTrace();
        }
    }

    public ArrayList<ImageIcon> getPicture(){
        arrayImage.add(pictureThumbnail);
        arrayImage.add(pictureMagnified);
        arrayImage.add(pictureTurned);
        return arrayImage;
    }

    /*public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imageThumbnail, 3, 4, this);
        g.drawImage(imageMagnified, 3, 4, this);
        g.drawImage(imageTurned, 3, 4, this);
    }*/


    /**
     * Main servant a tester la classe perspectiveModel pour l'eventuel affichage
     * @param args : String[]
     */
   /*
   public static void main(String[] args) {
        JFrame frameThumbnail = new JFrame();
        JFrame frameTurned = new JFrame();

        frameThumbnail.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frameThumbnail.setSize(90,75);

        frameTurned.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frameTurned.setSize(600,600);

        JPanel panelThumbnail = new JPanel();
        JPanel panelTurned = new JPanel();

        PerspectiveModel model = new PerspectiveModel();
        JLabel labelThumbnail = new JLabel(model.getPictureThumbnail());
        //JLabel labelMagnefied = new JLabel(model.getPictureMagnified());
        JLabel labelTurned = new JLabel(model.getPictureTurned());

        panelThumbnail.add(labelThumbnail);
        //panel.add(labelMagnefied);
        panelTurned.add(labelTurned);

        frameThumbnail.add(panelThumbnail);
        frameTurned.add(panelTurned);

        frameThumbnail.setVisible(true);
        frameTurned.setVisible(true);
    }*/

}

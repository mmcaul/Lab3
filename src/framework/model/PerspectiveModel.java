package framework.model;

import framework.observer.MonObservable;

import javax.swing.*;

public class PerspectiveModel extends MonObservable {

    String imagePathThumbnail = "BabyYodaThumbnail.jpg";
    ImageIcon pictureThumbnail = new ImageIcon(imagePathThumbnail);

    String imagePathMagnified = "BabyYodaMagnified.jpg";
    ImageIcon pictureMagnified = new ImageIcon(imagePathMagnified);

    String imagePathTurned = "BabyYodaTurned.jpg";
    ImageIcon pictureTurned = new ImageIcon(imagePathTurned);

    public ImageIcon getPictureThumbnail(){
        return pictureThumbnail;
    }

    public ImageIcon getPictureMagnified(){
        return pictureMagnified;
    }

    public ImageIcon getPictureTurned(){
        return pictureTurned;
    }

    /**
     * Main servant a tester la classe perspectiveModel pour l'eventuel affichage
     * @param args : String[]
     */
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
    }

}

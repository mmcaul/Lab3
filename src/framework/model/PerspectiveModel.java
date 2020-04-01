package framework.model;

import javax.swing.*;

public class PerspectiveModel extends Model{

    String imagePathThumbnail = "BabyYodaThumbnail.jpg";
    ImageIcon pictureThumbnail;

    String imagePathMagnified = "BabyYodaMagnified.jpg";
    ImageIcon pictureMagnified;

    String imagePathTurned = "BabyYodaTurned.jpg";
    ImageIcon pictureTurned;

    public PerspectiveModel(){
        pictureThumbnail = new ImageIcon(imagePathThumbnail);
        pictureMagnified = new ImageIcon(imagePathMagnified);
        pictureTurned = new ImageIcon(imagePathTurned);
    }

}

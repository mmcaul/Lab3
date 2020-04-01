package framework.model;

import framework.MonObservable;

import javax.swing.*;

public class ImageModel extends MonObservable {

    String imagePath = "BabyYoda.jpg";
    ImageIcon picture = new ImageIcon(imagePath);

    public ImageIcon getPicture(){
        return picture;
    }

}

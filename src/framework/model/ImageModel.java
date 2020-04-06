package framework.model;

import framework.observer.MonObservable;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ImageModel extends MonObservable implements Image{

    ArrayList<ImageIcon> arrayImage = new ArrayList<>();
    String imagePath = "BabyYoda.jpg";
    ImageIcon picture = new ImageIcon(imagePath);
    BufferedImage image;

    public ImageModel(){

        try{
            image = ImageIO.read(new File(imagePath));
        } catch(IOException ie){
            ie.printStackTrace();
        }

    }

    public ArrayList<ImageIcon> getPicture(){
        arrayImage.add(picture);
        return arrayImage;
    }

    /*public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 3, 4, this);
    }*/

}

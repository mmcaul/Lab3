package framework.model;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ImageModel extends Model{

    String imagePath = "BabyYoda.jpg";
    ImageIcon picture;

    public ImageModel() throws IOException {
        picture = new ImageIcon(imagePath);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);



    }

    public ImageIcon getPicture(){
        return picture;
    }

}

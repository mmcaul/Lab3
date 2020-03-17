package framework;

import javax.swing.*;
import java.util.ArrayList;

public class ImageController {

    // Singleton
    private static ImageController instance = new ImageController();
    private ImageController(){};
    public static ImageController getInstance(){
        return instance;
    }

    // Controller
    ImageModel image;
    JFrame view;

    public void setView(JFrame view) {
        this.view = view;
    }

    public void setImage(ImageModel image) {
        this.image = image;
    }

    public void handleOpen(){

    }

    public void handleZoom(){

    }

    public void handleMove(){

    }

    public void handleUndo(){

    }

    public void handleSave(){

    }

}

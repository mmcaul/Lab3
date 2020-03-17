package framework;

import javax.swing.*;

public class CommandController {

    // Singleton
    private static CommandController instance = new CommandController();
    private CommandController(){};
    public static CommandController getInstance(){
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

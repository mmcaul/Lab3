package framework.controller;

import framework.commands.Command;
import framework.commands.Memento;
import framework.model.ImageModel;
import framework.model.PerspectiveModel;
import framework.view.*;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class GestionCommandes {

    Memento memento;

    // Singleton
    private static GestionCommandes instance = new GestionCommandes();
    private GestionCommandes(){};
    public static GestionCommandes getInstance(){
        return instance;
    }

    // Controller
    JFrame frame;
    int xPos, yPos;

    ImageModel image;
    PerspectiveModel imageThumbnail;
    PerspectiveModel imageMagnified;
    PerspectiveModel imageTurned;

    ChangingView changingView;
    ThumbnailView thumbnailView;
    MagnifiedView magnifiedView;
    TurnedView turnedView;

    public void setFrame(JFrame f){
        this.frame = f;
    }

    public void setChangingView(ChangingView cV){
        this.changingView = cV;
    }

    public void setImageModel(ImageModel iM){
        this.image = iM;
    }

    public void executeCommand(Command c){
        c.handle();
    }

    public Memento save(){
        return memento;
    }

    public void restore(Memento m){
        this.memento = m;
    }
}

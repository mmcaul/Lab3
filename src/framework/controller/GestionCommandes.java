package framework.controller;

import framework.commands.Command;
import framework.commands.Memento;
import framework.model.ImageModel;
import framework.model.PerspectiveModel;
import framework.view.*;

import javax.swing.*;

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
    public int xPos, yPos;

    public ImageModel imageM;
    public PerspectiveModel imageP;

    public ChangingView changingView;
    public ThumbnailView thumbnailView;
    public  MagnifiedView magnifiedView;
    public TurnedView turnedView;

    public void setFrame(JFrame f){
        this.frame = f;
    }

    public void setChangingView(ChangingView cV){
        this.changingView = cV;
    }

    public void setImageModel(ImageModel iM){
        this.imageM = iM;
    }

    public void setPerspectiveModel(PerspectiveModel pM){
        this.imageP = pM;
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

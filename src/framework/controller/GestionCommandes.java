package framework.controller;

import framework.commands.Command;
import framework.commands.Memento;
import framework.model.ImageModel;
import framework.model.PerspectiveModel;
import framework.view.*;

import javax.swing.*;

/******************************************************
 Cours:   LOG121
 Session: H2020
 Groupe: 04
 Projet: Laboratoire #3
 Étudiant(e)s: Mélissa McAuley, Anthony Nguyen, Dat Quang Nguyen, Yussef Shehadeh

 Professeur : Benoit Galarneau
 Nom du fichier: GestionCommandes.java
 Date créé: 2020-03-19
 Date dern. modif. 2020-04-07
 *******************************************************/

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

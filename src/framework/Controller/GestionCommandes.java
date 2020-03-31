package framework.Controller;

import framework.Commands.Command;
import framework.Commands.Memento;
import framework.Model.ImageModel;

import javax.swing.*;

public class GestionCommandes {

    Memento memento;
    Command command;

    // Singleton
    private static GestionCommandes instance = new GestionCommandes();
    private GestionCommandes(){};
    public static GestionCommandes getInstance(){
        return instance;
    }

    // Controller
    ImageModel image;
    JFrame view;

    public void handle(){
        command.handle();
    }

    public void setView(JFrame view) {
        this.view = view;
    }

    public void setImage(ImageModel image) {
        this.image = image;
    }

    public Memento save(){
        return memento;
    }

    public void restore(Memento m){
        this.memento = m;
    }

}

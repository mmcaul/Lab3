package framework.commands;

import framework.controller.GestionCommandes;
import framework.model.ImageModel;

public class ZoomCommand implements Command {

    protected GestionCommandes gestionCommandes;
    protected ImageModel image;

    public ZoomCommand(GestionCommandes iC, ImageModel iM){
        this.gestionCommandes = iC;
        this.image = iM;
    }

    @Override
    public void handle(){

    }
}

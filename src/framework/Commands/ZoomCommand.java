package framework.Commands;

import framework.Controller.GestionCommandes;
import framework.Model.ImageModel;

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

package framework.commands;

import framework.controller.GestionCommandes;
import framework.model.ImageModel;

public class MoveCommand implements Command {

    protected GestionCommandes gestionCommandes;
    protected ImageModel image;

    public MoveCommand(GestionCommandes iC, ImageModel iM){
        this.gestionCommandes = iC;
        this.image = iM;
    }

    @Override
    public void handle(){

    }
}

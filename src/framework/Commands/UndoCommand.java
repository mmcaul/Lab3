package framework.Commands;

import framework.Controller.GestionCommandes;
import framework.Model.ImageModel;

public class UndoCommand implements Command {

    protected GestionCommandes gestionCommandes;
    protected ImageModel image;

    public UndoCommand(GestionCommandes iC, ImageModel iM){
        this.gestionCommandes = iC;
        this.image = iM;
    }

    @Override
    public void handle(){

    }

}

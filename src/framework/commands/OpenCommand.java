package framework.commands;

import framework.controller.GestionCommandes;
import framework.view.ChangingView;

public class OpenCommand implements Command {

    protected GestionCommandes gestionCommandes;

    public OpenCommand(GestionCommandes gC){
        this.gestionCommandes = gC;
    }

    @Override
    public void handle(){

        ChangingView changingView = new ChangingView();
        changingView.init();
        gestionCommandes.setChangingView(changingView);

    }
}

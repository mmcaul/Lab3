package framework.commands;

import framework.controller.GestionCommandes;
import framework.view.ChangingView;

public class OpenCommand implements Command {

    protected GestionCommandes gestionCommandes;

    public OpenCommand(){
        //this.gestionCommandes = iC;
    }

    @Override
    public void handle(){

        ChangingView changingView = new ChangingView();
        gestionCommandes.setChangingView(changingView);
        changingView.init();
        //gestionCommandes.addChangingPanel(changingView);

    }
}

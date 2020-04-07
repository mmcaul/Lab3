package framework.commands;

import framework.controller.GestionCommandes;
import framework.view.ChangingView;
import framework.view.MagnifiedView;
import framework.view.ThumbnailView;
import framework.view.TurnedView;

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

        ThumbnailView thumbnailView = new ThumbnailView();
        thumbnailView.init();

        MagnifiedView magnifiedView = new MagnifiedView();
        magnifiedView.init();

        TurnedView turnedView = new TurnedView();
        turnedView.init();

    }
}

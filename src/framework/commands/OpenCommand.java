package framework.commands;

import framework.controller.GestionCommandes;
import framework.view.ChangingView;
import framework.view.MagnifiedView;
import framework.view.ThumbnailView;
import framework.view.TurnedView;

/******************************************************
 Cours:   LOG121
 Session: H2020
 Groupe: 04
 Projet: Laboratoire #3
 Étudiant(e)s: Mélissa McAuley, Anthony Nguyen, Dat Quang Nguyen, Yussef Shehadeh

 Professeur : Benoit Galarneau
 Nom du fichier: OpenCommand.java
 Date créé: 2020-03-19
 Date dern. modif. 2020-04-07
 *******************************************************/

public class OpenCommand implements Command {

    protected GestionCommandes gestionCommandes;

    /**
     * Constructeur par parametres
     * @param gC : GestionCommandes
     */
    public OpenCommand(GestionCommandes gC){
        this.gestionCommandes = gC;
    }

    /**
     * Prend en charge ce qui arrive lorsqu'on veut ouvrir une image
     */
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

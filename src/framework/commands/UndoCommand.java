package framework.commands;

import framework.controller.GestionCommandes;
import framework.model.ImageModel;

/******************************************************
 Cours:   LOG121
 Session: H2020
 Groupe: 04
 Projet: Laboratoire #3
 Étudiant(e)s: Mélissa McAuley, Anthony Nguyen, Dat Quang Nguyen, Yussef Shehadeh

 Professeur : Benoit Galarneau
 Nom du fichier: Command.java
 Date créé: 2020-03-19
 Date dern. modif. 2020-04-11
 *******************************************************/

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

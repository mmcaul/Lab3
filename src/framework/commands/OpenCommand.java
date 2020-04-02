package framework.commands;

import framework.controller.GestionCommandes;
import framework.model.ImageModel;

import javax.swing.*;
import java.awt.event.MouseEvent;

public class OpenCommand implements Command {

    protected GestionCommandes gestionCommandes;
    protected ImageModel image;

    public OpenCommand(GestionCommandes iC, ImageModel iM){
        this.gestionCommandes = iC;
        this.image = iM;
    }

    @Override
    public void handle(){

        JLabel label = new JLabel(image.getPicture());


    }
}

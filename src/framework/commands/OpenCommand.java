package framework.commands;

import framework.controller.GestionCommandes;
import framework.model.ImageModel;

import javax.swing.*;

public class OpenCommand implements Command{

    protected GestionCommandes gestionCommandes;
    protected ImageModel image;

    public OpenCommand(GestionCommandes iC, ImageModel iM){
        this.gestionCommandes = iC;
        this.image = iM;
    }

    @Override
    public void handle(){

        JLabel label = new JLabel(image.getPicture());
        //frame.add(label);

    }

}

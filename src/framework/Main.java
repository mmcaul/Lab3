package framework;

import framework.controller.GestionCommandes;
import framework.model.ImageModel;
import framework.view.ChangingView;
import framework.view.Menu;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args){

        // Cree une instance du controlleur et le lie avec le frame du jeu
        GestionCommandes gestionCommandes = GestionCommandes.getInstance();

        JFrame frame = new JFrame();
        gestionCommandes.setFrame(frame);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1000,600);
        frame.setLayout(new BorderLayout());

        Menu menu = new Menu();

        frame.setJMenuBar(menu);

        frame.setVisible(true);

        /*
        // Cree une instance du controlleur et le lie avec le frame du jeu
        GestionCommandes gestionCommandes = GestionCommandes.getInstance();

        JFrame frame = new JFrame();
        ImageModel imageOriginal = new ImageModel();

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1000,600);
        frame.setLayout(new BorderLayout());

        gestionCommandes.setView(frame);
        ChangingView changingView = new ChangingView();

        Menu menu = new Menu();

        frame.setJMenuBar(menu);
        frame.add(changingView);

        frame.setVisible(true);
*/
    }
}

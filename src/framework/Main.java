package framework;

import framework.controller.GestionCommandes;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args){

        // Cree une instance du controlleur et le lie avec le frame du jeu
        GestionCommandes gestionCommandes = GestionCommandes.getInstance();

        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1000,600);
        frame.setLayout(new BorderLayout());

        gestionCommandes.setView(frame);

        Menu menu = new Menu();

        frame.setJMenuBar(menu);

        frame.setVisible(true);

    }
}

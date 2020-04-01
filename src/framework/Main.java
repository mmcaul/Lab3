package framework;

import framework.controller.GestionCommandes;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        // Cree une instance du controlleur et le lie avec le frame du jeu
        GestionCommandes gestionCommandes = GestionCommandes.getInstance();

        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1000,600);
        frame.setLayout(new BorderLayout());

        gestionCommandes.setView(frame);

        // Cree le menu pour une nouvelle partie et quitter
        Menu menu = new Menu();

        //ImageModel image = new ImageModel();

        frame.setJMenuBar(menu);

        //JLabel label = new JLabel(image.getPicture());
        //frame.add(label);

        frame.setVisible(true);

    }
}

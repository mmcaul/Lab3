package framework;

import framework.controller.GestionCommandes;
import framework.view.Menu;

import javax.swing.*;
import java.awt.*;

/******************************************************
 Cours:   LOG121
 Session: H2020
 Groupe: 04
 Projet: Laboratoire #3
 Étudiant(e)s: Mélissa McAuley, Anthony Nguyen, Dat Quang Nguyen, Yussef Shehadeh

 Professeur : Benoit Galarneau
 Nom du fichier: Main.java
 Date créé: 2020-03-19
 Date dern. modif. 2020-04-07
 *******************************************************/

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

    }
}

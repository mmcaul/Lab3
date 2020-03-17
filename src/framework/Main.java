package framework;

import framework.Controller.CommandController;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        // Cree une instance du controlleur et le lie avec le frame du jeu
        CommandController commandController = CommandController.getInstance();

        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1000,600);
        frame.setLayout(new BorderLayout());

        commandController.setView(frame);

        // Cree le menu pour une nouvelle partie et quitter
        Menu menu = new Menu();

        frame.setJMenuBar(menu);

        frame.setVisible(true);

    }
}

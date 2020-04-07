package framework.view;

import framework.commands.Command;
import framework.commands.OpenCommand;
import framework.controller.GestionCommandes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JMenuBar {

    JMenu menu;

    public Menu(){

        // Cree l'affichage pour le menu et les elements contenu a l'interieur
        menu = new JMenu("Fichier");

        JMenuItem itemOpen = new JMenuItem("Open");
        JMenuItem itemSave = new JMenuItem("Save");

        // Action Listener pour ouvrir une nouvelle image
        class OpenMenuListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                GestionCommandes gestionCommandes = GestionCommandes.getInstance();
                gestionCommandes.executeCommand(new OpenCommand(gestionCommandes));
            }
        }

        itemOpen.addActionListener(new OpenMenuListener());

        // Action Listener pour enregistrer l'image
        class SaveMenuListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                GestionCommandes gestionCommandes = GestionCommandes.getInstance();
            }
        }
        
        itemSave.addActionListener(new SaveMenuListener());

        menu.add(itemOpen);
        menu.add(itemSave);

        add(menu);

        menu = new JMenu("Edit");

        JMenuItem itemUndo = new JMenuItem("Undo");

        menu.add(itemUndo);

        add(menu);

    }

}

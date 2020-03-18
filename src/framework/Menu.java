package framework;

import framework.Controller.CommandController;

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

                CommandController commandController = CommandController.getInstance();
                commandController.handle();
            }
        }

        itemOpen.addActionListener(new OpenMenuListener());

        // Action Listener pour enregistrer l'image
        class SaveMenuListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                CommandController commandController = CommandController.getInstance();
            }
        }
        itemSave.addActionListener(new SaveMenuListener());

        menu.add(itemOpen);
        menu.add(itemSave);

        add(menu);

        menu = new JMenu("Edit");

        JMenuItem itemZoom = new JMenuItem("Zoom");
        JMenuItem itemMove = new JMenuItem("Move");
        JMenuItem itemUndo = new JMenuItem("Undo");

        // Action Listener pour zoom in et out de l'image
        class ZoomMenuListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {

                CommandController commandController = CommandController.getInstance();
                commandController.handle();
            }
        }

        itemZoom.addActionListener(new ZoomMenuListener());

        // Action Listener pour faire bouger l'image sur l'écran
        class MoveMenuListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                CommandController commandController = CommandController.getInstance();
                commandController.handle();
            }
        }
        itemMove.addActionListener(new MoveMenuListener());

        // Action Listener pour defaire un changement
        class UndoMenuListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                CommandController commandController = CommandController.getInstance();
                commandController.handle();
            }
        }

        itemMove.addActionListener(new UndoMenuListener());

        menu.add(itemZoom);
        menu.add(itemMove);
        menu.add(itemUndo);

        add(menu);

    }

}

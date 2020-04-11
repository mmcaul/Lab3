package framework.view;

import framework.commands.Command;
import framework.commands.OpenCommand;
import framework.controller.GestionCommandes;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Menu extends JMenuBar {

    JMenu menu;
    private File selectedFileSave;
    private JFileChooser saveFile;

    int newWidth;
    int newHeight;

    JLabel image = null;

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
                saveFile = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                saveFile.setDialogTitle("Save Image");

                int returnValue = saveFile.showSaveDialog(null);

                if(returnValue == JFileChooser.APPROVE_OPTION) {

                    selectedFileSave = saveFile.getSelectedFile();

                    try {
                        // rendre le JLabel en BufferedImage pour le sauvegarder
                        Icon icon = image.getIcon();
                        BufferedImage bi = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
                        Graphics g = bi.createGraphics();
                        icon.paintIcon(null, g, 0, 0);
                        g.dispose();

                        // sauvegarder
                        ImageIO.write(bi, "png", selectedFileSave);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
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

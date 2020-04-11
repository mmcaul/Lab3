package framework.view;

import framework.controller.GestionCommandes;
import framework.model.PerspectiveModel;
import framework.observer.MonObserver;

import javax.swing.*;
import java.awt.*;

/******************************************************
 Cours:   LOG121
 Session: H2020
 Groupe: 04
 Projet: Laboratoire #3
 Étudiant(e)s: Mélissa McAuley, Anthony Nguyen, Dat Quang Nguyen, Yussef Shehadeh

 Professeur : Benoit Galarneau
 Nom du fichier: ThumbnailView.java
 Date créé: 2020-03-19
 Date dern. modif. 2020-04-07
 *******************************************************/

public class ThumbnailView extends JPanel implements MonObserver {

    protected PerspectiveModel imageModel;
    protected JLabel imageThumbnail;
    protected GestionCommandes gestionCommandes;
    protected JFrame frame;
    private int xPos=90, yPos=100;

    /**
     * Constructeur par défault
     */
    public ThumbnailView(){
        frame = new JFrame();
        frame.setTitle("Thumbnail Frame");
        gestionCommandes = GestionCommandes.getInstance();

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(xPos,yPos);
        frame.setLayout(new BorderLayout());

        setPreferredSize(new Dimension(xPos, xPos));

        frame.add(this);
        frame.setVisible(true);
    }

    /**
     * Initialise un frame pour l'image thumbnail
     */
    public void init(){
        Dimension d = new Dimension(100, 100);
        setSize(d);
        setMinimumSize(d);
        setMaximumSize(d);

        setLayout(new BoxLayout(this,BoxLayout.X_AXIS));

        imageModel = new PerspectiveModel();
        gestionCommandes.setPerspectiveModel(imageModel);
        imageThumbnail = new JLabel(imageModel.getPicture().get(0));
        add(imageThumbnail);
    }

    /**
     * Met a jour l'image
     */
    @Override
    public void update(){
    	imageThumbnail.repaint();
    }

}

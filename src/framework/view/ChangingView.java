package framework.view;

import framework.commands.ZoomInCommand;
import framework.commands.ZoomOutCommand;
import framework.controller.GestionCommandes;
import framework.model.ImageModel;
import framework.observer.MonObserver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

/******************************************************
 Cours:   LOG121
 Session: H2020
 Groupe: 04
 Projet: Laboratoire #3
 Étudiant(e)s: Mélissa McAuley, Anthony Nguyen, Dat Quang Nguyen, Yussef Shehadeh

 Professeur : Benoit Galarneau
 Nom du fichier: ChangingView.java
 Date créé: 2020-03-19
 Date dern. modif. 2020-04-07
 *******************************************************/

public class ChangingView extends JPanel implements MonObserver{

    protected ImageModel imageModel;
    protected JLabel changingImage;
    protected GestionCommandes gestionCommandes = GestionCommandes.getInstance();
    protected JFrame frame;
    private int xPos=900, yPos=900;

    protected Point initialClick;
    protected int initX, initY;
    protected int x, width, y, height;

	/**
	 * Constructeur par défault
	 */
	public ChangingView(){
        frame = new JFrame();
        frame.setTitle("Changing Frame");

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(xPos,yPos);
        frame.setLayout(new BorderLayout());

        setPreferredSize(new Dimension(xPos, xPos));
        // zoom in and out of image
        addMouseWheelListener(new MouseWheelListener() {

			/**
			 * Appel à la command zoomIn et zoomOut lorsque la
			 * roulette de la souris est activé
			 * @param e : MouseWheelEvent
			 */
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {

					int point = e.getWheelRotation();
					if (point < 0) {
						gestionCommandes.executeCommand(new ZoomInCommand(new File("BabyYoda.jpg"), changingImage));
						update();
						e.getUnitsToScroll();
					} else {
						gestionCommandes.executeCommand(new ZoomOutCommand(new File("BabyYoda.jpg"), changingImage));
						update();
						e.getUnitsToScroll();
					}
			}
        });
        
        
        // move image according to where you move your mouse and clicked
        addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
			}

			/**
			 * Permet de connaitre le point initale du click
			 * @param e : MouseEvent
			 */
			@Override
			public void mousePressed(MouseEvent e) {
				
				initialClick = e.getPoint();
				
			}

			/**
			 * Sauvegarde la nouvelle position de la souris après le click
			 * @param e : MouseEvent
			 */
			@Override
			public void mouseReleased(MouseEvent e) {
				
				initX = changingImage.getX();
				initY = changingImage.getY();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
			}  
		});
		
		// inspired https://stackoverflow.com/questions/26227046/moving-image-with-mouse-java
		addMouseMotionListener(new MouseMotionAdapter() {

			/**
			 * Parcours la distance lorsqu'un click est initialisé
			 * @param e : MouseEvent
			 */
			public void mouseDragged(MouseEvent e) {
				
				// Mouvement de la souris
				int difX = e.getX() - initialClick.x;
				int difY = e.getY() - initialClick.y;
				
				// Bouge l'image
				x = initX + difX;
				y = initY + difY;
				
				// redessiner l'image selon la position de la souris
				update();
			}
		});
		

        frame.add(this);
        frame.setVisible(true);
    }

	/**
	 * Initialise le frame de l'image pouvant être modifier
	 */
	public void init(){
        Dimension d = new Dimension(600, 600);
        setSize(d);
        setMinimumSize(d);
        setMaximumSize(d);

        setLayout(new BoxLayout(this,BoxLayout.X_AXIS));

        imageModel = new ImageModel();
        gestionCommandes.setImageModel(imageModel);
        changingImage = new JLabel(imageModel.getPicture().get(0));
        add(changingImage);
    }

	/**
	 * Actualise l'image lorsqu'il y a un changement
	 */
    @Override
    public void update(){
        //If frame changes size, picture changes with it and all other picture frames too
    	width = gestionCommandes.changingView.changingImage.getWidth();
    	height = gestionCommandes.changingView.changingImage.getHeight();

        //If frame moves, all other frames move too
    	gestionCommandes.changingView.changingImage.setLocation(x,y);
    }

}

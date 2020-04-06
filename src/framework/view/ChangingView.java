package framework.view;

import framework.controller.GestionCommandes;
import framework.model.ImageModel;
import framework.observer.MonObserver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChangingView extends JPanel implements MonObserver{

    protected ImageModel imageModel;
    protected JLabel changingImage;
    protected GestionCommandes gestionCommandes;
    protected JFrame frame;
    protected JPanel panel;
    private int xPos=900, yPos=900;

    public ChangingView(){
        frame = new JFrame();
        frame.setTitle("Changing Frame");
        gestionCommandes = GestionCommandes.getInstance();

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(xPos,yPos);
        frame.setLayout(new BorderLayout());

        //panel = new JPanel();
        setPreferredSize(new Dimension(xPos, xPos));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                xPos = e.getX();
                yPos = e.getY();
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                frame.setLocation(frame.getX()+e.getX()-xPos,frame.getY()+e.getY()-yPos);
            }
        });

        frame.add(this);
        frame.setVisible(true);
    }

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


    @Override
    public void update(){
        //If frame changes size, picture changes with it and all other picture frames too
        //If frame moves, all other frames move too
        
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(600,600);

        ChangingView changingView = new ChangingView();

        frame.add(changingView);

        frame.setVisible(true);
    }

}

package framework.view;

import framework.controller.GestionCommandes;
import framework.model.PerspectiveModel;
import framework.observer.MonObserver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class MagnifiedView extends JPanel implements MonObserver {

    protected PerspectiveModel imageModel;
    protected JLabel imageThumbnail, imageMagnified, imageTurned;
    protected GestionCommandes gestionCommandes;
    protected JFrame frame;
    private int xPos=900, yPos=900;

    public MagnifiedView(){
        frame = new JFrame();
        frame.setTitle("Magnified Frame");
        gestionCommandes = GestionCommandes.getInstance();

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(xPos,yPos);
        frame.setLayout(new BorderLayout());

        setPreferredSize(new Dimension(xPos, xPos));
        /*addMouseListener(new MouseAdapter() {
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
        });*/

        frame.add(this);
        frame.setVisible(true);
    }

    public void init(){
        Dimension d = new Dimension(600, 600);
        setSize(d);
        setMinimumSize(d);
        setMaximumSize(d);

        setLayout(new BoxLayout(this,BoxLayout.X_AXIS));

        imageModel = new PerspectiveModel();
        gestionCommandes.setPerspectiveModel(imageModel);
        imageMagnified = new JLabel(imageModel.getPicture().get(1));
        add(imageMagnified);

    }

    @Override
    public void update(){
    	imageMagnified.repaint();
    }

}

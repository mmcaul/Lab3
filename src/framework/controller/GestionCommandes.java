package framework.controller;

import framework.commands.Command;
import framework.commands.Memento;
import framework.model.ImageModel;
import framework.model.PerspectiveModel;
import framework.view.*;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class GestionCommandes implements MouseMotionListener, MouseListener {

    Memento memento;

    // Singleton
    private static GestionCommandes instance = new GestionCommandes();
    private GestionCommandes(){};
    public static GestionCommandes getInstance(){
        return instance;
    }

    // Controller
    JFrame frame;
    Menu menu = new Menu();

    ImageModel image;
    PerspectiveModel imageThumbnail;
    PerspectiveModel imageMagnified;
    PerspectiveModel imageTurned;

    ChangingView changingView;
    ThumbnailView thumbnailView;
    MagnifiedView magnifiedView;
    TurnedView turnedView;

    public void setFrame(JFrame f){
        this.frame = f;
    }

    public void setChangingView(ChangingView cV){
        this.changingView = cV;
    }

    public void setImageModel(ImageModel iM){
        this.image = iM;
    }

    public void executeCommand(Command c){
        c.handle();

    }

    public Memento save(){
        return memento;
    }

    public void restore(Memento m){
        this.memento = m;
    }


    /**
     * Invoked when the mouse button has been clicked (pressed
     * and released) on a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    /**
     * Invoked when a mouse button has been pressed on a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mousePressed(MouseEvent e) {

    }

    /**
     * Invoked when a mouse button has been released on a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseReleased(MouseEvent e) {

    }

    /**
     * Invoked when the mouse enters a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseEntered(MouseEvent e) {

    }

    /**
     * Invoked when the mouse exits a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseExited(MouseEvent e) {

    }

    /**
     * Invoked when a mouse button is pressed on a component and then
     * dragged.  {@code MOUSE_DRAGGED} events will continue to be
     * delivered to the component where the drag originated until the
     * mouse button is released (regardless of whether the mouse position
     * is within the bounds of the component).
     * <p>
     * Due to platform-dependent Drag&amp;Drop implementations,
     * {@code MOUSE_DRAGGED} events may not be delivered during a native
     * Drag&amp;Drop operation.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseDragged(MouseEvent e) {

    }

    /**
     * Invoked when the mouse cursor has been moved onto a component
     * but no buttons have been pushed.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseMoved(MouseEvent e) {

    }
}

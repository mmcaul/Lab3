package framework.model;

import framework.observer.MonObservable;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/******************************************************
 Cours:   LOG121
 Session: H2020
 Groupe: 04
 Projet: Laboratoire #3
 Étudiant(e)s: Mélissa McAuley, Anthony Nguyen, Dat Quang Nguyen, Yussef Shehadeh

 Professeur : Benoit Galarneau
 Nom du fichier: PerspectiveModel.java
 Date créé: 2020-03-19
 Date dern. modif. 2020-04-07
 *******************************************************/

public class PerspectiveModel extends MonObservable implements Image {

    ArrayList<ImageIcon> arrayImage = new ArrayList<>();

    String imagePathThumbnail = "BabyYodaThumbnail.jpg";
    ImageIcon pictureThumbnail = new ImageIcon(imagePathThumbnail);
    BufferedImage imageThumbnail;

    String imagePathMagnified = "BabyYodaMagnified.jpg";
    ImageIcon pictureMagnified = new ImageIcon(imagePathMagnified);
    BufferedImage imageMagnified;

    String imagePathTurned = "BabyYodaTurned.jpg";
    ImageIcon pictureTurned = new ImageIcon(imagePathTurned);
    BufferedImage imageTurned;

    /**
     * Constructeur par défault
     */
    public PerspectiveModel(){

        try{
            imageThumbnail = ImageIO.read(new File(imagePathThumbnail));
            imageMagnified = ImageIO.read(new File(imagePathMagnified));
            imageTurned = ImageIO.read(new File(imagePathTurned));
        } catch(IOException ie){
            ie.printStackTrace();
        }
    }

    /**
     * Méthode qui retourne un ArrayList contenant
     * toutes les perspectives d'images
     * @return ArrayList<ImageIcon>
     */
    public ArrayList<ImageIcon> getPicture(){
        arrayImage.add(pictureThumbnail);
        arrayImage.add(pictureMagnified);
        arrayImage.add(pictureTurned);
        return arrayImage;
    }
}

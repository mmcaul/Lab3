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
 Nom du fichier: ImageModel.java
 Date créé: 2020-03-19
 Date dern. modif. 2020-04-07
 *******************************************************/

public class ImageModel extends MonObservable implements Image{

    ArrayList<ImageIcon> arrayImage = new ArrayList<>();
    String imagePath = "BabyYoda.jpg";
    ImageIcon picture = new ImageIcon(imagePath);
    BufferedImage img;

    /**
     * Constructeur par défault
     */
    public ImageModel(){

        try{
            img = ImageIO.read(new File(imagePath));
        } catch(IOException ie){
            ie.printStackTrace();
        }
    }

    /**
     * Méthode qui retourne un ArrayList contenant l'image changeant
     * @return ArrayList<ImageIcon>
     */
    public ArrayList<ImageIcon> getPicture(){
        arrayImage.add(picture);
        return arrayImage;
    }
    
    /**
     * 
     */
    public ImageIcon getIcon() {
    	return picture;
    }
}

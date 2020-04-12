package framework.observer;

import javax.swing.*;
import java.util.ArrayList;

/******************************************************
 Cours:   LOG121
 Session: H2020
 Groupe: 04
 Projet: Laboratoire #3
 Étudiant(e)s: Mélissa McAuley, Anthony Nguyen, Dat Quang Nguyen, Yussef Shehadeh

 Professeur : Benoit Galarneau
 Nom du fichier: MonObservable.java
 Date créé: 2020-03-19
 Date dern. modif. 2020-04-05
 *******************************************************/

public class MonObservable extends JComponent {

    //Variable
    ArrayList<MonObserver> observerList = new ArrayList<>();

    /**
     * Met les observer dans le arraylist
     * @param observer : MonObserver
     */
    public void attacherObserver(MonObserver observer){
        observerList.add(observer);
    }

    /**
     * Parcourt tout les observer inscrit dans la liste
     */
    public void avertirLesObservers(){
        for(MonObserver observer : observerList){
            observer.update();
        }
    }

}

package framework.observer;

import javax.swing.*;
import java.util.ArrayList;

public class MonObservable extends JComponent {

    ArrayList<MonObserver> observerList = new ArrayList<MonObserver>();

    public void attacherObserver(MonObserver observer){
        observerList.add(observer);
    }

    public void avertirLesObservers(){
        for(MonObserver observer : observerList){
            observer.update();
        }
    }

}

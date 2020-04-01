package framework.observer;

import java.util.ArrayList;

public class MonObservable {

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

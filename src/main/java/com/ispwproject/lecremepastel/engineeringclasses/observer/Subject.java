package com.ispwproject.lecremepastel.engineeringclasses.observer;

import java.util.ArrayList;

public abstract class Subject {

    private final ArrayList<Observer> observers;

    protected Subject(){
        observers = new ArrayList<>();
    }

    public void attachObserver(Observer o){
        this.observers.add(o);
    }
    public void detachObserver(Observer o){
        this.observers.remove(o);
    }
    protected void notifyObservers(){
        for(Observer o : observers){
            o.update();
        }
    }

}

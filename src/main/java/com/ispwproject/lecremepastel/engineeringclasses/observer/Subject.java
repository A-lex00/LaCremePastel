package com.ispwproject.lecremepastel.engineeringclasses.observer;

public interface Subject {

    void attachObserver(Observer o);
    void detachObserver(Observer o);
    void notifyObservers();

}

package com.ispwproject.lacremepastel.engineeringclasses.observer;

import java.util.ArrayList;

public abstract class Soggetto {
    protected boolean stato;    //se settato a true, abbiamo una nuova notizia da leggere altrimenti niente da leggere!
    protected ArrayList observerList;
    public void registraObserver(Observer observer){
        observerList.add(observer);
    }
    public void rimuoviOsservatore(Observer observer) {
        observerList.remove(observer);
    }
    public void informaObserver() {
        int len = observerList.size();
        for (int i = 0; i < len; i++) {
            Observer actualObserver = (Observer) observerList.get(i);
            actualObserver.aggiorna();
        }
    }
    public abstract void setStato(boolean bool);
    public abstract boolean getStato();

}

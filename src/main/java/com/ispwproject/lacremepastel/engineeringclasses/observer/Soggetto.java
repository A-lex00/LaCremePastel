package com.ispwproject.lacremepastel.engineeringclasses.observer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/*

public abstract class Soggetto implements  Runnable {
    protected boolean stato;    //se settato a true, abbiamo una nuova notizia da leggere altrimenti niente da leggere!
    protected List<Observer> observerList;
    private final Object MUTEX = new Object();
    protected  boolean isAlive;

    public Soggetto(Vector observers){
        this((Observer)null);
    }
    public Soggetto(Observer observer){
        this(new Vector<Observer>());
        if(observer != null)
            this.observerList.add(observer);
    }
    public Soggetto(List<Observer> list){
        this.observerList=list;
        this.isAlive=false;
    }


    public void registraObserver(Observer observer){
        synchronized (MUTEX){
            observerList.add(observer);
        }
    }
    public void rimuoviOsservatore(Observer observer) {
        synchronized (MUTEX) {
            observerList.remove(observer);
        }
    }
    public void informaObserver() {
        List<Observer> observers = null;
        synchronized (MUTEX) {
            if (this.isThereAnythingToNotify()) {
                observers = new ArrayList<Observer>(this.observerList);
                if (observers != null) {
                    Iterator<Observer> i = observers.iterator();
                    while (i.hasNext()) {
                        Observer observer = i.next();
                        observer.update();
                    }
                }
            }
        }
    }
        /*
            int len = observerList.size();
        for (int i = 0; i < len; i++) {
            Observer actualObserver = (Observer) observerList.get(i);
            actualObserver.update();
        }
    }


    @Override
    public void run(){
    this.isAlive=true;
    while(this.isAlive){
        this.do();
        this.notify();
        }
    }
    protected  abstract boolean isThereAnythingToNotify();
    protected  abstract  void do();
    public abstract void setStato(boolean bool);
    public abstract boolean getStato();


*/
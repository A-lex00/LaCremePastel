package com.ispwproject.lacremepastel.engineeringclasses.observer;

import java.util.ArrayList;
/**Subject è una classe astratta che fornisce interfacce per registrare o rimuovere dinamicamente gli observer (i subscribers)
 * implementa le seguenti funzioni
 * 1) attach(observer): aggiunge un ConcreteObserver alla lista delle classi da notificare
 * 2) detach(observer): rimuove un ConcreteObserver alla lista delle classi da notificare
 * 3) notify(): notifica un cambiamento alle classi ConcreteObserver
 * */
public abstract class Subject {
    /** lista di observer che si iscrivono per ricevere la notifica */
    private final ArrayList<Observer> observers;
    protected Subject(){
        observers= new ArrayList<>();
    }
    /** Aggiunge un observer alla lista dei subscribers */
    public void attach(Observer newObserver){
        observers.add(newObserver);
    }
    /** Rimuove un observer dalla lista dei subscrivers */
    public void detach(Observer removedObserver){
        observers.remove(removedObserver);
    }

    /** Implementato con un loop su tutti i ConcreteObserver, dove ogni observer maniera iterativa;
     * fa update; nel nostro caso, l'observer per ogni ordine aggiunto, popolerà il carrello della spesa
     */
    protected void notifyObservers(){
        for(Observer observer : observers){
            observer.update();
        }
    }
}

package com.ispwproject.lecremepastel.model;

import com.ispwproject.lecremepastel.engineeringclasses.observer.Observer;
import com.ispwproject.lecremepastel.engineeringclasses.observer.Subject;

import java.util.ArrayList;

public class OrderList implements Subject {

    private static final ArrayList<Observer> observers = new ArrayList<>();
    private final ArrayList<SimpleOrder> orderList;

    public OrderList(){
        orderList = new ArrayList<>();
    }

    @Override
    public void attachObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void detachObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for(Observer o : observers){
            o.update();
        }
    }

    public boolean addSimpleOrder(SimpleOrder simpleOrder){
        boolean ret = orderList.add(simpleOrder);
        notifyObservers();
        return ret;
    }

    public boolean removeSimpleOrder(SimpleOrder simpleOrder){
        boolean ret = orderList.remove(simpleOrder);
        notifyObservers();
        return ret;
    }

    public SimpleOrder removeSimpleOrder(int index){
        SimpleOrder ret = orderList.remove(index);
        notifyObservers();
        return ret;
    }

    public SimpleOrder getSimpleOrder(int index){
        return orderList.get(index);
    }
}

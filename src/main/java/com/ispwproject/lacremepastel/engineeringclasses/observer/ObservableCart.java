package com.ispwproject.lacremepastel.engineeringclasses.observer;

import com.ispwproject.lacremepastel.engineeringclasses.bean.OrderBean;
import com.ispwproject.lacremepastel.model.Order;
import com.ispwproject.lacremepastel.model.OrderLine;
import com.ispwproject.lacremepastel.model.Product;

import java.util.ArrayList;
import java.util.List;

/*public class ObservableCart {
    private OrderLine actualOrder;
    private List<Observer> observers=new ArrayList<>();

    public void addObserver(Observer observer){
        observer.update(this.actualOrder);
    }
    public void removeObserver(Observer observer){
        this.observers.remove(observer);
    }
    public ObservableCart(OrderLine actualOrder){
        this.actualOrder=actualOrder;
    }
    public void updateOrder(OrderLine order){
        Product product = order.getProduct();
        int amount = order.getAmount();
        this.actualOrder.setProduct(product);
        this.actualOrder.setAmount(amount);
        for(Observer observer : this.observers){
            observer.update(this.actualOrder);
        }
    }
}
*/
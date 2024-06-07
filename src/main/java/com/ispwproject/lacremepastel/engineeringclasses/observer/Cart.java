package com.ispwproject.lacremepastel.engineeringclasses.observer;

import com.ispwproject.lacremepastel.engineeringclasses.bean.OrderLineBean;
import com.ispwproject.lacremepastel.model.Order;
import com.ispwproject.lacremepastel.model.OrderLine;

import java.util.ArrayList;
import java.util.List;

public class Cart extends  Subject{

    /** Stato del subject **/
    private List<OrderLineBean> actualCart;

    /** Costruttore pubblico poichè ogni istanza di Cart appartiene  ad un solo utente **/
    public Cart(){
        super();
        this.actualCart = new ArrayList<>();
    }
    /** Metodo setState()
     * Utilizzata da GUIControllerMakeOrder quando ogni utente aggiunge una linea d'ordine al suo carrello .
     */
    public void addOrderLine(OrderLineBean orderLineBean){
        actualCart.add(orderLineBean);
        notifyObservers();
    }
    public void removeOrderLine(OrderLineBean orderLineBean){
        actualCart.remove(orderLineBean);
        notifyObservers();
    }

    /**
     * Metodo getState() in teoria utilizzato dai subscribers una volta notificati di dover svolgere un update()
     * @return tutto il cart
     */
    public List<OrderLineBean> getState(){
        return actualCart;
    }

}

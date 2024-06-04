package com.ispwproject.lacremepastel.engineeringclasses.observer;


import com.ispwproject.lacremepastel.model.OrderLine;

import java.util.ArrayList;
import java.util.List;

/** E' l'argomento da osservare (il carrello--> ConcreteSubject)
 * * se viene modificato il carrello (aggiungendo o rimuovendo orderLine), vengono successivamente
 *  * informati tutti gli observers(subscribers) utilizzando il metodo notifyObservers.
 *  * Questo model rappresenta il carrello.
 *  * Viene utilizzato per aggiornare le istanze di showShoppingCart
 *  * */
public class Cart extends Subject {
    private static   Cart actualCart = null;
    /** Stato del subject */
    private static List<OrderLine> actualOrder = new ArrayList<>();
    /**Singleton poichè si tratta dello stato di persistenza */
    public static Cart getInstance(){
        if(actualCart == null){
            actualCart = new Cart();
        }
        return actualCart;
    }
    /** Costruttore privato affinchè nessuno possa creare una nuova istanza*/
    private Cart(){}

    /** Metodo setState()
     * Utilizzata da GUIMakeOrder se il cliente crea un nuovo ordine *
     */

    public void addOrderLine(OrderLine orderLine){
        actualOrder.add(orderLine);
        notifyObservers();
    }

    /** Metodo getState()
     * restituisce l'intero ordine di un cliente
     *  Utilizzata da GuiShoppingCart se il cliente vede il carrello
     */
    public  List<OrderLine> getState(){
        return actualOrder;
    }

    /** Metodo setState()
     *elimina una linea dell'ordine di un cliente
     */
    public void removeOrder(OrderLine orderLine){
        actualOrder.remove(orderLine);
        notifyObservers();
    }

}

package com.ispwproject.lacremepastel.controller.gui;


import com.ispwproject.lacremepastel.controller.app.ManageOrderController;
import com.ispwproject.lacremepastel.engineeringclasses.bean.OrderBean;

import com.ispwproject.lacremepastel.engineeringclasses.observer.Observer;
import com.ispwproject.lacremepastel.model.OrderLine;
import com.ispwproject.lacremepastel.other.FXMLPaths;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.util.ArrayList;
import java.util.List;

//Concrete Observer
public class GUIControllerShoppingCart extends AbstractGUIController implements Observer {

    /**OBSERVER */
    private Cart actualCart;        /** ISTANZA DEL MODEL OSSERVATO */
    private List<OrderLine> actualOrder= new ArrayList<>();

    @FXML
    void confirmOrder(ActionEvent confirmEvent) {
        this.setupStage(confirmEvent, FXMLPaths.CUSTOMER_HOME);
    }
    @FXML
    void goBack(ActionEvent backEvent) {
        this.setupStage(backEvent,FXMLPaths.MAKE_ORDER);
    }
    public void setActualOrder(OrderLine order){
            actualOrder.add(order);
        }
    /**
     *Ricevo un ordine, lo invio all'applicativo per una traduzione da model a bean
     *
     */
    @Override
    public void update() {
        actualOrder=actualCart.getState();
    }
}

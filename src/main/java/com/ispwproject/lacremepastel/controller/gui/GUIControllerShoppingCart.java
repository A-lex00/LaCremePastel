package com.ispwproject.lacremepastel.controller.gui;


import com.ispwproject.lacremepastel.controller.app.ManageOrderController;
import com.ispwproject.lacremepastel.engineeringclasses.bean.OrderBean;

import com.ispwproject.lacremepastel.engineeringclasses.bean.OrderLineBean;
import com.ispwproject.lacremepastel.engineeringclasses.observer.Cart;
import com.ispwproject.lacremepastel.engineeringclasses.observer.Observer;
import com.ispwproject.lacremepastel.model.OrderLine;
import com.ispwproject.lacremepastel.other.FXMLPaths;
import javafx.collections.ObservableList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;

//Concrete Observer
public class GUIControllerShoppingCart extends AbstractGUIController implements Observer {


        @FXML
        private TableView order ;

        /**OBSERVER */
        private Cart actualCart;        /** ISTANZA DEL MODEL OSSERVATO */

        @FXML
        void confirmOrder(ActionEvent confirmEvent) {
            this.setupStage(confirmEvent, FXMLPaths.CUSTOMER_HOME);
        }
        @FXML
        void goBack(ActionEvent backEvent) {
            this.setupStage(backEvent,FXMLPaths.MAKE_ORDER);

        }
    /**
     *Ricevo un ordine, lo invio all'applicativo per una traduzione da model a bean
     *
     */
    @Override
    public void update() {
        List<OrderLineBean> state = actualCart.getState();
    }
}

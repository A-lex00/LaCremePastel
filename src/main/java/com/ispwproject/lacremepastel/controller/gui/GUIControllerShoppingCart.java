package com.ispwproject.lacremepastel.controller.gui;

import com.ispwproject.lacremepastel.controller.app.ManageProductController;
import com.ispwproject.lacremepastel.engineeringclasses.bean.OrderLineBean;
import com.ispwproject.lacremepastel.engineeringclasses.bean.ProductBean;
import com.ispwproject.lacremepastel.engineeringclasses.bean.SessionBean;
import com.ispwproject.lacremepastel.engineeringclasses.observer.Cart;
import com.ispwproject.lacremepastel.engineeringclasses.observer.Observer;
import com.ispwproject.lacremepastel.model.Order;
import com.ispwproject.lacremepastel.other.FXMLPaths;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

//Concrete Observer
public class GUIControllerShoppingCart extends AbstractGUIController  {

    @FXML
    private TableView<OrderLineBean> orderView ;
    @FXML
    private TableColumn<ProductBean, String> productColumn;
    @FXML
    private TableColumn<ProductBean, Double> priceColumn;
    @FXML
    private TableColumn<OrderLineBean, Integer> ammountColumn;
    private Cart confirmCart;

    public GUIControllerShoppingCart(){
        confirmCart = new Cart();
    }

    @FXML
    void confirmOrder(ActionEvent confirmEvent) {
        this.setupStage(confirmEvent, FXMLPaths.CUSTOMER_HOME);
    }
    @FXML
    void goBack(ActionEvent backEvent) {
        this.setupStage(backEvent,FXMLPaths.MAKE_ORDER);
    }

    @Override
    public void configure() {

        //Initializing Table
        productColumn.setCellValueFactory(new PropertyValueFactory<ProductBean,String>("productName"));
        ammountColumn.setCellValueFactory(new PropertyValueFactory<OrderLineBean,Integer>("amount"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<ProductBean,Double>("price"));
        ObservableList<OrderLineBean> list = FXCollections.observableList(confirmCart.getState());
        orderView.getItems().removeAll();
        orderView.setItems(list);
    }
}


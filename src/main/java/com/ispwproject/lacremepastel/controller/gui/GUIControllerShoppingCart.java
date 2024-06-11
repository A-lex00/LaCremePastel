package com.ispwproject.lacremepastel.controller.gui;

import com.ispwproject.lacremepastel.engineeringclasses.bean.OrderLineBean;
import com.ispwproject.lacremepastel.engineeringclasses.bean.ProductBean;
import com.ispwproject.lacremepastel.engineeringclasses.observer.Cart;
import com.ispwproject.lacremepastel.other.FXMLPaths;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

//Concrete Observer
public class GUIControllerShoppingCart extends AbstractGUIController  {

    @FXML
    private TableView<OrderLineBean> orderView ;
    @FXML
    private TableColumn<ProductBean, String> productColumn;
    @FXML
    private TableColumn<ProductBean, Double> priceColumn;
    @FXML
    private TableColumn<OrderLineBean, Integer> amountColumn;

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
        productColumn.setCellValueFactory(new PropertyValueFactory<>("productName"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        //Initializing cart
        Cart confirmCart = (Cart) this.getUserData("cart");
        ObservableList<OrderLineBean> list = FXCollections.observableList(confirmCart.getState());
        orderView.getItems().removeAll();
        orderView.setItems(list);
    }
}


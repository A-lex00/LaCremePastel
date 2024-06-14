package com.ispwproject.lacremepastel.controller.gui;

import com.ispwproject.lacremepastel.controller.app.MakeOrderController;
import com.ispwproject.lacremepastel.controller.app.ManageOrderController;
import com.ispwproject.lacremepastel.engineeringclasses.bean.OrderBean;
import com.ispwproject.lacremepastel.engineeringclasses.bean.OrderLineBean;
import com.ispwproject.lacremepastel.engineeringclasses.bean.ProductBean;
import com.ispwproject.lacremepastel.engineeringclasses.bean.SessionBean;
import com.ispwproject.lacremepastel.engineeringclasses.observer.Cart;
import com.ispwproject.lacremepastel.other.FXMLPaths;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

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
    private TableColumn<OrderLineBean, Integer> amountColumn;
    @FXML
    private Label price;

    @FXML
    void confirmOrder(ActionEvent confirmEvent) {
        this.setupStage(confirmEvent, FXMLPaths.CUSTOMER_HOME);
        Cart cart = (Cart) this.getUserData("cart");

        //recupero la sessione
        SessionBean sessionBean = (SessionBean) this.getUserData(SESSION_DATA);

        OrderBean orderBean = new OrderBean(sessionBean.getUsername(),cart.getState());

        MakeOrderController makeOrderController = new MakeOrderController();
        makeOrderController.createOrder(sessionBean,orderBean);
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
        double sum = calculator(confirmCart);
        price.setText(String.format("Totale Ordine: %.2f €", sum));
    }

    private double calculator(Cart confirmCart){
        List<OrderLineBean> actualCart = confirmCart.getState();
        double sum = 0.0;
        int index = 0;
        double unitaryPrice = 0;
        int quantity = 0;
        for(OrderLineBean orderLineBean : actualCart) {
            index = actualCart.indexOf(orderLineBean);
            unitaryPrice = actualCart.get(index).getPrice();
            quantity = actualCart.get(index).getAmount();
            sum += quantity * unitaryPrice;
        }
        return sum;
    }
}


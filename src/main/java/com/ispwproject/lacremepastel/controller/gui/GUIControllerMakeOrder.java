package com.ispwproject.lacremepastel.controller.gui;
import com.ispwproject.lacremepastel.controller.app.ManageProductController;
import com.ispwproject.lacremepastel.engineeringclasses.bean.OrderLineBean;
import com.ispwproject.lacremepastel.engineeringclasses.bean.ProductBean;
import com.ispwproject.lacremepastel.engineeringclasses.bean.SessionBean;
import com.ispwproject.lacremepastel.engineeringclasses.observer.Cart;
import com.ispwproject.lacremepastel.engineeringclasses.observer.Observer;
import com.ispwproject.lacremepastel.engineeringclasses.singleton.Configurations;
import com.ispwproject.lacremepastel.model.OrderLine;
import com.ispwproject.lacremepastel.model.Product;
import com.ispwproject.lacremepastel.other.FXMLPaths;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class GUIControllerMakeOrder  extends AbstractGUIController implements Observer {

    @FXML
    private ComboBox<String> productBox;
    @FXML
    private TextField quantityField;
    @FXML
    private TableView<OrderLineBean> orderView;
    @FXML
    private TableColumn<ProductBean, String> productColumn;
    @FXML
    private TableColumn<OrderLineBean, Integer> quantityColumn;
    @FXML
    private TableColumn<ProductBean, Double> priceColumn;

    private final Cart actualCart;
    private ArrayList<ProductBean> productList;

    public GUIControllerMakeOrder(){
        actualCart = new Cart();
    }

    @FXML
    void addCart(ActionEvent cartEvent) {
        System.out.println("addCart");
        int index = productBox.getSelectionModel().getSelectedIndex();
        ProductBean product = productList.get(index);
        try {
            int quantity = Integer.parseInt(quantityField.getText());
            OrderLineBean orderLineBean = new OrderLineBean(product, quantity);
            actualCart.addOrderLine(orderLineBean);
        }catch (NumberFormatException e){
            Logger.getLogger(Configurations.getInstance().getProperty("LOGGER_NAME")).severe(e.getMessage());
        }finally {
            productBox.getSelectionModel().clearSelection();
            quantityField.setText("");
        }
    }

    @FXML
    public void goBack(ActionEvent backEvent) {
        this.setupStage(backEvent, FXMLPaths.CUSTOMER_HOME);
    }

    @FXML
    public void confirmOrder(ActionEvent cartEvent) {
        this.setupStage(cartEvent, FXMLPaths.SHOPPING_CART);
        super.setUserData(actualCart);


    }

    @Override
    public void configure() {
        //Setup userData
        SessionBean sessionBean = (SessionBean) this.getUserData();

        //Loading productList
        ManageProductController manageProductController = new ManageProductController();
        this.productList = (ArrayList<ProductBean>) manageProductController.getProductList(sessionBean, null);
        for (ProductBean productBean : productList) {
            productBox.getItems().add(productBean.getProductName() + "\t" + productBean.getPrice() + "€");
        }
        actualCart.attach(this);

        //Initializing Table
        productColumn.setCellValueFactory(new PropertyValueFactory<ProductBean,String>("productName"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<OrderLineBean,Integer>("amount"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<ProductBean,Double>("price"));


    }

    @Override
    public void update() {
        System.out.println("Update Entered");
        orderView.getItems().removeAll();
        ObservableList<OrderLineBean> list = FXCollections.observableList(actualCart.getState());
        orderView.setItems(list);
    }
}





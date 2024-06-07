package com.ispwproject.lacremepastel.controller.gui;
import com.ispwproject.lacremepastel.controller.app.ManageProductController;
import com.ispwproject.lacremepastel.engineeringclasses.bean.OrderLineBean;
import com.ispwproject.lacremepastel.engineeringclasses.bean.ProductBean;
import com.ispwproject.lacremepastel.engineeringclasses.bean.SessionBean;
import com.ispwproject.lacremepastel.engineeringclasses.observer.Cart;
import com.ispwproject.lacremepastel.engineeringclasses.observer.Observer;
import com.ispwproject.lacremepastel.model.OrderLine;
import com.ispwproject.lacremepastel.model.Product;
import com.ispwproject.lacremepastel.other.FXMLPaths;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class GUIControllerMakeOrder  extends AbstractGUIController implements Observer {

    @FXML
    private ComboBox<String> productBox;
    @FXML
    private TextField quantityField;
    @FXML
    private TableView orderView;
    private Cart actualCart = new Cart();
    private ArrayList<ProductBean> productList ;


    @FXML
    void addCart(ActionEvent cartEvent) {
        System.out.println("addCart");
        int index = productBox.getSelectionModel().getSelectedIndex();
        ProductBean product = productList.get(index);
        int quantity = Integer.parseInt(quantityField.getText());

        OrderLineBean orderLineBean = new OrderLineBean(product , quantity);
        actualCart.addOrderLine(orderLineBean);
    }

    @FXML
    public void goBack(ActionEvent backEvent) {
        this.setupStage(backEvent, FXMLPaths.CUSTOMER_HOME);
    }
    @FXML
    public void confirmOrder(ActionEvent cartEvent) {
        this.setupStage(cartEvent, FXMLPaths.SHOPPING_CART);
    }

    @Override
    public void configure(){
        SessionBean sessionBean = (SessionBean) this.getUserData();
        ManageProductController manageProductController = new ManageProductController();
        this.productList = (ArrayList<ProductBean>) manageProductController.getProductList(sessionBean, null);
        for(ProductBean productBean : productList){
            productBox.getItems().add(productBean.getProductName() + "\t" + productBean.getPrice() + "€" );
        }
        actualCart.attach(this);
    }

    @Override
    public void update() {

        System.out.println("Update Entered");
        orderView.getColumns().add(0,actualCart.getState());
        orderView.getColumns().add(1,actualCart.getState());
        orderView.getColumns().add(2, actualCart.getState());

    }
}



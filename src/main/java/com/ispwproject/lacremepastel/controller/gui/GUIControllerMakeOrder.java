package com.ispwproject.lacremepastel.controller.gui;
import com.ispwproject.lacremepastel.controller.app.ManageProductController;
import com.ispwproject.lacremepastel.engineeringclasses.bean.ProductBean;
import com.ispwproject.lacremepastel.engineeringclasses.bean.SessionBean;
import com.ispwproject.lacremepastel.other.FXMLPaths;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class GUIControllerMakeOrder  extends AbstractGUIController{

    @FXML
    private ComboBox<String> productBox;
    @FXML
    private TextField quantityField;
    @FXML
    private ListView actualCart;


    private ArrayList<ProductBean> productList ;


    @FXML
    void addCart(ActionEvent cartEvent) {

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
    }
}



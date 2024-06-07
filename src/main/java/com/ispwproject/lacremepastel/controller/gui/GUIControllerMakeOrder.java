package com.ispwproject.lacremepastel.controller.gui;
import com.ispwproject.lacremepastel.controller.app.ManageProductController;
import com.ispwproject.lacremepastel.engineeringclasses.bean.OrderBean;
import com.ispwproject.lacremepastel.engineeringclasses.bean.ProductBean;
import com.ispwproject.lacremepastel.engineeringclasses.bean.SessionBean;
import com.ispwproject.lacremepastel.engineeringclasses.exception.InvalidParameterException;
import com.ispwproject.lacremepastel.engineeringclasses.singleton.Configurations;
import com.ispwproject.lacremepastel.model.OrderLine;
import com.ispwproject.lacremepastel.model.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.logging.Logger;

public class GUIControllerMakeOrder  extends AbstractGUIController{

    @FXML
    private ComboBox<String> productBox;
    @FXML
    private TextField quantityField;

    private List<ProductBean> productList ;

    @FXML
    void addCart(ActionEvent cartEvent) {
    }

    @FXML
    public void goBack(ActionEvent backEvent) {
        try{
            setupStage(
                    backEvent,
                    FXMLLoader.load(getClass().getResource("/view/customerFirstPage.fxml"))
            );
        }catch(IOException e){
            Logger.getLogger(Configurations.getInstance().getProperty("LOGGER_NAME")).severe(e.getMessage());
        }
    }
    @FXML
    public void showShoppingCart(ActionEvent cartEvent) {
        try{
            setupStage(
                    cartEvent,
                    FXMLLoader.load(getClass().getResource("/view/shoppingCart.fxml"))
            );
        }catch(IOException e){
            Logger.getLogger(Configurations.getInstance().getProperty("LOGGER_NAME")).severe(e.getMessage());
        }
    }

    @Override
    public void initialize(){
        SessionBean sessionBean = (SessionBean) this.getUserData();
        ManageProductController manageProductController = new ManageProductController();
        this.productList = manageProductController.getProductList(sessionBean, null);
        for(ProductBean productBean : productList){
            productBox.getItems().add(productBean.getProductName());
        }
    }



}



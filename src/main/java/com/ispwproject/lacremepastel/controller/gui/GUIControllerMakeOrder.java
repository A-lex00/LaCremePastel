package com.ispwproject.lacremepastel.controller.gui;
import com.ispwproject.lacremepastel.controller.app.ManageProductController;
import com.ispwproject.lacremepastel.engineeringclasses.bean.OrderBean;
import com.ispwproject.lacremepastel.engineeringclasses.bean.ProductBean;
import com.ispwproject.lacremepastel.engineeringclasses.bean.SessionBean;
import com.ispwproject.lacremepastel.engineeringclasses.exception.InvalidParameterException;
import com.ispwproject.lacremepastel.engineeringclasses.exception.SessionNotFoundException;
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
import java.util.List;

public class GUIControllerMakeOrder  {

        @FXML
        private ComboBox<String> yo;
        private List<ProductBean> productList ;
        private String productName;
        private int quantity;
        @FXML
        private TextField quantityField;

        private SessionBean sessionBean ;


    public GUIControllerMakeOrder() {
    }

        @FXML
        void addCart(ActionEvent cartEvent) {
            productName = yo.getValue();
            Product product = new Product(productName);
            quantity = Integer.parseInt(quantityField.getText());
            OrderBean orderBean = new OrderBean(sessionBean.getUsername());
            OrderLine orderLine = new OrderLine( product, quantity);
        }
        @FXML
        public void goBack(ActionEvent backEvent) {
            Node node=(Node) backEvent.getSource();
            Stage stage=(Stage) node.getScene().getWindow();
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/view/customerFirstPage.fxml"));
                stage.setScene(new Scene(root, 629, 481));
                stage.setTitle("La Creme Pastel");
                stage.show();
            }catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        @FXML
        public void showShoppingCart(ActionEvent cartEvent) {
            Node node=(Node) cartEvent.getSource();
            Stage stage=(Stage) node.getScene().getWindow();
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/view/shoppingCart.fxml"));
                stage.setScene(new Scene(root, 629, 481));
                stage.setTitle("La Creme Pastel");
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void inizio(SessionBean sessionBean)  {

        ManageProductController manageProductController=new ManageProductController();
        try {
            productList=manageProductController.getProductList(sessionBean,null);
        } catch (InvalidParameterException e) {
            throw new RuntimeException(e);
        }
        ObservableList<String> productNames = FXCollections.observableArrayList();
        for(ProductBean product: productList) {
            productNames.add(product.getProductName());
        }
        System.out.println(yo);
        inizioDati(productNames);

    }
    public void inizioDati(ObservableList<String> productNames)  {
        yo.setItems(productNames);
    }

}



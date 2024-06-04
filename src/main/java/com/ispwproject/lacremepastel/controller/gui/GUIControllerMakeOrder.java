package com.ispwproject.lacremepastel.controller.gui;
import com.ispwproject.lacremepastel.controller.app.ManageProductController;
import com.ispwproject.lacremepastel.engineeringclasses.bean.ProductBean;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class GUIControllerMakeOrder  implements Initializable  {

        @FXML
        private ComboBox<String> productBox;

        private List<ProductBean> productList;

        @FXML
        private TextField quantityField;

        @FXML
        void addCart(ActionEvent event) {

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)  {
        ManageProductController manageProductController=new ManageProductController();
        productList=manageProductController.loadProducts();
        ObservableList<String> productNames = FXCollections.observableArrayList();
        for(ProductBean product: productList) {
            productNames.add(product.getProductName());
        }      productBox.setItems(productNames);
        }
}

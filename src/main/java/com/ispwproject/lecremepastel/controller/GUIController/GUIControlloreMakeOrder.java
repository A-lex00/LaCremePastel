package com.ispwproject.lecremepastel.controller.GUIController;

import com.ispwproject.lecremepastel.controller.appcontroller.ManageProductController;
import com.ispwproject.lecremepastel.engineeringclasses.bean.OrderLineBean;
import com.ispwproject.lecremepastel.engineeringclasses.bean.ProductBean;
import com.ispwproject.lecremepastel.engineeringclasses.bean.SessionBean;
import com.ispwproject.lecremepastel.engineeringclasses.exception.IncorrectParametersException;
import com.ispwproject.lecremepastel.model.OrderLine;
import com.ispwproject.lecremepastel.model.Product;
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

import java.util.Collection;
import java.util.List;

public class GUIControlloreMakeOrder {
    private SessionBean sessionBean;
    @FXML
    private ComboBox<String> productBox=new ComboBox<>();
    @FXML
    private TextField quantityField=new TextField();
    private OrderLineBean currentCart=new OrderLineBean();

    @FXML
    public void showShoppingCart(ActionEvent showCartEvent) {
        Node n = (Node) showCartEvent.getSource();
        Stage shoppingStage = (Stage) n.getScene().getWindow();
        try {
            Parent root= FXMLLoader.load(getClass().getResource("/shoppingCart.fxml"));
            shoppingStage.setScene(new Scene(root, 629, 481));
            shoppingStage.setTitle("La Creme Pastel");
            shoppingStage.show();
        } catch (Exception e) {
        }
    }
    @FXML
    public void loadProduct(ActionEvent backEvent) throws IncorrectParametersException {
        ManageProductController productController=new ManageProductController();
        List<ProductBean> allProductList=productController.loadProducts();
        ObservableList<String> productNames=FXCollections.observableArrayList();
        for(ProductBean product: allProductList) {
            System.out.println(product.getProductName());
            productNames.add(product.getProductName());
        }      productBox.setItems(productNames);
    }
    @FXML
    public void addCart(ActionEvent addEvent) throws IncorrectParametersException {

        ManageProductController productController = new ManageProductController();
        List<ProductBean> allProductList = productController.loadProducts();
        int selectedProductId = -1;
        for (ProductBean product : allProductList) {
            if (product.getProductName().equals(productBox.getValue())) ;
            {
                selectedProductId = product.getId();
            }
        }

            if (selectedProductId != -1) {
                currentCart.setOrderId(selectedProductId);
            }
            currentCart.setAmount(Integer.parseInt(quantityField.getText()));
            System.out.println(currentCart + "currentCart");
        }
    @FXML
    public void goBack(ActionEvent backEvent){}
}

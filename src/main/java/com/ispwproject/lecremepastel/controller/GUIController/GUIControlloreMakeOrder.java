package com.ispwproject.lecremepastel.controller.GUIController;

import com.ispwproject.lecremepastel.engineeringclasses.bean.OrderLineBean;
import com.ispwproject.lecremepastel.engineeringclasses.bean.ProductBean;
import com.ispwproject.lecremepastel.engineeringclasses.bean.SessionBean;
import com.ispwproject.lecremepastel.engineeringclasses.exception.IncorrectParametersException;
import com.ispwproject.lecremepastel.model.OrderLine;
import com.ispwproject.lecremepastel.model.Product;
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

import java.util.List;

public class GUIControlloreMakeOrder {
    private ObservableList currentOrder;
    private ObservableList productList;
    private ObservableList idProductList;
    private SessionBean sessionBean;
    @FXML
    private ComboBox productBox=new ComboBox<>();
    @FXML
    private TextField quantityField=new TextField();

    public void inizialize(SessionBean importedSessionBean) throws IncorrectParametersException {
        this.sessionBean=importedSessionBean;
        List<ProductBean> allProductList = null;
        for(ProductBean product: allProductList) {
            productList.add(product.getProductName());
            idProductList.add(product.getId());
        }
        productBox.setItems(productList);
    }
    @FXML
    public void showShoppingCart(ActionEvent showCartEvent) {
        Node n = (Node) showCartEvent.getSource();
        Stage shoppingStage = (Stage) n.getScene().getWindow();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/shoppingCart.fxml"));
            shoppingStage.setScene(new Scene(root, 629, 481));
            shoppingStage.setTitle("La Creme Pastel");
            shoppingStage.show();
        } catch (Exception e) {
        }
    }
    @FXML
    public void goBack(ActionEvent backEvent){}
    @FXML
    public void addCart(ActionEvent addEvent){
        currentOrder.add(productBox.getValue());
        int quantity= Integer.parseInt(quantityField.getText());

        OrderLineBean orderLineBean= new OrderLineBean();

    }
}

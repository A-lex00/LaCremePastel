package com.ispwproject.lecremepastel.controller.GUIController;

import com.ispwproject.lecremepastel.engineeringclasses.bean.OrderLineBean;
import com.ispwproject.lecremepastel.engineeringclasses.bean.ProductBean;
import com.ispwproject.lecremepastel.engineeringclasses.bean.SessionBean;
import com.ispwproject.lecremepastel.engineeringclasses.exception.IncorrectParametersException;
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

public class GUIControlloreMakeOrder {
    private ObservableList currentOrder;
    private ProductBean productBean=new ProductBean();
    private ObservableList orderList;
    private SessionBean sessionBean;
    @FXML
    private ComboBox productBox=new ComboBox<>();
    @FXML
    private TextField quantityField=new TextField();

    public void inizialize(SessionBean importedSessionBean) throws IncorrectParametersException {
        this.sessionBean=importedSessionBean;
        ProductBean productBean=new ProductBean();
        orderList.add(productBean.getA);
        productBox.setItems(orderList);
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
        orderLineBean.set
    quantityField.getText();
    }

}

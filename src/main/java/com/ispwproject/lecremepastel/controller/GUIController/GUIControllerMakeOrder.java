package com.ispwproject.lecremepastel.controller.GUIController;

import com.ispwproject.lecremepastel.engineeringclasses.bean.SessionBean;
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

public class GUIControllerMakeOrder {
    private ObservableList currentOrder;
    private ObservableList orderList;
    private SessionBean sessionBean;
    @FXML
    private ComboBox productBox=new ComboBox<>();
    @FXML
    private TextField quantityField=new TextField();

    void inizialize(SessionBean importedSessionBean){
        this.sessionBean=importedSessionBean;
    }
    @FXML
    void showShoppingCart(ActionEvent showCartEvent) {
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
    void goBack(ActionEvent backEvent){}
    @FXML
    void addCart(ActionEvent addEvent){

    }

}

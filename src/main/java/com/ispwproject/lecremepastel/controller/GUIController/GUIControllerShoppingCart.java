package com.ispwproject.lecremepastel.controller.GUIController;

import com.ispwproject.lecremepastel.engineeringclasses.bean.OrderLineBean;
import com.ispwproject.lecremepastel.engineeringclasses.bean.SessionBean;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class GUIControllerShoppingCart {

    @FXML
    private ListView orderView=new ListView<>();
    private SessionBean sessionBean;

    @FXML
    public void confirmOrder(ActionEvent confirmEvent){}

    @FXML
    public void loadCart(ActionEvent loadEvent){

    }
    @FXML
    public void goBack(ActionEvent backEvent){
        Node node = (Node) backEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
    }



}

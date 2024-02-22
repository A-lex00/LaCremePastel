package com.ispwproject.lecremepastel.controller.GUIController;

import com.ispwproject.lecremepastel.engineeringclasses.bean.SessionBean;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;

public class GUIControllerShoppingCart {

    private SessionBean sessionBean;
    public void importSession(SessionBean importedSessionBean){
        this.sessionBean=importedSessionBean;
    }

    @FXML
    public void confirmOrder(ActionEvent confirmEvent){}
    @FXML
    public void goBack(ActionEvent backEvent){
        Node node = (Node) backEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
    }



}

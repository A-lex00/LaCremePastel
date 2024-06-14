package com.ispwproject.lacremepastel.controller.gui;

import com.ispwproject.lacremepastel.other.FXMLPaths;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class GUIControllerDirectorFirstPage extends AbstractGUIController{
    @FXML
    private Label initialLabel ;

    @FXML
    void manageOrder(ActionEvent manageEvent) {
        this.setupStage(manageEvent,FXMLPaths.MANAGE_ORDER);
    }

    @FXML
    void manageProduct(ActionEvent manageEvent) {
        this.setupStage(manageEvent, FXMLPaths.MANAGE_PRODUCT);
    }
    @FXML
    void manageWorkers(ActionEvent manageEvent) {
    }

    @FXML
    void requestHelp(ActionEvent helpEvent) {

    }

    @FXML
    void showCustomerList(ActionEvent showEvent) {

    }

}


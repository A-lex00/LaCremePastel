package com.ispwproject.lacremepastel.controller.gui;

import com.ispwproject.lacremepastel.other.FXMLPaths;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class GUIControllerCustomerFirstPage  extends AbstractGUIController{

    @FXML
    private Label welcomeLabel;


    @FXML
    void composeOrder(ActionEvent composeEvent) {
        this.setupStage(composeEvent, FXMLPaths.MAKE_ORDER);
    }
    @FXML
    void giveBack(ActionEvent backEvent) {

    }

    @FXML
    void orderHistory(ActionEvent event) {

    }

    @FXML
    void requestHelp(ActionEvent helpEvent) {

    }

    @FXML
    void reviewOrder(ActionEvent reviewEvent) {
    }

    @FXML
    void showNotice(ActionEvent noticeEvent) {
    }
}

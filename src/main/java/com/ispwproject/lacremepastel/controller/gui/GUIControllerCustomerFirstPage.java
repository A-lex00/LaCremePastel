package com.ispwproject.lacremepastel.controller.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class GUIControllerCustomerFirstPage  extends AbstractGUIController{

    @FXML
    private Label initialLabel;

    @FXML
    void composeOrder(ActionEvent composeEvent) {
        this.setupStage(composeEvent,"/view/makeOrder.fxml");
    }
    @FXML
    void giveBack(ActionEvent backEvent) {
        System.out.println("Segnalazione effettuata");
    }

    @FXML
    void orderHistory(ActionEvent event) {
        System.out.println("Ordini passati");
    }

    @FXML
    void requestHelp(ActionEvent helpEvent) {
        throw new UnsupportedOperationException();
    }

    @FXML
    void reviewOrder(ActionEvent reviewEvent) {
        //throw new UnsupportedOperationException();
    }

    @FXML
    void showNotice(ActionEvent noticeEvent) {
        throw new UnsupportedOperationException();
    }
}

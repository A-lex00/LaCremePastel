package com.ispwproject.lacremepastel.controller.gui;

import com.ispwproject.lacremepastel.engineeringclasses.bean.SessionBean;
import com.ispwproject.lacremepastel.engineeringclasses.singleton.Configurations;
import com.ispwproject.lacremepastel.other.FXMLPaths;
import com.ispwproject.lacremepastel.other.PoupopManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class GUIControllerDirectorFirstPage extends AbstractGUIController{
    @FXML
    private Label initialLabel = null;

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
        this.setupStage(manageEvent,FXMLPaths.MANAGE_PRODUCT);
    }

    @FXML
    void requestHelp(ActionEvent helpEvent) {
    }

    @FXML
    void showCustomerList(ActionEvent showEvent) {
        this.setupStage(showEvent,FXMLPaths.MANAGE_PRODUCT);
    }
}


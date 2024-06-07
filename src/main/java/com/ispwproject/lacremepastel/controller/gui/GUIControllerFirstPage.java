package com.ispwproject.lacremepastel.controller.gui;

import com.ispwproject.lacremepastel.other.FXMLPaths;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUIControllerFirstPage extends AbstractGUIController{

    @FXML
    void clickLoginButton(ActionEvent loginEvent) {
        this.setupStage(loginEvent, FXMLPaths.LOGIN_PAGE);
    }

    @FXML
    void clickRegistrationButton(ActionEvent registrationEvent) {
        this.setupStage(registrationEvent, FXMLPaths.REGISTER_PAGE);
    }
}
package com.ispwproject.lacremepastel.controller.gui;

import com.ispwproject.lacremepastel.engineeringclasses.bean.SessionBean;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;

public abstract class AbstractGUIController {

    private SessionBean sessionData;

    public SessionBean getSessionData() {
        return sessionData;
    }

    public void setSessionData(SessionBean sessionData) {
        if(sessionData != null){
            this.sessionData = sessionData;
        }
    }

    public void initialize(){}

    protected void setupStage(ActionEvent event, String fxmlPath){
        Node node=(Node) event.getSource();
        Stage stage=(Stage) node.getScene().getWindow();
        URL fxmlFile = getClass().getResource(fxmlPath);
        if(fxmlFile == null){
            System.err.println("FXML file not found: "+fxmlPath);
            return;
        }
        try {
            Parent root = FXMLLoader.load(fxmlFile);
            stage.setScene(new Scene(root, 629, 481));
            stage.show();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public abstract void importUserData(Object userData);
}

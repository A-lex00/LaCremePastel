package com.ispwproject.lacremepastel.controller.gui;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public abstract class AbstractGUIController {

    private Object userData;

    public Object getUserData() {
        return userData;
    }

    public void setUserData(Object userData) {
        if(userData != null){
            this.userData = userData;
        }
    }

    public void initialize(){}

    protected void setupStage(ActionEvent event, Pane pane){
        if(pane == null || event == null){
            return;
        }
        Node node=(Node) event.getSource();
        Stage stage=(Stage) node.getScene().getWindow();
        stage.setScene(new Scene(pane, 629, 481));
        stage.show();
    }
}

package com.ispwproject.lacremepastel.controller.gui;

import com.ispwproject.lacremepastel.engineeringclasses.singleton.Configurations;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.logging.Logger;

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

    public void configure(){}

    protected void setupStage(ActionEvent event, String filePath){
        if(filePath == null || event == null){
            return;
        }
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(filePath));
            Parent parent = loader.load();
            AbstractGUIController controller = loader.getController();
            controller.setUserData(this.getUserData());
            controller.configure();

            System.out.println(this.getUserData());

            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.setScene(new Scene(parent, 629, 481));
            stage.show();
        }catch (IOException e){
            Logger.getLogger(Configurations.getInstance().getProperty("LOGGER_NAME")).severe(e.getMessage());
        }
    }
}

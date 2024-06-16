package com.ispwproject.lacremepastel.controller.gui;

import com.ispwproject.lacremepastel.engineeringclasses.factory.PopupFactory;
import com.ispwproject.lacremepastel.engineeringclasses.singleton.Configurations;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.HashMap;
import java.util.logging.Logger;

public abstract class AbstractGUIController {

    protected static final String ORDER = "order";
    protected static final String SESSION_DATA = "sessionData";

    private HashMap<String, Object> userData;

    protected AbstractGUIController() {
        userData = new HashMap<>();
    }

    public Object getUserData(String name) {
        return this.userData.get(name);
    }

    public void setUserData(String name, Object userData) {
        if (userData != null && name != null && !name.isBlank()) {
            this.userData.put(name, userData);
        }
    }

    public Object deleteUserData(String name){
        return this.userData.remove(name);
    }

    public void configure(){
    }

    protected void setupStage(ActionEvent event, String filePath){
        if(filePath == null || event == null){
            return;
        }
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(filePath));
            Parent parent = loader.load();
            AbstractGUIController controller = loader.getController();
            controller.userData = this.userData;

            controller.configure();

            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.setScene(new Scene(parent, 629, 481));
            stage.show();
        } catch (Exception e) {
            Logger.getLogger(Configurations.LOGGER_NAME).severe(e.getMessage());
        }
    }

    protected void displayFeaturePopup(Event event){
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        PopupFactory popupFactory = new PopupFactory();
        popupFactory.createBasePopup("Feature non implementata!").show(stage);
    }
}

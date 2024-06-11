package com.ispwproject.lacremepastel.controller.gui;

import com.ispwproject.lacremepastel.engineeringclasses.singleton.Configurations;
import com.ispwproject.lacremepastel.other.FXMLPaths;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Logger;

public abstract class AbstractGUIController {

    private HashMap<String, Object> userData;
    protected static final String SESSION_DATA = "sessionData";

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

    public void configure() {
    }

    protected void createPopup(String message, Stage primaryStage) {
        try{
        Stage popupStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource(FXMLPaths.POUPOP));

        Parent root = loader.getRoot();

        Label label = new Label(message);
        ((Pane) root).getChildren().add(label);

        Scene scene = new Scene(root, 300, 150);
        popupStage.setScene(scene);
        popupStage.initModality(Modality.APPLICATION_MODAL);   //blocca l'interazione con la finestra principale fino alla chiusura del poupop
        popupStage.initOwner(primaryStage);
        popupStage.setTitle("Avviso");

        popupStage.show();
        popupStage.showAndWait(); //mostra il poupop e aspetta la chiusura prima di procedere con il codice successivo
    }catch(Exception e){
        Logger.getLogger(Configurations.getInstance().getProperty("LOGGER_NAME")).severe(e.getMessage());
    }
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
        }catch (IOException e){
            Logger.getLogger(Configurations.getInstance().getProperty("LOGGER_NAME")).severe(e.getMessage());
        }
    }
}

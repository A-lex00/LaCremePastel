package com.ispwproject.lacremepastel.controller.gui;

import com.ispwproject.lacremepastel.controller.app.ManageOrderController;
import com.ispwproject.lacremepastel.engineeringclasses.bean.OrderLineBean;
import com.ispwproject.lacremepastel.engineeringclasses.singleton.Configurations;
import com.ispwproject.lacremepastel.other.FXMLPaths;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import java.util.List;
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

    public void configure() throws Exception {
    }

    protected void setupStage(ActionEvent event, String filePath){
        if(filePath == null || event == null){
            return;
        }
        try {
            System.out.println("AbstractGUIControoler "+filePath);
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
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

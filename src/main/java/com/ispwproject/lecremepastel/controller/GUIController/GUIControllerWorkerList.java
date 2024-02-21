package com.ispwproject.lecremepastel.controller.GUIController;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUIControllerWorkerList {
    public void goBack(ActionEvent backEvent){
        Node node = (Node) backEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        System.out.println("Sei tornato Indietro");
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/directorFirstPage.fxml"));
            Scene scene = new Scene(root, 615, 481);
            stage.setScene(scene);
            stage.setTitle("La Creme Pastel");
            stage.show();
        } catch (Exception e) {
            System.err.println("errore nel cariacamento del roolback!");
            e.printStackTrace();
        }
    }
}


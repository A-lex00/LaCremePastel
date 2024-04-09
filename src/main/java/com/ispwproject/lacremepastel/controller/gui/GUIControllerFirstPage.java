package com.ispwproject.lacremepastel.controller.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUIControllerFirstPage {

    @FXML
    void clickLoginButton(ActionEvent loginEvent) {
        Node n = (Node) loginEvent.getSource();
        Stage stage = (Stage) n.getScene().getWindow();

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/loginPage.fxml"));
            stage.setScene(new Scene(root, 629, 481));
            stage.setTitle("La Creme Pastel");
            stage.show();
        } catch (Exception e) {
            System.err.println("Error: the loading of loginPage crashed!" + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    void clickRegistrationButton(ActionEvent registrationEvent) {
            Node node=(Node) registrationEvent.getSource();
            Stage stage=(Stage) node.getScene().getWindow();

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/registrationPage.fxml"));
            stage.setScene(new Scene(root, 629, 481));
            stage.setTitle("La Creme Pastel");
            stage.show();
        } catch (Exception e) {
            System.err.println("Errore nel caricamento della schermata di login!" + e.getMessage());
            e.printStackTrace();
        }
    }
}
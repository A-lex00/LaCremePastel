package com.ispwproject.lacremepastel.controller.gui;

import javafx.event.ActionEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class GUIControllerShoppingCart {
        @FXML
        void confirmOrder(ActionEvent confirmEvent) {
            Node node=(Node) confirmEvent.getSource();
            Stage stage=(Stage) node.getScene().getWindow();
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/view/customerFirstPage.fxml"));
                stage.setScene(new Scene(root, 629, 481));
                stage.setTitle("La Creme Pastel");
                stage.show();
            }catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        @FXML
        void goBack(ActionEvent backEvent) {
            Node node=(Node) backEvent.getSource();
            Stage stage=(Stage) node.getScene().getWindow();
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/view/makeOrder.fxml"));
                stage.setScene(new Scene(root, 629, 481));
                stage.setTitle("La Creme Pastel");
                stage.show();
            }catch (IOException e) {
                throw new RuntimeException(e);
            }


        }

    }

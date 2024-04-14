package com.ispwproject.lacremepastel.controller.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

    public class GUIControllerWorkerFirstPage {
        @FXML
        private Label welcomeLabel;

        public void setWelcome(String username){
            this.welcomeLabel.setText("Benvenuto"+username);
        }
        @FXML
        public void requestHelp(ActionEvent helpEvent) {
        }
        @FXML
        public void confirmProduction(ActionEvent confirmEvent){
    }

}

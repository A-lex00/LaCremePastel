package com.ispwproject.lacremepastel.controller.gui;

import com.ispwproject.lacremepastel.engineeringclasses.bean.SessionBean;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class GUIControllerWorkerFirstPage extends AbstractGUIController{
        private SessionBean sessionBean;

        @FXML
        private Label welcomeLabel;

        @FXML
        public void requestHelp(ActionEvent helpEvent) {
            this.displayFeaturePopup(helpEvent);
        }
        @FXML
        public void confirmProduction(ActionEvent confirmEvent){
            this.displayFeaturePopup(confirmEvent);
        }


}

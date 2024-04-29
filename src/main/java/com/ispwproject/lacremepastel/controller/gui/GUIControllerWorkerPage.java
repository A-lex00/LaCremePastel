package com.ispwproject.lacremepastel.controller.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class GUIControllerWorkerPage {


        @FXML
        protected Label welcomeLabel =new Label();

        @FXML
        void setWelcomeLabel(String message){
            this.welcomeLabel.setText(message);
        }

        @FXML
        void showProductionList(ActionEvent requestEvent){
            System.out.println("Ecco la lista dei prodotti:");
        }
        @FXML
        void confirmProduction(ActionEvent confirmEvent){
            System.out.println("Produzione effettuata");}
        @FXML
        void requestHelp(ActionEvent helpEvent){
            Node node= (Node) helpEvent.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/helpPage.fxml"));
                Stage poupopStage= new Stage();
                poupopStage.setScene(new Scene(root, 629, 481));
                poupopStage.setTitle("La Creme Pastel");
                poupopStage.initModality(Modality.APPLICATION_MODAL);   //blocca l'interazione con la finestra principale fino alla chiusura del poupop
                poupopStage.initOwner(stage);
                poupopStage.show();
            }catch(Exception e){
                System.err.println("Errore nel caricamento del FXML");
                e.printStackTrace();
            }
        }
}

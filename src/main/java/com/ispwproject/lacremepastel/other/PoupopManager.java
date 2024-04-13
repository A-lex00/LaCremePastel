package com.ispwproject.lacremepastel.other;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PoupopManager{

    public class PopupManager {
                                                        //DA VERIFICARE
        public void getPoupop(Stage stage,String message)throws Exception{

                Stage poupopStage=new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("/view/firstPage.fxml"));
                StackPane stackPane=new StackPane(root);
                Label label=new Label(message);
                stackPane.getChildren().add(label);
                Scene scene=new Scene(root,300,150);
                poupopStage.initModality(Modality.APPLICATION_MODAL);   //blocca l'interazione con la finestra principale fino alla chiusura del poupop
                poupopStage.initOwner(stage);
                poupopStage.setScene(scene);
                poupopStage.showAndWait(); //mostra il poupop e aspetta la chiusura prima di procedere con il codice successivo
        }
    }
}

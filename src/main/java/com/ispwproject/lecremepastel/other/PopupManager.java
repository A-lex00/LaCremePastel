package com.ispwproject.lecremepastel.other;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PopupManager {
    private Object message;
    private Label label=new Label();
    private Stage stage;
    private Scene scene;

    public void setOwner(Stage userStage){
        this.stage=userStage;}
    public void setLabel(String  message){
        if(label==null){
            this.label.setText("Avviso dell'applicazione!");
        }
        this.label.setText(message);}
    public void getPoupop(){
        Stage poupopStage=new Stage();
        poupopStage.initModality(Modality.APPLICATION_MODAL);   //blocca l'interazione con la finestra principale fino alla chiusura del poupop
        poupopStage.initOwner(stage);

        poupopStage.setScene(scene);
        poupopStage.showAndWait(); //mostra il poupop e aspetta la chiusura prima di procedere con il codice successivo
    }
}

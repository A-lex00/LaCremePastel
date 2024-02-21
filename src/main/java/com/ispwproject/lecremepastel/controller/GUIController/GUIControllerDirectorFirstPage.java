package com.ispwproject.lecremepastel.controller.GUIController;

import com.ispwproject.lecremepastel.other.PopupManager;
import com.ispwproject.lecremepastel.engineeringclasses.bean.SessionBean;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class GUIControllerDirectorFirstPage {
    private SessionBean sessionBean;
    public void importSession(SessionBean originalSessionBean){
        this.sessionBean=originalSessionBean;
    }
    @FXML
    public void viewCustomerList(ActionEvent viewCustomerListEvent){
            Node node = (Node) viewCustomerListEvent.getSource();
            Stage stage = (Stage) node.getScene().getWindow();

            Label label=new Label("Feature non implementata");
            Scene scene=new Scene(label,200,100);
            Stage poupopStage=new Stage();
            poupopStage.initModality(Modality.APPLICATION_MODAL);   //blocca l'interazione con la finestra principale fino alla chiusura del poupop
            poupopStage.initOwner(stage);

            poupopStage.setScene(scene);
            poupopStage.showAndWait(); //mostra il poupop e aspetta la chiusura prima di procedere con il codice successivo
    }
    @FXML
    public void manageOrder(ActionEvent manageOrderEvent){
        Node node = (Node) manageOrderEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/manageOrder.fxml"));
            stage.setScene(new Scene(root, 629, 481));
            stage.setTitle("La Creme Pastel");
            stage.show();
        }catch(Exception e){
            System.err.println("Errore nel caricamento del FXML");
            e.printStackTrace();
        }
    }
    @FXML
    public void manageProduct(ActionEvent manageProductEvent){
        Node node = (Node) manageProductEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Label label=new Label("Feature non implementata");
        Scene scene=new Scene(label,200,100);
        Stage poupopStage=new Stage();
        poupopStage.initModality(Modality.APPLICATION_MODAL);   //blocca l'interazione con la finestra principale fino alla chiusura del poupop
        poupopStage.initOwner(stage);

        poupopStage.setScene(scene);
        poupopStage.showAndWait(); //mostra il poupop e aspetta la chiusura prima di procedere con il codice successivo
    }

    @FXML
    public void manageWorkers(ActionEvent manageWorkersEvent){
        Node node = (Node) manageWorkersEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        PopupManager poupop=new PopupManager();
        poupop.setLabel("Feature non implementata!");
    }
    @FXML
        public void requestHelp(ActionEvent helpEvent){
        Node node= (Node) helpEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/helpPage.fxml"));
            Stage poupopStage= new Stage();
            poupopStage.setScene(new Scene(root, 600, 481));
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

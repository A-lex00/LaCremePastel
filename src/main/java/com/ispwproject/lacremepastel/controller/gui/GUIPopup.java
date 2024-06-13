package com.ispwproject.lacremepastel.controller.gui;

import com.ispwproject.lacremepastel.controller.app.ManageOrderController;
import com.ispwproject.lacremepastel.engineeringclasses.bean.OrderLineBean;
import com.ispwproject.lacremepastel.engineeringclasses.bean.SessionBean;
import com.ispwproject.lacremepastel.engineeringclasses.singleton.Configurations;
import com.ispwproject.lacremepastel.model.Order;
import com.ispwproject.lacremepastel.other.FXMLPaths;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.List;
import java.util.logging.Logger;

public class GUIPopup extends  AbstractGUIController {
    private SessionBean sessionBean;

   /* public void createPopup(String message, Stage primaryStage) {
        try{
            Stage popupStage = new Stage();

            popupStage.set

            Label label = new Label(message);
            ((Pane) root).getChildren().add(label);

            Scene scene = new Scene(root, 300, 150);
            popupStage.setScene(scene);
            popupStage.initModality(Modality.APPLICATION_MODAL);   //blocca l'interazione con la finestra principale fino alla chiusura del poupop
            popupStage.initOwner(primaryStage);
            popupStage.setTitle("Avviso");

            popupStage.show();
            popupStage.showAndWait(); //mostra il poupop e aspetta la chiusura prima di procedere con il codice successivo
        }catch(Exception e){
            Logger.getLogger(Configurations.getInstance().getProperty("LOGGER_NAME")).severe(e.getMessage());
        }
    }*/
    public void showDetails(Stage primaryStage, int idOrder){


        try{
            Stage popupStage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource(FXMLPaths.SHOW_DETAILS));

            Parent root = loader.getRoot();


            Scene scene = new Scene(root, 600, 400);
            popupStage.setScene(scene);

            configure(root, idOrder);
            popupStage.initModality(Modality.APPLICATION_MODAL);   //blocca l'interazione con la finestra principale fino alla chiusura del poupop
            popupStage.initOwner(primaryStage);
            popupStage.setTitle("Riepilogo Ordine numero:\t" + idOrder);

            popupStage.show();
            popupStage.showAndWait(); //mostra il poupop e aspetta la chiusura prima di procedere con il codice successivo
        }catch(Exception e){
                Logger.getLogger(Configurations.getInstance().getProperty("LOGGER_NAME")).severe(e.getMessage());
        }
    }
    private void configure(Parent root, int idOrder){
        // Recupero della TableView e delle colonne dal file FXML

        TableView<OrderLineBean> orderView = (TableView<OrderLineBean>) root.lookup("#orderView");
        TableColumn<OrderLineBean, String> productColumn = (TableColumn<OrderLineBean, String>) root.lookup("#productColumn");
        TableColumn<OrderLineBean, Integer> amountColumn = (TableColumn<OrderLineBean, Integer>) root.lookup("#amountColumn");

        // Inizializzazione delle colonne
        productColumn.setCellValueFactory(new PropertyValueFactory<>("productName"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));

        // Recupero dei dettagli dell'ordine dal database
        ManageOrderController manageOrderController = new ManageOrderController();
        ObservableList<OrderLineBean> list = manageOrderController.getOrderById(sessionBean,idOrder);
        orderView.setItems(list);

        // Aggiunta dei pulsanti e delle loro azioni
        Button acceptButton = (Button) root.lookup("#acceptOrder");
        Button rejectButton = (Button) root.lookup("#rejectOrder");
    };
}


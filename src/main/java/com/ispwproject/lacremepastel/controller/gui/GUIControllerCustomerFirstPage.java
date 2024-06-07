package com.ispwproject.lacremepastel.controller.gui;

import com.ispwproject.lacremepastel.engineeringclasses.singleton.Configurations;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.util.logging.Logger;


public class GUIControllerCustomerFirstPage  extends AbstractGUIController{

    @FXML
    private Label initialLabel;

    @FXML
    void composeOrder(ActionEvent composeEvent) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/makeOrder.fxml"));
            AnchorPane root = loader.load();
            GUIControllerMakeOrder controller = loader.getController();
            controller.setUserData(this.getUserData());
            this.setupStage(composeEvent,root);
        }
        catch(IllegalArgumentException e){
            System.err.println("Errore nel caricamento dei prodotti" + e.getMessage());
            Logger.getLogger(Configurations.getInstance().getProperty("LOGGER_NAME")).severe(e.getMessage());
        } catch (IOException e) {
            System.err.println("Errore nel caricamento della schermata del componi Ordine!" + e.getMessage());
            Logger.getLogger(Configurations.getInstance().getProperty("LOGGER_NAME")).severe(e.getMessage());
        }
    }

    @FXML
    void giveBack(ActionEvent backEvent) {
        System.out.println("Segnalazione effettuata");
    }

    @FXML
    void orderHistory(ActionEvent event) {
        System.out.println("Ordini passati");
    }

    @FXML
    void requestHelp(ActionEvent helpEvent) {
        throw new UnsupportedOperationException();
    }

    @FXML
    void reviewOrder(ActionEvent reviewEvent) {
        throw new UnsupportedOperationException();
    }

    @FXML
    void showNotice(ActionEvent noticeEvent) {
        throw new UnsupportedOperationException();
    }
}

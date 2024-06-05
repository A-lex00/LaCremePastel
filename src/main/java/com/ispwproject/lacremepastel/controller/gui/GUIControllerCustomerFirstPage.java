package com.ispwproject.lacremepastel.controller.gui;

import com.ispwproject.lacremepastel.engineeringclasses.bean.SessionBean;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class GUIControllerCustomerFirstPage  {
    private  SessionBean sessionBean= null;

    @FXML
    private Label initialLabel;

    public GUIControllerCustomerFirstPage(SessionBean sessionBean) {
    }

    public void setWelcome(String username){
        this.initialLabel.setText("Benvenuto"+ username);
    }

    @FXML
    void composeOrder(ActionEvent composeEvent) {
        Node node=(Node) composeEvent.getSource();
        Stage stage=(Stage) node.getScene().getWindow();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/makeOrder.fxml"));
            stage.setScene(new Scene(root, 629, 481));
            stage.setTitle("La Creme Pastel");
            stage.show();
        } catch(IllegalArgumentException e){
            System.err.println("Errore nel caricamento dei prodotti" + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Errore nel caricamento della schermata del componi Ordine!" + e.getMessage());
            e.printStackTrace();
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
        Node node=(Node) helpEvent.getSource();
        Stage stage=(Stage) node.getScene().getWindow();

    }

    @FXML
    void reviewOrder(ActionEvent reviewEvent) {
        Node node=(Node) reviewEvent.getSource();
        Stage stage=(Stage) node.getScene().getWindow();
    }

    @FXML
    void showNotice(ActionEvent noticeEvent) {
        Node node=(Node) noticeEvent.getSource();
        Stage stage=(Stage) node.getScene().getWindow();
    }

}

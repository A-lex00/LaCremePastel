package com.ispwproject.lacremepastel.controller.gui;

import com.ispwproject.lacremepastel.engineeringclasses.bean.SessionBean;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class GUIControllerCustomerFirstPage  {

    public GUIControllerCustomerFirstPage(){};
    private  SessionBean sessionBean;

    @FXML
    private Label initialLabel;



    @FXML
    void composeOrder(ActionEvent composeEvent) {
        Node node=(Node) composeEvent.getSource();
        Stage stage=(Stage) node.getScene().getWindow();
        try {
          /*  System.out.println("userdata" + stage.getUserData());
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/makeOrder.fxml"));
            GUIControllerMakeOrder guiControllerMakeOrder = new GUIControllerMakeOrder();
            loader.setController(guiControllerMakeOrder);
            Parent root = loader.getRoot();

            System.out.println(" before if: " + root);
            if(root == null) {
                System.out.println("userdataInif" + stage.getUserData());
                root = FXMLLoader.load(getClass().getResource("/view/makeOrder.fxml"));
            */

            Parent root = FXMLLoader.load(getClass().getResource("/view/makeOrder.fxml"));
            GUIControllerMakeOrder guiControllerMakeOrder = new GUIControllerMakeOrder();
            root.getParent().getScene().getWindow().
            guiControllerMakeOrder.inizio((SessionBean) stage.getUserData());
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

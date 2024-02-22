package com.ispwproject.lecremepastel.controller.GUIController;


import java.util.ArrayList;

import com.ispwproject.lecremepastel.engineeringclasses.exception.IncorrectParametersException;
import com.ispwproject.lecremepastel.engineeringclasses.observer.Observer;
import com.ispwproject.lecremepastel.model.OrderLine;
import com.ispwproject.lecremepastel.engineeringclasses.singleton.ObservablePendingOrderList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class GUIControllerManagerOrder implements Observer{

    private ObservablePendingOrderList observablePendingOrderList;

    public GUIControllerManagerOrder(){
        //observableOrderList = new ObservableOrderList();
        //observableOrderList.attachObserver(this);
    }

    @FXML
    protected ListView orderView;
    @FXML
    private Button rejectButton;
    @FXML
    private Button acceptButton;
    @FXML
    private Button backButton;

    @FXML
    void goBack(ActionEvent backEvent) {
        Node node = (Node) backEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        System.out.println("Sei tornato Indietro");
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/directorFirstPage.fxml"));
            Scene scene = new Scene(root, 615, 481);
            stage.setScene(scene);
            stage.setTitle("La Creme Pastel");
            stage.show();
        } catch (Exception e) {
            System.err.println("errore nel cariacamento del roolback!");
            e.printStackTrace();
        }
    }
    @FXML
    void acceptOrder(ActionEvent event){
        System.out.println("Ordine accettato!");
    }
    @FXML
    void rejectOrder(ActionEvent event){
        System.out.println("Ordine rifiutato!");
    }
    //checkClass
    @FXML
    void loadOrder(ActionEvent event) throws IncorrectParametersException {
        ArrayList<OrderLine> orderList;
        //orderList= orderBean.getAllOrder();
        //System.out.println(orderList);

    }

    @Override
    public void update() {

    }
}

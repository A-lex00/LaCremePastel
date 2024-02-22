package com.ispwproject.lecremepastel.controller.GUIController;

import com.ispwproject.lecremepastel.controller.appcontroller.MakeOrderController;
import com.ispwproject.lecremepastel.engineeringclasses.bean.SessionBean;
import com.ispwproject.lecremepastel.engineeringclasses.exception.IncorrectParametersException;
import com.ispwproject.lecremepastel.engineeringclasses.singleton.SessionManager;
import com.ispwproject.lecremepastel.other.PopupManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class GUIControllerCustomerPage {
    @FXML
    private Label initialLabel;
    private SessionBean sessionBean;

    @FXML
    public void setWelcomeString(){
        SessionBean sessionBean = SessionManager.getInstance().getSession("");
        initialLabel.setText("Benvenuto" + sessionBean.getUsername());
    }
    @FXML
    void composeOrder(ActionEvent composeOrderEvent) {
        Node n = (Node) composeOrderEvent.getSource();
        Stage stage = (Stage) n.getScene().getWindow();
        try{
            GUIControlloreMakeOrder controller=new GUIControlloreMakeOrder();
            controller.inizialize(sessionBean);
            Parent root = FXMLLoader.load(getClass().getResource("/makeOrder.fxml"));
            stage.setScene(new Scene(root, 629, 481));
            stage.setTitle("La Creme Pastel");
            stage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void reviewOrder(ActionEvent reviewOrderEvent) {
        System.out.println("ordine rivisto");
    }

    @FXML
    void orderHistory(ActionEvent historyEvent) {
        System.out.println("storico ordini");
    }
    @FXML
    void  giveBack(ActionEvent backEvent){
      System.out.println("Reso segnalato");

    }
    @FXML
    void requestHelp(ActionEvent helpEvent){
    }
    @FXML
    void showNotice(ActionEvent noticeEvent){
    }


}

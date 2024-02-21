package com.ispwproject.lecremepastel.controller.GUIController;

import com.ispwproject.lecremepastel.engineeringclasses.bean.SessionBean;
import com.ispwproject.lecremepastel.engineeringclasses.exception.IncorrectParametersException;
import com.ispwproject.lecremepastel.engineeringclasses.singleton.SessionManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

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
        System.out.println("PROVA");
    }

    @FXML
    void reviewOrder(ActionEvent reviewOrderEvent) {
        System.out.println("BElla pe Te");
    }

    @FXML
    void orderHistory(ActionEvent historyEvent) {
        System.out.println("Prova");
    }
    @FXML
    void  giveBack(ActionEvent backEvent){
      System.out.println("AA");

    }
    @FXML
    void requestHelp(ActionEvent helpEvent){
        System.out.println("Hai richiesto aiuto!");
    }
    @FXML
    void showNotice(ActionEvent noticeEvent){
    }


}

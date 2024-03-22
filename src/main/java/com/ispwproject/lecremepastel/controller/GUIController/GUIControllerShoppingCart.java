package com.ispwproject.lecremepastel.controller.GUIController;

import com.ispwproject.lecremepastel.controller.appcontroller.MakeOrderController;
import com.ispwproject.lecremepastel.engineeringclasses.bean.OrderLineBean;
import com.ispwproject.lecremepastel.engineeringclasses.bean.SessionBean;
import com.ispwproject.lecremepastel.engineeringclasses.bean.SimpleOrderBean;
import com.ispwproject.lecremepastel.model.OrderLine;
import com.ispwproject.lecremepastel.model.SimpleOrder;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.util.List;

public class GUIControllerShoppingCart {

    @FXML
    private List<OrderLineBean> orderLine;
    private int sid;
    private SessionBean sessionBean;

    public void inizialize(SimpleOrderBean simpleOrderBean){
        orderLine=simpleOrderBean.getProductList();
        this.sid=simpleOrderBean.getId();
    }

    @FXML
    public void confirmOrder(ActionEvent confirmEvent){
        MakeOrderController controller = new MakeOrderController();
        //controller.createSimpleOrder();
    }
    @FXML
    public void goBack(ActionEvent backEvent){
        Node node = (Node) backEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/makeOrder.fxml"));
            Scene scene = new Scene(root, 615, 481);
            stage.setScene(scene);
            stage.setTitle("La Creme Pastel");
            stage.show();
        } catch (Exception e) {
            System.err.println("errore nel cariacamento del roolback!");
            e.printStackTrace();
        }
    }



}

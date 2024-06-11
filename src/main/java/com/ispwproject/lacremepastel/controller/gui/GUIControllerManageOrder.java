package com.ispwproject.lacremepastel.controller.gui;

import com.ispwproject.lacremepastel.engineeringclasses.bean.OrderBean;
import com.ispwproject.lacremepastel.engineeringclasses.bean.OrderLineBean;
import com.ispwproject.lacremepastel.engineeringclasses.bean.SessionBean;
import com.ispwproject.lacremepastel.other.FXMLPaths;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import java.util.List;

public class GUIControllerManageOrder extends AbstractGUIController{

    @FXML
    private Button acceptButton;

    @FXML
    private Button backButton;

    @FXML
    private ListView<?> orderView;

    @FXML
    private Button rejectButton;

    private List<OrderLineBean> currentCart;

    @FXML
    void acceptOrder(ActionEvent event) {
        SessionBean sessionBean = (SessionBean) this.getUserData(SESSION_DATA);
        OrderBean orderBean = new OrderBean(sessionBean.getUsername());
        orderBean.setCart(currentCart);
    }

    @FXML
    void goBack(ActionEvent event) {
        this.setupStage(event, FXMLPaths.DIRECTOR_HOME);
    }

    @FXML
    void rejectOrder(ActionEvent event) {

    }

}
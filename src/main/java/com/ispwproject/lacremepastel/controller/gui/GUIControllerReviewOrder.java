package com.ispwproject.lacremepastel.controller.gui;

import com.ispwproject.lacremepastel.controller.app.ManageOrderController;
import com.ispwproject.lacremepastel.engineeringclasses.bean.OrderBean;
import com.ispwproject.lacremepastel.engineeringclasses.bean.OrderLineBean;
import com.ispwproject.lacremepastel.engineeringclasses.bean.SessionBean;
import com.ispwproject.lacremepastel.other.FXMLPaths;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class GUIControllerReviewOrder extends AbstractGUIController{

    @FXML
    private TableView<OrderLineBean> orderView;
    @FXML
    private TableColumn<OrderLineBean, String> productColumn;
    @FXML
    private TableColumn<OrderLineBean, Integer> amountColumn;

    public void rejectOrder(ActionEvent event) {
        ManageOrderController manageOrderController = new ManageOrderController();
        manageOrderController.rejectOrder(
                (SessionBean) this.getUserData(SESSION_DATA),
                (OrderBean) this.getUserData(ORDER)
        );
        this.setupStage(event, FXMLPaths.MANAGE_ORDER);
    }

    public void acceptOrder(ActionEvent event) {
        ManageOrderController manageOrderController = new ManageOrderController();
        manageOrderController.acceptOrder(
                (SessionBean) this.getUserData(SESSION_DATA),
                (OrderBean) this.getUserData(ORDER)
        );
        this.setupStage(event, FXMLPaths.MANAGE_ORDER);
    }

    @Override
    public void configure(){
        ManageOrderController manageOrderController = new ManageOrderController();
        int orderId = (Integer) this.deleteUserData(ORDER_ID);
        SessionBean sessionBean = (SessionBean) this.getUserData(SESSION_DATA);
        OrderBean orderBean = manageOrderController.getOrderById(sessionBean,orderId);
        this.setUserData(ORDER,orderBean);

        ObservableList<OrderLineBean> items = FXCollections.observableArrayList();
        items.setAll(orderBean.getAllOrder());

        //Initializing Table
        productColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getProductName()));
        amountColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getAmount()));
        orderView.setItems(items);
    }
}

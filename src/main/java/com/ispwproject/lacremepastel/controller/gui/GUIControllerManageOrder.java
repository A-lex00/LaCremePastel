package com.ispwproject.lacremepastel.controller.gui;

import com.ispwproject.lacremepastel.controller.app.ManageOrderController;
import com.ispwproject.lacremepastel.engineeringclasses.bean.OrderBean;
import com.ispwproject.lacremepastel.engineeringclasses.bean.SessionBean;
import com.ispwproject.lacremepastel.engineeringclasses.singleton.Configurations;
import com.ispwproject.lacremepastel.other.FXMLPaths;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.util.List;
import java.util.logging.Logger;

public class GUIControllerManageOrder extends AbstractGUIController {

    @FXML
    private Button backButton;

    @FXML
    private TableView<OrderBean> ordersView;

    @FXML
    private TableColumn<OrderBean, Integer> orderColumn;

    @FXML
    private TableColumn<OrderBean, String> customerColumn;

    @FXML
    private Button detailsButton;

    private List<OrderBean> orders;

    @FXML
    void goBack(ActionEvent event) {
        this.setupStage(event, FXMLPaths.DIRECTOR_HOME);
    }

    @Override
    public void configure(){
        SessionBean sessionBean = (SessionBean) this.getUserData(SESSION_DATA);
        ObservableList<OrderBean> actualOrders = FXCollections.observableArrayList();

        // Initializing ManageOrderController
        ManageOrderController manageOrderController = new ManageOrderController();
        this.orders = manageOrderController.getPendingOrders(sessionBean);

        actualOrders.setAll(orders);


        // Initializing Table
        customerColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getCustomerName()));
        orderColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getIdOrder()));

        // Set items to the TableView
        ordersView.setItems(actualOrders);
    }

    public void showDetails(ActionEvent event) {
        try {
            int index = ordersView.getSelectionModel().getSelectedIndex();
            this.setUserData(ORDER, orders.get(index));
            this.setupStage(event,FXMLPaths.SHOW_DETAILS);
        }catch (IndexOutOfBoundsException e){
            Logger.getLogger(Configurations.LOGGER_NAME).warning(e.getMessage());
        }
    }
}

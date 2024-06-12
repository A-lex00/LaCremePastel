package com.ispwproject.lacremepastel.controller.gui;

import com.ispwproject.lacremepastel.controller.app.ManageOrderController;
import com.ispwproject.lacremepastel.engineeringclasses.bean.OrderBean;
import com.ispwproject.lacremepastel.engineeringclasses.bean.OrderLineBean;
import com.ispwproject.lacremepastel.engineeringclasses.bean.SessionBean;
import com.ispwproject.lacremepastel.model.Order;
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

public class GUIControllerManageOrder extends AbstractGUIController {

    @FXML
    private Button backButton;

    @FXML
    private TableView<Order> ordersView;

    @FXML
    private TableColumn<Order, Integer> orderColumn;

    @FXML
    private TableColumn<Order, String> customerColumn;

    @FXML
    private Button detailsButton;

    private List<OrderLineBean> currentCart;

    private SessionBean sessionBean;

    @FXML
    void acceptOrder(ActionEvent event) {
        OrderBean orderBean = new OrderBean(sessionBean.getUsername());
        orderBean.setCart(currentCart);
        ManageOrderController orderController = new ManageOrderController();
        orderController.manage(currentCart, sessionBean);
    }

    @FXML
    void showDetails() {
        // Implement show details functionality
    }

    @FXML
    void goBack(ActionEvent event) {
        this.setupStage(event, FXMLPaths.DIRECTOR_HOME);
    }

    @FXML
    void rejectOrder(ActionEvent event) {
        // Implement reject order functionality
    }

    @Override
    public void configure() throws Exception {
        this.sessionBean = (SessionBean) this.getUserData(SESSION_DATA);
        ObservableList<Order> actualOrders = FXCollections.observableArrayList();

        // Initializing ManageOrderController
        ManageOrderController manageOrderController = new ManageOrderController();
        List<Order> orderNumbers = manageOrderController.getAllOrders(sessionBean);

        actualOrders.setAll(orderNumbers);
        System.out.println(actualOrders + " actualOrders GUIControllerManageOrder");

        // Initializing Table
        customerColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getCustomerName()));
        orderColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getIdOrder()));

        // Set items to the TableView
        ordersView.setItems(actualOrders);
    }
}

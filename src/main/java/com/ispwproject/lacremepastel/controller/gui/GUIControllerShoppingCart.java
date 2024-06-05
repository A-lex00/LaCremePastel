package com.ispwproject.lacremepastel.controller.gui;

import com.ispwproject.lacremepastel.controller.app.ManageOrder;
import com.ispwproject.lacremepastel.engineeringclasses.bean.OrderBean;
import com.ispwproject.lacremepastel.engineeringclasses.observer.Cart;
import com.ispwproject.lacremepastel.engineeringclasses.observer.Observer;
import com.ispwproject.lacremepastel.model.Order;
import com.ispwproject.lacremepastel.model.OrderLine;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;
//Concrete Observer
public class GUIControllerShoppingCart implements  Initializable, Observer {

        /**OBSERVER */
        private Cart actualCart;        /** ISTANZA DEL MODEL OSSERVATO */
       // private ListView<Order> Cart=new ListView<>();
        private List<OrderLine> actualOrder= new ArrayList<>();
        private List<OrderBean> orderBean=new ArrayList<>();
        public GUIControllerShoppingCart() {}

        @FXML
        void confirmOrder(ActionEvent confirmEvent) {
            Node node=(Node) confirmEvent.getSource();
            Stage stage=(Stage) node.getScene().getWindow();
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/view/customerFirstPage.fxml"));
                stage.setScene(new Scene(root, 629, 481));
                stage.setTitle("La Creme Pastel");
                stage.show();
            }catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        @FXML
        void goBack(ActionEvent backEvent) {
            Node node = (Node) backEvent.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/view/makeOrder.fxml"));
                stage.setScene(new Scene(root, 629, 481));
                stage.setTitle("La Creme Pastel");
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        public void setActualOrder(OrderLine order){
            actualOrder.add(order);
        }
    /**
     *Ricevo un ordine, lo invio all'applicativo per una traduzione da model a bean
     *
     */
    @Override
    public void update() {
        actualOrder=actualCart.getState();
        ManageOrder manageOrder = new ManageOrder();



    }

    /**
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

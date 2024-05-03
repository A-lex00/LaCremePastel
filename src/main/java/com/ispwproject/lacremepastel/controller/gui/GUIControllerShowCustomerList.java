package com.ispwproject.lacremepastel.controller.gui;

import com.ispwproject.lacremepastel.engineeringclasses.dao.CustomerDAO;
import com.ispwproject.lacremepastel.engineeringclasses.dao.db.CustomerDbDAO;
import com.ispwproject.lacremepastel.model.Customer;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class GUIControllerShowCustomerList implements Initializable {
        @FXML
        private ListView<String> customerView;
        private CustomerDAO customerDAO;
        private List<String> customers;
        private String selectedCustomer;
        @FXML
        void goBack(ActionEvent event) {
        }
        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
             CustomerDAO customerDAO1=new CustomerDbDAO();
             this.customers=customerDAO1.getAllCustomer();
             customerView.getItems().addAll(customers);
        }
}

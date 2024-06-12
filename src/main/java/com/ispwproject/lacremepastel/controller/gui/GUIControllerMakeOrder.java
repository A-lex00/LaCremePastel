package com.ispwproject.lacremepastel.controller.gui;
import com.ispwproject.lacremepastel.controller.app.ManageProductController;
import com.ispwproject.lacremepastel.engineeringclasses.bean.OrderLineBean;
import com.ispwproject.lacremepastel.engineeringclasses.bean.ProductBean;
import com.ispwproject.lacremepastel.engineeringclasses.bean.SessionBean;
import com.ispwproject.lacremepastel.engineeringclasses.observer.Cart;
import com.ispwproject.lacremepastel.engineeringclasses.observer.Observer;
import com.ispwproject.lacremepastel.engineeringclasses.singleton.Configurations;
import com.ispwproject.lacremepastel.other.FXMLPaths;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.ArrayList;
import java.util.logging.Logger;

public class GUIControllerMakeOrder  extends AbstractGUIController implements Observer {

    @FXML
    private ComboBox<String> productBox;
    @FXML
    private TextField quantityField;
    @FXML
    private TableView<OrderLineBean> orderView;
    @FXML
    private TableColumn<ProductBean, String> productColumn;
    @FXML
    private TableColumn<OrderLineBean, Integer> quantityColumn;
    @FXML
    private TableColumn<ProductBean, Double> priceColumn;

    private Cart actualCart;
    private ArrayList<ProductBean> productList;

    @FXML
    void addCart(ActionEvent cartEvent) {
        System.out.println("addCart");
        int index = productBox.getSelectionModel().getSelectedIndex();
        ProductBean product = productList.get(index);
        try {
            int quantity = Integer.parseInt(quantityField.getText() );
            OrderLineBean orderLineBean = new OrderLineBean(product, quantity);
            actualCart.addOrderLine(orderLineBean);
        }catch (NumberFormatException e){
            Logger.getLogger(Configurations.getInstance().getProperty("LOGGER_NAME")).severe(e.getMessage());
        }finally {
            productBox.getSelectionModel().clearSelection();
            quantityField.setText("");
        }
    }

    @FXML
    public void goBack(ActionEvent backEvent) {
        this.setupStage(backEvent, FXMLPaths.CUSTOMER_HOME);
    }

    @FXML
    public void confirmOrder(ActionEvent confirmEvent) {
        this.setUserData("cart",actualCart);
        this.setupStage(confirmEvent, FXMLPaths.SHOPPING_CART);
    }

    @Override
    public void configure() {
        //Setup userData
        SessionBean sessionBean = (SessionBean) this.getUserData(SESSION_DATA);

        //Retrieve an existing cart (if any)
        Cart tmp = (Cart) this.getUserData("cart");
        System.out.println("Retrieved Cart: "+tmp);
        if( tmp != null){
            this.actualCart = tmp;
            update();
        }else{
            actualCart = new Cart();
        }

        //Loading productList
        ManageProductController manageProductController = new ManageProductController();
        this.productList = (ArrayList<ProductBean>) manageProductController.getProductList(sessionBean, null);
        for (ProductBean productBean : productList) {
            productBox.getItems().add(productBean.getProductName() + "  " + productBean.getPrice() + "€");
        }
        actualCart.attach(this);

        //Initializing Table
        productColumn.setCellValueFactory(new PropertyValueFactory<>("productName"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
    }

    @Override
    public void update() {
        orderView.getItems().removeAll();
        ObservableList<OrderLineBean> list = FXCollections.observableList(actualCart.getState());
        orderView.setItems(list);
    }
}





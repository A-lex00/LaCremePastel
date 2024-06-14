package com.ispwproject.lacremepastel.controller.gui;

import com.ispwproject.lacremepastel.controller.app.ManageProductController;
import com.ispwproject.lacremepastel.engineeringclasses.bean.ProductBean;
import com.ispwproject.lacremepastel.engineeringclasses.bean.ProductFilterBean;
import com.ispwproject.lacremepastel.engineeringclasses.bean.SessionBean;
import com.ispwproject.lacremepastel.other.FXMLPaths;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.util.List;

public class GUIControllerManageProduct extends AbstractGUIController{

    @FXML
    private ComboBox<ProductBean> productBox;
    @FXML
    private TextField category;
    @FXML
    private TextField price;
    @FXML
    private ImageView image;
    @FXML
    private Button confirmButton;
    @FXML
    private TextField productName;
    @FXML
    private Button backButton;
    @FXML
    private Button deleteProduct;
    @FXML
    private Button searchButton;

    private SessionBean sessionData;

    @FXML
    void confirmModify(ActionEvent confirmEvent) {
        String name = this.productName.getText();
        double p = Double.parseDouble(this.price.getText());

        ManageProductController manageProductController = new ManageProductController();
        manageProductController.updateProduct(new ProductBean(name,p), sessionData);

    }

    @FXML
    public void goBack(ActionEvent backEvent) {
        this.setupStage(backEvent, FXMLPaths.DIRECTOR_HOME);
    }

    @FXML
    public void deleteProduct(ActionEvent deleteEvent) {
    }

    @FXML
    public void searchProduct(ActionEvent event) {
        String name = this.productName.getText();
        if(name == null){
            return;
        }
        ManageProductController manageProductController = new ManageProductController();
        ProductFilterBean productFilterBean = new ProductFilterBean(name);
        List<ProductBean> productList = manageProductController.getProductList(sessionData,productFilterBean);
        if(!productList.isEmpty()) {
            productBox.getItems().clear();
            price.clear();
            category.clear();
            for (ProductBean productBean : productList) {
                productBox.getItems().add(productBean);
            }
            productBox.setVisible(true);
        }
    }

    @Override
    public void configure() {
        this.sessionData = (SessionBean) this.getUserData(SESSION_DATA);
    }

    public void oracolo(ActionEvent event) {
        ProductBean selected = productBox.getSelectionModel().getSelectedItem();
        if(selected != null) {
            this.category.setText(selected.getCategory().toString());
            this.price.setText(String.valueOf(selected.getPrice()));
            this.productName.setText(selected.getProductName());
        }
    }
}

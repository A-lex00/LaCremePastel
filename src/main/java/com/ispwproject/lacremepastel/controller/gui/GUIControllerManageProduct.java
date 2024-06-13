package com.ispwproject.lacremepastel.controller.gui;

import com.ispwproject.lacremepastel.controller.app.ManageProductController;
import com.ispwproject.lacremepastel.engineeringclasses.bean.ProductBean;
import com.ispwproject.lacremepastel.engineeringclasses.bean.SessionBean;
import com.ispwproject.lacremepastel.other.FXMLPaths;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class GUIControllerManageProduct extends AbstractGUIController{

    @FXML
    private Button backButton;

    @FXML
    private Button confirm;

    @FXML
    private Button deleteProduct;

    @FXML
    private ImageView immage;
    @FXML
    private TextField productNameField;
    @FXML
    private TextField categoryField;
    @FXML
    private TextField priceField;


    @FXML
    private Button searchButton;
    @FXML
    void confirmModify(ActionEvent confirmEvent) {
        SessionBean sessionBean = (SessionBean) this.getUserData(SESSION_DATA);
        String name = productNameField.getText();
        double price = Double.parseDouble(priceField.getText());

        ManageProductController manageProductController = new ManageProductController();
        manageProductController.updateProduct(new ProductBean(name,price), sessionBean);

    }
    @FXML
    public void searchButton(ActionEvent searchEvent){}

    @FXML
    void goBack(ActionEvent backEvent) {
        this.setupStage(backEvent, FXMLPaths.DIRECTOR_HOME);
    }

    @FXML
    void deleteProduct(ActionEvent deleteEvent) {

    }

    public void productName(ActionEvent event) {
    }

    public void category(ActionEvent event) {
    }

    public void price(ActionEvent event) {
    }

    public void searchProduct(ActionEvent event) {
    }
}

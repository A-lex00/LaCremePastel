package com.ispwproject.lacremepastel.controller.gui;

import com.ispwproject.lacremepastel.controller.app.LoginController;
import com.ispwproject.lacremepastel.engineeringclasses.bean.RegisterBean;
import com.ispwproject.lacremepastel.engineeringclasses.exception.InvalidParameterException;
import com.ispwproject.lacremepastel.engineeringclasses.exception.UserAlreadyExistentException;
import com.ispwproject.lacremepastel.engineeringclasses.factory.PopupFactory;
import com.ispwproject.lacremepastel.other.FXMLPaths;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class GUIControllerRegistrationPage extends AbstractGUIController{
    @FXML
    private Button backButton;
    @FXML
    private Button confirmButton;
    @FXML
    private TextField cfPivaField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField cnfEmailField;
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField surnameField;
    @FXML
    private TextField usernameField;
    @FXML
    private TextField extraField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private PasswordField cnfPasswordField;
    @FXML
    private RadioButton customerDot;
    @FXML
    private RadioButton directorDot;
    @FXML
    private RadioButton workerDot;
    @FXML
    private final ToggleGroup roleGroup = new ToggleGroup();

    @FXML
    void back(ActionEvent backEvent) {
        this.setupStage(backEvent, FXMLPaths.FIRST_PAGE);
    }

    @FXML
    void addExtraField() {
        customerDot.setToggleGroup(roleGroup);
        directorDot.setToggleGroup(roleGroup);
        workerDot.setToggleGroup(roleGroup);
        boolean worker = workerDot.isSelected();
        boolean director = directorDot.isSelected();

        if (director || worker) {
            if (director) {
                extraField.setPromptText("Inserisci la tassazione");
            }
            if (worker) {
                extraField.setPromptText("Inserisci il tuo ruolo");
            }
            extraField.setVisible(true);
        } else {
            extraField.setVisible(false);
        }
    }

    @FXML
    public void confirm(ActionEvent confirmEvent) {
        String ruolo=null;
        String name = firstNameField.getText();
        String surname = surnameField.getText();
        String username = usernameField.getText();
        String email = emailField.getText();
        String cnfEmail = cnfEmailField.getText();
        String password = passwordField.getText();
        String cnfPassword = cnfPasswordField.getText();
        String cfPiva = cfPivaField.getText();
        String extraInfo = null;
        PopupFactory popupFactory = new PopupFactory();
        try {
            if (!cnfEmail.equalsIgnoreCase(email)) {
                throw new InvalidParameterException("Email does not match");
            }
            if (!cnfPassword.equalsIgnoreCase(password)) {
                throw new InvalidParameterException("Password does not match");
            }
        }catch (InvalidParameterException e) {
            //Creare il banner con il messaggio
            return;
        }

        if (workerDot.isSelected()) {
            ruolo = "WORKER";
            extraInfo=extraField.getText();
        }
        else if (customerDot.isSelected()) {
            ruolo="CUSTOMER";
        }else if(directorDot.isSelected()){
            ruolo="DIRECTOR";
            extraInfo=extraField.getText();
        }
        if(ruolo == null) {
            //Chiamata al banner
            return;
        }
        RegisterBean registerBean = new RegisterBean(username, cfPiva, password, name, surname, email, ruolo);

        if(workerDot.isSelected()){
            registerBean.setRole(extraInfo);
        }
        if(directorDot.isSelected()){
            registerBean.setBillingAddress(extraInfo);
        }

        Node node = (Node) confirmEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        try {
            LoginController loginController=new LoginController();
            loginController.register(registerBean);

            popupFactory.createBasePopup("Registrazione completata: Benvenuto").show(stage);
        } catch (UserAlreadyExistentException e) {
            popupFactory.createBasePopup("Credenziali già in uso").show(stage);
        }catch(InvalidParameterException invalidParameterException){
            popupFactory.createBasePopup("Errore nell'inserimento dei parametri").show(stage);
        }
    }
}

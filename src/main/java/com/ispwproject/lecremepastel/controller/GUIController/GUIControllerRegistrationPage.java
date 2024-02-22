package com.ispwproject.lecremepastel.controller.GUIController;

import com.ispwproject.lecremepastel.controller.appcontroller.LoginController;
import com.ispwproject.lecremepastel.engineeringclasses.bean.RegisterBean;
import com.ispwproject.lecremepastel.engineeringclasses.exception.IncorrectParametersException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;


public class GUIControllerRegistrationPage{
    protected RegisterBean registerBean;

    public void setUserBean(RegisterBean registerBean) {
        this.registerBean = registerBean;
    }
    @FXML
    protected Button confermButton = new Button();
    @FXML
    protected Button cancelButton = new Button();
    @FXML
    protected TextField firstnameField = new TextField();
    @FXML
    protected TextField surnameField = new TextField();
    @FXML
    protected TextField usernameField = new TextField();
    @FXML
    protected TextField cfPivaField = new TextField();
    @FXML
    protected TextField emailField = new TextField();
    @FXML
    protected TextField cnfEmailField = new TextField();
    @FXML
    protected TextField extraField = new TextField();
    @FXML
    protected PasswordField passwordField = new PasswordField();
    @FXML
    protected PasswordField cnfPasswordField = new PasswordField();
    @FXML
    protected RadioButton customerDot;
    @FXML
    protected RadioButton workerDot;
    @FXML
    protected RadioButton directorDot;
    @FXML
    protected ToggleGroup userTypeGroup = new ToggleGroup();

    public void checkRole() {

        workerDot.setToggleGroup(userTypeGroup);
        directorDot.setToggleGroup(userTypeGroup);
        customerDot.setToggleGroup(userTypeGroup);

        boolean customerUser = customerDot.isSelected();
        boolean directorUser = directorDot.isSelected();
        boolean workerUser = workerDot.isSelected();
        if(customerUser || workerUser){
            extraField.setVisible(true);
            if(workerUser){
                extraField.setPromptText("Inserisci il tuo ruolo ");
            }
            else{
                extraField.setPromptText("Inserisci il tuo indirizzo");
            }
        }
    }

    public void confirm(ActionEvent confirmEvent) {
        try {
            boolean customerUser = customerDot.isSelected();
            boolean directorUser = directorDot.isSelected();
            boolean workerUser = workerDot.isSelected();

            String extraInfo = extraField.getText();
            String firstname = firstnameField.getText();
            String surname = surnameField.getText();
            String username = usernameField.getText();
            String password = passwordField.getText();
            String cnfPass = cnfPasswordField.getText();
            String email = emailField.getText();
            String cnfEmail = cnfEmailField.getText();
            String cfPiva = cfPivaField.getText();

            String billingAddress = null;
            String role = null;
            if (customerUser) {
                billingAddress = extraInfo;
            }
            if (workerUser) {
                role = extraInfo;
            }
            RegisterBean rBean = new RegisterBean(email, cnfEmail, username, firstname, surname, password, cnfPass, cfPiva, role, billingAddress, workerUser, directorUser, customerUser);
            this.registerBean = rBean;
            LoginController loginController = new LoginController();
            System.out.println(rBean);
            if (Boolean.TRUE.equals(loginController.register(rBean))) {
                System.out.println("Registration Successful!");
            } else {
                System.out.println("Registration Failed! User already existent");
            }
        } catch (IncorrectParametersException le) {
            System.err.println("Errore nel passaggio nel Bean");
            le.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void back(ActionEvent backEvent) {
        Node node = (Node) backEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/firstPage.fxml"));
            stage.setScene(new Scene(root, 629, 481));
            stage.setTitle("La Creme Pastel");
            stage.show();
        } catch (Exception le) {
            System.err.println("Errore nel backHome!");
            le.printStackTrace();
        }
    }
}

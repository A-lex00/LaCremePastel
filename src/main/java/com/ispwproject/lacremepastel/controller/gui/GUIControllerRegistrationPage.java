package com.ispwproject.lacremepastel.controller.gui;

import com.ispwproject.lacremepastel.engineeringclasses.bean.RegisterBean;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.w3c.dom.Text;
import org.w3c.dom.events.MouseEvent;

import java.io.IOException;

public class GUIControllerRegistrationPage {
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
    private ToggleGroup roleGroup=new ToggleGroup();
    private boolean worker,director,customer;
    @FXML
    void back(ActionEvent backEvent) {
        Node node=(Node) backEvent.getSource();
        Stage stage=(Stage) node.getScene().getWindow();
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/firstPage.fxml"));
            stage.setScene(new Scene(root, 629, 481));
            stage.setTitle("La Creme Pastel");
            stage.show();
         }catch(Exception e){
            System.err.println("Errore nel go back!");
            e.printStackTrace();
        }
    }
    @FXML
     void addExtraField(){
        customerDot.setToggleGroup(roleGroup);
        directorDot.setToggleGroup(roleGroup);
        workerDot.setToggleGroup(roleGroup);
        customer=customerDot.isSelected();
        worker=workerDot.isSelected();
        director=directorDot.isSelected();

        if(director || worker ){
            if(director){
                extraField.setPromptText("Inserisci la tassazione");
            }
            if(worker){
                extraField.setPromptText("Inserisci il tuo ruolo");
            }
            extraField.setVisible(true);
        }
        else{
            extraField.setVisible(false);
        }
    }
    @FXML
    public void confirm(ActionEvent confirmButton){
        String ruolo;
        String name= firstNameField.getText();
        String surname=surnameField.getText();
        String username=usernameField.getText();
        String email= emailField.getText();
        String cnfEmail=cnfEmailField.getText();
        String password=passwordField.getText();
        String cnfPassword=cnfPasswordField.getText();
        String cfPiva=cfPivaField.getText();
        String extraInfo=extraField.getText();
        if( worker=workerDot.isSelected()){
            ruolo="WORKER";
            RegisterBean registerBean=new RegisterBean(username,cfPiva,password,name,surname,email,ruolo);
        }
        if(customer=customerDot.isSelected()){
            ruolo="CUSTOMER";
            RegisterBean registerBean=new RegisterBean(username,cfPiva,password,name,surname,email,ruolo);
        }
        if(director=directorDot.isSelected()){
            ruolo="DIRECTOR";
            RegisterBean registerBean=new RegisterBean(username,cfPiva,password,name,surname,email,ruolo);
        }
        System.out.println("Registrazione effettuata!");
    }
}

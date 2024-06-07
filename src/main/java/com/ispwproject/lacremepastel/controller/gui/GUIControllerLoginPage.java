package com.ispwproject.lacremepastel.controller.gui;

import com.ispwproject.lacremepastel.controller.app.LoginController;
import com.ispwproject.lacremepastel.engineeringclasses.bean.LoginBean;
import com.ispwproject.lacremepastel.engineeringclasses.bean.SessionBean;
import com.ispwproject.lacremepastel.engineeringclasses.exception.InvalidParameterException;
import com.ispwproject.lacremepastel.other.FXMLPaths;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class GUIControllerLoginPage extends AbstractGUIController{

    @FXML
    private TextField authField;
    @FXML
    private Button backButton;
    @FXML
    private Button loginButton;
    @FXML
    private PasswordField passField;

    @FXML
    void backHome(ActionEvent homeEvent) {
        this.setupStage(homeEvent, FXMLPaths.FIRST_PAGE);
    }
    @FXML
    public void mainPage(ActionEvent mainPageEvent){
        String username= authField.getText();
        String password=passField.getText();

        SessionBean sessionBean = null;
        try{
            LoginBean loginBean=new LoginBean(username,password);
            LoginController loginController=new LoginController();
            sessionBean = loginController.login(loginBean);

            if (sessionBean == null) {
                // Mostra un messaggio di errore all'utente
                throw new InvalidParameterException("Invalid username or password");
            }

            this.setUserData(sessionBean);

            if(sessionBean.getRole().equals("DIRECTOR")){
                this.setupStage(mainPageEvent,FXMLPaths.DIRECTOR_HOME);
            }else if(sessionBean.getRole().equals("CUSTOMER")){
                this.setupStage(mainPageEvent,FXMLPaths.CUSTOMER_HOME);
            }else if(sessionBean.getRole().equals("WORKER")){
                this.setupStage(mainPageEvent,FXMLPaths.WORKER_HOME);
            }

        }catch(InvalidParameterException parameterException){
            System.err.println("Errore nell'accesso: Dati errati!");
            parameterException.fillInStackTrace();
        }

    }
}

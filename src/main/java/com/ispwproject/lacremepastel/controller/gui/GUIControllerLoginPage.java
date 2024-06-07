package com.ispwproject.lacremepastel.controller.gui;

import com.ispwproject.lacremepastel.controller.app.LoginController;
import com.ispwproject.lacremepastel.engineeringclasses.bean.LoginBean;
import com.ispwproject.lacremepastel.engineeringclasses.bean.SessionBean;
import com.ispwproject.lacremepastel.engineeringclasses.exception.InvalidParameterException;
import com.ispwproject.lacremepastel.engineeringclasses.exception.UserAlreadyLoggedException;
import com.ispwproject.lacremepastel.engineeringclasses.exception.UuidAlreadyExistent;
import com.ispwproject.lacremepastel.engineeringclasses.singleton.SessionManager;
import com.ispwproject.lacremepastel.model.Session;
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

import java.net.URL;

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
        Node node=(Node) homeEvent.getSource();
        Stage stage=(Stage) node.getScene().getWindow();
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/view/firstPage.fxml"));
            stage.setScene(new Scene(root, 629, 481));
            stage.show();
        }catch(Exception e){
            System.err.println("Errore nel go back!");
            e.printStackTrace();

        }
    }
    @FXML
    public void mainPage(ActionEvent mainPageEvent){
        String username= authField.getText();
        String password=passField.getText();
        try{
            LoginBean loginBean=new LoginBean(username,password);
            LoginController loginController=new LoginController();
            SessionBean sessionBean = loginController.login(loginBean);

            if (sessionBean == null) {
                // Mostra un messaggio di errore all'utente
                System.err.println("Errore nell'accesso: Dati errati");
                return;
            }
            Node node=(Node) mainPageEvent.getSource();
            Stage stage=(Stage) node.getScene().getWindow();
            try{
                Parent root=null;
                if(sessionBean.getRole().equals("DIRECTOR")){
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/customerFirstPage.fxml"));
                    GUIControllerDirectorFirstPage guiControllerDirectorFirstPage = new GUIControllerDirectorFirstPage();
                    guiControllerDirectorFirstPage.setSessionBean(sessionBean);
                    loader.setController(guiControllerDirectorFirstPage);
                    root = loader.getRoot();
                    if(root == null) {
                        root = FXMLLoader.load(getClass().getResource("/view/directorFirstPage.fxml"));
                    }
                }
                if(sessionBean.getRole().equals("CUSTOMER")){
                    GUIControllerCustomerFirstPage guiControllerCustomerFirstPage = new GUIControllerCustomerFirstPage();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/customerFirstPage.fxml"));
                   // guiControllerCustomerFirstPage.setSessionBean(sessionBean);
                    loader.setController(guiControllerCustomerFirstPage);
                    root = loader.getRoot();
                    if(root == null) {
                        root = FXMLLoader.load(getClass().getResource("/view/customerFirstPage.fxml"));
                    }
                }
                if(sessionBean.getRole().equals("WORKER")){
                    root = FXMLLoader.load(getClass().getResource("/view/workerFirstPage.fxml"));
                    /*GUIControllerWorkerFirstPage guiControllerWorkerFirstPage = new GUIControllerWorkerFirstPage();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/workerFirstPage.fxml"));
                    guiControllerWorkerFirstPage.setSessionBean(sessionBean);
                    loader.setController(guiControllerWorkerFirstPage);
                    System.out.println("LoginPage : " + sessionBean);
                    root = loader.getRoot();
                    if(root == null) {
                        root = FXMLLoader.load(getClass().getResource("/view/workerFirstPage.fxml"));
                    }*/
                }
                stage.setScene(new Scene(root, 615, 480));
                stage.setUserData(sessionBean);
                stage.show();
            }catch(Exception e){
                System.err.println("Errore nel go back!");
                e.printStackTrace();

            }
        }catch(InvalidParameterException parameterException){
            System.err.println("Errore nell'accesso: Dati errati!");
            parameterException.fillInStackTrace();
        }
    }
}

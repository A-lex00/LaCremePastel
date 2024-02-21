package com.ispwproject.lecremepastel.controller.GUIController;

import com.ispwproject.lecremepastel.engineeringclasses.singleton.Configurations;
import com.ispwproject.lecremepastel.controller.appcontroller.LoginController;
import com.ispwproject.lecremepastel.engineeringclasses.bean.LoginBean;
import com.ispwproject.lecremepastel.engineeringclasses.bean.SessionBean;
import com.ispwproject.lecremepastel.engineeringclasses.singleton.SessionManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;



public class GUIControllerLoginPage{

    @FXML
    private Button backButton;
    @FXML
    private Button loginButton;

    @FXML
    private TextField authField=new TextField();
    @FXML
    private PasswordField passField=new PasswordField();
    @FXML
    void backHome(ActionEvent backEvent) {
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

    @FXML
    void goMainPage(ActionEvent loginEvent){
        Node node = (Node) loginEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        try{
            String authString = authField.getText();
            String passString = passField.getText();
            LoginBean loginBean = new LoginBean(authString,passString);
            LoginController loginController = new LoginController();
            String sid = loginController.login(loginBean);
            SessionBean sessionBean=SessionManager.getInstance().getSession(sid);
            if(sessionBean != null) {
                if (sessionBean.getUserType() == Integer.parseInt(Configurations.getInstance().getProperty("DIRECTOR"))) {
                    Parent root = FXMLLoader.load(getClass().getResource("/directorFirstPage.fxml"));
                    GUIControllerDirectorFirstPage controller = new GUIControllerDirectorFirstPage();
                    controller.importSession(sessionBean);
                    stage.setScene(new Scene(root, 615, 481));
                    stage.setTitle("La Creme Pastel");
                    stage.show();
                    System.out.println("Login Successful!");
                }
                if ((sessionBean.getUserType() == Integer.parseInt(Configurations.getInstance().getProperty("WORKER")))) {
                    Parent root = FXMLLoader.load(getClass().getResource("/workerFirstPage.fxml"));
                    stage.setScene(new Scene(root, 615, 481));
                    stage.setTitle("La Creme Pastel");
                    stage.show();
                    System.out.println("Login Successful!");
                }
                if ((sessionBean.getUserType() == Integer.parseInt(Configurations.getInstance().getProperty("CUSTOMER")))) {
                    Parent root = FXMLLoader.load(getClass().getResource("/customerFirstPage.fxml"));
                    stage.setScene(new Scene(root, 615, 481));
                    stage.setTitle("La Creme Pastel");
                    stage.show();
                    System.out.println("Login Successful!");
                }
            }else{
                Label label= new Label("Avviso! Errore nell'inserimento dei dati, login non effettuato");
                Scene scene=new Scene(label,350,50);
                Stage poupopStage=new Stage();
                poupopStage.initModality(Modality.APPLICATION_MODAL); //Imposta la modalità per bloccare l'interazione con la finestra principale fino a chiusura poupop
                poupopStage.initOwner(stage);    //imposto il proprietario

                poupopStage.setScene(scene);
                poupopStage.showAndWait(); //aspetto la chiusura del poupop per continuare con i comandi

                System.out.println("Login Failed!");
            }
            }catch(Exception e){
            System.err.println("Errore nell'inserimento dei parametri!");
            e.printStackTrace();
        }
    }
}



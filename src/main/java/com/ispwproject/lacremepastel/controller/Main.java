package com.ispwproject.lacremepastel.controller;

import com.ispwproject.lacremepastel.controller.app.LoginController;
import com.ispwproject.lacremepastel.engineeringclasses.bean.LoginBean;
import com.ispwproject.lacremepastel.engineeringclasses.bean.RegisterBean;
import com.ispwproject.lacremepastel.engineeringclasses.bean.SessionBean;
import com.ispwproject.lacremepastel.engineeringclasses.exception.UserAlreadyExistentException;
import com.ispwproject.lacremepastel.engineeringclasses.exception.UserAlreadyLoggedException;
import com.ispwproject.lacremepastel.engineeringclasses.exception.UuidAlreadyExistent;
import com.ispwproject.lacremepastel.engineeringclasses.singleton.Configurations;
import com.ispwproject.lacremepastel.model.Login;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    public static void main(String[] args){
        //launch(args);

        LoginController loginController = new LoginController();

        try {
            loginController.register(new RegisterBean(
                    "Test",
                    "12345678910",
                    "Password",
                    "FirstName",
                    "LastName",
                    "email@email.it",
                    "DIRECTOR"
            ));
        }catch (UserAlreadyExistentException e){
            System.out.println(e.getMessage());
        }

        try {
            loginController.login(new LoginBean(
                    "tinoC",
                    "1234"
            ));
        }catch (UserAlreadyLoggedException e){
            System.out.println("IP rebound for user");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public  void start(Stage primaryStage) {
        String enableGUI = Configurations.getInstance().getProperty("GUI");
        if (enableGUI.equals("yes")) {
            int count = Integer.parseInt(Configurations.getInstance().getProperty("COUNT"));
            try {
                for (; count > 0; count--) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/firstPage.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    primaryStage.setScene(scene);
                    primaryStage.setTitle("La Creme Pastel");
                    primaryStage.show();
                }
            } catch (Exception e) {
                System.err.println("Error during load of file FXML: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            startCLI();
        }
    }

        public static void startCLI(){
        }
    }

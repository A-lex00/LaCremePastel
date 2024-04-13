package com.ispwproject.lacremepastel.controller;

import com.ispwproject.lacremepastel.controller.cli.CLIControllerFirstPage;
import com.ispwproject.lacremepastel.engineeringclasses.singleton.Configurations;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
    public static void main(String[] args){
        launch(args);
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
            CLIControllerFirstPage cliControllerFirstPage = new CLIControllerFirstPage();
            
        }
    }

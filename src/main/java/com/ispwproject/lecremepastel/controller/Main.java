package com.ispwproject.lecremepastel.controller;

import com.ispwproject.lecremepastel.controller.CLIController.CLContext;
import com.ispwproject.lecremepastel.controller.CLIController.StartSection;
import com.ispwproject.lecremepastel.engineeringclasses.singleton.Configurations;
import com.ispwproject.lecremepastel.other.CLIStrings;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        String enableGUI = Configurations.getInstance().getProperty("GUI");
        //Test area
        //End Test area
        if(enableGUI.equals("yes")) {
            launch(args);
        }else{
            startCLI();
        }
    }

    public static void startCLI(){
        CLContext cli = new CLContext();

        System.out.println(CLIStrings.BYE_MESSAGE);
        System.exit(0);
    }

    public void start(Stage stage){
        int count = Integer.parseInt(Configurations.getInstance().getProperty("COUNT"));
        try{
            for(;count>0;count--){
                Stage primaryStage = new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/firstPage.fxml"));
                Parent root=loader.load();
                Scene scene=new Scene(root);
                primaryStage.setScene(scene);
                primaryStage.setTitle("La Creme Pastel");
                primaryStage.show();
            }
        }catch(Exception le){
                System.err.println("Error during load of file FXML: " + le.getMessage());
                le.printStackTrace();
        }
    }
}


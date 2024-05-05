package com.ispwproject.lacremepastel.controller;

import com.ispwproject.lacremepastel.controller.cli.machine.AbstractCLIStateMachine;
import com.ispwproject.lacremepastel.controller.cli.machine.ConcreteCLI;
import com.ispwproject.lacremepastel.engineeringclasses.exception.InvalidParameterException;
import com.ispwproject.lacremepastel.engineeringclasses.singleton.Configurations;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class Main extends Application {

    public static void main(String[] args){
        //Setup Logger
        Logger logger = Logger.getLogger(Configurations.getInstance().getProperty("LOGGER_NAME"));
        FileHandler fh;
        try {
            logger.setUseParentHandlers(false);
            fh = new FileHandler("file.log");
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);
            logger.info("Test Log File");
        }catch (IOException | SecurityException e){
            e.fillInStackTrace();
        }

        String enableGUI = Configurations.getInstance().getProperty("GUI");
        if (enableGUI.equals("yes")) {
            launch(args);
        } else {
            launchCLI();
        }
    }

    @Override
    public void start(Stage primaryStage) {
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
        }
    }

    public static void launchCLI(){
        AbstractCLIStateMachine cli = new ConcreteCLI();
        Scanner scanner = new Scanner(System.in);
        do{
            try{

                cli.printMessage();
                String read = scanner.nextLine();
                cli.processInput(read);
            }catch (IllegalStateException e){
                Logger.getLogger(Configurations.getInstance().getProperty("LOGGER_NAME")).severe(e.getMessage());
                System.exit(1);
            }catch (InvalidParameterException e){
                System.out.println("Invalid Input\n");
            }
        }while(cli.isRunning());
        System.exit(0);
    }
}

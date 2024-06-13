package com.ispwproject.lacremepastel.controller;

import com.ispwproject.lacremepastel.controller.cli.machine.AbstractCLIStateMachine;
import com.ispwproject.lacremepastel.controller.cli.machine.ConcreteCLI;
import com.ispwproject.lacremepastel.engineeringclasses.dao.StateDAO;
import com.ispwproject.lacremepastel.engineeringclasses.exception.InvalidParameterException;
import com.ispwproject.lacremepastel.engineeringclasses.exception.InvalidSessionException;
import com.ispwproject.lacremepastel.engineeringclasses.singleton.Configurations;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class Main extends Application {

    public static void main(String[] args){
        //Setup Logger
        Logger logger = Logger.getLogger(Configurations.LOGGER_NAME);
        FileHandler fh;
        try {
            logger.setUseParentHandlers(false);
            fh = new FileHandler("file.log", false);
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);
            logger.info("Run Started");
        }catch (IOException | SecurityException e){
            Logger.getLogger(Main.class.getName()).severe("Can't setup Logger! Exiting");
            System.exit(1);
        }
        String enableGUI = Configurations.getInstance().getProperty("GUI");
        if (enableGUI.equals("on")) {
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
                Stage stageCount= new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/firstPage.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                stageCount.setScene(scene);
                stageCount.setTitle("La Creme Pastel");
                stageCount.show();
            }
        } catch (Exception e) {
            Logger.getLogger(Configurations.LOGGER_NAME).severe(e.getMessage());
        }
    }

    public static void launchCLI(){
        AbstractCLIStateMachine cli = new ConcreteCLI(new StateDAO());
        Logger logger = Logger.getLogger(Configurations.LOGGER_NAME);
        do{
            try{
                if(!cli.doAction()){
                    int choose = Integer.parseInt(cli.readInput());
                    cli.changeState(choose);
                }
            }catch(InvalidSessionException e) {
                logger.info(e.getMessage());
                //Qui vorrei forzare il Logout dell'utente senza chiudere il programma
            }catch (IllegalStateException e){
                logger.severe(e.getMessage());
                System.exit(1);
            }catch (NumberFormatException | InvalidParameterException e){
                System.out.println("Invalid Input");
            }catch (NoSuchElementException e){
                logger.info("Stdin closed, exiting");
                System.exit(0);
            }catch (NullPointerException e){
                logger.severe(e.getMessage());
                System.exit(2);
            }
        }while(cli.isRunning());
        System.exit(0);
    }
}

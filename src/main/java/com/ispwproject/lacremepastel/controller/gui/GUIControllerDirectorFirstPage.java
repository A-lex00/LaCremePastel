package com.ispwproject.lacremepastel.controller.gui;

import com.ispwproject.lacremepastel.engineeringclasses.bean.SessionBean;
import com.ispwproject.lacremepastel.other.PoupopManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class GUIControllerDirectorFirstPage  {
    private SessionBean sessionBean = null;
    @FXML
    private Label initialLabel = null;
    
    public GUIControllerDirectorFirstPage(){}

    public void setSessionBean (SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }

        @FXML
        void manageOrder(ActionEvent manageoEvent) {
            Node node=(Node) manageoEvent.getSource();
            Stage stage=(Stage) node.getScene().getWindow();
            try {
                GUIControllerManageOrder guiControllerManagerOrder = new GUIControllerManageOrder();
                guiControllerManagerOrder.setSessionBean(sessionBean);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/manageOrder.fxml"));
                Parent root = loader.getRoot();
                loader.setController(guiControllerManagerOrder);
                if(root == null) {
                    root = FXMLLoader.load(getClass().getResource("/view/manageOrder.fxml"));
                }
                stage.setScene(new Scene(root, 615, 480));
                stage.setTitle("La Creme Pastel");
                stage.show();
            } catch (Exception e) {
                System.err.println("Errore nel caricamento della schermata della gestione degli ordini!" + e.getMessage());
                e.printStackTrace();
            }
        }

        @FXML
        void manageProduct(ActionEvent managepEvent) {
            Node node=(Node) managepEvent.getSource();
            Stage stage=(Stage) node.getScene().getWindow();
            try {
                GUIControllerManageProduct guiControllerManageProduct = new GUIControllerManageProduct();
                guiControllerManageProduct.setSessionBean(sessionBean);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/manageProduct.fxml"));
                Parent root = loader.getRoot();
                loader.setController(guiControllerManageProduct);
                if(root == null) {
                    root = FXMLLoader.load(getClass().getResource("/view/manageProduct.fxml"));
                }
                stage.setScene(new Scene(root, 629, 481));
                stage.setTitle("La Creme Pastel");
                stage.show();
            } catch (Exception e) {
                System.err.println("Errore nel caricamento della schermata dei prodotti!" + e.getMessage());
                e.printStackTrace();
            }
        }
        @FXML
        void manageWorkers(ActionEvent managewEvent) {
            Node node=(Node) managewEvent.getSource();
            Stage stage=(Stage) node.getScene().getWindow();
            try {
                GUIControllerManageWorker guiControllerManageWorker = new GUIControllerManageWorker();
                guiControllerManageWorker.setSessionBean(sessionBean);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/workersList.fxml"));;
                Parent root = loader.getRoot();
                loader.setController(guiControllerManageWorker);
                if(root == null) {
                    root = FXMLLoader.load((getClass().getResource("/view/workersList.fxml")));
                }
                stage.setScene(new Scene(root, 629, 481));
                stage.setTitle("La Creme Pastel");
                stage.show();
            } catch (Exception e) {
                System.err.println("Errore nel caricamento della schermata dei dipendenti!" + e.getMessage());
                e.printStackTrace();
            }
        }

        @FXML
        void requestHelp(ActionEvent helpEvent) {
            Node node=(Node) helpEvent.getSource();
            Stage stage=(Stage) node.getScene().getWindow();
        }

        @FXML
        void showCustomerList(ActionEvent showEvent) {
            Node node=(Node) showEvent.getSource();
            Stage stage=(Stage) node.getScene().getWindow();
            try {
                GUIControllerShowCustomerList guiControllerShowCustomerList = new GUIControllerShowCustomerList();
                guiControllerShowCustomerList.setSessionBean(sessionBean);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/customerList.fxml"));
                loader.setController(guiControllerShowCustomerList);
                Parent root = loader.getRoot();
                if(root == null) {
                    root = FXMLLoader.load((getClass().getResource("/view/customerList.fxml")));
                }
                stage.setScene(new Scene(root, 629, 481));
                stage.setTitle("La Creme Pastel");
                stage.show();
            } catch (Exception e) {
                System.err.println("Errore nel caricamento della schermata utenti!" + e.getMessage());
                e.printStackTrace();
            }
        }
}


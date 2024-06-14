package com.ispwproject.lacremepastel.engineeringclasses.factory;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;

public class PopupFactory {

    public Popup createBasePopup(String message) {
        return createBasePopup(message,"black");
    }

    public Popup createBasePopup(String message, String color){
        Popup popup = new Popup();
        Label label = new Label(message);
        label.setStyle("-fx-text-fill: "+color);
        Button closeButton = new Button("Close");
        closeButton.setOnAction(f -> popup.hide());

        VBox popupContent = new VBox(10);
        popupContent.getChildren().addAll(label, closeButton);
        popupContent.setAlignment(Pos.CENTER);
        popupContent.setPadding(new Insets(10));

        popup.getContent().add(popupContent);
        return popup;
    }
}

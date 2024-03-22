/*package com.ispwproject.le_creme_pastel.engineeringclasses.decorator;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class AdditionalTextField extends com.ispwproject.le_creme_pastel.engineeringclasses.decorator.RegistrationPageDecorator {
    public AdditionalTextField(com.ispwproject.le_creme_pastel.engineeringclasses.decorator.RegistrationPage registrationPage){
        super(registrationPage);
    }

    @Override
    public void checkRole() {
        decoratedRegistrationPage.checkRole();
    }

    @Override
    public void confirm(ActionEvent confirmEvent) {
        decoratedRegistrationPage.confirm(confirmEvent);
    }

    @Override
    public void back(ActionEvent backEvent) {
        decoratedRegistrationPage.back(backEvent);
    }

    @Override
    public TextField addTextField() {
        TextField additionalTextField=decoratedRegistrationPage.addTextField();
        additionalTextField.setLayoutX(108);
        additionalTextField.setLayoutY(347);
        additionalTextField.setPromptText("Aggiungi il campo aggiuntivo!");
        additionalTextField.setId("extraField");
        return null;
    }
}
*/
module Le.Creme.Pastel {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jbcrypt;
    requires org.json;
    requires org.apache.commons.validator;

    opens com.ispwproject.lecremepastel.controller.GUIController to javafx.fxml;
    exports com.ispwproject.lecremepastel.controller;
}
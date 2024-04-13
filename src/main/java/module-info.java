module com.ispwproject.lacremepastel {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires java.sql;
    requires jbcrypt;
    requires org.apache.commons.validator;

    opens com.ispwproject.lacremepastel.model to com.google.gson;

    opens com.ispwproject.lacremepastel.controller.gui to javafx.fxml;
    exports com.ispwproject.lacremepastel.controller.gui to javafx.fxml;
    exports com.ispwproject.lacremepastel.controller to javafx.graphics;
}
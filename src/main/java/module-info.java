module com.ispwproject.lacremepastel {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;
    requires com.google.gson;

    opens com.ispwproject.lacremepastel.model to com.google.gson;

}
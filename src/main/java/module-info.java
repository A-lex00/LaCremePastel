module com.ispwproject.lacremepastel {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires java.sql;
    requires jbcrypt;
    requires org.apache.commons.validator;
    requires org.checkerframework.checker.qual;
    requires org.apache.commons.logging;
    requires org.apache.commons.io;


    exports com.ispwproject.lacremepastel.model;
    opens com.ispwproject.lacremepastel.model to com.google.gson;

    exports com.ispwproject.lacremepastel.other;
    opens com.ispwproject.lacremepastel.other to com.google.gson;

    exports com.ispwproject.lacremepastel.controller.gui;
    opens com.ispwproject.lacremepastel.controller.gui to javafx.fxml;

    exports com.ispwproject.lacremepastel.engineeringclasses.bean;
    opens com.ispwproject.lacremepastel.engineeringclasses.bean to javafx.base;

    exports com.ispwproject.lacremepastel.controller;
    opens com.ispwproject.lacremepastel.controller to javafx.graphics;

}
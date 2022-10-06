module com.login_subsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires mysql.connector.java;
    requires java.sql;
    requires javafx.base;
    requires javafx.graphics;
    requires org.kordamp.ikonli.core;
    requires org.kordamp.ikonli.javafx;
    requires org.controlsfx.controls;
    requires MaterialFX;

    opens com.login_subsystem to javafx.fxml;
    exports com.login_subsystem;
}
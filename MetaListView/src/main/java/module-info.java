module com.metalistview {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.metalistview to javafx.fxml;
    exports com.metalistview;
}
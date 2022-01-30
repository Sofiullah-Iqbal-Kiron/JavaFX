module com.example.helloearth {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.helloearth to javafx.fxml;
    exports com.example.helloearth;
    exports com.example.helloearth.ChangeScene;
    opens com.example.helloearth.ChangeScene to javafx.fxml;
}
module com.example.stagecoach {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.stagecoach to javafx.fxml;
    exports com.example.stagecoach;
}
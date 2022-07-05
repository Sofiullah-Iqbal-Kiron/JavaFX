module com.example.media_training {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.media_training to javafx.fxml;
    exports com.example.media_training;
}
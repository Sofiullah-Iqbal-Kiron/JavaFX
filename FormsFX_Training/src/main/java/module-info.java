module com.example.formsfx_training {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.formsfx_training to javafx.fxml;
    exports com.example.formsfx_training;
}
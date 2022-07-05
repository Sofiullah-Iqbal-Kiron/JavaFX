module com.example.bootstrapfx_training {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.bootstrapfx_training to javafx.fxml;
    exports com.example.bootstrapfx_training;
}
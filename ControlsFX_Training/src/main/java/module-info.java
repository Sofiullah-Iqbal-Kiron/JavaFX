module com.controlsfx_training {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;

    opens com.controlsfx_training to javafx.fxml;
    exports com.controlsfx_training;
}
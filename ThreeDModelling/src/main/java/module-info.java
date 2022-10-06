module com.example.threedmodelling {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens com.threedmodelling to javafx.fxml;
    exports com.threedmodelling;
}
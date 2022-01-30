module com.example.sampleforms {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sampleforms to javafx.fxml;
    exports com.example.sampleforms;
}
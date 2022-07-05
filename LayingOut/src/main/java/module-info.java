module com.example.layingout {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.layingout to javafx.fxml;
    exports com.example.layingout;
}
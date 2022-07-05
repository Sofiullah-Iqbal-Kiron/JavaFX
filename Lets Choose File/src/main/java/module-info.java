module com.example.lets_choose_file {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lets_choose_file to javafx.fxml;
    exports com.example.lets_choose_file;
}
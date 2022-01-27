module com.example.latexpackagesorterandformatter {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.latexpackagesorterandformatter to javafx.fxml;
    exports com.example.latexpackagesorterandformatter;
}
module src.formssample {
    requires javafx.controls;
    requires javafx.fxml;


    opens src.formssample to javafx.fxml;
    exports src.formssample;
}
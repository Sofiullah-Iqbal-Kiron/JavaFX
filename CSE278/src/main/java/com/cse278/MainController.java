package com.cse278;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class MainController {
    //    Database connection.
    private static String connection = "jdbc:mysql://127.0.0.1:3306/";
    private static String user = "root";
    private static String password = "first92992%sqlme8*:";

    //    LaTeX codes.
    private static String basicLatexCode = "\\documentclass[12 pt, letterpaper]{extarticle}\\usepackage[document]{ragged2e}\\usepackage[margin=2.3cm]{geometry}\\usepackage{array,longtable,colortbl,graphicx,extsizes,hyperref,forest}\\newcommand{\\R}{\\textcolor{red}}\\newcommand{\\T}{\\texttt}\\title{\\textcolor{blue}{Bash command line and Git}}\\date{\\today}\\begin{document}\\maketitle\nhello\\end{document}";

    @FXML
    private Button trackYourOrderButton, newOrderButton, doneButton, printButton, backButton;

    @FXML
    private HBox welcomePage;

    @FXML
    private VBox newOrderForm;

    @FXML
    private Text oidValue, dateOfIssueValue, estimatedDeliveryTimeValue;

    @FXML
    private TextField senderName, senderNID, senderPhone, senderMail, receiverName, receiverNID, receiverPhone, receiverMail;

    @FXML
    private TextField fromCountry, fromDivision, fromDistrict, fromThana, fromPostCode, fromOtherDetails, toCountry, toDivision, toDistrict, toThana, toPostCode, toOtherDetails;

    @FXML
    private ComboBox<String> fromCountryComboBox, fromDivisionComboBox, fromDistrictComboBox, fromThanaComboBox,
            toCountryComboBox, toDivisionComboBox, toDistrictComboBox, toThanaComboBox;

    @FXML
    protected void printMemo() {
//        Writing latex codes.
        final File memo = new File("C:\\Users\\Hp\\Documents\\Rich JavaFX\\CSE278\\src\\main\\resources\\com\\cse278\\" + oidValue.getText() + ".tex");
        try {
            memo.createNewFile();
            FileWriter writer = new FileWriter(memo);
            writer.write(basicLatexCode);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        Compiling and generating pdf.
        /*String pdflatexCommand = "pdflatex " + oidValue.getText() + ".tex";
        try {
            Process process = Runtime.getRuntime().exec(new String[]{"cd C:\\Users\\Hp\\Documents\\Rich JavaFX\\CSE278\\src\\main\\resources\\com\\cse278", pdflatexCommand});
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        System.exit(0);*/
    }

    @FXML
    protected void bringNewOrderForm() {
        welcomePage.setVisible(false);

        setoidValue();
        addValuesInCountryComboBox();
        addValuesInDistrictComboBox();
        addValuesInThanaComboBox();
        setDateOfIssueValue();
        setEstimatedDeliveryTime();

        newOrderForm.setVisible(true);
    }

    @FXML
    protected void fromCountrySelected() {
        if (fromCountryComboBox.getSelectionModel().getSelectedItem() == "Bangladesh") {
            addValuesInFromDivisionComboBox();
            fromDivisionComboBox.setDisable(false);
        } else fromDivisionComboBox.setDisable(true);
    }

    @FXML
    protected void fromDivisionComboBoxSelected() {
        String division = fromDivisionComboBox.getSelectionModel().getSelectedItem();
        switch (division) {
            case "Barisal":
                ObservableList<String> districtsInBarisal =
                        FXCollections.observableArrayList("Barisal", "Barguna", "Bhola", "Jhalokati", "Patuakhali", "Pirojpur");
                fromDistrictComboBox.setItems(districtsInBarisal);
                break;
            case "Chittagong":
                ObservableList<String> districtsInChittagong =
                        FXCollections.observableArrayList("Brahmanbaria", "Comilla", "Chandpur", "Lakshmipur", "Noakhali", "Feni", "Khagrachhari", "Rangamati", "Bandarban", "Chittagong", "Cox's Bazar");
                fromDistrictComboBox.setItems(districtsInChittagong);
                break;
            case "Dhaka":
                ObservableList<String> districtsInDhaka =
                        FXCollections.observableArrayList("Dhaka", "Gazipur");
                fromDistrictComboBox.setItems(districtsInDhaka);
                break;
        }
        fromDistrictComboBox.setDisable(false);
        fromDistrictComboBox.getSelectionModel().selectFirst();
        fromDistrictComboBox.setVisibleRowCount(3);
        fromDistrictComboBox.setEditable(true);
        fromDistrictComboBox.setPromptText("Hey prompt here");
    }

    private void setoidValue() {
        Random random = new Random();
        int OID = Math.abs(random.nextInt());
        oidValue.setText(String.valueOf(OID));
    }

    private void addValuesInCountryComboBox() {
//        fromCountryComboBox, toCountryComboBox
        ObservableList<String> country = FXCollections.observableArrayList("Bangladesh", "India");
        fromCountryComboBox.setItems(country);
        toCountryComboBox.setItems(country);
    }

    private void addValuesInFromDivisionComboBox() {
//        fromDivisionComboBox
        ObservableList<String> division = FXCollections.observableArrayList("Barisal", "Chittagong", "Dhaka", "Khulna", "Mymensingh", "Rajshahi", "Rangpur", "Sylhet");
        fromDivisionComboBox.setItems(division);
    }

    private void addValuesInDistrictComboBox() {
//        fromDistrictComboBox, toDistrictComboBox
        ObservableList<String>
                districtsInKhulna = FXCollections.observableArrayList(),
                districtsInMymensingh = FXCollections.observableArrayList(),
                districtsInRajshahi = FXCollections.observableArrayList(),
                districtsInRangpur = FXCollections.observableArrayList(),
                districtsInSylhet = FXCollections.observableArrayList("Habiganj", "Moulvibazar", "Sunamganj", "Sylhet");
    }

    private void addValuesInThanaComboBox() {
//        fromThanaComboBox, toThanaComboBox
    }

    private void setDateOfIssueValue() {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL, yyyy");
        dateOfIssueValue.setText(dateTime.format(formatter) + " at " + dateTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }

    private void setEstimatedDeliveryTime() {
        LocalDateTime dateTime = LocalDateTime.now();
        // Bug: date will extend out 31.
        estimatedDeliveryTimeValue.setText((dateTime.getDayOfMonth() + 3) + " " + dateTime.format(DateTimeFormatter.ofPattern("LLLL")) + "-" + dateTime.getYear());
    }

    @FXML
    protected void backToTheWelcomePage() {
        newOrderForm.setVisible(false);
        welcomePage.setVisible(true);
    }

    @FXML
    protected void doneButtonPressed() throws IOException {
        Stage stage = new Stage();
        Parent root = new FXMLLoader(getClass().getResource("CongratesWindow.fxml")).load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setOnCloseRequest(e -> System.exit(0));
        stage.show();
    }
}
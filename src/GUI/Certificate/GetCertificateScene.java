package GUI.Certificate;

import Database.CertificateRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

// This class creates the get certificate(s) scene

public class GetCertificateScene {

    private static HBox getCertificatePane;
    private static String studentName;
    private static String gender;
    private static int percentage = 0;

    public GetCertificateScene() {
        getCertificatePane = new HBox();
        getCertificatePane.setSpacing(30);

        VBox getPercVbox = new VBox();
        VBox getCertVbox = new VBox();
        getPercVbox.setSpacing(10);
        getCertVbox.setSpacing(10);

        Text getCertStudentText = new Text();
        getCertStudentText.setFont(new Font(15));
        getCertStudentText.setTextAlignment(TextAlignment.JUSTIFY);
        getCertStudentText.setText("Certificates per student");

        Text getCertPercText = new Text();
        getCertPercText.setFont(new Font(15));
        getCertPercText.setTextAlignment(TextAlignment.JUSTIFY);
        getCertPercText.setText("Certificate percentages by gender");

        Text percText = new Text();
        percText.setFont(new Font(18));
        percText.setTextAlignment(TextAlignment.JUSTIFY);
        percText.setText("Percentage: " + percentage + "%         ");

        TextField studentName = new TextField();
        studentName.setPromptText("Student Name");
        studentName.setMaxSize(250, 200);

        ObservableList<String> options = FXCollections.observableArrayList("Male", "Female");
        ComboBox gender = new ComboBox(options);
        gender.setMaxSize(250, 200);
        Button searchStudent = new Button("Search");
        searchStudent.setMaxSize(250, 200);
        Button backFromGetCertificate = new Button("Back");
        backFromGetCertificate.setMaxSize(250, 200);
        Button searchPercentage = new Button("Search");
        searchPercentage.setMaxSize(250, 200);

        getPercVbox.getChildren().addAll(getCertPercText, gender, searchPercentage, percText);
        getCertVbox.getChildren().addAll(getCertStudentText, studentName, searchStudent, backFromGetCertificate);

        getCertificatePane.getChildren().addAll(getPercVbox, getCertVbox);
        getCertificatePane.setAlignment(Pos.CENTER);
        getPercVbox.setAlignment(Pos.CENTER_RIGHT);
        getCertVbox.setAlignment(Pos.CENTER_LEFT);

        backFromGetCertificate.setOnAction((event) -> {
            getCertificatePane.getScene().setRoot(CertificateScene.getCertificatePane());
        });

        searchStudent.setOnAction((event) -> {
            CertificateRepository getCertificate = new CertificateRepository();
            GetCertificateScene.studentName = studentName.getText();
            getCertificate.getCertificate(GetCertificateScene.studentName);
            CertificateStudentListScene certificates = new CertificateStudentListScene();
            getCertificatePane.getScene().setRoot(CertificateStudentListScene.getCertificateStudentPane());
            CertificateRepository list = new CertificateRepository();
            list.getCertificate(GetCertificateScene.studentName);
        });

        searchPercentage.setOnAction((event) -> {
            CertificateRepository getCertificatePerc = new CertificateRepository();
            GetCertificateScene.gender = (String) gender.getValue();
            percentage = getCertificatePerc.getCertificatePercentage(GetCertificateScene.gender);
            percText.setText("Percentage: " + percentage + "%         ");
        });
    }

    //This method gets the Gridpane for navigation to the next/previous scene.
    public static HBox getGetCertificatePane() {
        return getCertificatePane;
    }

    //This method retrieves the student name.
    public static String getStudentName() {
        return studentName;
    }
}

package GUI;

import Database.CertificateRepository;
import Database.RegistrationRepository;
import Domain.Certificate;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class GetCertificateScene {

    private static GridPane GetCertificatePane;
    private static String studentName;
    private static String gender;

    public GetCertificateScene() {
        GetCertificatePane = new GridPane();
        GetCertificatePane.setVgap(8);
        GetCertificatePane.setHgap(10);
        HBox getPercHbox = new HBox();
        HBox getStudentHbox = new HBox();
        getPercHbox.setSpacing(10);
        getStudentHbox.setSpacing(10);

        Text getCertStudentText = new Text();
        getCertStudentText.setFont(new Font(15));
        getCertStudentText.setTextAlignment(TextAlignment.JUSTIFY);
        getCertStudentText.setText("Search certificates per student");

        Text getCertPercText = new Text();
        getCertPercText.setFont(new Font(15));
        getCertPercText.setTextAlignment(TextAlignment.JUSTIFY);
        getCertPercText.setText("View percentages of certificates by gender");

        TextField studentName = new TextField("Student Name");
        TextField gender = new TextField("Gender");
        Button searchStudent = new Button( "Search");
        Button backFromGetCertificate = new Button("Back");
        Button searchPercentage = new Button("Search");

        getStudentHbox.getChildren().addAll(studentName, searchStudent);
        getPercHbox.getChildren().addAll(searchPercentage, backFromGetCertificate);
        GetCertificatePane.add(getCertStudentText, 1, 1);
        GetCertificatePane.add(getStudentHbox, 1, 2);
        GetCertificatePane.add(getCertPercText, 1, 4);
        GetCertificatePane.add(gender, 1, 5);
        GetCertificatePane.add(getPercHbox, 1, 6);

        backFromGetCertificate.setOnAction((event) -> {
            GetCertificatePane.getScene().setRoot(CertificateScene.getCertificatePane());
        });

        searchStudent.setOnAction((event) -> {
            CertificateRepository getCertificate = new CertificateRepository();
            GetCertificateScene.studentName = studentName.getText();
            getCertificate.getCertificate();
            CertificateStudentListScene certificates = new CertificateStudentListScene();
            GetCertificatePane.getScene().setRoot(certificates.getCertificateStudentPane());
            CertificateRepository list = new CertificateRepository();
            list.getCertificate();
        });

        searchPercentage.setOnAction((event) -> {
            CertificateRepository getCertificatePerc = new CertificateRepository();
            GetCertificateScene.gender = gender.getText();
            getCertificatePerc.getCertificatePercentage();
        });
    }

    public static GridPane getGetCertificatePane() {
        return GetCertificatePane;
    }

    public static String getGender() {
        return gender;
    }

    public static String getStudentName() {
        return studentName;
    }
}

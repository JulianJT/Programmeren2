package GUI;

import Database.CertificateRepository;
import Database.StudentRepository;
import Domain.Registration;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class AddCertificateScene {

    private static String userName;
    private static String studentName;
    private static String registration;
    private static int review;


    private static BorderPane AddCertificatePane;

    public AddCertificateScene() {
        AddCertificatePane = new BorderPane();
        VBox addCertVBox = new VBox();

        Text addCertText = new Text();
        addCertText.setFont(new Font(18));
        addCertText.setTextAlignment(TextAlignment.JUSTIFY);
        addCertText.setText("Here you can add certificates to students.");

        Button apply = new Button("Apply");
        Button backFromAddCertificate = new Button("Back");
        TextField studentName = new TextField();
        TextField review = new TextField(); // Has to be [0-10]
        TextField workerName = new TextField();
        TextField registrationName = new TextField();

        Label nameStudentText = new Label("Student Name");
        Label reviewText = new Label("Review [0-10]");
        Label workerNameText = new Label("Username");
        Label registrationText = new Label("Registration");

        GridPane addCertificateInput = new GridPane();
        addCertificateInput.add(workerNameText, 0, 0);
        addCertificateInput.add(workerName, 0, 1);
        addCertificateInput.add(nameStudentText, 1, 0);
        addCertificateInput.add(studentName, 1, 1);
        addCertificateInput.add(registrationText, 0, 2);
        addCertificateInput.add(registrationName, 0, 3);
        addCertificateInput.add(reviewText, 1, 2);
        addCertificateInput.add(review, 1, 3);
        addCertificateInput.add(backFromAddCertificate, 0, 4);
        addCertificateInput.add(apply, 1, 4);

        AddCertificatePane.setLeft(addCertVBox);
        addCertificateInput.setHgap(8);
        addCertificateInput.setVgap(8);
        addCertVBox.setSpacing(10);
        addCertVBox.getChildren().addAll(addCertText, addCertificateInput);

        backFromAddCertificate.setOnAction((event) -> {
            AddCertificatePane.getScene().setRoot(CertificateScene.getCertificatePane());
        });

        CertificateRepository addCertificate = new CertificateRepository();

        apply.setOnAction((event) -> {
            AddCertificateScene.userName = workerName.getText();
            AddCertificateScene.studentName = studentName.getText();
            AddCertificateScene.registration = registrationName.getText();
            AddCertificateScene.review = Integer.parseInt(review.getText());

            addCertificate.addCertificate();
        });
    }

    public static BorderPane getAddCertificatePane() {
        return AddCertificatePane;
    }

    public static String getUserName() {
        return userName;
    }

    public static String getStudentName() {
        return studentName;
    }

    public static String getRegistration() {
        return registration;
    }

    public static int getReview() {
        return review;
    }
}

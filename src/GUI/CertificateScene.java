package GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

class certificateStage extends Application {

    public void start(Stage CertificateStage) throws Exception {
        BorderPane certificateLayout = new BorderPane();
        VBox mainCertVBox = new VBox();
        HBox certButtonHBox = new HBox();
        Scene certificatePage = new Scene(certificateLayout, 500, 300);

        Text certificateText = new Text();
        certificateText.setFont(new Font(30));
        certificateText.setTextAlignment(TextAlignment.JUSTIFY);
        certificateText.setText("Certificate Menu");

        Button addCertificate = new Button("Add Certificate");
        Button getCertificate = new Button("View Certificates");
        Button backFromCertificate = new Button("Back");
        // Add Most Given Certificates (top 3)

        mainCertVBox.setSpacing(10);
        mainCertVBox.getChildren().addAll(certificateText, certButtonHBox, backFromCertificate);
        certButtonHBox.setSpacing(10);
        certButtonHBox.getChildren().addAll(addCertificate, getCertificate);

        certificateLayout.setLeft(mainCertVBox);


        BorderPane getCertificateLayout = new BorderPane();
        VBox getCertVBox = new VBox();
        HBox radioHBox = new HBox();
        HBox buttonHBox = new HBox();
        Scene getCertificatePage = new Scene(getCertificateLayout, 500, 300);

        Text getCertText = new Text();
        getCertText.setFont(new Font(15));
        getCertText.setTextAlignment(TextAlignment.JUSTIFY);
        getCertText.setText("Here you can view the percentages of students that achieved a certificate.");

        RadioButton male = new RadioButton("Male");
        RadioButton female = new RadioButton("Female");
        Button backFromGetCertificate = new Button("Back");
        Button search = new Button("Search");

        getCertificateLayout.setLeft(getCertVBox);

        getCertVBox.setSpacing(10);
        getCertVBox.getChildren().addAll(getCertText, radioHBox, buttonHBox);
        radioHBox.setSpacing(10);
        radioHBox.getChildren().addAll(male, female);
        buttonHBox.setSpacing(10);
        buttonHBox.getChildren().addAll(search, backFromGetCertificate);

        // Implement getting certificates from specific student (name).


        BorderPane addCertificateLayout = new BorderPane();
        VBox addCertVBox = new VBox();
        Scene addCertificatePage = new Scene(addCertificateLayout, 500, 300);

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
        Label workerNameText = new Label("Full Name");
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
        addCertificateLayout.setLeft(addCertVBox);
        addCertificateInput.setHgap(8);
        addCertificateInput.setVgap(8);
        addCertVBox.setSpacing(10);
        addCertVBox.getChildren().addAll(addCertText, addCertificateInput);

        backFromGetCertificate.setOnAction((event) -> {
            CertificateStage.setScene(certificatePage);
        });

        getCertificate.setOnAction((event) -> {
            CertificateStage.setScene(getCertificatePage);
        });

        addCertificate.setOnAction((event) -> {
            CertificateStage.setScene(addCertificatePage);
        });

        backFromAddCertificate.setOnAction((event) -> {
            CertificateStage.setScene(certificatePage);
        });
    }
}
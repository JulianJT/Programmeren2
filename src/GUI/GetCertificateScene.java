package GUI;

import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

class GetCertificateScene {
    private static BorderPane GetCertificatePane;

    public GetCertificateScene() {
        GetCertificatePane = new BorderPane();
        VBox getCertVBox = new VBox();
        HBox radioHBox = new HBox();
        HBox buttonHBox = new HBox();

        Text getCertText = new Text();
        getCertText.setFont(new Font(15));
        getCertText.setTextAlignment(TextAlignment.JUSTIFY);
        getCertText.setText("Here you can view the percentages of students that achieved a certificate.");

        RadioButton male = new RadioButton("Male");
        RadioButton female = new RadioButton("Female");
        Button backFromGetCertificate = new Button("Back");
        Button search = new Button("Search");

        GetCertificatePane.setLeft(getCertVBox);

        getCertVBox.setSpacing(10);
        getCertVBox.getChildren().addAll(getCertText, radioHBox, buttonHBox);
        radioHBox.setSpacing(10);
        radioHBox.getChildren().addAll(male, female);
        buttonHBox.setSpacing(10);
        buttonHBox.getChildren().addAll(search, backFromGetCertificate);

        // Implement getting certificates from specific student (name).

        backFromGetCertificate.setOnAction((event) -> {
            GetCertificatePane.getScene().setRoot(CertificateScene.getCertificatePane());
        });
    }

    public static BorderPane getGetCertificatePane() {
        return GetCertificatePane;
    }
}

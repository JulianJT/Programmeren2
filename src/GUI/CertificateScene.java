package GUI;

import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

class CertificateScene {
    private static GridPane CertificatePane;

    public CertificateScene() {
        CertificatePane = new GridPane();
        CertificatePane.setVgap(8);
        CertificatePane.setHgap(10);
        VBox mainCertVBox = new VBox();
        HBox certButtonHBox = new HBox();

        Text certificateText = new Text();
        certificateText.setFont(new Font(24));
        certificateText.setTextAlignment(TextAlignment.JUSTIFY);
        certificateText.setText("Certificate Menu");

        Button addCertificate = new Button("Add Certificate");
        Button getCertificate = new Button("View Certificates");
        Button backFromCertificate = new Button("Back");
        //TODO: Add Most Given Certificates (top 3)

        mainCertVBox.setSpacing(10);
        mainCertVBox.getChildren().addAll(certificateText, certButtonHBox, backFromCertificate);
        certButtonHBox.setSpacing(10);
        certButtonHBox.getChildren().addAll(addCertificate, getCertificate);

        CertificatePane.add(mainCertVBox,1 ,1);

        getCertificate.setOnAction((event) -> {
            GetCertificateScene getCertificateScene = new GetCertificateScene();
            CertificatePane.getScene().setRoot(getCertificateScene.getGetCertificatePane());
        });

        addCertificate.setOnAction((event) -> {
            AddCertificateScene addCertificateScene = new AddCertificateScene();
            CertificatePane.getScene().setRoot(addCertificateScene.getAddCertificatePane());
        });

        backFromCertificate.setOnAction((event) -> {
            CertificatePane.getScene().setRoot(StartScene.getStartMenu());
        });
    }

    public static GridPane getCertificatePane() {
        return CertificatePane;
    }
}
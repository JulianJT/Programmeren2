package GUI.Certificate;

import GUI.StartScene;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

// This class creates the main certificate scene

public class CertificateScene {
    private static VBox certificatePane;

    public CertificateScene() {
        certificatePane = new VBox();
        certificatePane.setSpacing(10);

        Text certificateText = new Text();
        certificateText.setFont(new Font(30));
        certificateText.setTextAlignment(TextAlignment.JUSTIFY);
        certificateText.setText("Certificate Menu");

        Button addCertificate = new Button("Add Certificate");
        addCertificate.setMaxSize(250, 200);
        Button getCertificate = new Button("View Certificates");
        getCertificate.setMaxSize(250, 200);
        Button backFromCertificate = new Button("Back");
        backFromCertificate.setMaxSize(250, 200);
        //TODO: Add Most Given Certificates (top 3)

        certificatePane.getChildren().addAll(certificateText, addCertificate, getCertificate, backFromCertificate);
        certificatePane.setAlignment(Pos.CENTER);

        getCertificate.setOnAction((event) -> {
            new GetCertificateScene();
            certificatePane.getScene().setRoot(GetCertificateScene.getGetCertificatePane());
        });

        addCertificate.setOnAction((event) -> {
            new AddCertificateScene();
            certificatePane.getScene().setRoot(AddCertificateScene.getAddCertificatePane());
        });

        backFromCertificate.setOnAction((event) -> {
            certificatePane.getScene().setRoot(StartScene.getStartMenu());
        });
    }

    //This method gets the Gridpane for navigation to the next/previous scene.
    public static VBox getCertificatePane() {
        return certificatePane;
    }
}
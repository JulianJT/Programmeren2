package GUI;

import Database.CertificateRepository;
import Domain.Certificate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;

public class CertificateStudentListScene {
    private static GridPane list;
    private static ListView listView;

    public CertificateStudentListScene() {

        list = new GridPane();
        list.setHgap(8);
        Button back = new Button("Back");

        CertificateRepository rglist = new CertificateRepository();

        ObservableList<Certificate> certificates = FXCollections.observableArrayList(rglist.getCertificate(GetCertificateScene.getStudentName()));
        listView = new ListView<>(certificates);
        listView.setPrefWidth(500);

        list.add(listView,0,0);
        list.add(back,0,1);

        back.setOnAction(actionEvent -> {
            list.getScene().setRoot(GetCertificateScene.getGetCertificatePane());
        });
    }

    public static GridPane getCertificateStudentPane() {
        return list ;
    }

}

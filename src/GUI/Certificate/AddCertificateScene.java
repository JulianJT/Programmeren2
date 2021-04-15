package GUI.Certificate;

import Database.CertificateRepository;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class AddCertificateScene {

    private static String userName;
    private static String studentName;
    private static String course;
    private static String review;

    private static GridPane AddCertificatePane;

    public AddCertificateScene() {
        AddCertificatePane = new GridPane();
        AddCertificatePane.setVgap(8);
        AddCertificatePane.setHgap(10);
        VBox addCertVBox = new VBox();

        Text addCertText = new Text();
        addCertText.setFont(new Font(18));
        addCertText.setTextAlignment(TextAlignment.JUSTIFY);
        addCertText.setText("Here you can add certificates to students.");

        Button apply = new Button("Apply");
        Button backFromAddCertificate = new Button("Back");
        TextField studentName = new TextField();
        TextField review = new TextField();
        TextField workerName = new TextField();
        TextField course = new TextField();

        Label nameStudentText = new Label("Student Name");
        Label reviewText = new Label("Review [1-10]");
        Label workerNameText = new Label("Username");
        Label courseText = new Label("Course");

        GridPane addCertificateInput = new GridPane();
        addCertificateInput.add(workerNameText, 0, 0);
        addCertificateInput.add(workerName, 0, 1);
        addCertificateInput.add(nameStudentText, 1, 0);
        addCertificateInput.add(studentName, 1, 1);
        addCertificateInput.add(courseText, 0, 2);
        addCertificateInput.add(course, 0, 3);
        addCertificateInput.add(reviewText, 1, 2);
        addCertificateInput.add(review, 1, 3);
        addCertificateInput.add(backFromAddCertificate, 0, 4);
        addCertificateInput.add(apply, 1, 4);

        AddCertificatePane.add(addCertVBox, 1, 1);
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
            AddCertificateScene.course = course.getText();
            AddCertificateScene.review = review.getText();

            addCertificate.addCertificate(AddCertificateScene.userName, AddCertificateScene.studentName, AddCertificateScene.course, AddCertificateScene.review);
        });
    }

    public static GridPane getAddCertificatePane() {
        return AddCertificatePane;
    }

    public static String getUserName() {
        return userName;
    }

    public static String getStudentName() {
        return studentName;
    }

    public static String getCourse() {
        return course;
    }

    public static String getReview() {
        return review;
    }
}

package GUI;

import GUI.Certificate.CertificateScene;
import GUI.Course.CourseScene;
import GUI.Registration.RegistrationScene;
import GUI.Student.StudentScene;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StartScene extends Application {
    private static HBox root2;
    public static Pane getStartMenu() {
        return root2;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Image image1 = new Image("eo_codecademy_01.jpg");

        ImageView imageView = new ImageView(image1);
        imageView.setFitWidth(200);
        imageView.setFitHeight(100);
        VBox root = new VBox();

        root2 = new HBox();

        root.setSpacing(10);

        Button student = new Button("Students");
        student.setMinWidth(250);
        Button course = new Button("Courses");
        course.setMaxSize(500,200);
        Button registration = new Button("Registrations");
        registration.setMaxSize(500,200);
        Button certificate = new Button("Certificates");
        certificate.setMaxSize(500,200);

        root.getChildren().addAll(imageView, student, course, registration, certificate);

        root2.getChildren().add(root);

        root2.setAlignment(Pos.CENTER);
        root.setAlignment(Pos.CENTER);

        Scene view = new Scene(root2, 500, 300);

        primaryStage.setTitle("Julian Tjintjelaar (2173067) | Sten Reijerse (2175709) | Wesley Snijdelaar (2176710) | Mohamed Haddouch (2177710)");
        primaryStage.setScene(view);
        primaryStage.show();

        student.setOnAction((event) -> {
            StudentScene students = new StudentScene();
            primaryStage.getScene().setRoot(students.getStudentPane());
        });

        registration.setOnAction((event) -> {
            RegistrationScene registrations = new RegistrationScene();
            primaryStage.getScene().setRoot(registrations.getRegistrationPane());
        });

        course.setOnAction((event) -> {
            CourseScene courses = new CourseScene();
            primaryStage.getScene().setRoot(courses.getCoursePane());
        });
        certificate.setOnAction((event) -> {
            CertificateScene certificates = new CertificateScene();
            primaryStage.getScene().setRoot(certificates.getCertificatePane());
        });


    }


}
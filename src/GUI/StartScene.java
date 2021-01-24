package GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class StartScene extends Application {
    private static GridPane getStartPane;

    public static Pane getStartMenu() {
        return getStartPane;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        getStartPane = new GridPane();
        getStartPane.setVgap(8);
        getStartPane.setHgap(10);

        Button student = new Button("Students");
        Button course = new Button("Courses");
        Button registration = new Button("Registrations");
        Button certificate = new Button("Certificates");

        getStartPane.add(student, 1, 1);
        getStartPane.add(course, 1, 2);
        getStartPane.add(registration, 1, 3);
        getStartPane.add(certificate, 1, 4);


        Scene view = new Scene(getStartPane, 500, 300);

        primaryStage.setTitle("Julian Tjintjelaar (2173067) | Sten Reijerse (2175709) | Wesley Snijdelaar (2176710) | Mohamed Haddouch (2177710)");
        primaryStage.setScene(view);
        primaryStage.show();

        student.setOnAction((event) -> {
            StudentScene students = new StudentScene();
            primaryStage.getScene().setRoot(StudentScene.getRootPane());
        });

        registration.setOnAction((event) -> {
            RegistrationScene registrations = new RegistrationScene();
            primaryStage.getScene().setRoot(RegistrationScene.getRegistrationPane());
        });

        course.setOnAction((event) -> {
            CourseScene courses = new CourseScene();
            primaryStage.getScene().setRoot(CourseScene.getCoursePane());
        });
        certificate.setOnAction((event) -> {
            CertificateScene certificates = new CertificateScene();
            primaryStage.getScene().setRoot(CertificateScene.getCertificatePane());
        });


    }


}
package GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class StartScene extends Application {
    private static GridPane getStartPane;


    @Override
    public void start (Stage primaryStage) throws Exception {

        getStartPane = new GridPane();
        getStartPane.setVgap(8);
        getStartPane.setHgap(10);

        Button student = new Button("Students");
        Button course = new Button("Courses");
        Button registration = new Button("Registrations");
        Button certificate = new Button("Certificates");

        getStartPane.add(student,1,1);
        getStartPane.add(course,1,2);
        getStartPane.add(registration,1,3);
        getStartPane.add(certificate,1,4);


        Scene view = new Scene(getStartPane, 500, 300);

        primaryStage.setTitle("CC Statistics");
        primaryStage.setScene(view);
        primaryStage.show();

        student.setOnAction((event) -> {
            StudentScene students = new StudentScene();
            primaryStage.getScene().setRoot(students.getRootPane());
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
    public static Pane getStartMenu() {
        return getStartPane ;
    }


}
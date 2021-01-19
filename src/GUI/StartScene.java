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

        Button student = new Button("Students");
        Button course = new Button("Courses");
        Button registration = new Button("Registrations");
        Button certificate = new Button("Certificates");

        getStartPane.getChildren().add(student);
//        getStartPane.getChildren().add(course);
//        getStartPane.getChildren().add(registration);
//        getStartPane.getChildren().add(certificate);


        Scene view = new Scene(getStartPane, 500, 300);

        primaryStage.setTitle("CC Statistics");
        primaryStage.setScene(view);
        primaryStage.show();

        student.setOnAction((event) -> {
            StudentScene students = new StudentScene();
            primaryStage.getScene().setRoot(students.getRootPane());
        });


    }
    public static Pane getStartMenu() {

        return getStartPane ;
    }


}
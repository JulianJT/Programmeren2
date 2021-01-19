package GUI;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.FileInputStream;

class CourseScene {

    private static GridPane CoursePane ; // or any other kind of pane, or  Group...

    public CourseScene() {

        CoursePane = new GridPane();
        Button addStudents = new Button("Add student(s)");
        Button removeStudents = new Button("Remove Student(s)");
        Button viewStudents = new Button("View Student(s)");
        Button viewProfile = new Button("View profile");

        Button back = new Button("Back");
        CoursePane.add(addStudents, 0, 0);
        CoursePane.add(removeStudents, 0, 1);
        CoursePane.add(viewStudents, 1, 0);
        CoursePane.add(viewProfile, 1, 1);
        CoursePane.add(back, 0, 3);


        back.setOnAction((event) -> {
            CoursePane.getScene().setRoot(StartScene.getStartMenu());
        });

        addStudents.setOnAction((event) -> {
            StudentInputScene input = new StudentInputScene();
            CoursePane.getScene().setRoot(input.getStudentInput());
        });




    }

    public static Pane getCoursePane() {
        return CoursePane ;
    }

}

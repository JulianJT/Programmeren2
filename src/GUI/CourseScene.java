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
        CoursePane.setVgap(8);
        CoursePane.setHgap(10);
        Button addStudents = new Button("Add student(s)");
        Button removeStudents = new Button("Remove Student(s)");
        Button viewStudents = new Button("View Student(s)");
        Button viewProfile = new Button("View profile");

        Button back = new Button("Back");
        CoursePane.add(addStudents, 1, 0);
        CoursePane.add(removeStudents, 1, 1);
        CoursePane.add(viewStudents, 2, 0);
        CoursePane.add(viewProfile, 2, 1);
        CoursePane.add(back, 1, 5);


        back.setOnAction((event) -> {
            CoursePane.getScene().setRoot(StartScene.getStartMenu());
        });



    }

    public static Pane getCoursePane() {
        return CoursePane ;
    }

}

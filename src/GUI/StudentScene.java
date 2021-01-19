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

class StudentScene {

    private static GridPane studentPane ; // or any other kind of pane, or  Group...

    public StudentScene() {

        studentPane = new GridPane();
        Button addStudents = new Button("Add student(s)");
        Button removeStudents = new Button("Remove Student(s)");
        Button viewStudents = new Button("View Student(s)");
        Button viewProfile = new Button("View profile");

        Button back = new Button("Back");
        studentPane.add(addStudents, 0, 0);
        studentPane.add(removeStudents, 0, 1);
        studentPane.add(viewStudents, 1, 0);
        studentPane.add(viewProfile, 1, 1);
        studentPane.add(back, 0, 3);


        back.setOnAction((event) -> {
            studentPane.getScene().setRoot(StartScene.getStartMenu());
        });

        addStudents.setOnAction((event) -> {
            StudentInputScene input = new StudentInputScene();
            studentPane.getScene().setRoot(input.getStudentInput());
        });

        // build UI, register event handlers, etc etc


    }

    public static Pane getRootPane() {
        return studentPane ;
    }

}

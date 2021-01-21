package GUI;


import Database.StudentRepository;
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
        studentPane.setVgap(8);
        studentPane.setHgap(10);
        Button addStudents = new Button("Add student(s)");
        Button removeStudents = new Button("Remove Student(s)");
        Button viewStudents = new Button("View Student(s)");
        Button viewProfile = new Button("View profile");

        Button back = new Button("Back");
        studentPane.add(addStudents, 1, 0);
        studentPane.add(removeStudents, 1, 1);
        studentPane.add(viewStudents, 2, 0);
        studentPane.add(viewProfile, 2, 1);
        studentPane.add(back, 1, 5);


        back.setOnAction((event) -> {
            studentPane.getScene().setRoot(StartScene.getStartMenu());
        });

        addStudents.setOnAction((event) -> {
            StudentInputScene input = new StudentInputScene();
            studentPane.getScene().setRoot(input.getStudentInput());
        });

        viewStudents.setOnAction((event) -> {
            StudentRepository list = new StudentRepository();
            StudentListScene studentTable = new StudentListScene();
            studentPane.getScene().setRoot(studentTable.getStudentTable());
            list.getAllStudents();
        });



    }

    public static Pane getRootPane() {
        return studentPane ;
    }

}

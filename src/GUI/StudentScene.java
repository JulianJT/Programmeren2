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
        VBox mainStVBox = new VBox();
        HBox stButtonHBox = new HBox();

        Text studentText = new Text();
        studentText.setFont(new Font(30));
        studentText.setTextAlignment(TextAlignment.JUSTIFY);
        studentText.setText("Student Menu");

        Button addStudents = new Button("Add student(s)");
        Button removeStudents = new Button("Remove Student(s)");
        Button viewStudents = new Button("View Student(s)");
        Button viewProfile = new Button("View profile");
        Button back = new Button("Back");

        mainStVBox.setSpacing(10);
        mainStVBox.getChildren().addAll(studentText, stButtonHBox, back);

        stButtonHBox.setSpacing(10);
        stButtonHBox.getChildren().addAll(addStudents, removeStudents, viewStudents, viewProfile);

        studentPane.add(mainStVBox,1 ,1);

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

        removeStudents.setOnAction((event) -> {
            StudentRemoveScene remove = new StudentRemoveScene();
            studentPane.getScene().setRoot(remove.getStudentRemovePane());
        });

        viewProfile.setOnAction((event) -> {
            StudentViewScene remove = new StudentViewScene();
            studentPane.getScene().setRoot(remove.getStudentViewPane());
        });


    }

    public static Pane getRootPane() {
        return studentPane ;
    }

}

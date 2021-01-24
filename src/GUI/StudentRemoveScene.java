package GUI;

import Database.StudentRepository;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.sql.*;

import java.sql.Connection;
import java.sql.ResultSet;

public class StudentRemoveScene {

    private static GridPane studentRemovePane;
    private static String studentName;

    public StudentRemoveScene() {
        studentRemovePane = new GridPane();

        Text instruction = new Text("Specify which student you would like to remove(First and lastname)");
        instruction.setFont(new Font(14));
        instruction.setTextAlignment(TextAlignment.JUSTIFY);
        TextField student = new TextField();
        Button back = new Button("Back");
        Button confirm = new Button("OK");

        studentRemovePane.add(instruction, 0,0);
        studentRemovePane.add(student, 0, 1);
        studentRemovePane.add(back, 0,2);
        studentRemovePane.add(confirm, 2,1);

        back.setOnAction((event) -> {

            studentRemovePane.getScene().setRoot(StudentScene.getRootPane());
        });

        StudentRepository repository = new StudentRepository();

        confirm.setOnAction((event) -> {

            studentName = student.getText();

                repository.deleteStudent();

        });

    }

   public static GridPane getStudentRemovePane() {
        return studentRemovePane;
   }

   public String getStudentName() {
        return studentName;
    }

}

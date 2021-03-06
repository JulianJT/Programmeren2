package GUI.Student;


import Database.StudentRepository;
import GUI.StartScene;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

// This class creates the main Student scene.

public class StudentScene {

    private static VBox studentPane;

    public StudentScene() {
        studentPane = new VBox();
        studentPane.setSpacing(10);

        Text studentText = new Text();
        studentText.setFont(new Font(30));
        studentText.setTextAlignment(TextAlignment.JUSTIFY);
        studentText.setText("Student Menu");

        Button addStudents = new Button("Add student(s)");
        addStudents.setMaxSize(250,200);
        Button removeStudents = new Button("Remove student(s)");
        removeStudents.setMaxSize(250,200);
        Button viewStudents = new Button("View student(s)");
        viewStudents.setMaxSize(250,200);
        Button viewProfile = new Button("View profile");
        viewProfile.setMaxSize(250,200);
        Button back = new Button("Back");
        back.setMaxSize(250,200);

        studentPane.getChildren().addAll(studentText, addStudents, removeStudents, viewStudents, viewProfile, back);
        studentPane.setAlignment(Pos.CENTER);

        back.setOnAction((event) -> {
            studentPane.getScene().setRoot(StartScene.getStartMenu());
        });

        addStudents.setOnAction((event) -> {
            new StudentInputScene();
            studentPane.getScene().setRoot(StudentInputScene.getStudentInput());
        });

        viewStudents.setOnAction((event) -> {
            StudentRepository list = new StudentRepository();
            new StudentListScene();
            studentPane.getScene().setRoot(StudentListScene.getStudentTable());
            list.getAllStudents();
        });

        removeStudents.setOnAction((event) -> {
            StudentRemoveScene remove = new StudentRemoveScene();
            studentPane.getScene().setRoot(remove.getStudentRemovePane());
        });

        viewProfile.setOnAction((event) -> {
            StudentViewScene view = new StudentViewScene();
            studentPane.getScene().setRoot(view.getStudentViewPane());
        });
    }

    //This method gets the Gridpane for navigation to the next/previous scene.
    public static VBox getStudentPane() {
        return studentPane;
    }

}

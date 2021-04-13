package GUI;


import Database.StudentRepository;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

class StudentScene {

    private static GridPane studentPane; // or any other kind of pane, or  Group...

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

        studentPane.add(mainStVBox, 1, 1);

        back.setOnAction((event) -> {
            studentPane.getScene().setRoot(StartScene.getStartMenu());
        });

        addStudents.setOnAction((event) -> {
            StudentInputScene input = new StudentInputScene();
            studentPane.getScene().setRoot(StudentInputScene.getStudentInput());
        });

        viewStudents.setOnAction((event) -> {
            StudentRepository list = new StudentRepository();
            StudentListScene studentTable = new StudentListScene();
            studentPane.getScene().setRoot(StudentListScene.getStudentTable());
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
        return studentPane;
    }

}

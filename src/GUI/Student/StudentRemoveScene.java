package GUI.Student;

import Database.StudentRepository;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

// This class creates the Student Remove scene.

public class StudentRemoveScene {

    private final GridPane studentRemovePane;
    private static String studentName;

    public StudentRemoveScene() {
        studentRemovePane = new GridPane();
        studentRemovePane.setAlignment(Pos.CENTER);
        VBox addStRVbox = new VBox();
        studentRemovePane.setVgap(10);
        studentRemovePane.setHgap(8);

        Text instruction = new Text("Specify which student you would like to remove(First and lastname)");
        instruction.setFont(new Font(14));
        instruction.setTextAlignment(TextAlignment.JUSTIFY);
        TextField student = new TextField();
        Button back = new Button("Back");
        back.setMinWidth(100);
        Button confirm = new Button("OK");
        confirm.setMinWidth(100);

        HBox rmvStudent = new HBox();
        rmvStudent.setAlignment(Pos.CENTER);
        rmvStudent.setSpacing(10);
        rmvStudent.getChildren().addAll(back, confirm);


        VBox removeStudent = new VBox();
        removeStudent.setAlignment(Pos.CENTER);
        removeStudent.setSpacing(10);
        removeStudent.getChildren().addAll(instruction, student);

        studentRemovePane.add(addStRVbox,1,1);
        addStRVbox.setSpacing(10);
        addStRVbox.getChildren().addAll(instruction, removeStudent, rmvStudent);


        StudentRepository repository = new StudentRepository();

        confirm.setOnAction((event) -> {
            studentName = student.getText();
                repository.deleteStudent(studentName);
        });

        back.setOnAction((event) -> {
            studentRemovePane.getScene().setRoot(StudentScene.getStudentPane());
        });

    }

    //This method gets the Gridpane for navigation to the next/previous scene.
   public GridPane getStudentRemovePane() {
        return studentRemovePane;
   }

}

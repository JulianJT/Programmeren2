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

// This class creates the Student search scene.

public class StudentViewScene {

    private static String studentName;
    private final GridPane studentViewPane;

    public StudentViewScene() {

        studentViewPane = new GridPane();
        studentViewPane.setAlignment(Pos.CENTER);
        VBox addStVVbox = new VBox();
        addStVVbox.setAlignment(Pos.CENTER);
        studentViewPane.setVgap(10);
        studentViewPane.setHgap(8);

        Text instruction = new Text("Specify whose profile you would like to view(First and lastname)");
        instruction.setFont(new Font(14));
        instruction.setTextAlignment(TextAlignment.JUSTIFY);
        Text studentInfo = new Text("");

        TextField student = new TextField();

        Button back = new Button("Back");
        back.setMinWidth(100);
        Button confirm = new Button("OK");
        confirm.setMinWidth(100);

        HBox viewStudent = new HBox();
        viewStudent.setAlignment(Pos.CENTER);
        viewStudent.setSpacing(10);
        viewStudent.getChildren().addAll(back, confirm);


        VBox vwStudent = new VBox();
        vwStudent.setAlignment(Pos.CENTER);
        vwStudent.setSpacing(10);
        vwStudent.getChildren().addAll(instruction, student);

        studentViewPane.add(addStVVbox, 1, 1);
        addStVVbox.setSpacing(10);
        addStVVbox.getChildren().addAll(instruction, vwStudent, viewStudent, studentInfo);
        StudentRepository repository = new StudentRepository();

        back.setOnAction((event) -> {
                studentViewPane.getScene().setRoot(StudentScene.getStudentPane());
        });


        confirm.setOnAction((event) -> {
            studentName = student.getText();
            studentInfo.setText(repository.viewStudent());
        });

    }

    //This method gets the Gridpane for navigation to the next/previous scene.
    public GridPane getStudentViewPane() {
        return studentViewPane;
    }

    //This method retrieves the studentname from this scene.
    public String getStudentName() {
        return studentName;
    }

}

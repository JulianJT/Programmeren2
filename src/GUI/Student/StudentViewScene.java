package GUI.Student;

import Database.StudentRepository;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class StudentViewScene {

    private static String studentName;
    private final GridPane studentViewPane;

    public StudentViewScene() {

        studentViewPane = new GridPane();
        VBox addStVVbox = new VBox();
        studentViewPane.setVgap(10);
        studentViewPane.setHgap(8);

        Text instruction = new Text("Specify whose profile you would like to view(First and lastname)");
        instruction.setFont(new Font(14));
        instruction.setTextAlignment(TextAlignment.JUSTIFY);
        Text studentInfo = new Text("");

        TextField student = new TextField();

        Button back = new Button("Back");
        Button confirm = new Button("OK");

        GridPane viewStudent = new GridPane();
        viewStudent.add(instruction, 0,0);
        viewStudent.add(student, 0, 1);
        viewStudent.add(back, 0,2);
        viewStudent.add(confirm, 2,1);
        viewStudent.add(studentInfo, 0,3);

        studentViewPane.add(addStVVbox, 1, 1);
        viewStudent.setHgap(8);
        viewStudent.setVgap(8);
        addStVVbox.setSpacing(10);
        addStVVbox.getChildren().addAll(instruction, viewStudent);
        StudentRepository repository = new StudentRepository();

        back.setOnAction((event) -> {
                studentViewPane.getScene().setRoot(StudentScene.getRootPane());
        });


        confirm.setOnAction((event) -> {
            studentName = student.getText();
            studentInfo.setText(repository.viewStudent());
        });

    }

    public GridPane getStudentViewPane() {
        return studentViewPane;
    }
    public String getStudentName() {
        return studentName;
    }

}

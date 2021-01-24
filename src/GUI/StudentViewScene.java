package GUI;

import Database.StudentRepository;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class StudentViewScene {
    private static GridPane studentViewPane;
    private static String studentName;

    public StudentViewScene() {
        StudentRepository repository = new StudentRepository();
        studentViewPane = new GridPane();


        Text instruction = new Text("Specify whose profile you would like to view(First and lastname)");
        instruction.setFont(new Font(14));
        instruction.setTextAlignment(TextAlignment.JUSTIFY);
        Text studentInfo = new Text("");


        TextField student = new TextField();

        Button back = new Button("Back");
        Button confirm = new Button("OK");

        studentViewPane.add(instruction, 0,0);
        studentViewPane.add(student, 0, 1);
        studentViewPane.add(back, 0,2);
        studentViewPane.add(confirm, 2,1);
        studentViewPane.add(studentInfo, 0,3);

        back.setOnAction((event) -> {
            studentInfo.setText("");
            studentViewPane.getScene().setRoot(StudentScene.getRootPane());
        });

        confirm.setOnAction((event) -> {

            studentName = student.getText();

                repository.viewStudent();
                studentInfo.setFont(new Font(12));
                studentInfo.setTextAlignment(TextAlignment.JUSTIFY);
                    studentInfo.setText(repository.getColumnValues());




        });

    }

    public static GridPane getStudentViewPane() {
        return studentViewPane;
    }

    public String getStudentName() {
        return studentName;
    }

}

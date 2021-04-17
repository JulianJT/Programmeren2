package GUI.Student;


import Database.StudentRepository;
import Domain.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;

public class StudentListScene {

    private static GridPane list;

    public StudentListScene() {

        list = new GridPane();
        Button back = new Button("Back");

        StudentRepository stList = new StudentRepository();

        ObservableList<Student> names = FXCollections.observableArrayList(stList.getAllStudents());
        ListView<Student> listView = new ListView<>(names);
        listView.setPrefWidth(500);
        list.add(listView, 0, 0);
        list.add(back, 0, 1);

        back.setOnAction((event) -> {
            list.getScene().setRoot(StudentScene.getStudentPane());
        });
    }

    public static GridPane getStudentTable() {
        return list;
    }

}

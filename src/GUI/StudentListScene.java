package GUI;


import Database.StudentRepository;
import Domain.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;

class StudentListScene {

    private static GridPane list;
    private static ListView listView;

    public StudentListScene(){

        list = new GridPane();
        Button back = new Button("Back");

        StudentRepository stlist = new StudentRepository();

        ObservableList<Student> names = FXCollections.observableArrayList(stlist.getAllStudents());
        listView = new ListView<>(names);
        listView.setPrefWidth(500);

        list.add(listView, 0, 0);
        list.add(back,0,1);

        back.setOnAction((event) -> {
            list.getScene().setRoot(StudentScene.getRootPane());
        });
    }

    public static GridPane getStudentTable() {
        return list;
    }

}

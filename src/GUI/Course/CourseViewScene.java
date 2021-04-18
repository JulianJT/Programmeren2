package GUI.Course;

import Database.CourseRepository;
import Domain.Course;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;

// This class creates the scene where you can view the courses

public class CourseViewScene {

    private static GridPane list;

    public CourseViewScene() {
        list = new GridPane();
        Button back = new Button("Back");

        CourseRepository crList = new CourseRepository();

        ObservableList<Course> courses = FXCollections.observableArrayList(crList.getAllCourses());
        ListView<Course> listview = new ListView<>(courses);
        listview.setPrefWidth(500);

        list.add(listview, 0, 0);
        list.add(back, 0, 1);

        back.setOnAction((event) -> {
            list.getScene().setRoot(CourseScene.getCoursePane());
        });

    }


    //This method gets the list of courses from the database.
    public static GridPane getCourseTable() {
        return list;
    }
}

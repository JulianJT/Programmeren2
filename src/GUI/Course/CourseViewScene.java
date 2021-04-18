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
    private static ListView listview;

    public CourseViewScene(){
        list = new GridPane();
        Button back = new Button("Back");

        CourseRepository crlist = new CourseRepository();

        ObservableList<Course> courses = FXCollections.observableArrayList(crlist.getAllCourses());
        listview = new ListView(courses);
        listview.setPrefWidth(500);

        list.add(listview,0,0);
        list.add(back,0,1);

        back.setOnAction((event) -> {
            list.getScene().setRoot(CourseScene.getCoursePane());
        });

    }


    public static GridPane getCourseTable() {
        return list;
    }
}

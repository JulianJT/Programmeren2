package GUI.Course;


import Database.CourseRepository;
import GUI.StartScene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class CourseScene {

    private static GridPane CoursePane; // or any other kind of pane, or  Group...

    public CourseScene() {

        CoursePane = new GridPane();
        CoursePane.setVgap(8);
        CoursePane.setHgap(10);
        Button addCourses = new Button("Add course(s)");
        Button removeCourses = new Button("Remove course(s)");
        Button viewCourses = new Button("View course(s)");
        Button updateCourses = new Button("Update course(s)");
        Button addModules = new Button("Add module");

        Button back = new Button("Back");
        CoursePane.add(addCourses, 1, 0);
        CoursePane.add(removeCourses, 1, 1);
        CoursePane.add(viewCourses, 2, 0);
        CoursePane.add(updateCourses, 2, 1);
        CoursePane.add(addModules,3,0);
        CoursePane.add(back, 1, 5);


        back.setOnAction((event) -> {
            CoursePane.getScene().setRoot(StartScene.getStartMenu());
        });

        addCourses.setOnAction((event) -> {
            AddCourseScene addCourseScene = new AddCourseScene();
            CoursePane.getScene().setRoot(AddCourseScene.getAddCoursePane());
        });
        viewCourses.setOnAction((event) -> {
            CourseRepository list = new CourseRepository();
            CourseViewScene courseViewScene = new CourseViewScene();
            CoursePane.getScene().setRoot(CourseViewScene.getCourseTable());
        });
        removeCourses.setOnAction((event) -> {
            CourseRemoveScene remove = new CourseRemoveScene();
            CoursePane.getScene().setRoot(remove.getCourseRemovePane());
        });
        addModules.setOnAction((event) -> {
            AddModuleScene addModuleScene = new AddModuleScene();
            addModules.getScene().setRoot(AddModuleScene.getAddModulePane());
        });

    }

    public static GridPane getCoursePane() {
        return CoursePane;
    }

}

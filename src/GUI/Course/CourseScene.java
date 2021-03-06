package GUI.Course;


import Database.CourseRepository;
import GUI.StartScene;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

// This class creates the main course scene

public class CourseScene {

    private static VBox coursePane;

    public CourseScene() {

        coursePane = new VBox();
        coursePane.setSpacing(10);

        Text courseText = new Text();
        courseText.setFont(new Font(30));
        courseText.setTextAlignment(TextAlignment.JUSTIFY);
        courseText.setText("Course Menu");

        Button addCourses = new Button("Add course(s)");
        addCourses.setMaxSize(250, 200);
        Button removeCourses = new Button("Remove course(s)");
        removeCourses.setMaxSize(250, 200);
        Button viewCourses = new Button("View course(s)");
        viewCourses.setMaxSize(250, 200);
        Button updateCourses = new Button("Update course(s)");
        updateCourses.setMaxSize(250, 200);
        Button addModules = new Button("Add module");
        addModules.setMaxSize(250, 200);
        Button back = new Button("Back");
        back.setMaxSize(250, 200);

        coursePane.getChildren().addAll(courseText, addCourses, removeCourses, viewCourses, updateCourses, addModules, back);
        coursePane.setAlignment(Pos.CENTER);

        back.setOnAction((event) -> {
            coursePane.getScene().setRoot(StartScene.getStartMenu());
        });

        addCourses.setOnAction((event) -> {
            new AddCourseScene();
            coursePane.getScene().setRoot(AddCourseScene.getAddCoursePane());
        });
        updateCourses.setOnAction((event) -> {
            new UpdateCourseScene();
            coursePane.getScene().setRoot(UpdateCourseScene.getUpdateCoursePane());
        });
        viewCourses.setOnAction((event) -> {
            new CourseViewScene();
            coursePane.getScene().setRoot(CourseViewScene.getCourseTable());
        });
        removeCourses.setOnAction((event) -> {
            CourseRemoveScene remove = new CourseRemoveScene();
            coursePane.getScene().setRoot(remove.getCourseRemovePane());
        });
        addModules.setOnAction((event) -> {
            new AddModuleScene();
            coursePane.getScene().setRoot(AddModuleScene.getAddModulePane());
        });
    }

    //This method gets the Gridpane for navigation to the next/previous scene.
    public static VBox getCoursePane() {
        return coursePane;
    }

}

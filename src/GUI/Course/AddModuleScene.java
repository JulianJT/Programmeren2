package GUI.Course;

import Database.CourseRepository;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class AddModuleScene {
    private static String title;
    private static String version;
    private static String description;
    private static String contentItemId;
    private static GridPane AddModulePane;

    public AddModuleScene() {
        AddModulePane = new GridPane();
        AddModulePane.setVgap(10);
        AddModulePane.setHgap(10);

        CourseRepository courseRepository = new CourseRepository();
        Button apply = new Button("Apply");
        Button backFromAddModule = new Button("Back");


        TextField title = new TextField();
        TextField version = new TextField();

        Label titleText = new Label("Module title:");
        Label versionText = new Label("Version:");

        GridPane addModuleInput = new GridPane();
        addModuleInput.add(titleText, 0, 0);
        addModuleInput.add(title, 0, 1);
        addModuleInput.add(versionText, 1, 0);
        addModuleInput.add(version, 1, 1);
        addModuleInput.add(backFromAddModule, 0, 7);
        addModuleInput.add(apply, 1, 6);


        AddModulePane.add(addModuleInput, 1, 1);
        addModuleInput.setHgap(8);
        addModuleInput.setVgap(8);

        backFromAddModule.setOnAction((event) -> {
            AddModulePane.getScene().setRoot(CourseScene.getCoursePane());
        });
    }
    public static GridPane getAddModulePane() {
        return AddModulePane;
    }

    public static String getTitle() {
        return title;
    }
    public static String getVersion() {
        return version;
    }
    public static String getContentItemId() {
        return contentItemId;
    }
    public static String getDescription() {
        return description;
    }
}
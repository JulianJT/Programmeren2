package GUI.Course;

import Database.CourseRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

// This class creates the add course scene

public class AddCourseScene {
    private static String userName;
    private static String subjectName;
    private static String intro;
    private static String level;
    private static VBox addCoursePane;

    public AddCourseScene() {
        addCoursePane = new VBox();
        addCoursePane.setAlignment(Pos.CENTER);
        addCoursePane.setSpacing(10);

        Text addCourseText = new Text();
        addCourseText.setFont(new Font(24));
        addCourseText.setTextAlignment(TextAlignment.JUSTIFY);
        addCourseText.setText("Add a course");

        CourseRepository courseRepository = new CourseRepository();
        Button apply = new Button("Apply");
        apply.setMaxSize(250, 200);
        Button backFromAddCourse = new Button("Back");
        backFromAddCourse.setMaxSize(250, 200);

        TextField courseName = new TextField();
        TextField subject = new TextField();
        TextArea introduction = new TextArea();
        introduction.setMaxWidth(150);
        introduction.setMaxHeight(80);
        final ComboBox<String> priorityComboBox = new ComboBox<>();
        priorityComboBox.getItems().addAll(courseRepository.getModules());
        priorityComboBox.setMaxSize(250, 200);
        priorityComboBox.setPromptText("Modules");

        Label nameCourseText = new Label("Course Name:");
        Label subjectText = new Label("Subject:");

        ObservableList<String> options = FXCollections.observableArrayList("Beginner", "Intermediate", "Expert");
        ComboBox<String> levelField = new ComboBox<>(options);
        levelField.setPromptText("Level");
        levelField.setMaxSize(250, 200);

        Label introText = new Label("Introduction:");

        GridPane addCourseInput = new GridPane();
        addCourseInput.setAlignment(Pos.CENTER);
        addCourseInput.add(nameCourseText, 0, 0);
        addCourseInput.add(courseName, 0, 1);
        addCourseInput.add(subjectText, 1, 0);
        addCourseInput.add(subject, 1, 1);
        addCourseInput.add(levelField, 0, 2);
        addCourseInput.add(priorityComboBox, 1, 2);
        addCourseInput.add(introText, 0, 5);
        addCourseInput.add(introduction, 0, 6);
        addCourseInput.add(backFromAddCourse, 0, 7);
        addCourseInput.add(apply, 1, 7);

        addCoursePane.getChildren().addAll(addCourseText, addCourseInput);
        addCourseInput.setHgap(8);
        addCourseInput.setVgap(8);


        backFromAddCourse.setOnAction((event) -> {
            addCoursePane.getScene().setRoot(CourseScene.getCoursePane());
        });

        CourseRepository addCourse = new CourseRepository();
        apply.setOnAction((event) -> {
            AddCourseScene.userName = courseName.getText();
            AddCourseScene.subjectName = subject.getText();
            AddCourseScene.intro = introduction.getText();
            AddCourseScene.level = levelField.getValue();

            addCourse.addCourse();
        });
    }

    //This method gets the VBox for navigation to the next/previous scene.
    public static VBox getAddCoursePane() {
        return addCoursePane;
    }

    //This method retrieves the courseName.
    public static String getCourseName() {
        return userName;
    }

    //This method retrieves the subjectname.
    public static String getSubjectName() {
        return subjectName;
    }

    //This method retrieves the introduction.
    public static String getIntroduction() {
        return intro;
    }

    //This method retrieves the level.
    public static String getLevel() {
        return level;
    }
}

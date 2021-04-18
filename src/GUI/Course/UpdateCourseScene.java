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

// This class creates the update course scene

public class UpdateCourseScene {
    private static String courseNameNew;
    private static String introduction;
    private static String level;
    private static String subject;
    private static String oldCourseName;

    private static VBox updateCoursePane;

    public UpdateCourseScene() {
        updateCoursePane = new VBox();
        updateCoursePane.setAlignment(Pos.CENTER);
        updateCoursePane.setSpacing(10);

        Button update = new Button("Update");
        Button backFromUpdateCourse = new Button("Back");
        backFromUpdateCourse.setMaxSize(200, 200);
        update.setMaxSize(200, 200);

        Text updateCourseText = new Text();
        updateCourseText.setFont(new Font(24));
        updateCourseText.setTextAlignment(TextAlignment.JUSTIFY);
        updateCourseText.setText("Update course");

        TextField courseName = new TextField();
        TextField subjectText = new TextField();
        TextArea introductionText = new TextArea();
        introductionText.setMaxWidth(150);
        introductionText.setMaxHeight(80);

        Label selectCourse = new Label("Old course name");
        TextField oldCourseNames = new TextField();

        Label nameCourseText = new Label("New course name:");
        Label subjectLabel = new Label("Subject:");


        ObservableList<String> options = FXCollections.observableArrayList("Beginner", "Advanced", "Expert");
        ComboBox levelField = new ComboBox(options);
        levelField.setPromptText("Level");
        levelField.setMaxSize(250, 200);
        Label levelText = new Label("Level:");
        Label introText = new Label("Introduction:");

        GridPane updateCourseInput = new GridPane();
        updateCourseInput.setAlignment(Pos.CENTER);
        updateCourseInput.add(nameCourseText, 1, 0);
        updateCourseInput.add(courseName, 1, 1);

        updateCourseInput.add(selectCourse, 0, 0);
        updateCourseInput.add(oldCourseNames, 0, 1);

        updateCourseInput.add(subjectLabel, 1, 2);
        updateCourseInput.add(subjectText, 1, 3);
        updateCourseInput.add(levelText, 0, 2);
        updateCourseInput.add(levelField, 0, 3);

        updateCourseInput.add(introText, 0, 5);
        updateCourseInput.add(introductionText, 0, 6);
        updateCourseInput.add(backFromUpdateCourse, 0, 7);
        updateCourseInput.add(update, 1, 7);

        updateCoursePane.getChildren().addAll(updateCourseText, updateCourseInput);
        updateCourseInput.setHgap(10);
        updateCourseInput.setVgap(10);

        backFromUpdateCourse.setOnAction((event) -> {
            updateCoursePane.getScene().setRoot(CourseScene.getCoursePane());
        });

        CourseRepository updateCourse = new CourseRepository();
        update.setOnAction((event) -> {
            courseNameNew = courseName.getText();
            subject = subjectText.getText();
            introduction = introductionText.getText();
            level = (String) levelField.getValue();
            oldCourseName = oldCourseNames.getText();

            updateCourse.updateCourse();
        });
    }

    //This method gets the VBox for navigation to the next/previous scene.
    public static VBox getUpdateCoursePane() {
        return updateCoursePane;
    }

    //This method retrieves the courseName.
    public static String getCourseName() {
        return courseNameNew;
    }

    //This method retrieves the subjectName.
    public static String getSubjectName() {
        return subject;
    }

    //this method retrieves the introduction.
    public static String getIntroduction() {
        return introduction;
    }

    //This method retrieves the level.
    public static String getLevel() {
        return level;
    }

    //This method retrieves the old courseName.
    public static String getOldCourseName() {
        return oldCourseName;
    }
}
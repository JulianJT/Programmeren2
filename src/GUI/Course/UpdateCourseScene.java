package GUI.Course;

import Database.CourseRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

// This class creates the update course scene

public class UpdateCourseScene {
    private static String courseNameNew;
    private static String introduction;
    private static String level;
    private static String subject;
    private static String oldCourseName;


    private static GridPane UpdateCoursePane;

    public UpdateCourseScene() {
        UpdateCoursePane = new GridPane();
        UpdateCoursePane.setAlignment(Pos.CENTER);
        UpdateCoursePane.setVgap(10);
        UpdateCoursePane.setHgap(10);

        Button update = new Button("Update");
        Button backFromUpdateCourse = new Button("Back");


        TextField courseName = new TextField();
        TextField subjectText = new TextField();
        TextArea introductionText = new TextArea();
        introductionText.setMaxWidth(200);
        introductionText.setMaxHeight(100);


        Label selectCourse = new Label("Name of the course you want to change:");
        TextField oldCourseNames = new TextField();

        Label nameCourseText = new Label("(New) course Name:");
        Label subjectLabel = new Label("Subject:");


        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "Beginner",
                        "Advanced",
                        "Expert"

                );

        ComboBox levelField = new ComboBox(options);
        Label levelText = new Label("Level: ");


        Label introText = new Label("Introduction:");

        GridPane updateCourseInput = new GridPane();
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
        updateCourseInput.add(update, 1, 6);

        UpdateCoursePane.add(updateCourseInput, 1, 1);
        updateCourseInput.setHgap(8);
        updateCourseInput.setVgap(8);

        backFromUpdateCourse.setOnAction((event) -> {
            UpdateCoursePane.getScene().setRoot(CourseScene.getCoursePane());
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

    //This method gets the Gridpane for navigation to the next/previous scene.
    public static GridPane getUpdateCoursePane() {
        return UpdateCoursePane;
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
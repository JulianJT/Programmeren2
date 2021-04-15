package GUI.Course;

import Database.CourseRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class AddCourseScene {
    private static String userName;
    private static String subjectName;
    private static String intro;
    private static String level;
    private static GridPane AddCoursePane;

    public AddCourseScene() {
        AddCoursePane = new GridPane();
        AddCoursePane.setVgap(10);
        AddCoursePane.setHgap(10);


        CourseRepository courseRepository = new CourseRepository();
        Button apply = new Button("Apply");
        Button backFromAddCourse = new Button("Back");

        TextField courseName = new TextField();
        TextField subject = new TextField();
        TextArea introduction = new TextArea();
        introduction.setMaxWidth(200);
        introduction.setMaxHeight(100);
        final ComboBox<String> priorityComboBox = new ComboBox<>();
        priorityComboBox.getItems().addAll(courseRepository.getModules());

        Label nameCourseText = new Label("Course Name:");
        Label subjectText = new Label("Subject:");


        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "Beginner",
                        "Advanced",
                        "Expert"

                );

        ComboBox levelField = new ComboBox(options);
        Label levelText = new Label("Level: ");



        Label introText = new Label("Introduction:");

        GridPane addCourseInput = new GridPane();
        addCourseInput.add(nameCourseText, 0, 0);
        addCourseInput.add(courseName, 0, 1);
        addCourseInput.add(subjectText, 1, 0);
        addCourseInput.add(subject, 1, 1);
        addCourseInput.add(levelText,0,2);
        addCourseInput.add(levelField, 0, 3);
        addCourseInput.add(priorityComboBox,1,4);
        addCourseInput.add(introText, 0, 5);
        addCourseInput.add(introduction, 0, 6);
        addCourseInput.add(backFromAddCourse, 0, 7);
        addCourseInput.add(apply, 1, 6);

        AddCoursePane.add(addCourseInput, 1, 1);
        addCourseInput.setHgap(8);
        addCourseInput.setVgap(8);


        backFromAddCourse.setOnAction((event) -> {
            AddCoursePane.getScene().setRoot(CourseScene.getCoursePane());
        });

        CourseRepository addCourse = new CourseRepository();
        apply.setOnAction((event) -> {
            AddCourseScene.userName = courseName.getText();
            AddCourseScene.subjectName = subject.getText();
            AddCourseScene.intro = introduction.getText();
            AddCourseScene.level = (String) levelField.getValue();

            addCourse.addCourse();
        });
    }

    public static GridPane getAddCoursePane() {
        return AddCoursePane;
    }

    public static String getCourseName() {
        return userName;
    }
    public static String getSubjectName() {
        return subjectName;
    }
    public static String getIntroduction() {
        return intro;
    }
    public static String getLevel() {
        return level;
    }
}

package GUI;
import Database.CertificateRepository;
import Database.CourseRepository;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class AddCourseScene {
    private static String userName;
    private static String subjectName;
    private static String intro;
    private static String level;


    private static GridPane AddCoursePane ;

    public AddCourseScene(){
        AddCoursePane = new GridPane();
        AddCoursePane.setVgap(8);
        AddCoursePane.setHgap(10);



        Button apply = new Button("Apply");
        Button backFromAddCourse = new Button("Back");

        TextField courseName = new TextField();
        TextField subject = new TextField();
        TextField level = new TextField();
        TextArea introduction = new TextArea();


        Label nameCourseText = new Label("Course Name:");
        Label subjectText = new Label("Subject:");
        Label levelIndicationText = new Label("Level:");
        Label introText = new Label("Introduction:");

        GridPane addCourseInput = new GridPane();
        addCourseInput.add(nameCourseText, 0, 0);
        addCourseInput.add(courseName, 0, 1);
        addCourseInput.add(subjectText, 1, 0);
        addCourseInput.add(subject, 1, 1);
        addCourseInput.add(levelIndicationText, 0,2);
        addCourseInput.add(level, 0,3);

        addCourseInput.add(introText, 0, 4);
        addCourseInput.add(introduction, 0, 5);

        addCourseInput.add(backFromAddCourse, 0, 6);
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
            AddCourseScene.level = level.getText();

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

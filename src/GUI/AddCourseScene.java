package GUI;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class AddCourseScene {
    private static GridPane AddCoursePane ;

    public AddCourseScene(){
        AddCoursePane = new GridPane();
        AddCoursePane.setVgap(8);
        AddCoursePane.setHgap(10);



        Button apply = new Button("Apply");
        Button backFromAddCourse = new Button("Back");

        TextField courseName = new TextField();
        TextField subject = new TextField();
        TextArea introduction = new TextArea();
        RadioButton Beginner = new RadioButton("Beginner");
        RadioButton Advanced = new RadioButton("Advanced");
        RadioButton Expert = new RadioButton("Expert");

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
        addCourseInput.add(Beginner, 0, 3);
        addCourseInput.add(Advanced, 0, 4);
        addCourseInput.add(Expert, 0, 5);
        addCourseInput.add(introText, 0, 6);
        addCourseInput.add(introduction, 0, 7);

        addCourseInput.add(backFromAddCourse, 0, 8);
        addCourseInput.add(apply, 1, 8);

        AddCoursePane.add(addCourseInput, 1, 1);
        addCourseInput.setHgap(8);
        addCourseInput.setVgap(8);


        backFromAddCourse.setOnAction((event) -> {
            AddCoursePane.getScene().setRoot(CourseScene.getCoursePane());
        });
    }
    public static GridPane getAddCoursePane() {
        return AddCoursePane;
    }
}

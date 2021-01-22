package GUI;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
        TextField levelIndication = new TextField();
        TextField introduction = new TextField();

        Label nameCourseText = new Label("Course Name:");
        Label subjectText = new Label("Subject:");
        Label levelIndicationText = new Label("Level:");
        Label introText = new Label("Introduction:");

        GridPane addCourseInput = new GridPane();
        addCourseInput.add(nameCourseText, 0, 0);
        addCourseInput.add(courseName, 0, 1);
        addCourseInput.add(subjectText, 1, 0);
        addCourseInput.add(subject, 1, 1);
        addCourseInput.add(backFromAddCourse, 0, 4);
        addCourseInput.add(apply, 1, 4);

       // AddCoursePane.setLeft(addCertVBox);
        addCourseInput.setHgap(8);
        addCourseInput.setVgap(8);
        //addCertVBox.getChildren().addAll(addCertText, addCourseInput);

        backFromAddCourse.setOnAction((event) -> {
            AddCoursePane.getScene().setRoot(CourseScene.getCoursePane());
        });
    }
    public static GridPane getAddCoursePane() {
        return AddCoursePane;
    }
}

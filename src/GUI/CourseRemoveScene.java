package GUI;

import Database.CourseRepository;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;



public class CourseRemoveScene {

    private final GridPane courseRemovePane;
    private static String courseName;

    public CourseRemoveScene(){
        courseRemovePane = new GridPane();
        VBox addCoRVbox = new VBox();
        courseRemovePane.setHgap(8);
        courseRemovePane.setVgap(10);

        Text instruction = new Text("Specify which course you would like to remove(only coursename)");
        instruction.setFont(new Font(14));
        instruction.setTextAlignment(TextAlignment.JUSTIFY);
        TextField course = new TextField();
        Button back = new Button("Back");
        Button confirm = new Button("Ok");

        GridPane removeCourse = new GridPane();
        removeCourse.add(instruction,0,0);
        removeCourse.add(course,0,1);
        removeCourse.add(back, 0,2);
        removeCourse.add(confirm,2,1);

        courseRemovePane.add(addCoRVbox,1,1);
        removeCourse.setVgap(8);
        removeCourse.setHgap(8);
        addCoRVbox.setSpacing(10);
        addCoRVbox.getChildren().addAll(instruction, removeCourse);

        CourseRepository repository = new CourseRepository();

        confirm.setOnAction((event) -> {
            courseName = course.getText();
            repository.deleteCourse();
        });


        back.setOnAction((event) -> {
            courseRemovePane.getScene().setRoot(CourseScene.getCoursePane());
        });

    }
    public GridPane getCourseRemovePane() {
        return courseRemovePane;
    }

    public String getCourseName() {
        return courseName;
    }
}

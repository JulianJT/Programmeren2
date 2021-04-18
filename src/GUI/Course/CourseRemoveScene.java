package GUI.Course;

import Database.CourseRepository;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

// This class creates the course remove scene.

public class CourseRemoveScene {

    private final GridPane courseRemovePane;
    private static String courseName;

    public CourseRemoveScene(){
        courseRemovePane = new GridPane();
        VBox addCoRVbox = new VBox();
        courseRemovePane.setHgap(8);
        courseRemovePane.setVgap(10);

        Text instruction = new Text("Specify which course you would like to remove(only coursename)");
        instruction.setFont(new Font(15));
        instruction.setTextAlignment(TextAlignment.JUSTIFY);
        TextField course = new TextField();
        course.setMaxWidth(300);
        Button confirm = new Button("Ok");
        confirm.setMinWidth(100);
        Button back = new Button("Back");
        back.setMinWidth(100);

        HBox rmvCOurse = new HBox();
        rmvCOurse.setAlignment(Pos.CENTER);
        rmvCOurse.setSpacing(10);
        rmvCOurse.getChildren().addAll(back, confirm);


        VBox removeCourse = new VBox();
        removeCourse.setAlignment(Pos.CENTER);
        removeCourse.setSpacing(10);
        removeCourse.getChildren().addAll(instruction, course);


        courseRemovePane.add(addCoRVbox,1,1);
        courseRemovePane.setAlignment(Pos.CENTER);
        addCoRVbox.setSpacing(10);
        addCoRVbox.getChildren().addAll(instruction, removeCourse, rmvCOurse);


        CourseRepository repository = new CourseRepository();

        confirm.setOnAction((event) -> {
            courseName = course.getText();
            repository.deleteCourse();
        });


        back.setOnAction((event) -> {
            courseRemovePane.getScene().setRoot(CourseScene.getCoursePane());
        });

    }
    //This method gets the Gridpane for navigation to the next/previous scene.
    public GridPane getCourseRemovePane() {
        return courseRemovePane;
    }

    //This method retrieves the courseName.
    public String getCourseName() {
        return courseName;
    }
}

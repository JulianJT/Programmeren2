package GUI;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.FileInputStream;

class CourseScene {

    private static GridPane CoursePane ; // or any other kind of pane, or  Group...

    public CourseScene() {

        CoursePane = new GridPane();
        CoursePane.setVgap(8);
        CoursePane.setHgap(10);
        Button addCourses = new Button("Add course(s)");
        Button removeCourses = new Button("Remove course(s)");
        Button viewCourses = new Button("View course(s)");
        Button updateCourses = new Button("Update course(s)");

        Button back = new Button("Back");
        CoursePane.add(addCourses, 1, 0);
        CoursePane.add(removeCourses, 1, 1);
        CoursePane.add(viewCourses, 2, 0);
        CoursePane.add(updateCourses, 2, 1);
        CoursePane.add(back, 1, 5);


        back.setOnAction((event) -> {
            CoursePane.getScene().setRoot(StartScene.getStartMenu());
        });

        addCourses.setOnAction((event) -> {
            AddCourseScene addCourseScene = new AddCourseScene();
            CoursePane.getScene().setRoot(addCourseScene.getAddCoursePane());
        });


    }

    public static GridPane getCoursePane() {
        return CoursePane ;
    }

}

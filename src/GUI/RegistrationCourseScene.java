package GUI;

import Database.RegistrationRepository;
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

public class RegistrationCourseScene{
    private static GridPane RegistrationCoursePane;

    public RegistrationCourseScene(){
        RegistrationCoursePane = new GridPane();
        RegistrationCoursePane.setVgap(8);
        RegistrationCoursePane.setHgap(10);
        Button showCourses = new Button("Show Courses");
        Button apply = new Button("Apply");


        Button back = new Button("Back");
        RegistrationCoursePane.add(showCourses, 1, 1);
        RegistrationCoursePane.add(apply, 2, 4);

        RegistrationCoursePane.add(back, 1, 6);


        back.setOnAction((event) -> {
            RegistrationCoursePane.getScene().setRoot(RegistrationScene.getRegistrationPane());
        });

        RegistrationRepository showPersons = new RegistrationRepository();

        showCourses.setOnAction((event) -> {



        });

    }

    public static Pane getRegistrationCoursePane() {
        return RegistrationCoursePane ;
    }

}



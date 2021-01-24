package GUI;

import Database.RegistrationRepository;
import Domain.Registration;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private static GridPane list;
    private static ListView listView;

    public RegistrationCourseScene(){

        list = new GridPane();
        list.setHgap(8);
        Button back = new Button("Back");

        RegistrationRepository rgclist = new RegistrationRepository();

        ObservableList<Registration> courses = FXCollections.observableArrayList(rgclist.showCourses());
        listView = new ListView<Registration>(courses);
        listView.setPrefWidth(500);

        list.add(listView,0,0);
        list.add(back,0,1);

        back.setOnAction((event) -> {
            list.getScene().setRoot(RegistrationScene.getRegistrationPane());
        });

    }

    public static Pane getRegistrationCoursePane() {
        return list ;
    }

}



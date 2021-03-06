package GUI.Registration;

import Database.RegistrationRepository;
import Domain.Registration;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

// This class creates the registration course scene.

public class RegistrationCourseScene {
    private static GridPane list;

    public RegistrationCourseScene() {

        list = new GridPane();
        list.setHgap(8);
        Button back = new Button("Back");

        RegistrationRepository rgcList = new RegistrationRepository();

        ObservableList<Registration> courses = FXCollections.observableArrayList(rgcList.showCourses());
        ListView<Registration> listView = new ListView<>(courses);
        listView.setPrefWidth(500);

        list.add(listView, 0, 0);
        list.add(back, 0, 1);

        back.setOnAction((event) -> {
            list.getScene().setRoot(RegistrationScene.getRegistrationPane());
        });

    }

    //This method gets the Gridpane for navigation to the next/previous scene.
    public static Pane getRegistrationCoursePane() {
        return list;
    }

}



package GUI;

import Database.RegistrationRepository;
import Domain.Registration;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

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



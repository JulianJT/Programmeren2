package GUI.Registration;

import Database.RegistrationRepository;
import Domain.Registration;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;

public class RegistrationPersonScene{

    private static GridPane list;
    private static ListView listViewke;

    public RegistrationPersonScene(){

        list = new GridPane();
        list.setHgap(8);
        Button back = new Button("Back");


        RegistrationRepository rglist = new RegistrationRepository();

        ObservableList<Registration> names = FXCollections.observableArrayList(rglist.showStudents());
        listViewke = new ListView<Registration>(names);
        listViewke.setPrefWidth(500);


        list.add(listViewke,0,0);
        list.add(back,0,3);

        back.setOnAction(actionEvent -> {
            list.getScene().setRoot(RegistrationScene.getRegistrationPane());
        });



    }

    public static GridPane getRegistrationPersonPane() {
        return list ;
    }

}



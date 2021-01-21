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

public class RegistrationPersonScene{
    private static GridPane RegistrationPersonPane;

    public RegistrationPersonScene(){

        RegistrationPersonPane = new GridPane();
        RegistrationPersonPane.setVgap(8);
        RegistrationPersonPane.setHgap(10);
        Button showPersons = new Button("Show Persons");
        Button apply = new Button("Apply");
//        Button ... = new Button("...");
//        Button ... = new Button("...");

        Button back = new Button("Back");
        RegistrationPersonPane.add(showPersons, 1, 1);
        RegistrationPersonPane.add(apply, 2, 4);

        RegistrationPersonPane.add(back, 1, 6);


        back.setOnAction((event) -> {
            RegistrationPersonPane.getScene().setRoot(RegistrationScene.getRegistrationPane());
        });




    }

    public static Pane getRegistrationPersonPane() {
        return RegistrationPersonPane ;
    }

}



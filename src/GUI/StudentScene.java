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

class StudentSc {

    private final GridPane rootPane ; // or any other kind of pane, or  Group...

    public StudentSc() {

        rootPane = new GridPane();
        rootPane.add(new Button("test"), 1,2);
        rootPane.add(new Button("test2"), 8,2);
        rootPane.add(new Button("test3"), 1,8);
        rootPane.add(new Button("test4"), 5,2);

        Button back = new Button("Back");
        rootPane.add(back, 1, 0);


        back.setOnAction((event) -> {
            rootPane.getScene().setRoot(StartScene.getStartMenu());
        });

        // build UI, register event handlers, etc etc


    }

    public Pane getRootPane() {
        return rootPane ;
    }

}

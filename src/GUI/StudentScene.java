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

    private final BorderPane rootPane ; // or any other kind of pane, or  Group...

    public StudentSc() {

        rootPane = new BorderPane();

        // build UI, register event handlers, etc etc

    }

    public Pane getRootPane() {
        return rootPane ;
    }

    // other methods you may need to access, etc...

}

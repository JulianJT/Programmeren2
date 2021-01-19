package GUI;


import javafx.scene.control.*;
import javafx.scene.layout.*;

class RegistrationScene {

    private final GridPane RegistrationPane; // or any other kind of pane, or  Group...

    public RegistrationScene() {

        RegistrationPane = new GridPane();
        RegistrationPane.add(new Button("test"), 1,2);
        RegistrationPane.add(new Button("test2"), 8,2);
        RegistrationPane.add(new Button("test3"), 1,8);
        RegistrationPane.add(new Button("test4"), 5,2);

        Button back = new Button("Back");
        RegistrationPane.add(back, 1, 0);


        back.setOnAction((event) -> {
            RegistrationPane.getScene().setRoot(StartScene.getStartMenu());
        });




    }

    public Pane getRegistrationPane() {
        return RegistrationPane;
    }

}

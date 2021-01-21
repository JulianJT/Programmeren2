package GUI;


import javafx.scene.control.*;
import javafx.scene.layout.*;
import Database.RegistrationRepository;

class RegistrationScene {

    private static GridPane RegistrationPane; // or any other kind of pane, or  Group...

    public RegistrationScene() {

        Button viewPersonRegistrations = new Button("Select person");
        Button viewCourseRegistrations = new Button("Select course");
//        Button viewCourseRegistrations = new Button("Select course");
//        Button backFromPersonRegistration = new Button("Back");
        Button backFromRegistration = new Button("Back");

        Label RegistrationText = new Label("Here you can take a look at the registration overview.");

        RegistrationPane = new GridPane();
        RegistrationPane.setVgap(8);
        RegistrationPane.setHgap(10);

        RegistrationPane.add(RegistrationText,1,1);
        RegistrationPane.add(viewPersonRegistrations,1,2);
        RegistrationPane.add(viewCourseRegistrations,1,3);
        RegistrationPane.add(backFromRegistration,1,7);

        RegistrationRepository showStudents = new RegistrationRepository();


        backFromRegistration.setOnAction((event) -> {
            RegistrationPane.getScene().setRoot(StartScene.getStartMenu());
        });

        viewPersonRegistrations.setOnAction((event) -> {
            RegistrationPersonScene persons = new RegistrationPersonScene();
            RegistrationPane.getScene().setRoot(persons.getRegistrationPersonPane());
            RegistrationRepository list = new RegistrationRepository();
            list.showStudents();
        });

        viewCourseRegistrations.setOnAction((event) -> {
            RegistrationCourseScene courses = new RegistrationCourseScene();
            RegistrationPane.getScene().setRoot(courses.getRegistrationCoursePane());
        });


    }

    public static Pane getRegistrationPane() { return RegistrationPane;
    }

}

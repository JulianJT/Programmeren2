package GUI.Registration;


import Database.RegistrationRepository;
import GUI.StartScene;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class RegistrationScene {

    private static VBox registrationPane;

    private static int amount = 0;

    public RegistrationScene() {

        registrationPane = new VBox();
        registrationPane.setSpacing(10);

        Text registrationText = new Text();
        registrationText.setFont(new Font(30));
        registrationText.setTextAlignment(TextAlignment.JUSTIFY);
        registrationText.setText("Registration Menu");

        Button viewPersonRegistrations = new Button("Show persons");
        viewPersonRegistrations.setMaxSize(250,200);
        Button viewCourseRegistrations = new Button("Show courses");
        viewCourseRegistrations.setMaxSize(250,200);
        Button showTotalRegistration = new Button("Show amount of registrations");
        showTotalRegistration.setMaxSize(250,200);
        Button backFromRegistration = new Button("Back");
        backFromRegistration.setMaxSize(250,200);

        registrationPane.getChildren().addAll(registrationText, viewPersonRegistrations, viewCourseRegistrations, showTotalRegistration, backFromRegistration);
        registrationPane.setAlignment(Pos.CENTER);


        backFromRegistration.setOnAction((event) -> {
            registrationPane.getScene().setRoot(StartScene.getStartMenu());
        });

        viewPersonRegistrations.setOnAction((event) -> {
            RegistrationPersonScene persons = new RegistrationPersonScene();
            registrationPane.getScene().setRoot(persons.getRegistrationPersonPane());
            RegistrationRepository list = new RegistrationRepository();
            list.showStudents();
        });

        viewCourseRegistrations.setOnAction((event) -> {
            RegistrationCourseScene courses = new RegistrationCourseScene();
            registrationPane.getScene().setRoot(courses.getRegistrationCoursePane());
        });

        showTotalRegistration.setOnAction((event) -> {
            RegistrationRepository getRegistrationAmount = new RegistrationRepository();
            amount = getRegistrationAmount.getRegistrationAmount();
            showTotalRegistration.setText("Amount of registrations: "+ amount);
        });


    }

    public static VBox getRegistrationPane() {
        return registrationPane;
    }

}

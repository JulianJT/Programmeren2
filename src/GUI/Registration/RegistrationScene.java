package GUI.Registration;


import Database.RegistrationRepository;
import GUI.StartScene;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

// This class generates the main Registration scene

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

        Button viewPersonRegistrations = new Button("Show students");
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
            new RegistrationPersonScene();
            registrationPane.getScene().setRoot(RegistrationPersonScene.getRegistrationPersonPane());
            RegistrationRepository list = new RegistrationRepository();
            list.showStudents();
        });

        viewCourseRegistrations.setOnAction((event) -> {
            new RegistrationCourseScene();
            registrationPane.getScene().setRoot(RegistrationCourseScene.getRegistrationCoursePane());
        });

        showTotalRegistration.setOnAction((event) -> {
            RegistrationRepository getRegistrationAmount = new RegistrationRepository();
            amount = getRegistrationAmount.getRegistrationAmount();
            showTotalRegistration.setText("Amount of registrations: "+ amount);
        });


    }

    //This method gets the Gridpane for navigation to the next/previous scene.
    public static VBox getRegistrationPane() {
        return registrationPane;
    }

}

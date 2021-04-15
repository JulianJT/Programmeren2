package GUI.Registration;


import Database.RegistrationRepository;
import GUI.StartScene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class RegistrationScene {

    private static GridPane RegistrationPane; // or any other kind of pane, or  Group...

    private static int amount = 0;

    public RegistrationScene() {

        RegistrationPane = new GridPane();
        RegistrationPane.setVgap(8);
        RegistrationPane.setHgap(10);
        VBox RegVBox = new VBox();
        HBox RegHBox = new HBox();

        Button viewPersonRegistrations = new Button("Show persons");
        Button viewCourseRegistrations = new Button("Show courses");
        Button showTotalRegistration = new Button("Show");
        Button backFromRegistration = new Button("Back");

        Text amountText = new Text();
        amountText.setText("Amount of registrations: "+ amount);
        Label RegistrationText = new Label("Registration Overview.");
        RegistrationText.setFont(new Font(30));
        RegistrationText.setTextAlignment(TextAlignment.JUSTIFY);

        RegVBox.setSpacing(10);
        RegVBox.getChildren().addAll(RegistrationText, viewPersonRegistrations,
                viewCourseRegistrations, RegHBox, backFromRegistration );

        RegHBox.setSpacing(10);
        RegHBox.getChildren().addAll( showTotalRegistration, amountText);

        RegistrationPane.add(RegVBox,1,1);



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

        showTotalRegistration.setOnAction((event) -> {
            RegistrationRepository getRegistrationAmount = new RegistrationRepository();
            amount = getRegistrationAmount.getRegistrationAmount();
            amountText.setText("Amount of registrations: "+ amount);
        });


    }

    public static Pane getRegistrationPane() {
        return RegistrationPane;
    }

}

package GUI.Course;

import Database.CourseRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// This class creates the add module scene

public class AddModuleScene {
    private static String title;
    private static Integer version;
    private static Integer contentItemId;
    private static String nameOrganization;
    private static String courseName;
    private static Date publicationDate;
    private static String contentStatus;
    private static GridPane AddModulePane;

    private static String description;
    private static String emailAddress;
    private static Integer serialNumber;

    public AddModuleScene() {
        AddModulePane = new GridPane();
        AddModulePane.setVgap(10);
        AddModulePane.setHgap(10);

        Button apply = new Button("Apply");
        Button backFromAddModule = new Button("Back");


        TextField title = new TextField();
        Spinner version = new Spinner(1, 10,1999999999);
        TextField nameOrganization = new TextField();
        Spinner contentItemId = new Spinner(1,10,1999999999);
        TextField courseName = new TextField();
        ObservableList<String> statussen = FXCollections.observableArrayList("Concept", "Active", "Archived");
        ComboBox status = new ComboBox(statussen);
        status.setPrefWidth(150);
        TextArea descriptionField = new TextArea();
        descriptionField.setMaxHeight(75);
        descriptionField.setMaxWidth(150);
        TextField email = new TextField();
        TextField serialNumberText = new TextField();


        Label titleText = new Label("Module title:");
        Label versionText = new Label("Version:");
        Label nameOrganizationText = new Label("Name of the organization:");
        Label contentItemIDText = new Label("Content item ID:");
        Label courseNameText = new Label("Add to which course?");
        Label statusText = new Label("Status:");
        Label descriptionText = new Label("Description:");
        Label emailText = new Label("eMail organization:");
        Label serialNumberField = new Label("SerialNumber:");

        GridPane addModuleInput = new GridPane();
        addModuleInput.add(titleText, 0, 0);
        addModuleInput.add(title, 0, 1);
        addModuleInput.add(versionText, 1, 0);
        addModuleInput.add(version, 1, 1);
        addModuleInput.add(nameOrganizationText,2,0);
        addModuleInput.add(nameOrganization,2,1);
        addModuleInput.add(courseNameText,0,2);
        addModuleInput.add(courseName,0,3);
        addModuleInput.add(contentItemIDText,1,2);
        addModuleInput.add(contentItemId,1,3);
        addModuleInput.add(serialNumberField,2,2);
        addModuleInput.add(serialNumberText,2,3);
        addModuleInput.add(emailText,0,4);
        addModuleInput.add(email,0,5);
        addModuleInput.add(statusText,1,4);
        addModuleInput.add(status,1,5);
        addModuleInput.add(descriptionText,2,4);
        addModuleInput.add(descriptionField,2,5);

        addModuleInput.add(backFromAddModule, 0, 6);
        addModuleInput.add(apply, 1, 6);

        AddModulePane.add(addModuleInput,1,1);
        addModuleInput.setHgap(8);
        addModuleInput.setVgap(8);

        backFromAddModule.setOnAction((event) -> {
            AddModulePane.getScene().setRoot(CourseScene.getCoursePane());
        });

        CourseRepository addModule = new CourseRepository();
        apply.setOnAction((event) -> {
            AddModuleScene.title = title.getText();
            AddModuleScene.version = (Integer) version.getValue();
            AddModuleScene.contentItemId = (Integer) contentItemId.getValue();
            AddModuleScene.nameOrganization = nameOrganization.getText();
            AddModuleScene.courseName = courseName.getText();
            AddModuleScene.contentStatus = (String) status.getValue();
            AddModuleScene.description = descriptionField.getText();
            AddModuleScene.emailAddress = email.getText();
            AddModuleScene.serialNumber = Integer.valueOf(serialNumberText.getText());

            try {

                 publicationDate = java.sql.Date.valueOf(LocalDate.now());

            } catch (NullPointerException e){

                System.out.println("Invalid date.");

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Oh no, an Error occurred!");
                alert.setContentText("Date is invalid.");
                alert.showAndWait();

                return;

            }

            addModule.addModule();
        });
    }


    public static GridPane getAddModulePane() {
        return AddModulePane;
    }

    public static String getTitle() {
        return title;
    }
    public static Integer getVersion() {
        return version;
    }
    public static Integer getContentItemId() {
        return contentItemId;
    }
    public static String getNameOrganization() {
        return nameOrganization;
    }
    public static String getCourseName() {
        return courseName;
    }
    public static Date getPublicationDate() {
        return publicationDate;
    }
    public static String getContentStatus() {
        return contentStatus;
    }
    public static String getEmailAddress() {
        return emailAddress;
    }
    public static String getDescription() {
        return description;
    }
    public static Integer getSerialNumber() {
        return serialNumber;
    }


}
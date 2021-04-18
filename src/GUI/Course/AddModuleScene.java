package GUI.Course;

import Database.CourseRepository;
import Database.InputCheck;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.sql.Date;
import java.time.LocalDate;

// This class creates the add module scene

public class AddModuleScene {
    private static String title;
    private static Integer version;
    private static Integer contentItemId;
    private static String nameOrganization;
    private static String courseName;
    private static Date publicationDate;
    private static String contentStatus;
    private static VBox addModulePane;

    private static String description;
    private static String emailAddress;
    private static Integer serialNumber;

    public AddModuleScene() {
        addModulePane = new VBox();
        addModulePane.setAlignment(Pos.CENTER);
        addModulePane.setSpacing(10);

        Button apply = new Button("Apply");
        Button backFromAddModule = new Button("Back");
        apply.setMaxSize(200, 200);
        backFromAddModule.setMaxSize(200, 200);

        Text addModuleText = new Text();
        addModuleText.setFont(new Font(24));
        addModuleText.setTextAlignment(TextAlignment.JUSTIFY);
        addModuleText.setText("Add a module");

        TextField title = new TextField();
        Spinner<Integer> version = new Spinner<>(1, 10, 1999999999);
        TextField nameOrganization = new TextField();
        Spinner<Integer> contentItemId = new Spinner<>(1, 10, 1999999999);
        TextField courseName = new TextField();
        ObservableList<String> statuses = FXCollections.observableArrayList("Concept", "Active", "Archived");
        ComboBox<String> status = new ComboBox<>(statuses);
        status.setPromptText("Status");
        status.setPrefWidth(150);
        TextArea descriptionField = new TextArea();
        descriptionField.setMaxHeight(40);
        descriptionField.setMaxWidth(150);
        TextField email = new TextField();
        TextField serialNumberText = new TextField();

        Label titleText = new Label("Module title:");
        Label versionText = new Label("Version:");
        Label nameOrganizationText = new Label("Name of the organization:");
        Label contentItemIDText = new Label("Content Item ID:");
        Label courseNameText = new Label("Add to which course?");
        Label statusText = new Label("Status:");
        Label descriptionText = new Label("Description:");
        Label emailText = new Label("Email organization:");
        Label serialNumberField = new Label("SerialNumber:");

        GridPane addModuleInput = new GridPane();
        addModuleInput.setAlignment(Pos.CENTER);
        addModuleInput.add(titleText, 0, 0);
        addModuleInput.add(title, 0, 1);
        addModuleInput.add(versionText, 1, 0);
        addModuleInput.add(version, 1, 1);
        addModuleInput.add(nameOrganizationText, 2, 0);
        addModuleInput.add(nameOrganization, 2, 1);
        addModuleInput.add(courseNameText, 0, 2);
        addModuleInput.add(courseName, 0, 3);
        addModuleInput.add(contentItemIDText, 1, 2);
        addModuleInput.add(contentItemId, 1, 3);
        addModuleInput.add(serialNumberField, 2, 2);
        addModuleInput.add(serialNumberText, 2, 3);
        addModuleInput.add(emailText, 0, 4);
        addModuleInput.add(email, 0, 5);
        addModuleInput.add(statusText, 1, 4);
        addModuleInput.add(status, 1, 5);
        addModuleInput.add(descriptionText, 2, 4);
        addModuleInput.add(descriptionField, 2, 5);

        addModuleInput.add(backFromAddModule, 0, 6);
        addModuleInput.add(apply, 1, 6);

        addModulePane.getChildren().addAll(addModuleText, addModuleInput);
        addModuleInput.setHgap(8);
        addModuleInput.setVgap(8);

        backFromAddModule.setOnAction((event) -> {
            addModulePane.getScene().setRoot(CourseScene.getCoursePane());
        });

        CourseRepository addModule = new CourseRepository();
        apply.setOnAction((event) -> {
            AddModuleScene.title = title.getText();
            AddModuleScene.version = version.getValue();
            AddModuleScene.contentItemId = contentItemId.getValue();
            AddModuleScene.nameOrganization = nameOrganization.getText();
            AddModuleScene.courseName = courseName.getText();
            AddModuleScene.contentStatus = status.getValue();
            AddModuleScene.description = descriptionField.getText();
            AddModuleScene.emailAddress = email.getText();

            if (InputCheck.isInteger(serialNumberText.getText()))
                AddModuleScene.serialNumber = Integer.valueOf(serialNumberText.getText());
            else {
                InputCheck.showAlert("Failed to parse serialnumber");
                return;
            }

            try {

                publicationDate = java.sql.Date.valueOf(LocalDate.now());

            } catch (NullPointerException e) {
                InputCheck.showAlert("Date is invalid.");
                return;
            }
            addModule.addModule();
        });
    }


    //This method gets the VBox for navigation to the next/previous scene.
    public static VBox getAddModulePane() {
        return addModulePane;
    }

    //This method retrieves the title.
    public static String getTitle() {
        return title;
    }

    //This method retrieves the version.
    public static Integer getVersion() {
        return version;
    }

    //This method retrieves the contentItemId.
    public static Integer getContentItemId() {
        return contentItemId;
    }

    //This method retrieves the name of the organization.
    public static String getNameOrganization() {
        return nameOrganization;
    }

    //This method retrieves the courseName.
    public static String getCourseName() {
        return courseName;
    }

    //This method retrieves the publication date.
    public static Date getPublicationDate() {
        return publicationDate;
    }

    //This method retrieves the content status.
    public static String getContentStatus() {
        return contentStatus;
    }

    //This method retrieves the emailaddress.
    public static String getEmailAddress() {
        return emailAddress;
    }

    //This method retrieves the description.
    public static String getDescription() {
        return description;
    }

    //This method retrieves the serialnumber.
    public static Integer getSerialNumber() {
        return serialNumber;
    }


}
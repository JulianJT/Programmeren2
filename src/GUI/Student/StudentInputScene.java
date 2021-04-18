package GUI.Student;

import Database.StudentRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.util.Date;

// This class creates the add student scene.

public class StudentInputScene {
    private static String userName;
    private static String email;
    private static Date birthday;
    private static String gender;
    private static String address;
    private static String residence;
    private static String country;
    private static String zipcode;

    private static GridPane studentInputPane;

    public StudentInputScene() {

        studentInputPane = new GridPane();
        studentInputPane.setAlignment(Pos.CENTER);
        VBox addStVBox = new VBox();
        studentInputPane.setHgap(8);
        studentInputPane.setVgap(10);

        Text addStudentText = new Text();
        addStudentText.setFont(new Font(24));
        addStudentText.setTextAlignment(TextAlignment.JUSTIFY);
        addStudentText.setText("Add a student");

        TextField emailField = new TextField();
        TextField fullName = new TextField();
        DatePicker datePicker = new DatePicker();
        ObservableList<String> options = FXCollections.observableArrayList("Male", "Female");
        ComboBox<String> genderField = new ComboBox<>(options);
        genderField.setMaxSize(250, 200);
        genderField.setPromptText("Gender");
        TextField addressField = new TextField();
        TextField residenceField = new TextField();
        TextField countryField = new TextField();
        TextField zipCodeField = new TextField();


        Label emailText = new Label("E-mail Address");
        Label nameText = new Label("Full name");
        Label birthdayText = new Label("Date of birth");
        Label genderText = new Label("Gender");
        Label addressText = new Label("Address");
        Label residenceText = new Label("Residence");
        Label countryText = new Label("Country");
        Label zipCodeText = new Label("Zipcode");
        Button back = new Button("Back");
        back.setMaxSize(250, 200);
        Button apply = new Button("Apply");
        apply.setMaxSize(250, 200);

        GridPane addStudentInput = new GridPane();
        addStudentInput.add(emailText, 0, 0);
        addStudentInput.add(emailField, 0, 1);
        addStudentInput.add(nameText, 0, 2);
        addStudentInput.add(fullName, 0, 3);
        addStudentInput.add(birthdayText, 0, 4);
        addStudentInput.add(datePicker, 0, 5);
        addStudentInput.add(genderText, 0, 6);
        addStudentInput.add(genderField, 0, 7);
        addStudentInput.add(addressText, 1, 0);
        addStudentInput.add(addressField, 1, 1);
        addStudentInput.add(residenceText, 1, 2);
        addStudentInput.add(residenceField, 1, 3);
        addStudentInput.add(countryText, 1, 4);
        addStudentInput.add(countryField, 1, 5);
        addStudentInput.add(zipCodeText, 1 , 6);
        addStudentInput.add(zipCodeField, 1, 7);
        addStudentInput.add(back, 0, 8);
        addStudentInput.add(apply, 1, 8);

        studentInputPane.add(addStVBox,1,1);
        addStudentInput.setHgap(8);
        addStudentInput.setVgap(8);
        addStVBox.setSpacing(10);
        addStVBox.getChildren().addAll(addStudentText, addStudentInput);

        addStVBox.setAlignment(Pos.CENTER);

        back.setOnAction((event) -> {
            studentInputPane.getScene().setRoot(StudentScene.getStudentPane());
        });

        StudentRepository addstudent = new StudentRepository();

        apply.setOnAction((event) -> {

            try {

                birthday = java.sql.Date.valueOf(datePicker.getValue());
  
            } catch (NullPointerException e){

                System.out.println("Birthday is empty");

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Oh no, an Error occurred!");
                alert.setContentText("Birthday is empty.");
                alert.showAndWait();

                return;

            }

            zipcode = zipCodeField.getText();
            userName = fullName.getText();
            email = emailField.getText();
            gender = genderField.getValue();
            address = addressField.getText();
            residence = residenceField.getText();
            country = countryField.getText();

            addstudent.addStudent(userName, email, birthday, gender, address, residence, country, zipcode);
        });
    }

    //This method gets the Gridpane for navigation to the next/previous scene.
    public static GridPane getStudentInput() {
        return studentInputPane ;
    }
}

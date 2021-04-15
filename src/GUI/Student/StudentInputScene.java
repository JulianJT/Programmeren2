package GUI.Student;

import Database.StudentRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.util.Date;

public class StudentInputScene {
    private static String userName;
    private static String email;
    private static Date birthday;
    private static String gender;
    private static String address;
    private static String residence;
    private static String country;

    private static GridPane studentInputPane;

    public StudentInputScene() {

        studentInputPane = new GridPane();
        VBox addStVBox = new VBox();
        studentInputPane.setHgap(8);
        studentInputPane.setVgap(10);

        Text addStudentText = new Text();
        addStudentText.setFont(new Font(18));
        addStudentText.setTextAlignment(TextAlignment.JUSTIFY);
        addStudentText.setText("Here you can add a student to the database.");

        TextField emailField = new TextField();
        TextField fullName = new TextField();
        DatePicker datePicker = new DatePicker();
        ObservableList<String> options = FXCollections.observableArrayList("Male", "Female");
        ComboBox genderField = new ComboBox(options);
        TextField addressField = new TextField();
        TextField residenceField = new TextField();
        TextField countryField = new TextField();

        Label emailText = new Label("E-mail Address");
        Label nameText = new Label("Full name");
        Label birthdayText = new Label("Date of birth");
        Label genderText = new Label("Gender");
        Label addressText = new Label("Address");
        Label residenceText = new Label("Residence");
        Label countryText = new Label("Country");
        Button back = new Button("Back");
        Button apply = new Button("Apply");

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
        addStudentInput.add(back, 0, 8);
        addStudentInput.add(apply, 1, 8);

        studentInputPane.add(addStVBox,1,1);
        addStudentInput.setHgap(8);
        addStudentInput.setVgap(8);
        addStVBox.setSpacing(10);
        addStVBox.getChildren().addAll(addStudentText, addStudentInput);


        back.setOnAction((event) -> {
            studentInputPane.getScene().setRoot(StudentScene.getRootPane());
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
            userName = fullName.getText();
            email = emailField.getText();
            gender = (String) genderField.getValue();
            address = addressField.getText();
            residence = residenceField.getText();
            country = countryField.getText();

            addstudent.addStudent(userName, email, birthday, gender, address, residence, country);
        });
    }

    public static String getUsername(){
        return userName;
    }
    public static String getEmail(){
        return email;
    }
    public static String getGender(){
        return gender;
    }
    public static String getAddress(){
        return address;
    }
    public static String getResidence(){
        return residence;
    }
    public static String getCountry(){
        return country;
    }
    public static Date getBirthday() {
        return birthday;
    }
    public static GridPane getStudentInput() {
        return studentInputPane ;
    }
}
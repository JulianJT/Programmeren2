package GUI;

import Database.StudentRepository;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.sql.*;

import java.sql.Connection;
import java.sql.ResultSet;

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

        TextField emailField = new TextField();
        TextField fullName = new TextField();
        DatePicker datePicker = new DatePicker();
        TextField genderField = new TextField();
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
        Button cancel = new Button("Cancel");

        studentInputPane.add(emailText, 0, 0);
        studentInputPane.add(emailField, 0, 1);
        studentInputPane.add(nameText, 0, 2);
        studentInputPane.add(fullName, 0, 3);
        studentInputPane.add(birthdayText, 0, 4);
        studentInputPane.add(datePicker, 0, 5);
        studentInputPane.add(genderText, 0, 6);
        studentInputPane.add(genderField, 0, 7);
        studentInputPane.add(addressText, 1, 0);
        studentInputPane.add(addressField, 1, 1);
        studentInputPane.add(residenceText, 1, 2);
        studentInputPane.add(residenceField, 1, 3);
        studentInputPane.add(countryText, 1, 4);
        studentInputPane.add(countryField, 1, 5);
        studentInputPane.add(back, 0, 8);
        studentInputPane.add(apply, 1, 8);
        studentInputPane.add(cancel, 2, 8);


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
            gender = genderField.getText();
            address = addressField.getText();
            residence = residenceField.getText();
            country = countryField.getText();

            addstudent.addStudent();


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

package GUI;

import Database.StudentRepository;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.sql.*;

import java.sql.Connection;
import java.sql.ResultSet;

import java.util.Date;

public class StudentInputScene {
    public String userName;
    public String email;
    public Date birthday;
    public String gender;
    public String address;
    public String residence;
    public String country;

    private static GridPane studentInputPane;

    public StudentInputScene() {

        studentInputPane = new GridPane();

        TextField email = new TextField();
        TextField fullName = new TextField();
        DatePicker datePicker = new DatePicker();
        TextField gender = new TextField();
        TextField address = new TextField();
        TextField residence = new TextField();
        TextField country = new TextField();
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
        studentInputPane.add(email, 0, 1);
        studentInputPane.add(nameText, 0, 2);
        studentInputPane.add(fullName, 0, 3);
        studentInputPane.add(birthdayText, 0, 4);
        studentInputPane.add(datePicker, 0, 5);
        studentInputPane.add(genderText, 0, 6);
        studentInputPane.add(gender, 0, 7);
        studentInputPane.add(addressText, 1, 0);
        studentInputPane.add(address, 1, 1);
        studentInputPane.add(residenceText, 1, 2);
        studentInputPane.add(residence, 1, 3);
        studentInputPane.add(countryText, 1, 4);
        studentInputPane.add(country, 1, 5);
        studentInputPane.add(back, 0, 8);
        studentInputPane.add(apply, 1, 8);
        studentInputPane.add(cancel, 2, 8);


        back.setOnAction((event) -> {
            studentInputPane.getScene().setRoot(StudentScene.getRootPane());
        });

        StudentRepository addstudent = new StudentRepository();


        apply.setOnAction((event) -> {
            userName = fullName.getText();
            this.email = email.getText();
            this.gender = gender.getText();
            this.address = address.getText();
            this.residence = residence.getText();
            this.country = country.getText();
            addstudent.addStudent();


        });

    }
    public String getUsername(){
        return userName;
    }
    public String getEmail(){
        return email;
    }
    public String getGender(){
        return gender;
    }
    public String getAddress(){
        return address;
    }

    public String getResidence(){
        return residence;
    }
    public String getCountry(){
        return country;
    }

    public Date getBirthday() {
        return birthday;
    }


    public static GridPane getStudentInput() {
        return studentInputPane ;
    }
}

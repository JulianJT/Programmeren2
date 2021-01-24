package Database;

import GUI.StudentInputScene;
import javafx.scene.control.Alert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentInputCheck {
    String userName = StudentInputScene.getUsername();
    String email = StudentInputScene.getEmail();
    String gender = StudentInputScene.getGender();
    String address = StudentInputScene.getAddress();
    String residence = StudentInputScene.getResidence();
    String country = StudentInputScene.getCountry();

    public boolean checkInput() {

        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(email);
        System.out.println(email + " : " + matcher.matches());

        if (!(matcher.matches())) {

            System.out.println("Invalid email error occurred!");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Oh no, an Error occurred!");
            alert.setContentText("Invalid email specified.");

            alert.showAndWait();
            return false;
        }

        if (!(gender.equalsIgnoreCase("Male") || gender.equalsIgnoreCase("Female"))) {

            System.out.println("Invalid gender error occurred!");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Oh no, an Error occurred!");
            alert.setContentText("Invalid gender specified.");

            alert.showAndWait();
            return false;
        }

        if (userName.isEmpty()) {
            System.out.println("Username was empty");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Oh no, an Error occurred!");
            alert.setContentText("Name is empty");

            alert.showAndWait();
            return false;
        }

        if (email.isEmpty()) {
            System.out.println("Email was empty");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Oh no, an Error occurred!");
            alert.setContentText("Email is empty");

            alert.showAndWait();
            return false;
        }

        if (address.isEmpty()) {
            System.out.println("Address was empty!");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Oh no, an Error occurred!");
            alert.setContentText("Address is empty");

            alert.showAndWait();
            return false;
        }

        if (residence.isEmpty()) {
            System.out.println("Residence was empty!");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Oh no, an Error occurred!");
            alert.setContentText("Residence is empty");

            alert.showAndWait();
            return false;
        }

        if (country.isEmpty()) {
            System.out.println("Country was empty!");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Oh no, an Error occurred!");
            alert.setContentText("Country is empty");

            alert.showAndWait();
            return false;
        }

        return false;

    }


}

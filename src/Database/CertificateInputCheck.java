package Database;

import GUI.AddCertificateScene;
import GUI.GetCertificateScene;
import javafx.scene.control.Alert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CertificateInputCheck {

    String review = AddCertificateScene.getReview();
    String studentName = AddCertificateScene.getStudentName();
    String workerName = AddCertificateScene.getUserName();
    String regEmail = AddCertificateScene.getRegistration();

    public boolean addCheckInput() {

        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(regEmail);
        System.out.println(regEmail + " : " + matcher.matches());

        if (regEmail.isEmpty()) {
            System.out.println("Email was empty");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Oh no, an Error occurred!");
            alert.setContentText("Email is empty");

            alert.showAndWait();
            return true;
        }
        if (studentName.isEmpty()) {
            System.out.println("Studentname was empty");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Oh no, an Error occurred!");
            alert.setContentText("Studentname is empty");

            alert.showAndWait();
            return true;
        }
        if (workerName.isEmpty()) {
            System.out.println("Username was empty");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Oh no, an Error occurred!");
            alert.setContentText("Username is empty");

            alert.showAndWait();
            return true;
        }
        if (!isInteger(review)) {
            System.out.println("Review could not be converted to a number!");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Oh no, an Error occurred!");
            alert.setContentText("Review is not a number");

            alert.showAndWait();
            return true;
        }
        if (Integer.parseInt(review) < 1 || Integer.parseInt(review) > 10) {
            System.out.println("Review has to be a number between 1 and 10!");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Oh no, an Error occurred!");
            alert.setContentText("Review is invalid");

            alert.showAndWait();
            return true;
        }

        if (!(matcher.matches())) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Oh no, an Error occurred!");
            alert.setContentText("Invalid email specified.");

            alert.showAndWait();
            return true;
        }

        return false;
    }

    public boolean getGenderCheckInput() {
        String gender = GetCertificateScene.getGender();

        if (!(gender.equalsIgnoreCase("Male") || gender.equalsIgnoreCase("Female"))) {

            System.out.println("Invalid gender error occurred!");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Oh no, an Error occurred!");
            alert.setContentText("Invalid gender specified.");

            alert.showAndWait();
            return true;
        }
        return false;
    }

    public boolean isInteger(String review) {
        try {
            Integer.parseInt(review);
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }
}

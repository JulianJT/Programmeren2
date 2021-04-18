package Database;

import javafx.scene.control.Alert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// This class checks the user input in certificate and student.

public class InputCheck {

    public static InputCheck INSTANCE = new InputCheck();

    //This method checks the input for certificate whether or not they're empty.
    public boolean addCertificateInputCheck(String course, String userName, String studentName, String review) {
        if (course.isEmpty()) {
            showAlert("Course is empty");
            return true;
        }

        if (studentName.isEmpty()) {
            showAlert("Studentname is empty");
            return true;
        }

        if (userName.isEmpty()) {
            showAlert("Username is empty");
            return true;
        }

        if (!isInteger(review)) {
            showAlert("Review is not a number");
            return true;
        }

        if (!review.isEmpty()) {
            if (Integer.parseInt(review) < 1 || Integer.parseInt(review) > 10) {
                showAlert("Review is invalid. Use a number between 1 and 10.");
                return true;
            }
        }
        return false;
    }

    //This method checks the values from the addstudentscene.
    public boolean addStudentInputCheck(String userName, String email, String address, String residence, String country, String zipcode) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        if (!(matcher.matches())) {
            showAlert("Invalid email specified.");
            return true;
        }

        if (userName.isEmpty()) {
            showAlert("Name is empty");
            return true;
        }

        if (email.isEmpty()) {
            showAlert("Email is empty");
            return true;
        }

        if (address.isEmpty()) {
            showAlert("Address is empty");
            return true;
        }

        if (residence.isEmpty()) {
            showAlert("Residence is empty");
            return true;
        }

        if (country.isEmpty()) {
            showAlert("Country is empty");
            return true;
        }

        if (zipcode.isEmpty()) {
            showAlert("Zipcode is empty");
            return true;
        }

        if (zipcode.length() > 9) {
            showAlert("Max zipcode size is 9 characters");
            return true;
        }

        return false;
    }

    //This method checks whether or not the review is an integer.
    private boolean isInteger(String review) {
        try {
            Integer.parseInt(review);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //This method shows an alertBox with a message.
    private void showAlert(String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Dialog");
        alert.setHeaderText("Oh no, an error occurred!");
        alert.setContentText(content);
        alert.showAndWait();
    }
}

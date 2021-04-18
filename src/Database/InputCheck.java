package Database;

import javafx.scene.control.Alert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// This class checks the user input in certificate and student.

public class InputCheck {

    private static final String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
    private static final Pattern emailPattern = Pattern.compile(emailRegex);

    public static InputCheck INSTANCE = new InputCheck();

    //This method checks whether or not a String can be converted to an Integer.
    public static boolean isInteger(String integer) {
        try {
            Integer.parseInt(integer);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //This method shows an alertBox with a message.
    public static void showAlert(String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Dialog");
        alert.setHeaderText("Oh no, an error occurred!");
        alert.setContentText(content);
        alert.showAndWait();
    }

    //This method checks the input values from the AddCertificateScene
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

    //This method checks the input values from the AddStudentScene.
    public boolean addStudentInputCheck(String userName, String email, String address, String residence, String country, String zipcode) {
        Matcher matcher = emailPattern.matcher(email);

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

    //This method checks the input values from the AddModuleScene
    public boolean addModuleInputCheck(String title, String nameOrganization, String courseName, String contentStatus, String emailAddress, String description) {
        Matcher matcher = emailPattern.matcher(emailAddress);

        if (!(matcher.matches())) {
            showAlert("Invalid email specified.");
            return true;
        }

        if (title.isEmpty()) {
            showAlert("Title is empty");
            return true;
        }

        if (nameOrganization.isEmpty()) {
            showAlert("Organization name is empty");
            return true;
        }

        if (courseName.isEmpty()) {
            showAlert("Course name is empty");
            return true;
        }

        if (contentStatus.isEmpty()) {
            showAlert("Content status is empty");
            return true;
        }

        if (emailAddress.isEmpty()) {
            showAlert("Email is empty");
            return true;
        }

        if (description.isEmpty()) {
            showAlert("Description is empty");
            return true;
        }

        return false;
    }

    //This method checks the input values from the AddCourseScene
    public boolean addCourseInputCheck(String courseName, String subjectName, String intro, String level) {
        if (courseName.isEmpty()) {
            showAlert("New course name is empty");
            return true;
        }

        if (subjectName.isEmpty()) {
            showAlert("Subject name is empty");
            return true;
        }

        if (intro.isEmpty()) {
            showAlert("Introduction is empty");
            return true;
        }

        if (level.isEmpty()) {
            showAlert("Level is empty");
            return true;
        }

        return false;
    }

    //This method checks the input values for the UpdateCourseScene
    public boolean updateCourseInputCheck(String courseName, String subjectName, String intro, String level, String oldCourseName) {
        if (courseName.isEmpty()) {
            showAlert("Course name is empty");
            return true;
        }

        if (subjectName.isEmpty()) {
            showAlert("Subject name is empty");
            return true;
        }

        if (intro.isEmpty()) {
            showAlert("Introduction is empty");
            return true;
        }

        if (level.isEmpty()) {
            showAlert("Level is empty");
            return true;
        }

        if (oldCourseName.isEmpty()) {
            showAlert("Old course name is empty");
            return true;
        }

        return false;
    }
}

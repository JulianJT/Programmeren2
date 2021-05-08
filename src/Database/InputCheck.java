package Database;

import javafx.scene.control.Alert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// This class checks the user input in certificate and student.

public class InputCheck {
    private static final Pattern emailPattern = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
    private static final Pattern zipcodePattern = Pattern.compile("[1-9]{1}[0-9]{3}[a-zA-Z]{2}");

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

    // This method loops through all given inputs to check if null or empty.
    public static boolean checkIfEmpty(String... args) {
        for (String s : args) {
            if (s == null || s.isEmpty())
                return true;
        }
        return false;
    }

    //This method checks the input values from the AddCertificateScene
    public String addCertificateInputCheck(String course, String userName, String studentName, String review) {
        if (checkIfEmpty(course, userName, studentName, review))
            return "Empty field.";

        if (!isInteger(review))
            return "Review is not a number";

        if (!review.isEmpty()) {
            if (Integer.parseInt(review) < 1 || Integer.parseInt(review) > 10)
                return "Review is invalid. Use a number between 1 and 10.";
        }
        return null;
    }

    //This method checks the input values from the AddStudentScene.
    public String addStudentInputCheck(String userName, String email, String address, String residence, String country, String zipcode, String gender) {
        Matcher matcher = emailPattern.matcher(email);
        Matcher zipMatcher = zipcodePattern.matcher(zipcode);

        if (checkIfEmpty(userName, email, address, residence, country, gender, zipcode))
            return "Empty field.";

        if (!(matcher.matches()))
            return "Invalid email specified.";

        if (!(zipMatcher.matches()))
            return "Invalid zipcode.";

        if (zipcode.length() > 9)
            return "Max zipcode size is 9 characters";
        return null;
    }

    //This method checks the input values from the AddModuleScene
    public String addModuleInputCheck(String title, String nameOrganization, String courseName, String contentStatus, String emailAddress, String description) {
        Matcher matcher = emailPattern.matcher(emailAddress);

        if (checkIfEmpty(title, nameOrganization, courseName, contentStatus, emailAddress, description))
            return "Empty field.";

        if (!(matcher.matches()))
            return "Invalid email specified.";
        return null;
    }

    //This method checks the input values from the AddCourseScene
    public String addCourseInputCheck(String courseName, String subjectName, String intro, String level) {
        if (checkIfEmpty(courseName, subjectName, intro, level))
            return "Empty field.";
        return null;
    }

    //This method checks the input values for the UpdateCourseScene
    public String updateCourseInputCheck(String courseName, String subjectName, String intro, String level, String oldCourseName) {
        if (checkIfEmpty(courseName, subjectName, intro, level, oldCourseName))
            return "Empty field.";
        return null;
    }
}

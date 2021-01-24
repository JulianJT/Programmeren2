package Database;

import GUI.AddCertificateScene;
import GUI.GetCertificateScene;
import javafx.scene.control.Alert;

public class CertificateInputCheck {

    String review = AddCertificateScene.getReview();
    String studentName = AddCertificateScene.getStudentName();
    String workerName = AddCertificateScene.getUserName();
    String course = AddCertificateScene.getCourse();

    public boolean addCheckInput() {
        if (course.isEmpty()) {
            System.out.println("Course was empty");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Oh no, an Error occurred!");
            alert.setContentText("Course is empty");

            alert.showAndWait();
            return true;
        }
        if (studentName.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Oh no, an Error occurred!");
            alert.setContentText("Studentname is empty");

            alert.showAndWait();
            return true;
        }
        if (workerName.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Oh no, an Error occurred!");
            alert.setContentText("Username is empty");

            alert.showAndWait();
            return true;
        }
        if (!isInteger(review)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Oh no, an Error occurred!");
            alert.setContentText("Review is not a number");

            alert.showAndWait();
            return true;
        }
        if (Integer.parseInt(review) < 1 || Integer.parseInt(review) > 10) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Oh no, an Error occurred!");
            alert.setContentText("Review is invalid. Use a number between 1 and 10.");

            alert.showAndWait();
            return true;
        }

        return false;
    }

    public boolean getGenderCheckInput() {
        String gender = GetCertificateScene.getGender();

        if (!(gender.equalsIgnoreCase("Male") || gender.equalsIgnoreCase("Female"))) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Oh no, an Error occurred!");
            alert.setContentText("Invalid gender specified. Use \"Male\" or \"Female\".");

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

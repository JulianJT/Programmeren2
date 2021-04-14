package Database;

import Domain.Student;
import GUI.StudentRemoveScene;
import GUI.StudentViewScene;
import javafx.scene.control.Alert;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentRepository extends DatabaseConnection {

    public List<Student> getAllStudents() {
        ArrayList<Student> students = new ArrayList<>();
        String name;
        String email;
        ResultSet rs;

        try {

            String SQL = "SELECT * FROM Student";
            rs = executeSelectStatement(SQL);

                while (rs.next()) {
                    name = rs.getString("name");
                    email = rs.getString("emailAddress");

                    Student student = new Student(name, email);
                    students.add(student);
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
        closeConnection();
        return students;
    }

    public void addStudent(String userName, String email, Date birthday, String gender, String address, String residence, String country) {
        if (InputCheck.INSTANCE.addStudentInputCheck(userName, email, gender, address, residence, country))
            return;

        String SQL = "INSERT INTO Student (emailAddress, name, dateOfBirth, gender, address, residence, country) VALUES('" + email + "','" + userName + "','" + birthday + "','" + gender + "','" + address + "','" + residence + "','" + country + "')";
        executeInsertStatement(SQL);
    }

    public String viewStudent() {
        StringBuilder studentProfile = new StringBuilder();
        StudentViewScene viewStudent = new StudentViewScene();
        String studentName = viewStudent.getStudentName();
        ResultSet rs;

        if (studentName.equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Oh no, an Error occurred!");
            alert.setContentText("Name field is empty");
            alert.showAndWait();
            return null;
        }

        try {

            String SQL = "SELECT * FROM Student WHERE Name = '" + studentName + "'";
            rs = executeSelectStatement(SQL);

            if (!rs.isBeforeFirst()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Oh no, an Error occurred!");
                alert.setContentText("Student not found.");
                alert.showAndWait();
                return null;
            }

            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();

            while (rs.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    studentProfile.append(rsmd.getColumnName(i)).append(": ").append(rs.getString(i)).append("\n");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        closeConnection();
        return studentProfile.toString();
    }

    public void deleteStudent() {

        StudentRemoveScene removeStudent = new StudentRemoveScene();
        String studentName = removeStudent.getStudentName();

        try {

            String SQL = "DELETE FROM Student WHERE Name = '" + studentName + "'";
            int deleted = executeUpdateStatement(SQL);

            if (deleted == 0) {
                showError("Student not found!");
            } else {
                showInfo("Student successfully deleted.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



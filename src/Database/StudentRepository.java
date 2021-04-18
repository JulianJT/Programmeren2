package Database;

import Domain.Student;
import GUI.Student.StudentViewScene;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// This class contains methods that executes and builds queries for Student

public class StudentRepository extends DatabaseConnection {


    //This method shows all the students in the database.
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

    //This method retrieves the information it needs from studentInput and executes a query with these parameters. After this the data gets added to the database.
    public void addStudent(String userName, String email, Date birthday, String gender, String address, String residence, String country, String zipcode) {
        if (InputCheck.INSTANCE.addStudentInputCheck(userName, email, address, residence, country, zipcode))
            return;

        String SQL = "INSERT INTO Student (emailAddress, name, dateOfBirth, gender, address, residence, country, zipcode) VALUES('" + email + "','" + userName + "','" + birthday + "','" + gender + "','" + address + "','" + residence + "','" + country + "','" + zipcode + "')";
        executeInsertStatement(SQL);
        showInfo("Student successfully added to database.");
    }

    //This method retrieves a student from the database.
    public String viewStudent() {
        StringBuilder studentProfile = new StringBuilder();
        StudentViewScene viewStudent = new StudentViewScene();
        String studentName = viewStudent.getStudentName();
        ResultSet rs;

        if (studentName.equals("")) {
            showError("Name field is empty");
            return null;
        }

        try {

            String SQL = "SELECT * FROM Student WHERE Name = '" + studentName + "'";
            rs = executeSelectStatement(SQL);

            if (!rs.isBeforeFirst()) {
                showError("Student not found.");
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

    //This method deletes a specified student from the database. It retrieves its information from studentRemoveScene.
    public void deleteStudent(String studentName) {

        try {

            String SQL = "DELETE FROM Student WHERE Name = '" + studentName + "'";
            int deleted = executeUpdateStatement(SQL);

            if (deleted == 0) {
                System.out.println("Student not found!");
                showError("Student not found!");
            } else {
                System.out.println("Student successfully deleted.");
                showInfo("Student successfully deleted.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



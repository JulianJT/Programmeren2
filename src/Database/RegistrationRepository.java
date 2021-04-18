package Database;

import Domain.Registration;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

// This class contains methods that executes and builds queries for Registration

public class RegistrationRepository extends DatabaseConnection {

    public List<Registration> showStudents() {
        ArrayList<Registration> studentRegistration = new ArrayList<>();
        String name;
        String course;
        ResultSet rs;

        try {
            String SQL = "SELECT Student.name, Course.courseName FROM Student " +
                    "LEFT JOIN Registration ON Student.emailAddress=Registration.emailAddress LEFT JOIN Course ON Registration.courseName=Course.courseName ORDER BY name";

            rs = executeSelectStatement(SQL);

            while (rs.next()) {
                name = rs.getString("name");
                course = rs.getString("courseName");

                if (rs.wasNull()) {
                    course = "Not registered for a course yet";
                }

                Registration StudReg = new Registration(name, course);
                studentRegistration.add(StudReg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        closeConnection();
        return studentRegistration;
    }

    public List<Registration> showCourses() {
        ArrayList<Registration> coursesRegistration = new ArrayList<>();
        String name;
        String course;
        ResultSet rs;

        try {

            String SQL = "SELECT Course.courseName, Student.name FROM Course " +
                    "LEFT JOIN Registration ON Course.courseName=Registration.courseName LEFT JOIN STUDENT ON Registration.emailAddress=Student.emailAddress ORDER BY courseName";

            rs = executeSelectStatement(SQL);

            while (rs.next()) {
                course = rs.getString("courseName");
                name = rs.getString("name");

                if (rs.wasNull()) {
                    name = "No registrations yet";
                }

                Registration CourseReg = new Registration(course, name);
                coursesRegistration.add(CourseReg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        closeConnection();
        return coursesRegistration;
    }

    public int getRegistrationAmount() {
        ResultSet rs;

        try {

            String SQL = "SELECT COUNT(Student.name) FROM Course " +
                    "LEFT JOIN Registration ON Course.courseName=Registration.courseName " +
                    "LEFT JOIN STUDENT ON Registration.emailAddress=Student.emailAddress";

            rs = executeSelectStatement(SQL);

            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        closeConnection();
        return 0;
    }
}

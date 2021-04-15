package Database;

import Domain.Course;
import GUI.Course.AddCourseScene;
import GUI.Course.CourseRemoveScene;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CourseRepository extends DatabaseConnection {

    public String getModules() {
        StringBuilder modules = new StringBuilder();
        ResultSet rs;

        try {

            String SQL = "SELECT * FROM Module";
            rs = executeSelectStatement(SQL);

            while (rs.next()) {
                modules.append(rs.getString("title"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        closeConnection();
        return modules.toString();
    }

    public List<Course> getAllCourses() {
        ArrayList<Course> courses = new ArrayList<>();
        String name;
        String subject;
        String text;
        ResultSet rs;

        try {

            String SQL = "SELECT * FROM Course";
            rs = executeSelectStatement(SQL);

            while (rs.next()) {
                name = rs.getString("courseName");
                subject = rs.getString("subject");
                text = rs.getString("introductionText");

                Course course = new Course(name, subject, text);
                courses.add(course);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        closeConnection();
        return courses;
    }


    public void addCourse() {
        String courseName = AddCourseScene.getCourseName();
        String subjectName = AddCourseScene.getSubjectName();
        String intro = AddCourseScene.getIntroduction();
        String level = AddCourseScene.getLevel();

        String SQL = "INSERT INTO Course (courseName, subject, introductionText, level_indication) VALUES('" + courseName + "','" + subjectName + "','" + intro + "','" + level + "')";
        executeInsertStatement(SQL);
    }

    public void deleteCourse() {

        CourseRemoveScene removeCourse = new CourseRemoveScene();
        String courseName = removeCourse.getCourseName();

        try {

            String SQL = "DELETE FROM course WHERE courseName = '" + courseName + "'";
            int deleted = executeUpdateStatement(SQL);

            if (deleted == 0) {
                showError("Course not found!");
            } else {
                showInfo("Course successfully deleted.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

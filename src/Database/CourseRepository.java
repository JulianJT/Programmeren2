package Database;

import GUI.AddCourseScene;

import java.sql.ResultSet;

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

    public void addCourse() {
        String courseName = AddCourseScene.getCourseName();
        String subjectName = AddCourseScene.getSubjectName();
        String intro = AddCourseScene.getIntroduction();
        String level = AddCourseScene.getLevel();

        String SQL = "INSERT INTO Course (courseName, subject, introductionText, level_indication) VALUES('" + courseName + "','" + subjectName + "','" + intro + "','" + level + "')";
        executeInsertStatement(SQL);
    }
}

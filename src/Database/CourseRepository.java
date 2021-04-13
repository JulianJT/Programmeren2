package Database;

import GUI.AddCourseScene;

import java.sql.ResultSet;


public class CourseRepository extends DatabaseConnection {

    public String getModules() {
        StringBuilder modules = new StringBuilder();
        ResultSet rs = null;

        try {

            String SQL = "SELECT * FROM Module";
            rs = executeSqlStatement(SQL);

            while (rs.next()) {
                modules.append(rs.getString("title"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modules.toString();
    }


    public void addCourse() {

        String courseName = AddCourseScene.getCourseName();
        String subjectName = AddCourseScene.getSubjectName();
        String intro = AddCourseScene.getIntroduction();
        String level = AddCourseScene.getLevel();

        try {

            String SQL = "INSERT INTO Course (courseName, subject, introductionText, level_indication) VALUES('" + courseName + "','" + subjectName + "','" + intro + "','" + level + "')";
            executeSqlStatement(SQL);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

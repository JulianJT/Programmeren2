package Database;

import Domain.Course;
import GUI.Course.AddCourseScene;
import GUI.Course.AddModuleScene;
import GUI.Course.CourseRemoveScene;
import GUI.Course.UpdateCourseScene;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

// This class contains methods that executes and builds queries for Courses

public class CourseRepository extends DatabaseConnection {


    //This methods retrieves all the modules from the database.
    public List<String> getModules() {
        List<String> modules = new ArrayList<>();
        ResultSet rs;

        try {

            String SQL = "SELECT * FROM Module";
            rs = executeSelectStatement(SQL);

            while (rs.next()) {
                modules.add(rs.getString("title"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        closeConnection();
        return modules;
    }

    //This method retrieves all the courses from the database.
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


    //This method adds a course to the database.
    public void addCourse() {
        String courseName = AddCourseScene.getCourseName();
        String subjectName = AddCourseScene.getSubjectName();
        String intro = AddCourseScene.getIntroduction();
        String level = AddCourseScene.getLevel();

        if (InputCheck.INSTANCE.addCourseInputCheck(courseName, subjectName, intro, level))
            return;

        String SQL = "INSERT INTO Course (courseName, subject, introductionText, level_indication) VALUES('" + courseName + "','" + subjectName + "','" + intro + "','" + level + "')";
        boolean bl = executeInsertStatement(SQL);

        if (bl)
            showInfo("Course succesfully added.");
        else
            showError("Failed to add course.");
    }

    //This method updates a course from the database.
    public void updateCourse() {
        String courseName = UpdateCourseScene.getCourseName();
        String subjectName = UpdateCourseScene.getSubjectName();
        String intro = UpdateCourseScene.getIntroduction();
        String level = UpdateCourseScene.getLevel();
        String oldCourseName = UpdateCourseScene.getOldCourseName();

        if (InputCheck.INSTANCE.updateCourseInputCheck(courseName, subjectName, intro, level, oldCourseName))
            return;

        String SQL = "Update Course " + "SET" + " " +
                "courseName='" + courseName + "', subject='" + subjectName + "', introductionText='" + intro + "', level_indication='" + level + "' " +
                "WHERE courseName='" + oldCourseName + "'";

        System.out.println(SQL);

        int updated = executeUpdateStatement(SQL);
        if (updated != 0)
            showInfo("Course successfully updated.");
        else
            showError("Failed to update course.");
    }

    //This method adds a module to the database.
    public void addModule() {
        String title = AddModuleScene.getTitle();
        Integer version = AddModuleScene.getVersion();
        String nameOrganization = AddModuleScene.getNameOrganization();
        Integer contentItemId = AddModuleScene.getContentItemId();
        String courseName = AddModuleScene.getCourseName();
        Date publicationDate = AddModuleScene.getPublicationDate();
        String contentStatus = AddModuleScene.getContentStatus();
        String emailAddress = AddModuleScene.getEmailAddress();
        String description = AddModuleScene.getDescription();
        Integer serialNumber = AddModuleScene.getSerialNumber();

        if (InputCheck.INSTANCE.addModuleInputCheck(title, nameOrganization, courseName, contentStatus, emailAddress, description))
            return;

        String SQL = "SET IDENTITY_INSERT ContentItem ON INSERT INTO ContentItem(contentItemID, PublicationDate, contentStatus) VALUES('" + contentItemId + "','" + publicationDate + "','" + contentStatus + "')" + "SET IDENTITY_INSERT ContentItem OFF";
        String SQL2 = "SET IDENTITY_INSERT ContentItem ON INSERT INTO Module (title, version, nameOrganization, contentItemId, courseName, description, emailAddress, serialNumber) VALUES('" + title + "','" + version + "','" + nameOrganization + "','" + contentItemId + "','" + courseName + "','" + description + "', '" + emailAddress + "','" + serialNumber + "')" + "SET IDENTITY_INSERT ContentItem OFF";

        boolean bl = executeInsertStatement(SQL);
        boolean bl2 = executeInsertStatement(SQL2);

        if (bl && bl2)
            showInfo("Module successfully added.");
        else
            showError("Failed to add module.");

    }

    //This method deletes a course from the database.
    public void deleteCourse() {

        CourseRemoveScene removeCourse = new CourseRemoveScene();
        String courseName = removeCourse.getCourseName();

        try {

            String SQL = "DELETE FROM Course WHERE courseName = '" + courseName + "'";
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

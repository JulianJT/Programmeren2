
import Database.InputCheck;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

public class InputCheckTest {
    private static final String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
    private static final String zipcodeRegex = "[1-9]{1}[0-9]{3}[a-zA-Z]{2}";
    private static final Pattern emailPattern = Pattern.compile(emailRegex);
    private static final Pattern zipcodePattern = Pattern.compile(zipcodeRegex);

    @Test
    @DisplayName("AddCertificate: Non-integers")
    public void testCertificateInput() {
        boolean bl = addCertificateInputCheck("course", "user", "student", "four");
        assertTrue(bl);
    }

    @Test
    @DisplayName("AddCertificate: Integers not [1-10]")
    public void testCertificateInput2() {
        boolean bl = addCertificateInputCheck("course", "user", "student", "0");
        assertTrue(bl);
    }

    @Test
    @DisplayName("AddCertificate: Correct Input")
    public void testCertificateInput3() {
        boolean bl = addCertificateInputCheck("course", "user", "student", "7");
        assertFalse(bl);
    }

    @Test
    @DisplayName("AddStudent: Incorrect Email")
    public void testStudentInput1() {
        boolean bl = addStudentInputCheck("user", "notEmail", "address", "residence", "country", "4562LW");
        assertTrue(bl);
    }

    @Test
    @DisplayName("AddStudent: Empty Field")
    public void testStudentInput2() {
        boolean bl = addStudentInputCheck("", "student@outlook.com", "address", "residence", "country", "4562LW");
        assertTrue(bl);
    }

    @Test
    @DisplayName("AddStudent: Incorrect Zipcode")
    public void testStudentInput3() {
        boolean bl = addStudentInputCheck("user", "student@outlook.com", "address", "residence", "country", "L32lXW");
        assertTrue(bl);
    }

    @Test
    @DisplayName("AddStudent: Correct Input")
    public void testStudentInput4() {
        boolean bl = addStudentInputCheck("user", "student@outlook.com", "address", "residence", "country", "4562LW");
        assertFalse(bl);
    }

    @Test
    @DisplayName("AddModule: Incorrect Email")
    public void testModuleInput1() {
        boolean bl = addModuleInputCheck("Title", "Organization", "Course", "Status", "Email", "Description");
        assertTrue(bl);
    }

    @Test
    @DisplayName("AddModule: Empty Field")
    public void testModuleInput2() {
        boolean bl =  addModuleInputCheck("Title", "Organization", "Course", "", "student@gmail.com", "Description");
        assertTrue(bl);
    }

    @Test
    @DisplayName("AddModule: Correct Input")
    public void testModuleInput3() {
        boolean bl =  addModuleInputCheck("Title", "Organization", "Course", "Status", "student@gmail.com", "Description");
        assertFalse(bl);
    }

    @Test
    @DisplayName("AddCourse: Empty Field")
    public void testCourseInput1() {
        boolean bl = addCourseInputCheck("Course", "Subject", "", "Beginner");
        assertTrue(bl);
    }

    @Test
    @DisplayName("AddCourse: Correct Input")
    public void testCourseInput2() {
        boolean bl = addCourseInputCheck("Course", "Subject", "Introduction", "Expert");
        assertFalse(bl);
    }

    @Test
    @DisplayName("UpdateCourse: Empty Field")
    public void testUpdateCourseInput1() {
        boolean bl = updateCourseInputCheck("", "Subject", "Introduction", "Beginner", "Old Course");
        assertTrue(bl);
    }

    @Test
    @DisplayName("UpdateCourse: Correct Input")
    public void testUpdateCourseInput2() {
        boolean bl = updateCourseInputCheck("Course", "Subject", "Introduction", "Beginner", "Old Course");
        assertFalse(bl);
    }

    /**
     * All of the methods below are identical copies of the InputCheck methods used in the application.
     * If we were to call the methods directly, it would fail because of Alert Dialogs.
     * Some methods here may look slightly different at first, but they function identical.
     */

    // addCertificateInputCheck without Alert Dialogs
    private boolean addCertificateInputCheck(String course, String userName, String studentName, String review) {
        if (course.isEmpty())
            return true;

        if (studentName.isEmpty())
            return true;

        if (userName.isEmpty())
            return true;

        if (!InputCheck.isInteger(review))
            return true;

        if (!review.isEmpty())
            return Integer.parseInt(review) < 1 || Integer.parseInt(review) > 10;

        return false;
    }

    // addStudentInputCheck without Alert Dialogs
    private boolean addStudentInputCheck(String userName, String email, String address, String residence, String country, String zipcode) {
        Matcher matcher = emailPattern.matcher(email);
        Matcher zipMatcher = zipcodePattern.matcher(zipcode);

        if (!(matcher.matches()))
            return true;

        if (!(zipMatcher.matches()))
            return true;

        if (userName.isEmpty())
            return true;

        if (email.isEmpty())
            return true;

        if (address.isEmpty())
            return true;

        if (residence.isEmpty())
            return true;

        if (country.isEmpty())
            return true;

        if (zipcode.isEmpty())
            return true;

        return zipcode.length() > 9;
    }

    // addModuleInputCheck without Alert Dialogs
    public boolean addModuleInputCheck(String title, String nameOrganization, String courseName, String contentStatus, String emailAddress, String description) {
        Matcher matcher = emailPattern.matcher(emailAddress);

        if (!(matcher.matches()))
            return true;

        if (title.isEmpty())
            return true;

        if (nameOrganization.isEmpty())
            return true;

        if (courseName.isEmpty())
            return true;

        if (contentStatus.isEmpty())
            return true;

        if (emailAddress.isEmpty())
            return true;

        return description.isEmpty();
    }

    // addCourseInputCheck without Alert Dialogs
    public boolean addCourseInputCheck(String courseName, String subjectName, String intro, String level) {
        if (courseName.isEmpty())
            return true;

        if (subjectName.isEmpty())
            return true;

        if (intro.isEmpty())
            return true;

        return level.isEmpty();
    }

    // updateCourseInputCheck without Alert Dialogs
    public boolean updateCourseInputCheck(String courseName, String subjectName, String intro, String level, String oldCourseName) {
        if (courseName.isEmpty())
            return true;

        if (subjectName.isEmpty())
            return true;

        if (intro.isEmpty())
            return true;

        if (level.isEmpty())
            return true;

        return oldCourseName.isEmpty();
    }
}
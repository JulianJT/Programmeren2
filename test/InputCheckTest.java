import Database.InputCheck;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class InputCheckTest {
    private static final InputCheck check = InputCheck.INSTANCE;

    @Test
    @DisplayName("AddCertificate: Non-integers")
    public void testCertificateInput() {
        String error = check.addCertificateInputCheck("course", "user", "student", "four");
        assertEquals("Review is not a number", error);
    }

    @Test
    @DisplayName("AddCertificate: Integers not [1-10]")
    public void testCertificateInput2() {
        String error = check.addCertificateInputCheck("course", "user", "student", "0");
        assertEquals("Review is invalid. Use a number between 1 and 10.", error);
    }

    @Test
    @DisplayName("AddCertificate: Correct Input")
    public void testCertificateInput3() {
        String error = check.addCertificateInputCheck("course", "user", "student", "7");
        assertNull(error);
    }

    @Test
    @DisplayName("AddStudent: Incorrect Email")
    public void testStudentInput1() {
        String error = check.addStudentInputCheck("user", "notEmail", "address", "residence", "country", "4562LW", "Male");
        assertEquals("Invalid email specified.", error);
    }

    @Test
    @DisplayName("AddStudent: Empty Field")
    public void testStudentInput2() {
        String error = check.addStudentInputCheck("", "student@outlook.com", "address", "residence", "country", "4562LW", "Female");
        assertEquals("Empty field.", error);
    }

    @Test
    @DisplayName("AddStudent: Incorrect Zipcode")
    public void testStudentInput3() {
        String error = check.addStudentInputCheck("user", "student@outlook.com", "address", "residence", "country", "L32lXW", "Male");
        assertEquals("Invalid zipcode.", error);
    }

    @Test
    @DisplayName("AddStudent: Correct Input")
    public void testStudentInput4() {
        String error = check.addStudentInputCheck("user", "student@outlook.com", "address", "residence", "country", "4562LW", "Female");
        assertNull(error);
    }

    @Test
    @DisplayName("AddModule: Incorrect Email")
    public void testModuleInput1() {
        String error = check.addModuleInputCheck("Title", "Organization", "Course", "Status", "Email", "Description");
        assertEquals("Invalid email specified.", error);
    }

    @Test
    @DisplayName("AddModule: Empty Field")
    public void testModuleInput2() {
        String error =  check.addModuleInputCheck("Title", "Organization", "Course", "", "student@gmail.com", "Description");
        assertEquals("Empty field.", error);
    }

    @Test
    @DisplayName("AddModule: Correct Input")
    public void testModuleInput3() {
        String error =  check.addModuleInputCheck("Title", "Organization", "Course", "Status", "student@gmail.com", "Description");
        assertNull(error);
    }

    @Test
    @DisplayName("AddCourse: Empty Field")
    public void testCourseInput1() {
        String error = check.addCourseInputCheck("Course", "Subject", "", "Beginner");
        assertEquals("Empty field.", error);
    }

    @Test
    @DisplayName("AddCourse: Correct Input")
    public void testCourseInput2() {
        String error = check.addCourseInputCheck("Course", "Subject", "Introduction", "Expert");
        assertNull(error);
    }

    @Test
    @DisplayName("UpdateCourse: Empty Field")
    public void testUpdateCourseInput1() {
        String error = check.updateCourseInputCheck("", "Subject", "Introduction", "Beginner", "Old Course");
        assertEquals("Empty field.", error);
    }

    @Test
    @DisplayName("UpdateCourse: Correct Input")
    public void testUpdateCourseInput2() {
        String error = check.updateCourseInputCheck("Course", "Subject", "Introduction", "Beginner", "Old Course");
        assertNull(error);
    }
}
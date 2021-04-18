
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

public class InputCheckTest {

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
    @DisplayName("Student: Incorrect Email")
    public void testStudentInput1() {
        boolean bl = addStudentInputCheck("user", "notEmail", "address", "residence", "country", "4562LW");
        assertTrue(bl);
    }

    @Test
    @DisplayName("Student: Empty Field")
    public void testStudentInput2() {
        boolean bl = addStudentInputCheck("", "student@outlook.com", "address", "residence", "country", "4562LW");
        assertTrue(bl);
    }

    @Test
    @DisplayName("Student: Incorrect Zipcode")
    public void testStudentInput3() {
        boolean bl = addStudentInputCheck("user", "student@outlook.com", "address", "residence", "country", "45682332LW");
        assertTrue(bl);
    }

    @Test
    @DisplayName("Student: Correct Input")
    public void testStudentInput4() {
        boolean bl = addStudentInputCheck("user", "student@outlook.com", "address", "residence", "country", "4562LW");
        assertFalse(bl);
    }

    // addCertificateInputCheck without Alert Dialogs.
    private boolean addCertificateInputCheck(String course, String userName, String studentName, String review) {
        if (course.isEmpty()) {
            return true;
        }

        if (studentName.isEmpty()) {
            return true;
        }

        if (userName.isEmpty()) {
            return true;
        }

        if (!isInteger(review)) {
            return true;
        }

        if (!review.isEmpty()) {
            return Integer.parseInt(review) < 1 || Integer.parseInt(review) > 10;
        }

        return false;
    }

    // addStudentInputCheck without Alert Dialogs.
    private boolean addStudentInputCheck(String userName, String email, String address, String residence, String country, String zipcode) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        if (!(matcher.matches())) {
            return true;
        }

        if (userName.isEmpty()) {
            return true;
        }

        if (email.isEmpty()) {
            return true;
        }

        if (address.isEmpty()) {
            return true;
        }

        if (residence.isEmpty()) {
            return true;
        }

        if (country.isEmpty()) {
            return true;
        }

        if (zipcode.isEmpty()) {
            return true;
        }

        if (zipcode.length() > 9) {
            return true;
        }

        return false;
    }

    private boolean isInteger(String review) {
        try {
            Integer.parseInt(review);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
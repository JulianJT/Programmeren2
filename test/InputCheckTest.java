
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
        boolean bl = addStudentInputCheck("user", "notEmail", "address", "residence", "country");
        assertTrue(bl);
    }

    @Test
    @DisplayName("Student: Empty Field")
    public void testStudentInput3() {
        boolean bl = addStudentInputCheck("", "student@outlook.com", "address", "residence", "country");
        assertTrue(bl);
    }

    @Test
    @DisplayName("Student: Correct Input")
    public void testStudentInput2() {
        boolean bl = addStudentInputCheck("user", "student@outlook.com", "address", "residence", "country");
        assertFalse(bl);
    }

    // addCertificateInputCheck without Alert Dialogs.
    public boolean addCertificateInputCheck(String course, String userName, String studentName, String review) {
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
    public boolean addStudentInputCheck(String userName, String email, String address, String residence, String country) {
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
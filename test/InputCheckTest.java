import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InputCheckTest {

    @Test
    @DisplayName("Certificate: Non-integers")
    public void testCertificateInput() {
        boolean bl = addCertificateInputCheck("course", "user", "student", "four");
        assertTrue(bl);
    }

    @Test
    @DisplayName("Certificate: Integers not [1-10]")
    public void testCertificateInput2() {
        boolean bl = addCertificateInputCheck("course", "user", "student", "0");
        assertTrue(bl);
    }

    @Test
    @DisplayName("Certificate: Correct Input")
    public void testCertificateInput3() {
        boolean bl = addCertificateInputCheck("course", "user", "student", "7");
        assertFalse(bl);
    }

    // certificateInputCheck without Alerts
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

    private boolean isInteger(String review) {
        try {
            Integer.parseInt(review);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
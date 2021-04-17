package Database;

import Domain.Certificate;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CertificateRepository extends DatabaseConnection {

    // adds certificate to database
    public void addCertificate(String userName, String studentName, String course, String review) {
        if (InputCheck.INSTANCE.addCertificateInputCheck(course, userName, studentName, review)) {
            return;
        }

        String insert = "INSERT INTO Certificate (review, nameWorker) VALUES(" + review + ",'" + userName + "')";
        executeInsertStatement(insert);
        //TODO: Connect this certificate to a registration. Use studentName and course.
    }

    // gets certificate from database for student
    public List<Certificate> getCertificate(String studentName) {
        ArrayList<Certificate> certificates = new ArrayList<>();
        ResultSet rs;

        try {

            String SQL = "SELECT certificateID, review, nameWorker FROM Certificate WHERE certificateID IN (SELECT certificateID FROM Registration WHERE emailAddress in (SELECT emailAddress FROM Student WHERE name = '" + studentName + "'))";
            rs = executeSelectStatement(SQL);

            while (rs.next()) {
                String nameWorker = rs.getString("nameWorker");
                int review = rs.getInt("review");
                int id = rs.getInt("certificateID");

                certificates.add(new Certificate(id, review, nameWorker));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        closeConnection();
        return certificates;
    }

    // returns percentage of people with certificate
    public int getCertificatePercentage(String gender) {

        //TODO: Implement Certificate Percentage

        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
        closeConnection();
        return 0;
    }
}
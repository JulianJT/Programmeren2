package Database;

import Domain.Certificate;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CertificateRepository extends DatabaseConnection {

    public void addCertificate(String userName, String studentName, String course, String review) {
        if (InputCheck.INSTANCE.addCertificateInputCheck(course, userName, studentName, review)) {
            return;
        }

        String SQL = "INSERT INTO Certificate (review, nameWorker) VALUES(" + review + ",'" + userName + "')";
        insertSqlStatement(SQL);
    }

    public List<Certificate> getCertificate(String studentName) {
        ArrayList<Certificate> certificates = new ArrayList<>();
        ResultSet rs;

        try {

            String SQL = "SELECT certificateID, review, nameWorker FROM Certificate WHERE certificateID IN ( SELECT certificateID FROM Registration INNER JOIN Student ON Registration.emailAddress = Student.emailAddress WHERE name = '" + studentName + "')";
            rs = selectSqlStatement(SQL);

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

    public int getCertificatePercentage(String gender) {
        if (InputCheck.INSTANCE.getCertificatePercentageInputCheck()) {
            return 0;
        }
        //TODO: Implement Certificate Percentage
        return 0;
    }
}


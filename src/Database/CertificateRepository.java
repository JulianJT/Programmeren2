package Database;

import Domain.Certificate;
import GUI.AddCertificateScene;
import GUI.GetCertificateScene;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CertificateRepository extends DatabaseConnection {

    public void addCertificate() {
        String userName = AddCertificateScene.getUserName();
        String studentName = AddCertificateScene.getStudentName();
        String course = AddCertificateScene.getCourse();
        String review = AddCertificateScene.getReview();

        if (InputCheck.INSTANCE.addCertificateInputCheck(course, userName, studentName, review)) {
            return;
        }

        String SQL = "INSERT INTO Certificate (review, nameWorker) VALUES(" + review + ",'" + userName + "')";
        executeSqlStatement(SQL);
    }

    public List<Certificate> getCertificate() {
        ArrayList<Certificate> certificates = new ArrayList<>();
        String studentName = GetCertificateScene.getStudentName();
        ResultSet rs;

        try {

            String SQL = "SELECT certificateID, review, nameWorker FROM Certificate WHERE certificateID IN ( SELECT certificateID FROM Registration INNER JOIN Student ON Registration.emailAddress = Student.emailAddress WHERE name = '" + studentName + "')";
            rs = executeSqlStatement(SQL);

            while (rs.next()) {
                String nameWorker = rs.getString("nameWorker");
                int review = rs.getInt("review");
                int id = rs.getInt("certificateID");

                certificates.add(new Certificate(id, review, nameWorker));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return certificates;
    }

    public int getCertificatePercentage() {
        String gender = GetCertificateScene.getGender();
        if (InputCheck.INSTANCE.getCertificatePercentageInputCheck()) {
            return 0;
        }
        //TODO: Implement Certificate Percentage
        return 0;
    }
}


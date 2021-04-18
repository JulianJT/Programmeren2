package Database;

import Domain.Certificate;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

// This class contains methods that executes and builds queries for Certificate

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
        ResultSet rs;
        int x = 0;
        int y = 0;

        if (gender == "Male") {
            try {
                String SQL = "SELECT gender FROM Student LEFT JOIN Registration ON Student.emailAddress = Registration.emailAddress " +
                        "LEFT JOIN Certificate ON Registration.certificateID = Certificate.certificateID " +
                        "WHERE gender = 'Male' AND Certificate.certificateID IS NOT NULL";
                rs = executeSelectStatement(SQL);
                System.out.println(SQL);

                while (rs.next()) {
                    x++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                String SQL = "SELECT gender FROM Student LEFT JOIN Registration ON Student.emailAddress = Registration.emailAddress " +
                        "LEFT JOIN Certificate ON Registration.certificateID = Certificate.certificateID " +
                        "WHERE gender = 'Female' AND Certificate.certificateID IS NOT NULL";
                rs = executeSelectStatement(SQL);
                System.out.println(SQL);

                while (rs.next()) {
                    y++;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            closeConnection();
            int xy = x+y;
            int z = (x*100);
            int w = z/xy;

            return w;
        } else if (gender == "Female") {

            try {
                String SQL = "SELECT gender FROM Student LEFT JOIN Registration ON Student.emailAddress = Registration.emailAddress " +
                        "LEFT JOIN Certificate ON Registration.certificateID = Certificate.certificateID " +
                        "WHERE gender = 'Female' AND Certificate.certificateID IS NOT NULL";
                rs = executeSelectStatement(SQL);
                System.out.println(SQL);

                while (rs.next()) {
                    y++;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                String SQL = "SELECT gender FROM Student LEFT JOIN Registration ON Student.emailAddress = Registration.emailAddress " +
                        "LEFT JOIN Certificate ON Registration.certificateID = Certificate.certificateID " +
                        "WHERE gender = 'Male' AND Certificate.certificateID IS NOT NULL";
                rs = executeSelectStatement(SQL);
                System.out.println(SQL);

                while (rs.next()) {
                    x++;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            closeConnection();

            int xy = x+y;
            int z = (y*100);
            int w = z/xy;

            return w;

        }else{
            return 0;
        }
    }
}
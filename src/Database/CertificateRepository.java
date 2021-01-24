package Database;

import Domain.Certificate;
import GUI.AddCertificateScene;
import GUI.GetCertificateScene;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CertificateRepository {

    public void addCertificate() {

        CertificateInputCheck checkInput = new CertificateInputCheck();

        if (checkInput.addCheckInput()) {
            return;
        }

        String userName = AddCertificateScene.getUserName();
        String studentName = AddCertificateScene.getStudentName();
        String course = AddCertificateScene.getCourse();
        int review = Integer.parseInt(AddCertificateScene.getReview());

        String connectionUrl = "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=QuatroOpdracht;user=sa;password=12345;portNumber=1433\n;";
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl);

            String SQL = "INSERT INTO Certificate (review, nameWorker) VALUES(" + review + ",'" + userName + "')";

            stmt = con.createStatement();

            rs = stmt.executeQuery(SQL);

            System.out.print(String.format("| %7s | %-32s | %-24s |\n", " ", " ", " ").replace(" ", "-"));

        } catch (Exception e) {

        } finally {
            if (rs != null) try {
                rs.close();
            } catch (Exception e) {
            }
            if (stmt != null) try {
                stmt.close();
            } catch (Exception e) {
            }
            if (con != null) try {
                con.close();
            } catch (Exception e) {
            }
        }
    }

    public List<Certificate> getCertificate() {

        ArrayList<Certificate> certificates = new ArrayList<>();
        String studentName = GetCertificateScene.getStudentName();

        String connectionUrl = "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=QuatroOpdracht;user=sa;password=12345;portNumber=1433\n;";
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl);

            String SQL = "SELECT certificateID, review, nameWorker FROM Certificate WHERE certificateID IN ( SELECT certificateID FROM Registration INNER JOIN Student ON Registration.emailAddress = Student.emailAddress WHERE name = '" + studentName + "')";
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                String nameWorker = rs.getString("nameWorker");
                int review = rs.getInt("review");
                int id = rs.getInt("certificateID");

                Certificate certificate = new Certificate(id, review, nameWorker);
                certificates.add(certificate);

            }

        } catch (Exception e) {

        } finally {
            if (rs != null) try {
                rs.close();
            } catch (Exception e) {
            }
            if (stmt != null) try {
                stmt.close();
            } catch (Exception e) {
            }
            if (con != null) try {
                con.close();
            } catch (Exception e) {
            }
        }

        return certificates;

    }

    public int getCertificatePercentage() {
        String gender = GetCertificateScene.getGender();

        CertificateInputCheck checkInput = new CertificateInputCheck();

        if (checkInput.getGenderCheckInput()) {
            return 0;
        }

        String connectionUrl = "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=QuatroOpdracht;user=sa;password=12345;portNumber=1433\n;";
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl);
            String SQL = "SELECT COUNT(emailAddress), COUNT(certificateID) FROM Registration WHERE emailAddress IN ( SELECT emailAddress FROM Student WHERE gender = '" + gender + "')";
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                int registrations = rs.getInt(1);
                int certificates = rs.getInt(2);
                return certificates / registrations * 100;
            }
        } catch (Exception e) {

        } finally {
            if (rs != null) try {
                rs.close();
            } catch (Exception e) {
            }
            if (stmt != null) try {
                stmt.close();
            } catch (Exception e) {
            }
            if (con != null) try {
                con.close();
            } catch (Exception e) {
            }
        }

        return 0;
    }
}


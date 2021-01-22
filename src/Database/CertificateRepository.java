package Database;

import Domain.Certificate;
import Domain.Registration;
import GUI.AddCertificateScene;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class CertificateRepository {


    public void addCertificate() {

        //CertificateInputCheck checkInput = new CertificateInputCheck();
        //checkInput.checkInput();

        //if (checkInput.checkInput()) {
        //    return;
        //}

        String userName = AddCertificateScene.getUserName();
        String studentName = AddCertificateScene.getStudentName();
        String registration = AddCertificateScene.getRegistration();
        int review = AddCertificateScene.getReview();

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

        }

        // Handle any errors that may have occurred.
        catch (Exception e) {

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
}


package Database;

import Domain.Certificate;
import Domain.Registration;
import Domain.Student;
import GUI.AddCertificateScene;
import GUI.GetCertificateScene;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class CertificateRepository {

    public void addCertificate() {

        CertificateInputCheck checkInput = new CertificateInputCheck();

        if (checkInput.addCheckInput()) {
            return;
        }

        String userName = AddCertificateScene.getUserName();
        String studentName = AddCertificateScene.getStudentName();
        String registration = AddCertificateScene.getRegistration();
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

    public List<Certificate> getCertificate() {

        ArrayList<Certificate> certificates = new ArrayList<>();
        String studentName = GetCertificateScene.getStudentName();

        // Dit zijn de instellingen voor de verbinding. Vervang de databaseName indien deze voor jou anders is.
        String connectionUrl = "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=QuatroOpdracht;user=sa;password=12345;portNumber=1433\n;";

        // Connection beheert informatie over de connectie met de database.
        Connection con = null;

        // Statement zorgt dat we een SQL query kunnen uitvoeren.
        Statement stmt = null;

        // ResultSet is de tabel die we van de database terugkrijgen.
        // We kunnen door de rows heen stappen en iedere kolom lezen.
        ResultSet rs = null;

        try {
            // 'Importeer' de driver die je gedownload hebt.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Maak de verbinding met de database.
            con = DriverManager.getConnection(connectionUrl);

            // Stel een SQL query samen.
            String SQL = "SELECT certificateID, review, nameWorker FROM Certificate WHERE certificateID IN ( SELECT certificateID FROM Registration INNER JOIN Student ON Registration.emailAddress = Student.emailAddress WHERE name = '"+studentName+"')";
            stmt = con.createStatement();
            // Voer de query uit op de database.
            rs = stmt.executeQuery(SQL);


            // Als de resultset waarden bevat dan lopen we hier door deze waarden en printen ze.
            while (rs.next()) {
                // Vraag per row de kolommen in die row op.
                String nameWorker = rs.getString("nameWorker");
                int review = rs.getInt("review");
                int id = rs.getInt("certificateID");

                Certificate certificate = new Certificate(id, review, nameWorker);
                certificates.add(certificate);


                // Print de kolomwaarden.
                // System.out.println(ISBN + " " + title + " " + author);

                // Met 'format' kun je de string die je print het juiste formaat geven, als je dat wilt.
                // %d = decimal, %s = string, %-32s = string, links uitgelijnd, 32 characters breed.

            }

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

        return certificates;

    }

    public void getCertificatePercentage() {
        String gender = GetCertificateScene.getGender();
    }

}


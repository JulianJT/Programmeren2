package Database;

import Domain.Student;
import GUI.StudentInputScene;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentRepository {


//    public List<Student> getAllStudents() {
//        return null;
//    }
//
////    public Student getStudent(String email) {
//
////    }

    public void addStudent() {

        StudentInputCheck checkInput = new StudentInputCheck();
        checkInput.checkInput();

        if (checkInput.checkInput()) {
            return;
        }

        String userName = StudentInputScene.getUsername();
        String email = StudentInputScene.getEmail();
        Date birthday = StudentInputScene.getBirthday();
        String gender = StudentInputScene.getGender();
        String address = StudentInputScene.getAddress();
        String residence = StudentInputScene.getResidence();
        String country = StudentInputScene.getCountry();

        // Checks if gender is either Male or Female, ignoring case.

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
            String SQL = "INSERT INTO Student (emailAddress, name, dateOfBirth, gender, address, residence, country) VALUES('" + email + "','" + userName + "','" + birthday + "','" + gender + "','" + address + "','" + residence + "','" + country + "')";
            stmt = con.createStatement();
            // Voer de query uit op de database.
            rs = stmt.executeQuery(SQL);

            System.out.print(String.format("| %7s | %-32s | %-24s |\n", " ", " ", " ").replace(" ", "-"));

            // Als de resultset waarden bevat dan lopen we hier door deze waarden en printen ze.
            while (rs.next()) {
                // Vraag per row de kolommen in die row op.
                String title = rs.getString("name");
                String author = rs.getString("emailAddress");

                // Print de kolomwaarden.
                // System.out.println(ISBN + " " + title + " " + author);

                // Met 'format' kun je de string die je print het juiste formaat geven, als je dat wilt.
                // %d = decimal, %s = string, %-32s = string, links uitgelijnd, 32 characters breed.
                System.out.format("| %7d | %-32s | %-24s | \n", title, author);
            }
            System.out.println(String.format("| %7s | %-32s | %-24s |\n", " ", " ", " ").replace(" ", "-"));

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

        System.out.println(userName + " was added to the database.");
        System.out.println(userName + " " + gender + " " + residence + " " + country + " " + address + " " + birthday);

}

    // build UI, register event handlers, etc etc

}

//    public void updateStudent(Student student) {

//    }

//    public void deleteStudent(Student student) {

//    }



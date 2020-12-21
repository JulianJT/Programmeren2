package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.image.Image ;

import java.io.FileInputStream;
import java.sql.*;

// Als je dit ziet werkt het goed.

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Image image = new Image(new FileInputStream(""));
        //Setting the image view
        ImageView imageView = new ImageView(image);
        //Setting the position of the image
        imageView.setX(500);
        imageView.setY(75);
        //setting the fit height and width of the image view
        imageView.setFitHeight(103);
        imageView.setFitWidth(489);

        Button student = new Button("Add student");
        Button addStudents = new Button("Add student(s)");
        Button removeStudents = new Button("Remove Student(s)");
        Button viewStudents = new Button("View Student(s)");
        Button viewProfile = new Button("View profile");
        Button backStudent = new Button("Back");

        Button course = new Button("Add course");
        Button registration = new Button("Add registration");
        Button certificate = new Button("Add certificate");

        Button apply = new Button("Apply");
        Button cancel = new Button("Cancel");
        Button backFromInput = new Button("Back");

        VBox mainPage = new VBox();
            mainPage.setSpacing(10);
            mainPage.getChildren().addAll(student, course, registration, certificate);

        Text t = new Text();
            t.setFont(new Font(20));
            t.setWrappingWidth(200);
            t.setTextAlignment(TextAlignment.JUSTIFY);
            t.setText("This is the CC Statistics app.");

        GridPane studentPage = new GridPane();
            studentPage.setVgap(8);
            studentPage.setHgap(8);
            Scene studentPageSc = new Scene(studentPage, 500, 200);

            studentPage.add(addStudents, 0, 0);
            studentPage.add(removeStudents, 0,1);
            studentPage.add(viewStudents, 1,0);
            studentPage.add(viewProfile, 1,1);
            studentPage.add(backStudent,0,3);

        TextField email = new TextField();
            TextField fullName = new TextField();
            TextField dateOfBirth = new TextField();
            TextField gender = new TextField();
            TextField address = new TextField();
            TextField residence = new TextField();
            TextField country = new TextField();


            Label emailText = new Label("E-mail Address");
            Label nameText = new Label("Full name");
            Label birthdayText = new Label("Date of birth");
            Label genderText = new Label("Gender");
            Label addressText = new Label("Address");
            Label residenceText = new Label("Residence");
            Label countryText = new Label("Country");

        GridPane studentInput = new GridPane();
            Scene studentInputView = new Scene(studentInput, 500, 200);
            studentInput.add(emailText, 0,0);
            studentInput.add(email, 0,1);
            studentInput.add(nameText,0,2);
            studentInput.add(fullName,0,3);
            studentInput.add(birthdayText,0,4);
            studentInput.add(dateOfBirth,0,5);
            studentInput.add(genderText,0,6);
            studentInput.add(gender,0,7);
            studentInput.add(addressText,1,0);
            studentInput.add(address,1,1);
            studentInput.add(residenceText,1, 2);
            studentInput.add(residence,1,3);
            studentInput.add(countryText,1,4);
            studentInput.add(country,1,5);
            studentInput.add(backFromInput, 0,8);
            studentInput.add(apply, 1,8);
            studentInput.add(cancel,2,8);

        BorderPane layout = new BorderPane();
            layout.setTop(imageView);
            layout.setRight(t);
            layout.setLeft(mainPage);


        student.setOnAction((event) -> {
            primaryStage.setScene(studentPageSc);
        });

        addStudents.setOnAction((event) -> {
            primaryStage.setScene(studentInputView);
        });

        backFromInput.setOnAction((event) -> {
            primaryStage.setScene(studentPageSc);
        });


        Scene view = new Scene(layout, 500, 300);

        backStudent.setOnAction((event) -> {
            primaryStage.setScene(view);
        });

        primaryStage.setTitle("CC Statistics");
        primaryStage.setScene(view);
        primaryStage.show();


    }

    public static void main(String[] args) {

       launch(Main.class);


        // Dit zijn de instellingen voor de verbinding. Vervang de databaseName indien deze voor jou anders is.
        String connectionUrl = "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=Bibliotheek;user=sa;password=12345;portNumber=1433\n;";

        // Connection beheert informatie over de connectie met de database.
        Connection con = null;

        // Statement zorgt dat we een SQL query kunnen uitvoeren.
        Statement stmt = null;

        // ResultSet is de tabel die we van de database terugkrijgen.
        // We kunnen door de rows heen stappen en iedere kolom lezen.
        ResultSet rs = null;

        try

        {
            // 'Importeer' de driver die je gedownload hebt.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Maak de verbinding met de database.
            con = DriverManager.getConnection(connectionUrl);

            // Stel een SQL query samen.
            String SQL = "SELECT TOP 10 * FROM Boek";
            stmt = con.createStatement();
            // Voer de query uit op de database.
            rs = stmt.executeQuery(SQL);

            System.out.print(String.format("| %7s | %-32s | %-24s |\n", " ", " ", " ").replace(" ", "-"));

            // Als de resultset waarden bevat dan lopen we hier door deze waarden en printen ze.
            while (rs.next()) {
                // Vraag per row de kolommen in die row op.
                int ISBN = rs.getInt("ISBN");
                String title = rs.getString("Titel");
                String author = rs.getString("Auteur");

                // Print de kolomwaarden.
                // System.out.println(ISBN + " " + title + " " + author);

                // Met 'format' kun je de string die je print het juiste formaat geven, als je dat wilt.
                // %d = decimal, %s = string, %-32s = string, links uitgelijnd, 32 characters breed.
                System.out.format("| %7d | %-32s | %-24s | \n", ISBN, title, author);
            }
            System.out.println(String.format("| %7s | %-32s | %-24s |\n", " ", " ", " ").replace(" ", "-"));

        }

        // Handle any errors that may have occurred.
        catch(
                Exception e)

        {
            e.printStackTrace();
        }
        finally

        {
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


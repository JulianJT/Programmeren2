package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
import java.sql.Date;

import java.io.FileInputStream;
import java.sql.*;

public class UserInterface extends Application {

        public static String userName;
        public static String email;
        public static Date birthday;
        public static String gender;
        public static String address;
        public static String residence;
        public static String country;

        @Override
        public void start (Stage primaryStage) throws Exception {
            Image image = new Image(new FileInputStream("C:\\Users\\jdtji\\Desktop\\download.png"));
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
            studentPage.add(removeStudents, 0, 1);
            studentPage.add(viewStudents, 1, 0);
            studentPage.add(viewProfile, 1, 1);
            studentPage.add(backStudent, 0, 3);

            TextField email = new TextField();
            TextField fullName = new TextField();
            DatePicker datePicker = new DatePicker();
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
            studentInput.add(emailText, 0, 0);
            studentInput.add(email, 0, 1);
            studentInput.add(nameText, 0, 2);
            studentInput.add(fullName, 0, 3);
            studentInput.add(birthdayText, 0, 4);
            studentInput.add(datePicker, 0, 5);
            studentInput.add(genderText, 0, 6);
            studentInput.add(gender, 0, 7);
            studentInput.add(addressText, 1, 0);
            studentInput.add(address, 1, 1);
            studentInput.add(residenceText, 1, 2);
            studentInput.add(residence, 1, 3);
            studentInput.add(countryText, 1, 4);
            studentInput.add(country, 1, 5);
            studentInput.add(backFromInput, 0, 8);
            studentInput.add(apply, 1, 8);
            studentInput.add(cancel, 2, 8);

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


            apply.setOnAction((event) -> {

                userName = fullName.getText();
                this.email = email.getText();
                this.gender = gender.getText();
                this.address = address.getText();
                this.residence = residence.getText();
                this.country = country.getText();

                // Tries to assign value to birthday, if birthday is empty an error dialogue will appear.
                try {

                    birthday = java.sql.Date.valueOf(datePicker.getValue());

                } catch (NullPointerException e){

                    System.out.println("Birthday is empty");

                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Dialog");
                    alert.setHeaderText("Oh no, an Error occurred!");
                    alert.setContentText("Birthday is empty.");

                    alert.showAndWait();


                    return;

                }

                // Checks if gender is either Male or Female, ignoring case.
                if (!this.gender.equalsIgnoreCase("Male") || this.gender.equalsIgnoreCase("Female")) {

                    System.out.println("Invalid gender error occurred!");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Dialog");
                    alert.setHeaderText("Oh no, an Error occurred!");
                    alert.setContentText("Invalid gender specified.");

                    alert.showAndWait();
                    return;
                }



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
                    String SQL = "INSERT INTO Student (emailAddress, name, dateOfBirth, gender, address, residence, country) VALUES('" + this.email + "','" + userName + "','" + birthday + "','" + this.gender + "','" + this.address + "','" + this.residence + "','" + this.country + "')";
                    stmt = con.createStatement();
                    // Voer de query uit op de database.
                    rs = stmt.executeQuery(SQL);

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

                System.out.println(userName + "was added to the database.");
            });


            Scene view = new Scene(layout, 500, 300);

            backStudent.setOnAction((event) -> {
                primaryStage.setScene(view);
            });

            primaryStage.setTitle("CC Statistics");
            primaryStage.setScene(view);
            primaryStage.show();

            Button viewPersonRegistrations = new Button("Select person");
            Button viewCourseRegistrations = new Button("Select course");
            Button backFromRegistration = new Button("Back");
            Button backFromPersonRegistration = new Button("Back");
            Button backFromCourseRegistration = new Button("Back");

            Label RegistrationText = new Label("Here you can take a look at the registration overview.");


            GridPane registrationPage = new GridPane();
            registrationPage.setVgap(8);
            registrationPage.setHgap(10);
            Scene registrationPageSc = new Scene(registrationPage, 500, 200);
            registrationPage.add(RegistrationText, 1,1);
            registrationPage.add(viewPersonRegistrations, 1,2);
            registrationPage.add(viewCourseRegistrations, 1,3);
            registrationPage.add(backFromRegistration, 1,6);


            GridPane selectPersonReg = new GridPane();
            selectPersonReg.getChildren().addAll(backFromPersonRegistration);
            Scene selectPersonRegView = new Scene(selectPersonReg, 500, 200);

            GridPane selectCourseReg = new GridPane();
            selectCourseReg.getChildren().addAll(backFromCourseRegistration);
            Scene selectCourseRegView = new Scene(selectCourseReg, 500, 200);


            registration.setOnAction((event) -> {
                primaryStage.setScene(registrationPageSc);
            });
            backFromRegistration.setOnAction((event) -> {
                primaryStage.setScene(view);
            });
            viewPersonRegistrations.setOnAction((event) -> {
                primaryStage.setScene(selectPersonRegView);
            });
            viewCourseRegistrations.setOnAction((event) -> {
                primaryStage.setScene(selectCourseRegView);
            });
            backFromPersonRegistration.setOnAction((event) -> {
                primaryStage.setScene(registrationPageSc);
            });
            backFromCourseRegistration.setOnAction((event) -> {
                primaryStage.setScene(registrationPageSc);
            });
                
                
               
                
            GridPane certificateLayout = new GridPane();
            Scene certificatePage = new Scene(certificateLayout, 500, 200);

            GridPane addCertificateLayout = new GridPane();
            Scene addCertificate = new Scene(addCertificateLayout,500, 200);


            Button add_certificate = new Button("Add Certificate");
            Button backFromCertificate = new Button("Back");
            Button backFromAddCertificate = new Button("Back");

            certificateLayout.add(backFromCertificate, 1,6);
            addCertificateLayout.add(backFromAddCertificate, 1,6);
            certificateLayout.add(add_certificate, 1,2);

            backFromCertificate.setOnAction((event) -> {
                primaryStage.setScene(view);
            });

            backFromAddCertificate.setOnAction((event) -> {
                primaryStage.setScene(certificatePage);
            });

            certificate.setOnAction((event) -> {
                primaryStage.setScene(certificatePage);
            });

            add_certificate.setOnAction((event) -> {
                primaryStage.setScene(addCertificate);
            });

        }

}





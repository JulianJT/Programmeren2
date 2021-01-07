
        package sample;

        import javafx.application.Application;
        import javafx.collections.FXCollections;
        import javafx.collections.ObservableList;
        import javafx.scene.Scene;
        import javafx.scene.control.*;
        import javafx.scene.image.ImageView;
        import javafx.scene.layout.BorderPane;
        import javafx.scene.layout.GridPane;
        import javafx.scene.layout.VBox;
        import javafx.scene.text.Font;
        import javafx.scene.text.Text;
        import javafx.scene.text.TextAlignment;
        import javafx.stage.Stage;
        import javafx.scene.image.Image ;
        import java.sql.Date;
        import java.io.FileInputStream;
        import java.sql.*;
<<<<<<< Updated upstream
        import javafx.scene.layout.HBox;
=======
        import java.sql.Connection;
        import java.sql.ResultSet;

        import javafx.beans.property.SimpleStringProperty;
        import javafx.beans.value.ObservableValue;

        import javafx.scene.control.TableColumn;
        import javafx.scene.control.TableColumn.CellDataFeatures;
        import javafx.scene.control.TableView;

        import javafx.util.Callback;
>>>>>>> Stashed changes

    public class UserInterface extends Application {

    public static String userName;
    public static String email;
    public static Date birthday;
    public static String gender;
    public static String address;
    public static String residence;
    public static String country;

        private TableView tableview;
        private ObservableList<ObservableList> data ;

        public void buildData(){

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
                String SQL = "SELECT * FROM Student";
                stmt = con.createStatement();
                // Voer de query uit op de database.
                rs = stmt.executeQuery(SQL);

                for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                    //We are using non property style for making dynamic table
                    final int j = i;
                    TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
                    col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                        public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {
                            return new SimpleStringProperty(param.getValue().get(j).toString());
                        }
                    });

                    tableview.getColumns().addAll(col);
                    System.out.println("Column [" + i + "] ");
                }

                /********************************
                 * Data added to ObservableList *
                 ********************************/
                int count = 0;
                while (rs.next()) {

                    //Iterate Row
                    ObservableList<String> row = FXCollections.observableArrayList();
                    for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                        //Iterate Column
                        row.add(rs.getString(i));
//                        data.add(row);
                    }
                    count+=1;

                    System.out.println("Row " + count + " added "  + row);

                }
                tableview.setItems(data);

                //FINALLY ADDED TO TableView

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error on Building Data");
            }

        }

    @Override
    public void start (Stage primaryStage) throws Exception {
<<<<<<< Updated upstream
        //Image image = new Image(new FileInputStream("C:\\Users\\jdtji\\Desktop\\download.png"));
=======

        Image image = new Image(new FileInputStream("C:\\Users\\jdtji\\Desktop\\download.png"));
>>>>>>> Stashed changes
        //Setting the image view
        //ImageView imageView = new ImageView(image);
        //Setting the position of the image
        //imageView.setX(500);
        //imageView.setY(75);
        //setting the fit height and width of the image view
        //imageView.setFitHeight(103);
        //imageView.setFitWidth(489);

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
        //layout.setTop(imageView);
        layout.setRight(t);
        layout.setLeft(mainPage);

        Button backFromStudentList = new Button("Back");
        tableview = new TableView();

        VBox students = new VBox(tableview);
        Scene studentView = new Scene(students, 560, 200);
        students.getChildren().addAll(backFromStudentList);


        backFromStudentList.setOnAction((event) -> {
            primaryStage.setScene(studentPageSc);
        });


        student.setOnAction((event) -> {
            primaryStage.setScene(studentPageSc);
        });

        addStudents.setOnAction((event) -> {
            primaryStage.setScene(studentInputView);
        });

        backFromInput.setOnAction((event) -> {
            primaryStage.setScene(studentPageSc);
        });


        viewStudents.setOnAction((event) -> {
            buildData();
            primaryStage.setScene(studentView);


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
            if (!(this.gender.equalsIgnoreCase("Male") || this.gender.equalsIgnoreCase("Female"))) {

                System.out.println("Invalid gender error occurred!");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Oh no, an Error occurred!");
                alert.setContentText("Invalid gender specified.");

                alert.showAndWait();
                return;
            }

            if(userName.isEmpty()) {
                System.out.println("Username was empty");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Oh no, an Error occurred!");
                alert.setContentText("Name is empty");

                alert.showAndWait();
                return;
            }

            if(this.email.isEmpty()) {
                System.out.println("Email was empty");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Oh no, an Error occurred!");
                alert.setContentText("Email is empty");

                alert.showAndWait();
                return;
            }

            if(this.address.isEmpty()) {
                System.out.println("Address was empty!");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Oh no, an Error occurred!");
                alert.setContentText("Address is empty");

                alert.showAndWait();
                return;
            }

            if(this.residence.isEmpty()) {
                System.out.println("Residence was empty!");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Oh no, an Error occurred!");
                alert.setContentText("Residence is empty");

                alert.showAndWait();
                return;
            }

            if(this.country.isEmpty()) {
                System.out.println("Country was empty!");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Oh no, an Error occurred!");
                alert.setContentText("Country is empty");

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

        backFromCourseRegistration.setOnAction((event) -> {
            primaryStage.setScene(registrationPageSc);
        });

        // Certificate Part starts here...
        BorderPane certificateLayout =new BorderPane();
        VBox mainCertVBox = new VBox();
        HBox certButtonHBox = new HBox();
        Scene certificatePage = new Scene(certificateLayout,500, 300);

        Text certificateText = new Text();
        certificateText.setFont(new Font(30));
        certificateText.setTextAlignment(TextAlignment.JUSTIFY);
        certificateText.setText("Certificate Menu");

        Button addCertificate = new Button("Add Certificate");
        Button getCertificate = new Button("View Certificates");
        Button backFromCertificate = new Button("Back");
        // Add Most Given Certificates (top 3)

        mainCertVBox.setSpacing(10);
        mainCertVBox.getChildren().addAll(certificateText, certButtonHBox, backFromCertificate);
        certButtonHBox.setSpacing(10);
        certButtonHBox.getChildren().addAll(addCertificate, getCertificate);

        certificateLayout.setLeft(mainCertVBox);


        BorderPane getCertificateLayout = new BorderPane();
        VBox getCertVBox = new VBox();
        HBox radioHBox = new HBox();
        HBox buttonHBox = new HBox();
        Scene getCertificatePage = new Scene(getCertificateLayout, 500, 300);

        Text getCertText = new Text();
        getCertText.setFont(new Font(15));
        getCertText.setTextAlignment(TextAlignment.JUSTIFY);
        getCertText.setText("Here you can view the percentages of students that achieved a certificate.");

        RadioButton male = new RadioButton("Male");
        RadioButton female = new RadioButton("Female");
        Button backFromGetCertificate = new Button("Back");
        Button search = new Button("Search");

        getCertificateLayout.setLeft(getCertVBox);

        getCertVBox.setSpacing(10);
        getCertVBox.getChildren().addAll(getCertText, radioHBox, buttonHBox);
        radioHBox.setSpacing(10);
        radioHBox.getChildren().addAll(male, female);
        buttonHBox.setSpacing(10);
        buttonHBox.getChildren().addAll(search, backFromGetCertificate);

        // Implement getting certificates from specific student (name).


        BorderPane addCertificateLayout = new BorderPane();
        VBox addCertVBox = new VBox();
        Scene addCertificatePage = new Scene(addCertificateLayout, 500, 300);

        Text addCertText = new Text();
        addCertText.setFont(new Font(18));
        addCertText.setTextAlignment(TextAlignment.JUSTIFY);
        addCertText.setText("Here you can add certificates to students.");

        Button applyToDB = new Button("Apply");
        Button cancelCert = new Button("Cancel");
        Button backFromAddCertificate = new Button("Back");
        TextField studentName = new TextField();
        TextField review = new TextField(); // Has to be [0-10]
        TextField workerName = new TextField();
        TextField registrationName = new TextField();

        Label nameStudentText = new Label("Student Name");
        Label reviewText = new Label("Review [0-10]");
        Label workerNameText = new Label("Full Name");
        Label registrationText = new Label("Registration");

        GridPane addCertificateInput = new GridPane();
        addCertificateInput.add(workerNameText,0,0);
        addCertificateInput.add(workerName,0,1);
        addCertificateInput.add(nameStudentText, 1, 0);
        addCertificateInput.add(studentName, 1, 1);
        addCertificateInput.add(registrationText, 0, 2);
        addCertificateInput.add(registrationName, 0, 3);
        addCertificateInput.add(reviewText, 1, 2);
        addCertificateInput.add(review, 1, 3);

        addCertificateInput.add(backFromAddCertificate, 0, 4);
        addCertificateInput.add(apply, 1, 4);

        addCertificateLayout.setLeft(addCertVBox);

        addCertificateInput.setHgap(8);
        addCertificateInput.setVgap(8);
        addCertVBox.setSpacing(10);
        addCertVBox.getChildren().addAll(addCertText, addCertificateInput);

        
        backFromGetCertificate.setOnAction((event) -> {
            primaryStage.setScene(certificatePage);
        });

        certificate.setOnAction((event) -> {
            primaryStage.setScene(certificatePage);
        });

        getCertificate.setOnAction((event) -> {
            primaryStage.setScene(getCertificatePage);
        });

        addCertificate.setOnAction((event) -> {
            primaryStage.setScene(addCertificatePage);
        });

        backFromCertificate.setOnAction((event) -> {
            primaryStage.setScene(view);
        });

        backFromAddCertificate.setOnAction((event) -> {
            primaryStage.setScene(certificatePage);
        });

    }

}





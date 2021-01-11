package GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class StartScene extends Application {
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

        BorderPane layout = new BorderPane();

        layout.setRight(t);
        layout.setLeft(mainPage);

        Scene view = new Scene(layout, 500, 300);

        primaryStage.setTitle("CC Statistics");
        primaryStage.setScene(view);
        primaryStage.show();

        student.setOnAction((event) -> {
            StudentScene students = new StudentScene();
            primaryStage.getScene().setRoot(students.getRootPane());
        });
       }


}
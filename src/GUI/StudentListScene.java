package GUI;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Database.StudentRepository;
import Domain.Student;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
import java.util.ArrayList;

class StudentListScene {

    private static GridPane list;
    private static ListView listView;

    public StudentListScene(){

        list = new GridPane();
        Button back = new Button("back");

        StudentRepository stlist = new StudentRepository();

        ObservableList<Student> names = FXCollections.observableArrayList(stlist.getAllStudents());
        listView = new ListView<>(names);
        listView.setPrefWidth(500);

        list.add(listView, 0, 0);
        list.add(back,0,1);

        back.setOnAction((event) -> {
            list.getScene().setRoot(StudentScene.getRootPane());
        });
    }

    public static GridPane getStudentTable() {
        return list;
    }

}

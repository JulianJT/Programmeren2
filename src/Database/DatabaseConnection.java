package Database;

import javafx.scene.control.Alert;

import java.sql.*;

// This class creates the connection to the database.

public class DatabaseConnection {
    private final static String DBNAME = "QuatroOpdracht";
    private final static String USER = "sa";
    private final static String PASSWORD = "12345";
    private final static String PORTNR = "1433";
    private final static String URL = "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=" + DBNAME + ";user=" + USER + ";password=" + PASSWORD + ";portNumber=" + PORTNR + ";";

    private Statement stmt = null;
    private Connection con = null;
    private ResultSet rs = null;

    // executes SELECT statements, returns results.
    protected ResultSet executeSelectStatement(String SQL) {
        try {

            con = getConnection();
            if (con != null) {
                stmt = con.createStatement();
                rs = stmt.executeQuery(SQL);
                return rs;
            }

        } catch (Exception e) {
            e.printStackTrace();
            closeConnection();
        }
        return null;
    }

    // executes INSERT statements
    protected boolean executeInsertStatement(String SQL) {
        boolean bl = false;
        try {
            con = getConnection();
            if (con != null) {
                stmt = con.createStatement();
                stmt.execute(SQL);
                bl = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            closeConnection();
        }
        return bl;
    }

    // executes UPDATE statements
    protected int executeUpdateStatement(String SQL) {
        try {
            con = getConnection();
            if (con != null) {
                stmt = con.createStatement();
                return stmt.executeUpdate(SQL);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return 0;
    }

    // sets up database connection
    private Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(URL);
    }

    // closes database connection
    protected void closeConnection() {
        if (rs != null) try {
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (stmt != null) try {
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (con != null) try {
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // shows confirmation dialogs
    protected void showInfo(String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Task completed.");
        alert.setContentText(content);
        alert.showAndWait();
    }

    // shows error dialogs
    protected void showError(String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Dialog");
        alert.setHeaderText("Oh no, an error occurred!");
        alert.setContentText(content);
        alert.showAndWait();
    }
}

package Database;

import javafx.scene.control.Alert;

import java.sql.*;

public class DatabaseConnection {
    private final static String DBNAME = "QuatroOpdracht";
    private final static String USER = "sa";
    private final static String PASSWORD = "12345";
    private final static String PORTNR = "1433";
    private final static String URL = "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=" + DBNAME + ";user=" + USER + ";password=" + PASSWORD + ";portNumber=" + PORTNR + ";";

    private Statement stmt = null;
    private Connection con = null;
    private ResultSet rs = null;

    protected ResultSet executeSelectStatement(String SQL) {
        try {
            con = getConnection();
            if (con != null) {
                stmt = con.createStatement();
                rs = stmt.executeQuery(SQL);
                return rs;
            }
        } catch (Exception e) {
            closeConnection();
        }
        return null;
    }

    protected void executeInsertStatement(String SQL) {
        try {
            con = getConnection();
            if (con != null) {
                stmt = con.createStatement();
                stmt.executeQuery(SQL);
            }
        } catch (Exception ignored) {
        } finally {
            closeConnection();
        }
    }

    protected int executeUpdateStatement(String SQL) {
        try {
            con = getConnection();
            if (con != null) {
                stmt = con.createStatement();
                return stmt.executeUpdate(SQL);
            }
        } catch (Exception ignored) {
        } finally {
            closeConnection();
        }
        return 0;
    }

    private Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(URL);
    }

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

    protected void showInfo(String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Task completed.");
        alert.setContentText(content);
        alert.showAndWait();
    }

    protected void showError(String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Dialog");
        alert.setHeaderText("Oh no, an error occurred!");
        alert.setContentText(content);
        alert.showAndWait();
    }
}

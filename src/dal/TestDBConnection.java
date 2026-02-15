package dal;

import java.sql.Connection;
import java.sql.SQLException;

public class TestDBConnection {

    public static void main(String[] args) {

        try {
            DatabaseConnection db = DatabaseConnection.getInstance();
            Connection conn = db.getConnection();

            if (conn != null && !conn.isClosed()) {
                System.out.println("Database Connected Successfully!");
            } else {
                System.out.println("Database Connection Failed!");
            }

        } catch (SQLException e) {
            System.out.println("Error while testing connection");
            e.printStackTrace();
        }
    }
}

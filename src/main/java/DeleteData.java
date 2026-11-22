import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteData {
    public static void main(String[] args) {
        String DB_URL = "jdbc:mysql://localhost/college";
        int ID = 2;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, "root", "root_pass123");

            Statement stmt = conn.createStatement();
            int isDeleteQuerySuccess = stmt.executeUpdate("DELETE FROM student WHERE id = " + ID);

            if (isDeleteQuerySuccess == 0) {
                System.out.println("ID not found: " + ID);
            } else {
                System.out.println("Data with ID " + ID + " deleted successfully!");
            }

            stmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

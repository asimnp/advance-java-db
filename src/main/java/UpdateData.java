import java.sql.*;

public class UpdateData {
    public static void main(String[] args) {
        String DB_URL = "jdbc:mysql://localhost/college";
        int ID = 2;
        try {
           Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, "root", "root_pass123");

            Statement stmt = conn.createStatement();
            int isUpdateQuerySuccess = stmt.executeUpdate("UPDATE student SET name = 'Tom Will' WHERE id = " + ID);

            if (isUpdateQuerySuccess == 0) {
                System.out.println("ID not found: " + ID);
            } else {
                System.out.println("Date updated successfully!");

                ResultSet rs = stmt.executeQuery("SELECT * FROM student WHERE id = " + ID);
                rs.next();
                System.out.println("Name: " + rs.getString("name"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

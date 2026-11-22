import java.sql.*;

public class Main {
    public static void main(String[] args)  {
        String DB_URL = "jdbc:mysql://localhost/college";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, "root", "root_pass123");

            System.out.println("DB Connected!");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

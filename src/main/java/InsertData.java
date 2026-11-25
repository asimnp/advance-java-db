import java.sql.*;

public class InsertData {
    public static void main(String[] args)  {
        String DB_URL = "jdbc:mysql://localhost/college";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, "root", "root_pass123");

            Statement stmt =  conn.createStatement();
            stmt.executeUpdate("INSERT INTO student (name, bio, age) VALUES ('Tom', 'Observer', 28)");

            System.out.println("Data inserted successfully !");

            stmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

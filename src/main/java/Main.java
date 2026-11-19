import java.sql.*;

public class Main {
    public static void main(String[] args)  {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("DB Connected!");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}


import javax.swing.*;
import java.sql.*;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Swing with DB");

        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JLabel name = new JLabel("Name:");
        JTextField nameInput = new JTextField(20);

        JLabel bio = new JLabel("Bio:");
        JTextArea bioInput = new JTextArea(5, 20);

        JLabel age = new JLabel("Age:");
        JTextField ageInput = new JTextField(20);

        JButton submitBtn = new JButton("Submit");

        JPanel panel = new JPanel();

        panel.add(name);
        panel.add(nameInput);

        panel.add(bio);
        panel.add(bioInput);

        panel.add(age);
        panel.add(ageInput);

        panel.add(submitBtn);

        frame.add(panel);

        submitBtn.addActionListener(e -> {

            String nameValue = nameInput.getText();
            String bioValue = bioInput.getText();
            String ageValue = ageInput.getText();

            String DB_URL = "jdbc:mysql://localhost/college";

            String sql = "INSERT INTO student (name, bio, age) VALUES (?, ?, ?)";

            try {
                // Load MySQL driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Connect to database
                Connection conn = DriverManager.getConnection(
                        DB_URL, "root", "root_pass123"
                );

                // Prepare SQL query
                PreparedStatement pstmt = conn.prepareStatement(sql);

                // Set values
                pstmt.setString(1, nameValue);
                pstmt.setString(2, bioValue);
                pstmt.setInt(3, Integer.parseInt(ageValue));

                // Execute query
                pstmt.executeUpdate();

                JOptionPane.showMessageDialog(
                        frame,
                        "Data inserted successfully!"
                );

                // Clear input fields
                nameInput.setText("");
                bioInput.setText("");
                ageInput.setText("");

                pstmt.close();
                conn.close();

            } catch (ClassNotFoundException | SQLException ex) {

                JOptionPane.showMessageDialog(
                        frame,
                        ex.getMessage(),
                        "Database Error",
                        JOptionPane.ERROR_MESSAGE
                );

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Please enter a valid age!"
                );
            }
        });

        frame.setVisible(true);
    }
}

import java.sql.*;

public class HelpdeskApp {
    public static void main(String[] args) {
        try {
            
            Class.forName("oracle.jdbc.driver.OracleDriver");

            
            Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe", 
                "system",        // Your Oracle username
                "dbms123"       // Your Oracle password
            );

            System.out.println("Connected to Oracle Database!");

            
            String insertSQL = "INSERT INTO tickets (employee_id, issue, status) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(insertSQL);
            pstmt.setInt(1, 1);  // assuming employee_id 1 exists
            pstmt.setString(2, "System crash issue");
            pstmt.setString(3, "Open");
            int rowsInserted = pstmt.executeUpdate();

            System.out.println(rowsInserted + " ticket(s) inserted.");

            conn.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}

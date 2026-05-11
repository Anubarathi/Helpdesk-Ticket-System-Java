import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    static String url = "jdbc:mysql://localhost:3306/helpdesk_ticket";
    static String username = "root";
    static String password = "your_password";

    public static Connection getConnection() {

        try {
            Connection con = DriverManager.getConnection(url, username, password);
            return con;
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }
}

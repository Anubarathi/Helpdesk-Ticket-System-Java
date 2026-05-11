import java.sql.*;

public class TicketDAO {

    public void addTicket(Ticket t) {

        try {
            Connection con = DBConnection.getConnection();

            String query = "INSERT INTO tickets(customer_name, issue_description, status) VALUES(?,?,?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, t.customerName);
            ps.setString(2, t.issueDescription);
            ps.setString(3, t.status);

            ps.executeUpdate();

            System.out.println("Ticket Added!");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void viewTickets() {

        try {
            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM tickets";

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(query);

            while(rs.next()) {

                System.out.println(
                    rs.getInt("id") + " | " +
                    rs.getString("customer_name") + " | " +
                    rs.getString("issue_description") + " | " +
                    rs.getString("status")
                );
            }

        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public void updateTicket(int id, String status) {

        try {
            Connection con = DBConnection.getConnection();

            String query = "UPDATE tickets SET status=? WHERE id=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, status);
            ps.setInt(2, id);

            ps.executeUpdate();

            System.out.println("Ticket Updated!");

        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public void deleteTicket(int id) {

        try {
            Connection con = DBConnection.getConnection();

            String query = "DELETE FROM tickets WHERE id=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);

            ps.executeUpdate();

            System.out.println("Ticket Deleted!");

        } catch(Exception e) {
            System.out.println(e);
        }
    }
}

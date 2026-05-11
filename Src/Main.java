import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        TicketDAO dao = new TicketDAO();

        while(true) {

            System.out.println("\nHELPDESK SYSTEM");
            System.out.println("1. Add Ticket");
            System.out.println("2. View Tickets");
            System.out.println("3. Update Ticket");
            System.out.println("4. Delete Ticket");
            System.out.println("5. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {

                case 1:

                    System.out.print("Customer Name: ");
                    String name = sc.nextLine();

                    System.out.print("Issue: ");
                    String issue = sc.nextLine();

                    System.out.print("Status: ");
                    String status = sc.nextLine();

                    dao.addTicket(new Ticket(name, issue, status));

                    break;

                case 2:

                    dao.viewTickets();

                    break;

                case 3:

                    System.out.print("Ticket ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("New Status: ");
                    String newStatus = sc.nextLine();

                    dao.updateTicket(id, newStatus);

                    break;

                case 4:

                    System.out.print("Ticket ID: ");
                    int deleteId = sc.nextInt();

                    dao.deleteTicket(deleteId);

                    break;

                case 5:

                    System.exit(0);
            }
        }
    }
}

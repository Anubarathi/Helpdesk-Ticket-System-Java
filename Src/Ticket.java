public class Ticket {

    int id;
    String customerName;
    String issueDescription;
    String status;

    public Ticket(int id, String customerName, String issueDescription, String status) {
        this.id = id;
        this.customerName = customerName;
        this.issueDescription = issueDescription;
        this.status = status;
    }

    public Ticket(String customerName, String issueDescription, String status) {
        this.customerName = customerName;
        this.issueDescription = issueDescription;
        this.status = status;
    }
}

import java.util.Scanner;

abstract class Order {
    protected int id;
    protected String description;

    public Order(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public abstract void acceptDetails();
    public abstract void displayDetails();
}

class PurchaseOrder extends Order {
    private String customerName;

    public PurchaseOrder(int id, String description, String customerName) {
        super(id, description);
        this.customerName = customerName;
    }

    @Override
    public void acceptDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Purchase Order ID: ");
        id = sc.nextInt();
        sc.nextLine();  // Consume newline
        System.out.print("Enter Description: ");
        description = sc.nextLine();
        System.out.print("Enter Customer Name: ");
        customerName = sc.nextLine();
    }

    @Override
    public void displayDetails() {
        System.out.println("Purchase Order ID: " + id);
        System.out.println("Description: " + description);
        System.out.println("Customer Name: " + customerName);
    }
}

public class OrderTest {
    public static void main(String[] args) {
        PurchaseOrder po1 = new PurchaseOrder(1, "Electronics", "Alice");
        PurchaseOrder po2 = new PurchaseOrder(2, "Furniture", "Bob");
        PurchaseOrder po3 = new PurchaseOrder(3, "Clothing", "Charlie");

        po1.displayDetails();
        po2.displayDetails();
        po3.displayDetails();
    }
}

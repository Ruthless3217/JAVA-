import java.io.*;
import java.util.Scanner;

class Employee {
    private int e_id;
    private String cname;
    private String address;
    private String mobile_no;

    // Constructor
    public Employee(int e_id, String cname, String address, String mobile_no) {
        this.e_id = e_id;
        this.cname = cname;
        this.address = address;
        this.mobile_no = mobile_no;
    }

    // Method to accept employee details
    public static Employee acceptDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Employee ID: ");
        int e_id = sc.nextInt();
        sc.nextLine();  // Consume the newline character
        System.out.print("Enter Customer Name: ");
        String cname = sc.nextLine();
        System.out.print("Enter Address: ");
        String address = sc.nextLine();
        System.out.print("Enter Mobile Number: ");
        String mobile_no = sc.nextLine();
        return new Employee(e_id, cname, address, mobile_no);
    }

    // Method to display employee details
    public void displayDetails() {
        System.out.println("Employee ID: " + e_id);
        System.out.println("Customer Name: " + cname);
        System.out.println("Address: " + address);
        System.out.println("Mobile Number: " + mobile_no);
    }

    // Method to write employee details to file
    public void writeToFile(DataOutputStream dos) throws IOException {
        dos.writeInt(e_id);
        dos.writeUTF(cname);
        dos.writeUTF(address);
        dos.writeUTF(mobile_no);
    }

    // Method to read employee details from file
    public static Employee readFromFile(DataInputStream dis) throws IOException {
        int e_id = dis.readInt();
        String cname = dis.readUTF();
        String address = dis.readUTF();
        String mobile_no = dis.readUTF();
        return new Employee(e_id, cname, address, mobile_no);
    }
}

public class EmployeeDetails {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        sc.nextLine();  // Consume the newline character
        
        // Write employee details to a file
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("employee_details.dat"));
        for (int i = 0; i < n; i++) {
            Employee emp = Employee.acceptDetails();
            emp.writeToFile(dos);
        }
        dos.close();

        // Read employee details from the file
        DataInputStream dis = new DataInputStream(new FileInputStream("employee_details.dat"));
        System.out.println("\nEmployee Details from File:");
        for (int i = 0; i < n; i++) {
            Employee emp = Employee.readFromFile(dis);
            emp.displayDetails();
        }
        dis.close();
    }
}

import java.util.Scanner;

class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;

    // Default constructor
    public Employee() {
        id = 0;
        name = "Unknown";
        department = "Unknown";
        salary = 0.0;
    }

    // Parameterized constructor
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Method to accept employee details
    public void acceptDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Employee ID: ");
        id = sc.nextInt();
        sc.nextLine();  // Consume newline
        System.out.print("Enter Employee Name: ");
        name = sc.nextLine();
        System.out.print("Enter Department: ");
        department = sc.nextLine();
        System.out.print("Enter Salary: ");
        salary = sc.nextDouble();
    }

    // Method to display employee details
    public void displayDetails() {
        System.out.println("Employee ID: " + id);
        System.out.println("Employee Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + salary);
    }

    // Method to get the salary (for Manager subclass)
    public double getSalary() {
        return salary;
    }
}

class Manager extends Employee {
    private double bonus;

    // Default constructor
    public Manager() {
        super();
        bonus = 0.0;
    }

    // Parameterized constructor
    public Manager(int id, String name, String department, double salary, double bonus) {
        super(id, name, department, salary);
        this.bonus = bonus;
    }

    // Method to accept manager details
    public void acceptManagerDetails() {
        super.acceptDetails();  // Accept employee details
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Bonus: ");
        bonus = sc.nextDouble();
    }

    // Method to display manager details
    public void displayManagerDetails() {
        super.displayDetails();  // Display employee details
        System.out.println("Bonus: " + bonus);
    }

    // Method to get the total salary (salary + bonus)
    public double getTotalSalary() {
        return getSalary() + bonus;
    }
}

public class EmployeeManagerTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of managers: ");
        int n = sc.nextInt();
        sc.nextLine();  // Consume newline

        Manager[] managers = new Manager[n];

        // Accept details for n managers
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Manager " + (i + 1) + ":");
            managers[i] = new Manager();
            managers[i].acceptManagerDetails();
        }

        // Find the manager with the maximum total salary (salary + bonus)
        Manager maxSalaryManager = managers[0];
        for (int i = 1; i < n; i++) {
            if (managers[i].getTotalSalary() > maxSalaryManager.getTotalSalary()) {
                maxSalaryManager = managers[i];
            }
        }

        // Display details of the manager with the maximum total salary
        System.out.println("\nManager with the Maximum Total Salary:");
        maxSalaryManager.displayManagerDetails();
        System.out.println("Total Salary (Salary + Bonus): " + maxSalaryManager.getTotalSalary());
    }
}

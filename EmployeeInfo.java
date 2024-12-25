import java.util.Scanner;

class Employee {
    String name;
    int age;
    String department;

    public Employee(String name, int age, String department) {
        this.name = name;
        this.age = age;
        this.department = department;
    }

    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age + ", Department: " + department);
    }
}

public class EmployeeInfo {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            System.out.println("Enter details for Employee " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();  // Consume the newline
            System.out.print("Department: ");
            String department = scanner.nextLine();

            employees[i] = new Employee(name, age, department);
        }

        System.out.println("\nEmployee Information:");
        for (Employee emp : employees) {
            emp.displayInfo();
        }

        scanner.close();
    }
}

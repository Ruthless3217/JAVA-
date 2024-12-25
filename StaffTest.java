abstract class Staff {
    protected String name;
    protected String address;

    public Staff(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public abstract void displayDetails();
}

class FullTimeStaff extends Staff {
    private String department;
    private double salary;

    public FullTimeStaff(String name, String address, String department, double salary) {
        super(name, address);
        this.department = department;
        this.salary = salary;
    }

    @Override
    public void displayDetails() {
        System.out.println("FullTime Staff - Name: " + name + ", Address: " + address + ", Department: " + department + ", Salary: " + salary);
    }
}

class PartTimeStaff extends Staff {
    private int numberOfHours;
    private double ratePerHour;

    public PartTimeStaff(String name, String address, int numberOfHours, double ratePerHour) {
        super(name, address);
        this.numberOfHours = numberOfHours;
        this.ratePerHour = ratePerHour;
    }

    @Override
    public void displayDetails() {
        System.out.println("PartTime Staff - Name: " + name + ", Address: " + address + ", Hours: " + numberOfHours + ", Rate: " + ratePerHour);
    }
}

public class StaffTest {
    public static void main(String[] args) {
        Staff fullTime = new FullTimeStaff("Alice", "New York", "HR", 60000);
        Staff partTime = new PartTimeStaff("Bob", "California", 20, 25);

        fullTime.displayDetails();
        partTime.displayDetails();
    }
}

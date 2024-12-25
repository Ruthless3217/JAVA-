class Employee {
    public void work() {
        System.out.println("Employee is working");
    }

    public double getSalary() {
        return 50000;
    }
}

class HRManager extends Employee {
    @Override
    public void work() {
        System.out.println("HR Manager is managing employee relations");
    }

    public void addEmployee() {
        System.out.println("Adding a new employee");
    }
}

public class EmployeeTest {
    public static void main(String[] args) {
        HRManager hr = new HRManager();
        hr.work();
        hr.addEmployee();
        System.out.println("HR Manager Salary: " + hr.getSalary());
    }
}

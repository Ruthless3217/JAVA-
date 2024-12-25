package operation;

public class Addition {
    public int add(int a, int b) {
        return a + b;
    }
}
package operation;

public class Subtraction {
    public int subtract(int a, int b) {
        return a - b;
    }
}
package operation;

public class Multiplication {
    public int multiply(int a, int b) {
        return a * b;
    }
}
package operation;

public class Division {
    public double divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }
        return (double) a / b;
    }
}
import operation.*;

public class Operations{
    public static void main(String[] args) {
        Addition addition = new Addition();
        Subtraction subtraction = new Subtraction();
        Multiplication multiplication = new Multiplication();
        Division division = new Division();
        
        int a = 10, b = 5;

        System.out.println("Addition: " + addition.add(a, b));
        System.out.println("Subtraction: " + subtraction.subtract(a, b));
        System.out.println("Multiplication: " + multiplication.multiply(a, b));
        try {
            System.out.println("Division: " + division.divide(a, b));
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}

// Defining the Shape interface
interface Shape {
    // Abstract method to calculate area
    double area();
}

// Circle class implements Shape interface
class Circle implements Shape {
    private final double radius;  // final variable for radius

    // Constructor to initialize radius
    public Circle(double radius) {
        this.radius = radius;
    }

    // Implementing area() method for Circle
    @Override
    public double area() {
        final double PI = 3.14159;  // final constant for PI
        return PI * radius * radius; // Area formula for Circle: PI * r^2
    }
}

// Sphere class implements Shape interface
class Sphere implements Shape {
    private final double radius;  // final variable for radius

    // Constructor to initialize radius
    public Sphere(double radius) {
        this.radius = radius;
    }

    // Implementing area() method for Sphere
    @Override
    public double area() {
        final double PI = 3.14159;  // final constant for PI
        return 4 * PI * radius * radius; // Surface area formula for Sphere: 4 * PI * r^2
    }
}

public class ShapeFinal {
    public static void main(String[] args) {
        // Create a Circle object with a given radius
        Shape circle = new Circle(5.0);  // radius = 5
        System.out.println("Area of Circle: " + circle.area());

        // Create a Sphere object with a given radius
        Shape sphere = new Sphere(7.0);  // radius = 7
        System.out.println("Surface Area of Sphere: " + sphere.area());
    }
}

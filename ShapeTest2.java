abstract class Shape {
    public abstract double calc_area();
    public abstract double calc_volume();
}

class Sphere extends Shape {
    private double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    @Override
    public double calc_area() {
        return 4 * Math.PI * radius * radius;
    }

    @Override
    public double calc_volume() {
        return (4.0/3) * Math.PI * radius * radius * radius;
    }
}

class Cone extends Shape {
    private double radius;
    private double height;

    public Cone(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double calc_area() {
        return Math.PI * radius * (radius + Math.sqrt(radius*radius + height*height));
    }

    @Override
    public double calc_volume() {
        return (1.0/3) * Math.PI * radius * radius * height;
    }
}

public class ShapeTest2 {
    public static void main(String[] args) {
        Shape sphere = new Sphere(5);
        Shape cone = new Cone(3, 7);

        System.out.println("Sphere Area: " + sphere.calc_area());
        System.out.println("Sphere Volume: " + sphere.calc_volume());
        System.out.println("Cone Area: " + cone.calc_area());
        System.out.println("Cone Volume: " + cone.calc_volume());
    }
}

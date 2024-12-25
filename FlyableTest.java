interface Flyable {
    void fly_obj();
}

class Spacecraft implements Flyable {
    @Override
    public void fly_obj() {
        System.out.println("Spacecraft is flying in space.");
    }
}

class Airplane implements Flyable {
    @Override
    public void fly_obj() {
        System.out.println("Airplane is flying in the sky.");
    }
}

class Helicopter implements Flyable {
    @Override
    public void fly_obj() {
        System.out.println("Helicopter is flying in the air.");
    }
}

public class FlyableTest {
    public static void main(String[] args) {
        Flyable spacecraft = new Spacecraft();
        Flyable airplane = new Airplane();
        Flyable helicopter = new Helicopter();

        spacecraft.fly_obj();
        airplane.fly_obj();
        helicopter.fly_obj();
    }
}

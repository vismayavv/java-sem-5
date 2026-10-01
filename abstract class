abstract class Vehicle {
    abstract void start();

    void display() {
        System.out.println("This is a vehicle");
    }
}

class Car extends Vehicle {
    void start() {
        System.out.println("Car starts with a key");
    }
}

class Bike extends Vehicle {
    void start() {
        System.out.println("Bike starts with a button");
    }
}

public class Main {
    public static void main(String[] args) {
        Car c = new Car();
        Bike b = new Bike();

        c.display();
        c.start();

        b.display();
        b.start();
    }
}
